
open class SensorLogger( var zuloggenderSensor : Sensor ) : Sensor {

    override fun getTemperature(): Float {
        var log = this.zuloggenderSensor.getTemperature()
        println("@SensorLogger: Die Temperatur beträgt: $log Grad.")
        return log
    }
}