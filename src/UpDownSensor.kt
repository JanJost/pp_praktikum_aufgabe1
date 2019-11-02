import kotlin.random.Random

// liefert kontinuierlich steigende,
// sinkende oder unveränderte Werte und simuliert somit normale Temperaturschwankungen

class UpDownSensor() : Sensor {

    val startValue : Float = 22F
    var tempChangeCounter = 0
    private var aktuelleTemperatur : Float = 0.0F

    override fun getTemperature(): Float {
        var schwankung : Float = Random.nextFloat()
        var schwankungCause : Int = Random.nextInt(1, 3)

        when (schwankungCause) {
            1 -> aktuelleTemperatur += schwankung
            2 -> aktuelleTemperatur -= schwankung
            else -> { // Note the block
                print("Fehler: SchwankungCause liefert falsche Werte")
            }
        }

        return aktuelleTemperatur;
    }
}