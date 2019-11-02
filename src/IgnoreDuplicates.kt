
open class IgnoreDuplicates( var zuIgnorierndeWerteSensor : Sensor ) : Sensor {

    private var oldValue = this.zuIgnorierndeWerteSensor.getTemperature()

    override fun getTemperature(): Float {

        var matchingSensorValue : Float = this.zuIgnorierndeWerteSensor.getTemperature()

        while (matchingSensorValue.toInt() == oldValue.toInt() ) {
            matchingSensorValue = this.zuIgnorierndeWerteSensor.getTemperature()
        }

        return matchingSensorValue
    }

}