package com.andreisingeleytsev.interestsquizapp.domain.quiz.model

sealed class QuizCategory(val title: String, val list: List<QuestionItem>) {
    data object Art : QuizCategory(
        "Art", listOf(
            QuestionItem(
                "What is art?",
                listOf(
                    "Art is an expression of human creativity and emotion.",
                    "Art is a set of skills and techniques.",
                    "Art is a form of entertainment.",
                    "Art is a way to communicate and provoke thoughts."
                )
            ),
            QuestionItem(
                "Which forms of art do you prefer the most?",
                listOf("Painting", "Sculpture", "Photography", "Music")
            ),
            QuestionItem(
                "Do you think realism or abstract art is more expressive?",
                listOf(
                    "I find realism more expressive.",
                    "I find abstract art more expressive.",
                    "It depends on the artwork.",
                    "I'm not sure."
                )
            ),
            QuestionItem(
                "What is considered classical art?",
                listOf(
                    "Classical art typically refers to the art of ancient Greece and Rome.",
                    "It can also refer to art from other historical periods known for their refinement and balance.",
                    "Classical art is subjective and varies by culture.",
                    "I have no idea."
                )
            ),
            QuestionItem(
                "Who do you think made the most significant contribution to art?",
                listOf("Leonardo da Vinci", "Vincent van Gogh", "Pablo Picasso", "Michelangelo")
            ),
            QuestionItem(
                "How does art impact your life?",
                listOf(
                    "Art provides me with inspiration and emotional connection.",
                    "I enjoy creating art myself.",
                    "I don't engage with art regularly.",
                    "Art has no impact on my life."
                )
            ),
            QuestionItem(
                "What do you consider the most iconic artwork in history?",
                listOf("The Mona Lisa", "Starry Night", "The Scream", "Guernica")
            ),
            QuestionItem(
                "Do you believe that art should have a message or meaning?",
                listOf(
                    "Art should always convey a message or meaning.",
                    "Art can be purely aesthetic without a message.",
                    "It depends on the artist's intent.",
                    "I'm not sure."
                )
            ),
            QuestionItem(
                "What art movements or styles do you find the most intriguing?",
                listOf("Impressionism", "Surrealism", "Cubism", "Pop art")
            ),
            QuestionItem(
                "How important is art education in fostering creativity?",
                listOf(
                    "Art education is crucial for fostering creativity.",
                    "Art education is helpful but not essential.",
                    "Art education has little impact on creativity.",
                    "I have no opinion on this."
                )
            ),
            QuestionItem(
                "Do you prefer traditional or digital art?",
                listOf(
                    "I prefer traditional art.",
                    "I prefer digital art.",
                    "I like both equally.",
                    "I'm not familiar with digital art."
                )
            ),
            QuestionItem(
                "What is your favorite art gallery or museum?",
                listOf(
                    "The Louvre (Paris, France)",
                    "The Metropolitan Museum of Art (New York, USA)",
                    "The British Museum (London, UK)",
                    "I have never been to an art gallery or museum."
                )
            ),
            QuestionItem(
                "How do you interpret abstract art?",
                listOf(
                    "I see my own meaning in abstract art.",
                    "I struggle to understand abstract art.",
                    "I appreciate the complexity of abstract art.",
                    "I don't have an opinion on abstract art."
                )
            ),
            QuestionItem(
                "What is your favorite art medium to work with?",
                listOf("Oil paint", "Watercolor", "Graphite/charcoal", "Digital media")
            ),
            QuestionItem(
                "How does art influence society and culture?",
                listOf(
                    "Art reflects and shapes societal values and culture.",
                    "Art has no influence on society and culture.",
                    "I'm unsure about the impact of art on society and culture.",
                    "Art influences culture but not society."
                )
            ),
            QuestionItem(
                "What role does public art play in urban environments?",
                listOf(
                    "Public art enhances the cultural and aesthetic appeal of cities.",
                    "Public art is irrelevant in urban environments.",
                    "I'm not familiar with public art.",
                    "Public art is controversial and divisive."
                )
            ),
            QuestionItem(
                "Do you think anyone can appreciate art, or is it an acquired taste?",
                listOf(
                    "Anyone can appreciate art with an open mind.",
                    "Appreciating art requires some knowledge and exposure.",
                    "Art appreciation is limited to a select few.",
                    "I have no opinion on this."
                )
            ),
            QuestionItem(
                "How has technology impacted the art world?",
                listOf(
                    "Technology has revolutionized how art is created and shared.",
                    "Technology has had minimal impact on the art world.",
                    "I'm not familiar with the impact of technology on art.",
                    "Technology has negatively affected the art world."
                )
            ),
            QuestionItem(
                "What is your favorite artistic period in history?",
                listOf("The Renaissance", "The Baroque", "The Romantic period", "The Modern era")
            ),
            QuestionItem(
                "What is your favorite art genre or movement?",
                listOf("Abstract expressionism", "Renaissance art", "Pop art", "Minimalism")
            )
        )
    )

    data object Science : QuizCategory(
        "Science", listOf(
            QuestionItem(
                "What is the smallest particle in an atom?",
                listOf("Quark", "Electron", "Proton", "Neutron")
            ),
            QuestionItem(
                "What is the chemical symbol for the element gold?",
                listOf("Au", "Ag", "Fe", "Hg")
            ),
            QuestionItem(
                "What is the study of heredity and variation in living organisms called?",
                listOf("Genetics", "Ecology", "Biology", "Chemistry")
            ),
            QuestionItem(
                "Which planet is known as the 'Red Planet'?",
                listOf("Mars", "Venus", "Jupiter", "Saturn")
            ),
            QuestionItem(
                "What is the process by which plants make their own food using sunlight?",
                listOf("Photosynthesis", "Respiration", "Fermentation", "Osmosis")
            ),
            QuestionItem(
                "What is the primary function of the Large Hadron Collider (LHC)?",
                listOf(
                    "Particle physics experiments",
                    "Weather forecasting",
                    "Space exploration",
                    "Climate modeling"
                )
            ),
            QuestionItem(
                "What is the speed of light in a vacuum?",
                listOf(
                    "299,792,458 meters per second",
                    "100,000,000 meters per second",
                    "500,000,000 meters per second",
                    "1,000,000,000 meters per second"
                )
            ),
            QuestionItem(
                "What is the chemical formula for water?",
                listOf("H2O", "CO2", "NaCl", "O2")
            ),
            QuestionItem(
                "Which scientist is known for the theory of relativity?",
                listOf("Albert Einstein", "Isaac Newton", "Galileo Galilei", "Stephen Hawking")
            ),
            QuestionItem(
                "What is the force that pulls objects toward the center of the Earth?",
                listOf("Gravity", "Magnetism", "Friction", "Inertia")
            ),
            QuestionItem(
                "What is the study of the Earth's past through examination of plant and animal fossils called?",
                listOf("Paleontology", "Geology", "Astronomy", "Meteorology")
            ),
            QuestionItem(
                "What is the study of the Earth's atmosphere and weather called?",
                listOf("Meteorology", "Oceanography", "Astronomy", "Geology")
            ),
            QuestionItem(
                "What is the smallest planet in our solar system?",
                listOf("Mercury", "Venus", "Mars", "Earth")
            ),
            QuestionItem(
                "Which gas is most abundant in the Earth's atmosphere?",
                listOf("Nitrogen (N2)", "Oxygen (O2)", "Carbon dioxide (CO2)", "Hydrogen (H2)")
            ),
            QuestionItem(
                "What is the process of nuclear fusion that powers the Sun?",
                listOf("Thermonuclear fusion", "Fission", "Nuclear decay", "Radioactive decay")
            ),
            QuestionItem(
                "What is the chemical symbol for the element oxygen?",
                listOf("O", "O2", "Ox", "Os")
            ),
            QuestionItem(
                "What is the study of the behavior and properties of matter called?",
                listOf("Chemistry", "Physics", "Biology", "Geology")
            ),
            QuestionItem(
                "What is the term for the process of a solid changing directly into a gas without becoming a liquid first?",
                listOf("Sublimation", "Evaporation", "Condensation", "Melting")
            ),
            QuestionItem(
                "What is the most abundant element in the Earth's crust?",
                listOf("Oxygen (O)", "Silicon (Si)", "Aluminum (Al)", "Iron (Fe)")
            ),
            QuestionItem(
                "What is the unit of measurement for electrical resistance?",
                listOf("Ohm", "Volt", "Ampere", "Watt")
            )
        )
    )

    data object Biology : QuizCategory(
        "Biology", listOf(
            QuestionItem(
                "What is the process by which plants make their own food using sunlight?",
                listOf("Photosynthesis", "Respiration", "Fermentation", "Osmosis")
            ),
            QuestionItem(
                "Which part of the cell is responsible for energy production?",
                listOf("Mitochondria", "Nucleus", "Endoplasmic reticulum", "Golgi apparatus")
            ),
            QuestionItem(
                "What is the body's primary defense mechanism against harmful pathogens?",
                listOf("Immune system", "Nervous system", "Endocrine system", "Circulatory system")
            ),
            QuestionItem(
                "What molecule carries genetic information in cells?",
                listOf("DNA", "RNA", "Protein", "Lipid")
            ),
            QuestionItem(
                "What is the process of cell division by which two daughter cells are formed from one parent cell?",
                listOf("Mitosis", "Meiosis", "Binary fission", "Budding")
            ),
            QuestionItem(
                "What is the largest organ in the human body?",
                listOf("Skin", "Liver", "Heart", "Lungs")
            ),
            QuestionItem(
                "What gas do plants absorb from the atmosphere during photosynthesis?",
                listOf("Carbon dioxide (CO2)", "Oxygen (O2)", "Nitrogen (N2)", "Hydrogen (H2)")
            ),
            QuestionItem(
                "Which system in the human body is responsible for transporting blood throughout the body?",
                listOf(
                    "Circulatory system",
                    "Respiratory system",
                    "Digestive system",
                    "Excretory system"
                )
            ),
            QuestionItem(
                "What is the name of the process by which organisms maintain a stable internal environment?",
                listOf("Homeostasis", "Evolution", "Adaptation", "Metabolism")
            ),
            QuestionItem(
                "What is the smallest unit of life that can carry out all the functions of living things?",
                listOf("Cell", "Molecule", "Atom", "Organ")
            ),
            QuestionItem(
                "Which gas do humans exhale when they breathe out?",
                listOf("Carbon dioxide (CO2)", "Oxygen (O2)", "Nitrogen (N2)", "Hydrogen (H2)")
            ),
            QuestionItem(
                "What is the name of the body's chemical messengers, produced by glands, that regulate various physiological processes?",
                listOf("Hormones", "Enzymes", "Antibodies", "Neurotransmitters")
            ),
            QuestionItem(
                "Which organ is responsible for filtering waste products from the blood and producing urine?",
                listOf("Kidneys", "Liver", "Pancreas", "Spleen")
            ),
            QuestionItem(
                "What is the process by which living organisms produce offspring of the same kind?",
                listOf("Reproduction", "Growth", "Metabolism", "Excretion")
            ),
            QuestionItem(
                "Which gas is primarily responsible for the greenhouse effect and global warming?",
                listOf("Carbon dioxide (CO2)", "Oxygen (O2)", "Methane (CH4)", "Nitrogen (N2)")
            ),
            QuestionItem(
                "What is the term for the study of the classification and naming of living organisms?",
                listOf("Taxonomy", "Genetics", "Ecology", "Anatomy")
            ),
            QuestionItem(
                "Which gas do humans need to breathe in for respiration?",
                listOf("Oxygen (O2)", "Carbon dioxide (CO2)", "Nitrogen (N2)", "Hydrogen (H2)")
            ),
            QuestionItem(
                "What is the main function of red blood cells in the human body?",
                listOf("Carrying oxygen", "Digesting food", "Filtering toxins", "Storing energy")
            ),
            QuestionItem(
                "What is the process of the gradual change in a species over time?",
                listOf("Evolution", "Adaptation", "Mutation", "Genetic drift")
            ),
            QuestionItem(
                "Which gas do plants release during respiration?",
                listOf("Oxygen (O2)", "Carbon dioxide (CO2)", "Nitrogen (N2)", "Hydrogen (H2)")
            )
        )
    )

    data object History : QuizCategory(
        "History", listOf(
            QuestionItem(
                "What is the process by which plants make their own food using sunlight?",
                listOf("Photosynthesis", "Respiration", "Fermentation", "Osmosis")
            ),
            QuestionItem(
                "Which part of the cell is responsible for energy production?",
                listOf("Mitochondria", "Nucleus", "Endoplasmic reticulum", "Golgi apparatus")
            ),
            QuestionItem(
                "What is the body's primary defense mechanism against harmful pathogens?",
                listOf("Immune system", "Nervous system", "Endocrine system", "Circulatory system")
            ),
            QuestionItem(
                "What molecule carries genetic information in cells?",
                listOf("DNA", "RNA", "Protein", "Lipid")
            ),
            QuestionItem(
                "What is the process of cell division by which two daughter cells are formed from one parent cell?",
                listOf("Mitosis", "Meiosis", "Binary fission", "Budding")
            ),
            QuestionItem(
                "What is the largest organ in the human body?",
                listOf("Skin", "Liver", "Heart", "Lungs")
            ),
            QuestionItem(
                "What gas do plants absorb from the atmosphere during photosynthesis?",
                listOf("Carbon dioxide (CO2)", "Oxygen (O2)", "Nitrogen (N2)", "Hydrogen (H2)")
            ),
            QuestionItem(
                "Which system in the human body is responsible for transporting blood throughout the body?",
                listOf(
                    "Circulatory system",
                    "Respiratory system",
                    "Digestive system",
                    "Excretory system"
                )
            ),
            QuestionItem(
                "What is the name of the process by which organisms maintain a stable internal environment?",
                listOf("Homeostasis", "Evolution", "Adaptation", "Metabolism")
            ),
            QuestionItem(
                "What is the smallest unit of life that can carry out all the functions of living things?",
                listOf("Cell", "Molecule", "Atom", "Organ")
            ),
            QuestionItem(
                "Which gas do humans exhale when they breathe out?",
                listOf("Carbon dioxide (CO2)", "Oxygen (O2)", "Nitrogen (N2)", "Hydrogen (H2)")
            ),
            QuestionItem(
                "What is the name of the body's chemical messengers, produced by glands, that regulate various physiological processes?",
                listOf("Hormones", "Enzymes", "Antibodies", "Neurotransmitters")
            ),
            QuestionItem(
                "Which organ is responsible for filtering waste products from the blood and producing urine?",
                listOf("Kidneys", "Liver", "Pancreas", "Spleen")
            ),
            QuestionItem(
                "What is the process by which living organisms produce offspring of the same kind?",
                listOf("Reproduction", "Growth", "Metabolism", "Excretion")
            ),
            QuestionItem(
                "Which gas is primarily responsible for the greenhouse effect and global warming?",
                listOf("Carbon dioxide (CO2)", "Oxygen (O2)", "Methane (CH4)", "Nitrogen (N2)")
            ),
            QuestionItem(
                "What is the term for the study of the classification and naming of living organisms?",
                listOf("Taxonomy", "Genetics", "Ecology", "Anatomy")
            ),
            QuestionItem(
                "Which gas do humans need to breathe in for respiration?",
                listOf("Oxygen (O2)", "Carbon dioxide (CO2)", "Nitrogen (N2)", "Hydrogen (H2)")
            ),
            QuestionItem(
                "What is the main function of red blood cells in the human body?",
                listOf("Carrying oxygen", "Digesting food", "Filtering toxins", "Storing energy")
            ),
            QuestionItem(
                "What is the process of the gradual change in a species over time?",
                listOf("Evolution", "Adaptation", "Mutation", "Genetic drift")
            ),
            QuestionItem(
                "Which gas do plants release during respiration?",
                listOf("Oxygen (O2)", "Carbon dioxide (CO2)", "Nitrogen (N2)", "Hydrogen (H2)")
            )
        )
    )

    data object Language : QuizCategory(
        "Language", listOf(
            QuestionItem(
                "What is the study of the structure and sound of language called?",
                listOf("Linguistics", "Phonetics", "Syntax", "Semiotics")
            ),
            QuestionItem(
                "Which language is known for having the most native speakers in the world?",
                listOf("Mandarin Chinese", "English", "Spanish", "Hindi")
            ),
            QuestionItem(
                "What is the term for a word that sounds like the sound it represents, such as 'buzz' or 'hiss'?",
                listOf("Onomatopoeia", "Palindrome", "Alliteration", "Simile")
            ),
            QuestionItem(
                "Which alphabet is used for writing Russian?",
                listOf("Cyrillic", "Latin", "Greek", "Arabic")
            ),
            QuestionItem(
                "What is the process of code-switching in linguistics?",
                listOf(
                    "Switching between two or more languages or dialects within a conversation.",
                    "Translating words between two languages.",
                    "Creating a new language by blending two existing ones.",
                    "Writing in a secret code or cipher language."
                )
            ),
            QuestionItem(
                "What is the term for the smallest unit of meaning in a language?",
                listOf("Morpheme", "Phoneme", "Syntax", "Semantics")
            ),
            QuestionItem(
                "What is the study of the historical development of languages and language families called?",
                listOf(
                    "Historical linguistics",
                    "Descriptive linguistics",
                    "Sociolinguistics",
                    "Psycholinguistics"
                )
            ),
            QuestionItem(
                "What is the term for a word or phrase that has the opposite meaning of another word?",
                listOf("Antonym", "Synonym", "Homonym", "Heteronym")
            ),
            QuestionItem(
                "Which linguistic term refers to the study of the meaning of words and how they relate to concepts in the mind?",
                listOf("Semantics", "Syntax", "Pragmatics", "Phonetics")
            ),
            QuestionItem(
                "What is the term for the natural, unconscious process of language acquisition in children?",
                listOf("Language acquisition", "Code-switching", "Bilingualism", "Metalinguistics")
            ),
            QuestionItem(
                "What is the name of the script used for writing Arabic?",
                listOf("Arabic script", "Cyrillic script", "Latin script", "Devanagari script")
            ),
            QuestionItem(
                "What is the term for a variation of a language spoken in a particular region?",
                listOf("Dialect", "Accent", "Creole", "Pidgin")
            ),
            QuestionItem(
                "What is the study of the sound system of a language called?",
                listOf("Phonetics", "Syntax", "Morphology", "Pragmatics")
            ),
            QuestionItem(
                "What is the term for a word or phrase that sounds like the word it represents, such as 'moo' or 'buzz'?",
                listOf("Phonomime", "Onomatopoeia", "Phoneme", "Simile")
            ),
            QuestionItem(
                "What is the study of language use in social contexts, including issues of power and identity?",
                listOf("Sociolinguistics", "Psycholinguistics", "Semiotics", "Pragmatics")
            ),
            QuestionItem(
                "What is the term for a word that is spelled the same way forwards and backwards, such as 'radar'?",
                listOf("Palindrome", "Homonym", "Antonym", "Synonym")
            ),
            QuestionItem(
                "What is the process of creating new words by combining parts of existing words called?",
                listOf("Word formation", "Neologism", "Reduplication", "Borrowing")
            ),
            QuestionItem(
                "What is the linguistic term for the study of sentence structure and word order?",
                listOf("Syntax", "Semantics", "Pragmatics", "Phonetics")
            ),
            QuestionItem(
                "Which language family includes English, German, Dutch, and Swedish?",
                listOf("Germanic", "Romance", "Slavic", "Semitic")
            ),
            QuestionItem(
                "What is the term for the study of meaning in language and communication?",
                listOf("Semantics", "Syntax", "Phonetics", "Pragmatics")
            )
        )
    )

    data object Math : QuizCategory(
        "Math", listOf(
            QuestionItem(
                "What is the value of π (pi) to two decimal places?",
                listOf("3.14", "3.16", "3.12", "3.18")
            ),
            QuestionItem("What is the square root of 25?", listOf("5", "6", "4", "7")),
            QuestionItem(
                "What is the result of 7 multiplied by 8?",
                listOf("56", "64", "48", "52")
            ),
            QuestionItem("What is the next prime number after 17?", listOf("19", "21", "18", "20")),
            QuestionItem(
                "What is the area of a rectangle with a length of 10 units and a width of 6 units?",
                listOf("60 square units", "16 square units", "36 square units", "100 square units")
            ),
            QuestionItem("What is the value of 9 squared (9^2)?", listOf("81", "72", "63", "90")),
            QuestionItem("Solve for x: 2x + 3 = 7", listOf("x = 2", "x = 3", "x = 4", "x = 5")),
            QuestionItem("What is the smallest prime number?", listOf("2", "1", "3", "0")),
            QuestionItem(
                "What is the circumference of a circle with a radius of 4 units?",
                listOf("25.12 units", "16 units", "12.56 units", "50.24 units")
            ),
            QuestionItem(
                "What is the value of 3 to the power of 4 (3^4)?",
                listOf("81", "64", "27", "12")
            ),
            QuestionItem(
                "What is the sum of the angles in a triangle?",
                listOf("180 degrees", "90 degrees", "360 degrees", "120 degrees")
            ),
            QuestionItem(
                "If a = 4 and b = 7, what is the value of a + b?",
                listOf("11", "12", "9", "10")
            ),
            QuestionItem("What is the value of 6 divided by 2?", listOf("3", "4", "2", "5")),
            QuestionItem(
                "What is the largest two-digit prime number?",
                listOf("97", "89", "91", "83")
            ),
            QuestionItem("Solve for y: 2y - 5 = 11", listOf("y = 8", "y = 10", "y = 6", "y = 12")),
            QuestionItem("What is the product of 9 and 7?", listOf("63", "56", "72", "49")),
            QuestionItem("What is the result of 15 minus 9?", listOf("6", "5", "7", "8")),
            QuestionItem(
                "What is the area of a square with a side length of 5 units?",
                listOf("25 square units", "20 square units", "30 square units", "15 square units")
            ),
            QuestionItem("What is the value of 10% of 80?", listOf("8", "10", "16", "20")),
            QuestionItem("Solve for x: 3x = 15", listOf("x = 5", "x = 3", "x = 6", "x = 4"))
        )
    )
}

data class QuestionItem(val question: String, val answers: List<String>)
