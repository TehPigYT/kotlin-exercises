fun countScores(scoreArray: IntArray): Triple<Int, Int, Int> {
    var sum = 0
    var max = 0
    var max_id = 0
    for((i, score) in scoreArray.withIndex()){
        print("ID: $i | Score: $score >> ")

        if(max < score){
            max = score
            max_id = i
        }
        sum += score
    };
    val avg = sum / scoreArray.size
    return Triple(avg, max, max_id)
}

fun showMenu() {
    println("\n=== Score Evaluation ===")
    println("1. Evaluate student score")
    println("2. Show statistics")
    println("3. Exit")
    print("Selection: ")
}

fun printScore(score: Int) {
    when (score) {
        in 85..100 -> println("Score: $score -> Grade: A (Excellent!)")
        in 66..84 -> println("Score: $score -> Grade: B (Well done)")
        in 50..65 -> println("Score: $score -> Grade: C (Good)")
        else -> println("Score: $score -> Grade: F (Fail)")
    }
}

fun main() {
    var running = true;
    var studentCount = 0

    val scoreArray = IntArray(10)

    while (running) {
        // Show menu
        showMenu()

        val choice = readLine()?.toIntOrNull() ?: 0

        when (choice) {
            1 -> {
                print("Input student score: ")
                val score = readLine()?.toIntOrNull() ?: 0

                printScore(score)

                scoreArray[studentCount] = score;
                studentCount++;
            }
            2 -> {
                // If check for plural

                // Statistics
                println("Statistics: Total Students: $studentCount")

                val (avg, max, max_id) = countScores(scoreArray)

                println("Average Score: $avg")
                println("Max Score: $max (ID: $max_id)")
            }
            3 -> {
                running = false
                println("Program is terminating...")
            }
            else -> println("Invalid choice.")
        }
    }
}
