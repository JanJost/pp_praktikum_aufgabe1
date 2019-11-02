
class TemperatureAlert : TemperatureObserver {
    var notifyValue = 37

    override fun update( newValue : Float ) {
        if ( newValue > notifyValue )
            println("Dang thats hot!")
    }
}