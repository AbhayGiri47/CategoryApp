package com.example.categoryapp.presentation


import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.categoryapp.R
import com.example.categoryapp.base.BaseActivity
import com.example.categoryapp.databinding.ActivityMainBinding
import com.example.categoryapp.presentation.adapter.CategoryImageAdapter
import com.example.categoryapp.presentation.adapter.CategoryListAdapter
import com.example.categoryapp.presentation.category_analysis.CarouselAnalysisBottomSheet
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val params = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.WRAP_CONTENT,
        LinearLayout.LayoutParams.WRAP_CONTENT
    ).apply {
        setMargins(12, 0, 12, 0)
    }

    private var dotsImage = mutableListOf<ImageView>()

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun observeViewModel() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.categoryImage.collectLatest {
                        carouselImageAdapter.submitList(it)
                        setupIndicator(it.size)
                    }
                }
                launch {
                    viewModel.categoryList.collectLatest {
                        carouselListAdapter.submitList(it)
                        with(binding.tvCatalogRangeStatus) {
                            isVisible = it.isNullOrEmpty()
                            text =
                                if (it == null) getString(R.string.txt_loading) else getString(R.string.txt_no_item_found)
                        }
                    }
                }
                launch {
                    viewModel.searchQuery.collectLatest {
                        binding.searchText.setQuery(it, false)
                    }
                }
                launch {
                    viewModel.showBottomSheet.collectLatest {
                        val analysisSheet = CarouselAnalysisBottomSheet()
                        analysisSheet.show(supportFragmentManager, CarouselAnalysisBottomSheet.TAG)
                    }
                }
            }
        }
    }

    private fun setupIndicator(size: Int) {
        for (i in 0 until size) {
            val dot = ImageView(this@MainActivity).apply {
                setImageResource(R.drawable.unselected_dot)
                layoutParams = params
            }
            dotsImage.add(dot)
            binding.slideDotLL.addView(dot)
        }
        dotsImage[0].setImageResource(R.drawable.selected_dot)
    }

    override fun initialize() {
        with(binding) {
            viewpagerCarousel.adapter = carouselImageAdapter
            rvCarouselSubItemList.layoutManager = LinearLayoutManager(this@MainActivity)
            rvCarouselSubItemList.adapter = carouselListAdapter

            searchText.setOnQueryTextListener(searchTextListener)
        }
        setupOnClickListeners()
    }

    private val viewModel by viewModels<CategoryViewModel>()

    private val carouselImageAdapter = CategoryImageAdapter()
    private val carouselListAdapter = CategoryListAdapter()

    private val searchTextListener = object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            binding.searchText.clearFocus()
            return true
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            newText?.let { viewModel.onSearchValueChange(newText) }
            return true
        }

    }

    private val onCarouselPageChanged = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            binding.searchText.clearFocus()
            viewModel.onCategoryChanged(position)
            dotsImage.forEachIndexed { index, imageView ->
                imageView.setImageResource(
                    if (index == position) R.drawable.selected_dot else R.drawable.unselected_dot
                )
            }
        }
    }

    private fun setupOnClickListeners() {
        binding.fbShowOptions.setOnClickListener {
            viewModel.showBottomSheet()
        }
        with(binding.searchText) {
            setOnClickListener {
                isIconified = false
                requestFocus()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        binding.viewpagerCarousel.registerOnPageChangeCallback(onCarouselPageChanged)
    }

    override fun onPause() {
        super.onPause()
        binding.viewpagerCarousel.unregisterOnPageChangeCallback(onCarouselPageChanged)
    }
}
