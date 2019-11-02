import kotlin.random.Random

// liefert zufällige Temperaturwerte (Fließkommazahlen) innerhalb eines Wertebereichs
// (min, max als Eigenschaften anlegen)

class RandomSensor() : Sensor {

    private val min = -10
    private val max = 45

    override fun getTemperature(): Float {
        return Random.nextFloat()+ Random.nextInt(min,max);
    }

}
