
class Thermometer( private var meinSensor : Sensor) {

    val observerList = ArrayList<TemperatureObserver>()

    fun startChecking ( durchlaufe : Int ) {

        for ( x in 0..durchlaufe ){

            // println ("@Thermometer misst: ${newValue} Grad")

            informObserver( meinSensor.getTemperature() )

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