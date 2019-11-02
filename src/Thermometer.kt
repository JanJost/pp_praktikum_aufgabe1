
class Thermometer( private var meinSensor : Sensor) {

    val observerList = ArrayList<TemperatureObserver>()

    fun startChecking ( n : Int ) {
        var durchlaufe = n
        while ( durchlaufe != 0 ){
            var newValue = meinSensor.getTemperature()
            // println ("@Thermometer misst: ${newValue} Grad")
            informObserver( newValue )
            durchlaufe--
        }
    }

    fun addObserver( newObserver : TemperatureObserver ){
        observerList.add(newObserver)
    }

    fun informObserver( newValue : Float ){
        observerList.forEach{
            it.update( newValue )
        }
    }
}