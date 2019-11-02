
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