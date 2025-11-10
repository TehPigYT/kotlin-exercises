fun inputStudentData(names: Array<String>, grades: IntArray) {
    println("\n--- Input Student Data ---")

    for (i in names.indices) {
        println("\nStudent ${i + 1}:")

        print("Name: ")
        names[i] = readLine() ?: ""

        print("Score (0-100): ")
        var grade = readLine()?.toIntOrNull() ?: 0

        // Έλεγχος εγκυρότητας
        while (grade !in 0..100) {
            print("Invalid Score. Input value again (0-100): ")
            grade = readLine()?.toIntOrNull() ?: 0
        }

        grades[i] = grade
    }

    println("\nData inserted successfully!")
}

fun calculateAverage(grades: IntArray): Double {
    if (grades.isEmpty()) return 0.0

    var sum = 0
    for(grade in grades) sum += grade

    return sum.toDouble() / grades.size
}

fun findTopStudent(names: Array<String>, grades: IntArray) {
    if (grades.isEmpty()) {
        println("No data available")
        return
    }

    var maxGrade = grades[0]
    var topIndex = 0

    for (i in grades.indices) {
        if (grades[i] > maxGrade) {
            maxGrade = grades[i]
            topIndex = i
        }
    }

    println("\nTop Student:")
    println("   Name: ${names[topIndex]}")
    println("   Score: $maxGrade")
}

fun displayAllStudents(names: Array<String>, grades: IntArray) {
    println("\n📋 Student list:")
    println("═".repeat(40))

    for (i in names.indices) {
        val grade = grades[i]
        val status = when {
            grade >= 85 -> "A"
            grade >= 66 -> "B"
            grade >= 50 -> "C"
            else -> "F"
        }

        println("${i + 1}. ${names[i].padEnd(20)} - $grade ($status)")
    }

    println("═".repeat(40))
}

fun filterByGrade(names: Array<String>, grades: IntArray, minGrade: Int) {
    println("\nStudents with score >= $minGrade:")
    var count = 0

    for (i in names.indices) {
        if (grades[i] >= minGrade) {
            println("   ${names[i]}: ${grades[i]}")
            count++
        }
    }

    if (count == 0) println("No students found.")
}

fun searchStudentByName(name: String) {

}

fun getStudentsByGrade(grade: String){

}

// Bubble sort
fun sortStudentsByGrade(names: Array<String>, grades: IntArray) {
    for (i in grades.indices) {
        for (j in 0 until grades.size - 1 - i) {
            if (grades[j] < grades[j + 1]) {
                // Swap grades
                val tempGrade = grades[j]
                grades[j] = grades[j + 1]
                grades[j + 1] = tempGrade

                // Swap names
                val tempName = names[j]
                names[j] = names[j + 1]
                names[j + 1] = tempName
            }
        }
    }
}

fun countStudentsOnHalf() {

}

fun exportDataToCSV() {
    
}

fun main() {
    print("How many students? ")
    val studentCount = readLine()?.toIntOrNull() ?: 0

    if (studentCount <= 0) {
        println("Invalid amount of students.")
        return
    }

    val names = Array(studentCount) { "" }
    val grades = IntArray(studentCount)

    var running = true

    while (running) {
        println("\n=== Manage Scores ===")
        println("1. Input student data")
        println("2. Show all students")
        println("3. Calculate average score")
        println("4. Find top student")
        println("5. Exit")
        print("\nSelect: ")

        val choice = readLine()?.toIntOrNull() ?: 0

        when (choice) {
            1 -> inputStudentData(names, grades)
            2 -> displayAllStudents(names, grades)
            3 -> {
                val avg = calculateAverage(grades)
                println("\nAverage Score: %.2f".format(avg))
            }
            4 -> findTopStudent(names, grades)
            5 -> {
                running = false
                println("\nProgram exiting...")
            }
            else -> println("Invalid choice.")
        }
    }
}
