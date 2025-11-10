fun main() {
    val books = mutableListOf<String>()
    val authors = mutableListOf<String>()
    val years = mutableListOf<Int>()
    var running = true

    while (running) {
        println("\n=== LIBRARY ===")
        println("Amount of books: ${books.size}")
        println("\n1. Add Book")
        println("2. Show all Books")
        println("3. Search Book")
        println("4. Delete Book")
        println("5. Exit")
        print("\nSelect: ")

        val choice = readLine()?.toIntOrNull() ?: 0

        when (choice) {
            1 -> {
                // Add book
                print("Input Book Title: ")
                val title = readLine() ?: ""

                if(books.contains(title)){
                    println("Book title already exists.")
                    continue;
                }

                print("Input Author: ")
                val author = readLine() ?: ""

                print("Input Release Year: ")
                val year = readLine()?.toIntOrNull() ?: 0

                if (title.isNotEmpty()) {
                    books.add(title)
                    authors.add(author)
                    years.add(year)
                    println("Book Added successfully!")
                } else println("Invalid title")
            }
            2 -> {
                // Show all books
                if(books.isEmpty()) println("There are no books in the library.")

                println("1. Sort by title")
                println("2. Unsorted")

                val choice_search = readLine()?.toIntOrNull() ?: 0

                when(choice_search) {
                    1 -> {
                        println("Sorted books")
                        val sortedBooks = books.sorted()
                        for ((i, book) in sortedBooks.withIndex()) println("${i + 1}. $book  - Author: ${authors[i]} - Year: ${years[i]}")
                        var sum = 0;
                        for(year in years) sum += year;
                        val avg = sum / years.size;
                        println("Average Release Year: $avg")
                    }
                    2 -> {
                        println("Books in Library")
                        for((i, book) in books.withIndex()) println("${i+1}. $book - Author: ${authors[i]} - Year: ${years[i]}")
                        var sum = 0;
                        for(year in years) sum += year;
                        val avg = sum / years.size;
                        println("Average Release Year: $avg")
                    }
                    else -> println("Invalid choice.")
                }
            }
            3 -> {
                // Search book
                println("1. Search by title")
                println("2. Search by author")

                val choice_search = readLine()?.toIntOrNull() ?: 0

                when(choice_search) {
                    1 -> {
                        print("Input search title: ")
                        val title = readLine() ?: ""

                        if (books.contains(title)) {
                            val position = books.indexOf(title)
                            println("Found book at position ${position + 1}")
                        } else println("Book not found.")
                    }

                    2 -> {
                        print("Input search author: ")
                        val author = readLine() ?: ""

                        if (authors.contains(author)) {
                            var i = 1;
                            for ((index, book) in books.withIndex()) {
                                if (authors[index] == author) println("${i}. $book")
                                i++
                            }
                        } else println("No books found.")
                    }
                    else -> println("Invalid choice.")
                }
            }
            4 -> {
                // Delete book
                if(books.isEmpty()) println("There are no books to delete.")
                else {
                   // Show list
                    for((i, book) in books.withIndex()) println("${i+1}. $book - Author: ${authors[i]} - Year: ${years[i]}")

                    print("\nInput book number to delete: ")
                    val num = readLine()?.toIntOrNull() ?: 0

                    if(num in 1..books.size){
                        val removed = books.removeAt(num - 1)
                        println("Book [$removed] has been deleted.")
                    } else println("Invalid number.")
                }
            }
            5 -> {
                running = false
                println("Program exiting...")
            }
            else -> println("Invalid choice.")
        }
    }
}
