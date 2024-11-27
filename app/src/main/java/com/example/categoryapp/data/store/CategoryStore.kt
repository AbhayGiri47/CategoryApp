package com.example.categoryapp.data.store

import com.example.categoryapp.R
import com.example.categoryapp.data.model.Category
import com.example.categoryapp.data.model.CategoryList
import com.example.categoryapp.data.model.CategoryType

class CategoryStore {

    val houseSubItems = listOf(
        CategoryList(
            R.drawable.thumbnail_house,
            "Bungalow",
            "A single-story house with a wide layout."
        ),
        CategoryList(
            R.drawable.thumbnail_house,
            "Villa",
            "A luxurious and spacious standalone house."
        ),
        CategoryList(
            R.drawable.thumbnail_house,
            "Apartment",
            "A residential unit in a multi-story building."
        ),
        CategoryList(
            R.drawable.thumbnail_house,
            "Cottage",
            "A small, cozy house, often in a rural setting."
        ),
        CategoryList(
            R.drawable.thumbnail_house,
            "Townhouse",
            "A multi-story house sharing walls with adjacent homes."
        ),
        CategoryList(R.drawable.thumbnail_house, "Mansion", "A large, grand, and opulent house."),
        CategoryList(
            R.drawable.thumbnail_house,
            "Duplex",
            "A house divided into two separate units."
        ),
        CategoryList(
            R.drawable.thumbnail_house,
            "Farmhouse",
            "A house on a farm, typically surrounded by land."
        ),
        CategoryList(
            R.drawable.thumbnail_house,
            "Studio Apartment",
            "A small, self-contained living space."
        ),
        CategoryList(R.drawable.thumbnail_house, "Penthouse", "A luxurious top-floor apartment."),
        CategoryList(
            R.drawable.thumbnail_house,
            "Cabin",
            "A simple house, usually made of wood, in a remote area."
        ),
        CategoryList(
            R.drawable.thumbnail_house,
            "Loft",
            "A large, open living space often converted from an industrial area."
        ),
        CategoryList(
            R.drawable.thumbnail_house,
            "Row House",
            "A series of similar houses in a continuous row."
        ),
        CategoryList(R.drawable.thumbnail_house, "Treehouse", "A house built in or around a tree."),
        CategoryList(
            R.drawable.thumbnail_house,
            "Mobile Home",
            "A portable house that can be moved to different locations."
        ),
        CategoryList(R.drawable.thumbnail_house, "Tiny House", "A compact and minimalist home."),
        CategoryList(
            R.drawable.thumbnail_house,
            "Beach House",
            "A house located near a beach or coastline."
        ),
        CategoryList(
            R.drawable.thumbnail_house,
            "Eco-friendly House",
            "A house built with sustainable and green materials."
        ),
        CategoryList(
            R.drawable.thumbnail_house,
            "Skyscraper Apartment",
            "A residential unit in a high-rise building."
        )
    )

    val birdSubItems = listOf(
        CategoryList(
            R.drawable.thumbnail_birds,
            "Eagle",
            "A powerful bird of prey with keen eyesight."
        ),
        CategoryList(
            R.drawable.thumbnail_birds,
            "Parrot",
            "A colorful bird known for mimicking sounds."
        ),
        CategoryList(
            R.drawable.thumbnail_birds,
            "Sparrow",
            "A small and agile bird commonly found worldwide."
        ),
        CategoryList(
            R.drawable.thumbnail_birds,
            "Owl",
            "A nocturnal bird of prey with large eyes."
        ),
        CategoryList(
            R.drawable.thumbnail_birds,
            "Peacock",
            "A bird known for its vibrant tail feathers."
        ),
        CategoryList(
            R.drawable.thumbnail_birds,
            "Penguin",
            "A flightless bird adapted to aquatic life."
        ),
        CategoryList(
            R.drawable.thumbnail_birds,
            "Hummingbird",
            "A tiny bird known for its rapid wing movement."
        ),
        CategoryList(
            R.drawable.thumbnail_birds,
            "Flamingo",
            "A tall bird with pink plumage and long legs."
        ),
        CategoryList(
            R.drawable.thumbnail_birds,
            "Kingfisher",
            "A bird known for its striking colors and fishing skills."
        ),
        CategoryList(
            R.drawable.thumbnail_birds,
            "Crow",
            "A highly intelligent and adaptable bird."
        ),
        CategoryList(
            R.drawable.thumbnail_birds,
            "Swan",
            "A graceful water bird with white feathers."
        ),
        CategoryList(
            R.drawable.thumbnail_birds,
            "Woodpecker",
            "A bird known for pecking at wood to find insects."
        ),
        CategoryList(
            R.drawable.thumbnail_birds,
            "Canary",
            "A small bird known for its melodious singing."
        ),
        CategoryList(
            R.drawable.thumbnail_birds,
            "Pigeon",
            "A common city bird known for its adaptability."
        ),
        CategoryList(
            R.drawable.thumbnail_birds,
            "Hawk",
            "A bird of prey known for its speed and hunting skills."
        ),
        CategoryList(
            R.drawable.thumbnail_birds,
            "Robin",
            "A small bird with a distinctive red breast."
        ),
        CategoryList(
            R.drawable.thumbnail_birds,
            "Duck",
            "A waterfowl known for its webbed feet and quacking sound."
        ),
        CategoryList(R.drawable.thumbnail_birds, "Toucan", "A bird with a large, colorful beak."),
        CategoryList(
            R.drawable.thumbnail_birds,
            "Seagull",
            "A coastal bird often seen near oceans and lakes."
        )
    )

    val vehicleSubItems = listOf(
        CategoryList(
            R.drawable.thumbnail_vehicle,
            "Car",
            "A four-wheeled motor vehicle for transportation."
        ),
        CategoryList(
            R.drawable.thumbnail_vehicle,
            "Motorcycle",
            "A two-wheeled motorized vehicle."
        ),
        CategoryList(
            R.drawable.thumbnail_vehicle,
            "Bicycle",
            "A two-wheeled pedal-powered vehicle."
        ),
        CategoryList(
            R.drawable.thumbnail_vehicle,
            "Truck",
            "A large motor vehicle for transporting goods."
        ),
        CategoryList(
            R.drawable.thumbnail_vehicle,
            "Bus",
            "A large vehicle for public or private passenger transport."
        ),
        CategoryList(
            R.drawable.thumbnail_vehicle,
            "Van",
            "A medium-sized motor vehicle for transporting goods or people."
        ),
        CategoryList(
            R.drawable.thumbnail_vehicle,
            "Train",
            "A vehicle that runs on tracks for mass transport."
        ),
        CategoryList(
            R.drawable.thumbnail_vehicle,
            "Airplane",
            "An aircraft designed for air travel."
        ),
        CategoryList(
            R.drawable.thumbnail_vehicle,
            "Helicopter",
            "A rotary-winged aircraft for versatile transport."
        ),
        CategoryList(
            R.drawable.thumbnail_vehicle,
            "Boat",
            "A watercraft designed for travel on water."
        ),
        CategoryList(
            R.drawable.thumbnail_vehicle,
            "Ship",
            "A large vessel for transporting goods or people across water."
        ),
        CategoryList(
            R.drawable.thumbnail_vehicle,
            "Submarine",
            "An underwater vehicle for exploration or military use."
        ),
        CategoryList(
            R.drawable.thumbnail_vehicle,
            "Scooter",
            "A lightweight motorized two-wheeled vehicle."
        ),
        CategoryList(
            R.drawable.thumbnail_vehicle,
            "Tram",
            "A rail vehicle used for urban public transport."
        ),
        CategoryList(
            R.drawable.thumbnail_vehicle,
            "RV",
            "A recreational vehicle for traveling and living."
        ),
        CategoryList(
            R.drawable.thumbnail_vehicle,
            "SUV",
            "A sport utility vehicle designed for on-road and off-road use."
        ),
        CategoryList(R.drawable.thumbnail_vehicle, "Convertible", "A car with a retractable roof."),
        CategoryList(R.drawable.thumbnail_vehicle, "Electric Car", "A car powered by electricity."),
        CategoryList(
            R.drawable.thumbnail_vehicle,
            "Hovercraft",
            "A vehicle that glides over surfaces on a cushion of air."
        ),
        CategoryList(
            R.drawable.thumbnail_vehicle,
            "Jet Ski",
            "A small watercraft for recreational use."
        ),
        CategoryList(
            R.drawable.thumbnail_vehicle,
            "Bulldozer",
            "A powerful vehicle for construction work."
        ),
        CategoryList(
            R.drawable.thumbnail_vehicle,
            "Tractor",
            "A vehicle used in agriculture for pulling equipment."
        ),
    )

    val clothingItems = listOf(
        CategoryList(R.drawable.thumbnail_clothing, "T-Shirts", "Casual and versatile upper wear."),
        CategoryList(R.drawable.thumbnail_clothing, "Jeans", "Durable and comfortable denim pants."),
        CategoryList(
            R.drawable.thumbnail_clothing,
            "Jackets",
            "Outerwear for warmth and style."
        ),
        CategoryList(R.drawable.thumbnail_clothing, "Shirts", "Formal or casual upper wear."),
        CategoryList(
            R.drawable.thumbnail_clothing,
            "Dresses",
            "One-piece outfits for various occasions."
        ),
        CategoryList(
            R.drawable.thumbnail_clothing,
            "Skirts",
            "Versatile bottom wear for women."
        ),
        CategoryList(R.drawable.thumbnail_clothing, "Shorts", "Comfortable and casual bottom wear."),
        CategoryList(
            R.drawable.thumbnail_clothing,
            "Sweaters",
            "Knitted upper wear for colder weather."
        ),
        CategoryList(
            R.drawable.thumbnail_clothing,
            "Hoodies",
            "Casual and cozy sweatshirts with hoods."
        ),
        CategoryList(
            R.drawable.thumbnail_clothing,
            "Blazers",
            "Formal jackets for business or events."
        ),
        CategoryList(R.drawable.thumbnail_clothing, "Coats", "Long outerwear for warmth."),
        CategoryList(
            R.drawable.thumbnail_clothing,
            "Trousers",
            "Formal or casual pants for everyday wear."
        ),
        CategoryList(
            R.drawable.thumbnail_clothing,
            "Suits",
            "Matching formal jackets and trousers."
        ),
        CategoryList(
            R.drawable.thumbnail_clothing,
            "Pajamas",
            "Comfortable sleepwear for relaxation."
        ),
        CategoryList(
            R.drawable.thumbnail_clothing,
            "Activewear",
            "Clothing for workouts and sports."
        ),
        CategoryList(
            R.drawable.thumbnail_clothing,
            "Swimwear",
            "Clothing designed for swimming activities."
        ),
        CategoryList(
            R.drawable.thumbnail_clothing,
            "Scarves",
            "Accessories for warmth or fashion."
        ),
        CategoryList(
            R.drawable.thumbnail_clothing,
            "Hats",
            "Headwear for style or sun protection."
        ),
        CategoryList(
            R.drawable.thumbnail_clothing,
            "Gloves",
            "Handwear for warmth or protection."
        )
    )

    val treeSubItems = listOf(
        CategoryList(R.drawable.thumbnail_trees, "Oak", "A large, strong tree with lobed leaves."),
        CategoryList(R.drawable.thumbnail_trees, "Pine", "An evergreen tree with needle-like leaves."),
        CategoryList(R.drawable.thumbnail_trees, "Maple", "Known for its distinctive leaves and syrup."),
        CategoryList(R.drawable.thumbnail_trees, "Birch", "A tree with white bark and delicate leaves."),
        CategoryList(R.drawable.thumbnail_trees, "Willow", "A tree with long, drooping branches."),
        CategoryList(R.drawable.thumbnail_trees, "Cherry Blossom", "A tree famous for its pink and white blossoms."),
        CategoryList(R.drawable.thumbnail_trees, "Redwood", "One of the tallest trees in the world."),
        CategoryList(R.drawable.thumbnail_trees, "Cedar", "A coniferous tree with aromatic wood."),
        CategoryList(R.drawable.thumbnail_trees, "Baobab", "A tree with a thick trunk, native to Africa."),
        CategoryList(R.drawable.thumbnail_trees, "Palm", "A tropical tree with long, feathery leaves."),
        CategoryList(R.drawable.thumbnail_trees, "Aspen", "A tree with trembling leaves that shimmer in the wind."),
        CategoryList(R.drawable.thumbnail_trees, "Cypress", "A conical tree often associated with Mediterranean regions."),
        CategoryList(R.drawable.thumbnail_trees, "Eucalyptus", "A fast-growing tree with aromatic leaves."),
        CategoryList(R.drawable.thumbnail_trees, "Banyan", "A large tree with aerial roots."),
        CategoryList(R.drawable.thumbnail_trees, "Magnolia", "A tree with large, fragrant flowers."),
        CategoryList(R.drawable.thumbnail_trees, "Spruce", "A coniferous tree with a pyramid shape."),
        CategoryList(R.drawable.thumbnail_trees, "Fir", "An evergreen tree with flat needle-like leaves."),
        CategoryList(R.drawable.thumbnail_trees, "Sequoia", "A massive tree native to California."),
        CategoryList(R.drawable.thumbnail_trees, "Dogwood", "A tree with attractive flowers and colorful foliage.")
    )

    val categoryList = listOf(
        Category(R.drawable.house, CategoryType.HOUSE),
        Category(R.drawable.birds, CategoryType.BIRDS),
        Category(R.drawable.vehicle, CategoryType.VEHICLE),
        Category(R.drawable.clothes, CategoryType.CLOTHES),
        Category(R.drawable.trees, CategoryType.TREES)
    )


}