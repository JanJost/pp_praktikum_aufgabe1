import kotlin.math.roundToInt
import kotlin.random.Random

interface Sensor {

    fun getTemperature() : Float {
        return 0.0F
    }
}

class RandomSensor : Sensor {

    private val min = -10
    private val max = 45

    override fun getTemperature(): Float {
        return Random.nextFloat()+ Random.nextInt(min,max);
    }

}

class UpDownSensor() : Sensor {

    private var aktuelleTemperatur : Float = 22.0F

    override fun getTemperature(): Float {
        var schwankung : Float = Random.nextFloat()
        var schwankungCause : Int = Random.nextInt(1, 4)

        when (schwankungCause) {
            1 -> aktuelleTemperatur += schwankung
            2 -> aktuelleTemperatur -= schwankung
            3 -> aktuelleTemperatur
            else -> { // Note the block
                print("Fehler: SchwankungCause liefert falsche Werte")
            }
        }

        return aktuelleTemperatur;
    }
}

open class RoundValues( var zurundenderSensor: Sensor ) : Sensor {

    override fun getTemperature(): Float {
        return this.zurundenderSensor.getTemperature().roundToInt().toFloat()
    }

}

open class SensorLimits( var minmaxSensor : Sensor ) : Sensor {

    private val min = -10
    private val max = 45

    override fun getTemperature(): Float {

        var matchingSensorValue : Float = this.minmaxSensor.getTemperature()

        while (matchingSensorValue > max || matchingSensorValue < min) {
            matchingSensorValue = this.minmaxSensor.getTemperature()
        }

        return matchingSensorValue
    }

}

open class SensorLogger( var zuloggenderSensor : Sensor ) : Sensor {

    override fun getTemperature(): Float {
        var log = this.zuloggenderSensor.getTemperature()
        println("@SensorLogger: Die Temperatur beträgt: $log Grad.")
        return log
    }
}

open class IgnoreDuplicates( var zuIgnorierndeWerteSensor : Sensor ) : Sensor {

//    private var oldValue = this.zuIgnorierndeWerteSensor.getTemperature()
    private var oldValue = 0.0F

    override fun getTemperature(): Float {

        var matchingSensorValue : Float = this.zuIgnorierndeWerteSensor.getTemperature()

        while (((matchingSensorValue*100).roundToInt())/100 == ((oldValue*100).roundToInt())/100 ) {
            matchingSensorValue = this.zuIgnorierndeWerteSensor.getTemperature()
        }
        oldValue = matchingSensorValue
        return matchingSensorValue
    }

}