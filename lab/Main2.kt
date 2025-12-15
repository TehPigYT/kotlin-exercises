import javax.xml.stream.events.Characters

open class GameCharacter(
    val name: String,
    var health: Int = 100,
    var level: Int = 1,
) {
    var experience: Int = 0

    open fun attack(): Int = 10
    open fun defend(): Int = 5
    open fun getDescription(): String = "Character: $name"

    fun takeDamage(damage: Int){
        if(health >= 0 && health <= damage) health = 0
        else health -= damage
    }

    fun heal(amount: Int){
        if(health <= 100 && (health + amount >= 100)) health = 100
        else health += amount
    }

    fun gainExperience(xp: Int){
        if(experience >= 100){
            level++
            experience = 0
        } else experience += xp
    }

    fun isAlive(): Boolean {
        return health > 0
    }

    fun displayStats(){
        getDescription()
        print("Name: $name | ")
        print("Health: $health | ")
        print("Level: $level | ")
        println("Experience: $experience")
    }
}

class Warrior (name: String) : GameCharacter(name) {
    var weaponPower: Int = 15

    override fun attack(): Int = 10 + weaponPower
    override fun defend(): Int = 5 + 10
    override fun getDescription(): String = "⚔️ Warrior: $name"

    fun shieldBlock(): Int = 20
}

class Mage (name: String) : GameCharacter(name) {
    var mana: Int = 50

    override fun attack(): Int = 10 + 20
    override fun defend(): Int = 5 + 3
    override fun getDescription(): String = "🔮 Mage: $name"

    fun castSpell(): Int {
        if(mana >= 20){
            mana -= 20
            return 40
        }
        return 0
    }
    fun restoreMana(amount: Int) {
        if(amount > 50) mana += 50
        else mana += amount
    }
}

class Archer (name: String) : GameCharacter(name) {
    var arrows: Int = 10

    override fun attack(): Int {
        if(arrows > 0){
            arrows--
            return 18
        }
        return 5
    }
    override fun defend(): Int = 5 + 5
    override fun getDescription(): String = "🏹 Archer: $name"

    fun refillArrows(amount: Int) {
        if(amount > 10) arrows += 10
        else arrows += amount
    }
}

fun characterAttack(character: GameCharacter){
    character.getDescription()
    println("Attacks with power: [${character.attack()}]")
}

fun battle(attacker: GameCharacter, defender: GameCharacter){
    val aDmg = attacker.attack()
    val dDmg = defender.defend()
    val totalDmg = aDmg - dDmg
    defender.takeDamage(totalDmg)
    attacker.displayStats()
    defender.displayStats()
}

fun findStrongestCharacter(characters: List<GameCharacter>): GameCharacter? {
    return characters.maxByOrNull { it.attack() }
}

fun healTeam(characters: List<GameCharacter>, healAmount: Int){
    for(c in characters) c.heal(healAmount)
}

fun main() {
    // Δημιουργία χαρακτήρων
    val warrior = Warrior("Αχιλλέας")
    val mage = Mage("Μέρλιν")
    val archer = Archer("Ρόμπιν")

    println("=== ΧΑΡΑΚΤΗΡΕΣ ===")
    warrior.displayStats()
    mage.displayStats()
    archer.displayStats()

    println("\n=== ΕΠΙΘΕΣΕΙΣ ===")
    characterAttack(warrior)
    characterAttack(mage)
    characterAttack(archer)

    println("\n=== ΜΑΧΗ ===")
    battle(mage, warrior)

    println("\n=== ΙΣΧΥΡΟΤΕΡΟΣ ===")
    val party: List<GameCharacter> = listOf(warrior, mage, archer)
    val strongest = findStrongestCharacter(party)
    println("Ισχυρότερος: ${strongest?.getDescription()}")

    println("\n=== ΘΕΡΑΠΕΙΑ ΟΜΑΔΑΣ ===")
    healTeam(party, 20)
    warrior.displayStats()
}