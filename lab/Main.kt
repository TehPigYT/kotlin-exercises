// ==================== INTERFACE PLAYABLE ====================

interface Playable {
    // Abstract μέθοδοι - ΠΡΕΠΕΙ να υλοποιηθούν
    fun play()
    fun pause()
    fun stop()
    fun getDuration(): Int
    fun getTitle(): String

    // Default μέθοδος - μπορεί να χρησιμοποιηθεί ή να γίνει override
    fun displayInfo() {
        println("🎵 ${getTitle()} - Διάρκεια: ${getDuration()}s")
    }
}


// ==================== ΥΛΟΠΟΙΗΣΗ: SONG ====================

class Song(
    private val songTitle: String,
    private val artist: String,
    private val songDuration: Int
) : Playable {

    // Υλοποίηση των abstract μεθόδων
    override fun play() {
        println("🎵 Παίζει: $songTitle από $artist")
    }

    override fun pause() {
        println("⏸️ Παύση: $songTitle")
    }

    override fun stop() {
        println("⏹️ Σταμάτημα: $songTitle")
    }

    override fun getDuration(): Int {
        return songDuration
    }

    override fun getTitle(): String {
        return songTitle
    }

    // Μοναδική μέθοδος για Song
    fun skipToNext() {
        println("⏭️ Επόμενο τραγούδι")
    }
}


// ==================== ΥΛΟΠΟΙΗΣΗ: VIDEO ====================

class Video(
    private val videoTitle: String,
    var resolution: String,
    private val videoDuration: Int
) : Playable {

    override fun play() {
        println("🎬 Παίζει βίντεο: $videoTitle [$resolution]")
    }

    override fun pause() {
        println("⏸️ Παύση βίντεο: $videoTitle")
    }

    override fun stop() {
        println("⏹️ Σταμάτημα βίντεο: $videoTitle")
    }

    override fun getDuration(): Int {
        return videoDuration
    }

    override fun getTitle(): String {
        return videoTitle
    }

    // Override της default μεθόδου - δίνουμε custom εμφάνιση
    override fun displayInfo() {
        println("🎬 $videoTitle [$resolution] - Διάρκεια: ${videoDuration}s")
    }

    // Μοναδική μέθοδος για Video
    fun changeQuality(newResolution: String) {
        resolution = newResolution
        println("📺 Ανάλυση άλλαξε σε: $resolution")
    }
}


// ==================== ΥΛΟΠΟΙΗΣΗ: PODCAST ====================

class Podcast(
    private val podcastTitle: String,
    private val host: String,
    private val episode: Int,
    private val podcastDuration: Int
) : Playable {

    override fun play() {
        println("🎙️ Podcast: $podcastTitle - Επεισόδιο #$episode με $host")
    }

    override fun pause() {
        println("⏸️ Παύση podcast")
    }

    override fun stop() {
        println("⏹️ Σταμάτημα podcast")
    }

    override fun getDuration(): Int {
        return podcastDuration
    }

    override fun getTitle(): String {
        return "Ep.$episode: $podcastTitle"
    }

    // Μοναδική μέθοδος για Podcast
    fun speedUp(speed: Double) {
        println("⏩ Ταχύτητα αναπαραγωγής: ${speed}x")
    }
}


// ==================== ΠΟΛΥΜΟΡΦΙΚΕΣ ΣΥΝΑΡΤΗΣΕΙΣ ====================

// Δέχεται οποιοδήποτε Playable και το παίζει
fun playMedia(media: Playable) {
    media.displayInfo()
    media.play()
}

// Δημιουργεί playlist και υπολογίζει συνολική διάρκεια
fun createPlaylist(items: List<Playable>, name: String) {
    println("📂 Playlist: $name")
    println("─".repeat(25))

    var totalDuration = 0

    for (item in items) {
        item.displayInfo()
        totalDuration += item.getDuration()
    }

    println("─".repeat(25))
    val minutes = totalDuration / 60
    println("⏱️ Συνολική διάρκεια: ${totalDuration}s ($minutes λεπτά)")
}

// Βρίσκει το μέσο με τη μεγαλύτερη διάρκεια
fun findLongestMedia(items: List<Playable>): Playable? {
    if (items.isEmpty()) {
        return null
    }

    var longest = items[0]
    var maxDuration = longest.getDuration()

    for (item in items) {
        val currentDuration = item.getDuration()
        if (currentDuration > maxDuration) {
            maxDuration = currentDuration
            longest = item
        }
    }

    return longest
}

// Παίζει όλα τα μέσα στη σειρά
fun playAll(items: List<Playable>) {
    println("\n🎵 Αναπαραγωγή όλων...")
    for (item in items) {
        item.play()
    }
}


// ==================== MAIN FUNCTION ====================

fun main() {
    println("═══════════════════════════════════════")
    println("    🎵 MEDIA PLAYER SYSTEM 🎵")
    println("═══════════════════════════════════════")

    // Δημιουργία media
    val song = Song("Bohemian Rhapsody", "Queen", 354)
    val video = Video("Inception Trailer", "1080p", 158)
    val podcast = Podcast("Debate: Jordan Peterson vs Peter Jordanson", "Matan Even", 142, 18000)
    val podcast1 = Podcast("Joe Rogan vs Roe Jogan", "Matan Even", 20000, 20000000)
    val podcast2 = Podcast("Elon Musk vs Mlon Eusk", "Matan Even", 20000, 20000000)

    println("\n=== ΑΝΑΠΑΡΑΓΩΓΗ ΜΕΣΩΝ ===")
    playMedia(song)
    println()
    playMedia(video)
    println()
    playMedia(podcast)
    println()
    playMedia(podcast1)
    println()
    playMedia(podcast2)

    println("\n=== ΔΗΜΙΟΥΡΓΙΑ PLAYLIST ===")
    val myPlaylist: List<Playable> = listOf(song, video, podcast)
    createPlaylist(myPlaylist, "Τα Αγαπημένα Μου")

    println("\n=== ΜΕΓΑΛΥΤΕΡΗ ΔΙΑΡΚΕΙΑ ===")
    val longest = findLongestMedia(myPlaylist)
    if (longest != null) {
        println("Μεγαλύτερη διάρκεια: ${longest.getTitle()} - ${longest.getDuration()}s")
    }

    println("\n=== ΑΝΑΠΑΡΑΓΩΓΗ ΟΛΩΝ ===")
    playAll(myPlaylist)

    println("\n=== ΕΙΔΙΚΕΣ ΛΕΙΤΟΥΡΓΙΕΣ ===")
    song.skipToNext()
    video.changeQuality("4K")
    podcast.speedUp(4.5)

    println("\n═══════════════════════════════════════")
    println("       ✨ ΤΕΛΟΣ ΠΡΟΓΡΑΜΜΑΤΟΣ ✨")
    println("═══════════════════════════════════════")
}