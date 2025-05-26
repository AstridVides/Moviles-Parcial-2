package com.ajvlsiete.adopcionmascotas.models

object ProductRepository {
    val products = listOf(
        Product(
            id =1,
            name = "Laptop",
            category = "Electrónica",
            price = 999.99,
            description = "Potente laptop con 16GB RAM.",
            image = "https://i5.walmartimages.com/seo/HP-Pavilion-13-3-FHD-Intel-Core-i3-8GB-RAM-128GB-SSD-Silver_906cf222-d138-430a-8146-d129b0cca3a2_2.f838f300a6e31f50074faf4091a1da7b.jpeg"
        ),
        Product(
            id = 2,
            name = "Zapatos",
            category = "Moda", 59.99,
            description = "Zapatos cómodos y modernos.",
            image = "https://m.media-amazon.com/images/I/617JkxyZwoL.jpg"
        ),
        Product(
            id = 3,
            name = "Auriculares",
            category = "Electrónica",
            price = 29.99,
            description = "Auriculares con cancelación de ruido.",
            image = "https://vieta.es/cdn/shop/files/8431543120931_3113082b-e8a8-4d6d-8a12-cba196569d15.jpg?v=1742988177"
        ),
        Product(
            id = 4,
            name = "Sueter",
            category = "Ropa",
            price = 29.99,
            description = "Ropida muy fresca.",
            image = "https://upload.wikimedia.org/wikipedia/commons/e/ea/Jersei-coll-alt.jpg"
        ),
        Product(
            id = 5,
            name = "Gorrito ",
            category = "Ropa",
            price = 2.99,
            description = "Auriculares con cancelación de ruido.",
            image = "https://s.alicdn.com/@sc04/kf/H462dec583fd8447c8cbb85324a7b90c4d.jpg_300x300.jpg"
        ),
    )
}

