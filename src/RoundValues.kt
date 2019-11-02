
open class RoundValues( var zurundenderSensor: Sensor ) : Sensor {

    override fun getTemperature(): Float {
        return this.zurundenderSensor.getTemperature().toInt().toFloat()
    }
}