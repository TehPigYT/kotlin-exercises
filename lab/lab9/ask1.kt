class Pet(
    val name: String,
    val species: String,
    var age: Int
) {
    var hunger = 50;
    var happiness = 50;
    var energy = 50;

    fun feed(){
        if(hunger <= 0) return println("$name is full!")

        hunger = if (hunger > 30) hunger - 30 else 0
        energy = if (energy <= 90) energy + 10 else 100

        println("$name has been fed! (+10 energy | -30 hunger)")
    }

    fun play(){
        if(happiness >= 100) return println("$name is already excited!")

        happiness = if (happiness < 80) happiness + 20 else 100
        energy = if (energy > 15) energy - 15 else 0

        println("$name played! (+20 happiness | -15 energy)")
    }

    fun sleep() {
        if(energy >= 100) return println("$name is not tired!")

        energy = if (energy < 60) energy + 40 else 100

        println("$name took a good night's rest! (+40 energy)")
    }

    fun displayStatus() {
        println("=-".repeat(20))
        println("Name: $name | Species: $species | Age: $age")
        println("Hunger: $hunger | Happiness: $happiness | Energy: $energy")
        println("=-".repeat(20))
    }

    fun getOverallHealth(): String {
        val score = (100 - hunger + happiness + energy) / 3
        return when (score) {
            in 70..100 -> "Excellent!"
            in 40..69 -> "Good"
            else -> "Needs care"
        }
    }

    fun needsAttention(): Boolean {
        if (hunger > 70 || happiness < 30 || energy < 20) return true
        else return false
    }
}

fun addPet(pet: Pet, pets: MutableList<Pet>) {
    pets.add(pet)
}

fun showAllPets(pets: List<Pet>){
    for((index, pet) in pets.withIndex()) println("${index+1}. Name: ${pet.name} | Species: ${pet.species} | Age: ${pet.age}")
}

fun findPetByName(name: String, pets: List<Pet>): Pet? {
    val found = pets.find { it.name === name }

    if (found != null) return found
    else return null
}

fun getPetsNeedingAttention(pets: List<Pet>): List<Pet> {
    val petsNeedAttention = mutableListOf<Pet>()
    for ((index, pet) in pets.withIndex()) {
        if(pet.needsAttention()) petsNeedAttention.add(pet)
    }
    return petsNeedAttention
}

fun main(){
    val pet = Pet("Bob", "Yorkshire", 68)
    pet.feed()
    pet.play()
    pet.sleep()
    pet.displayStatus()
    println("Status: ${pet.getOverallHealth()}")
    println("Needs attention? ${pet.needsAttention()}")

    val pets: MutableList<Pet> = mutableListOf()
    addPet(pet, pets)
    showAllPets(pets)
    findPetByName("Bob", pets)
    val neededAttetion = getPetsNeedingAttention()
    // for((pet) in neededAttetion)
    // ...
}
