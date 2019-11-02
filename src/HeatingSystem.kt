

class HeatingSystem : TemperatureObserver {

    val valueList = ArrayList<Float>()
    var counter = 0

    override fun update( newValue : Float ) {
        counter++
        valueList.add(newValue.toFloat())       //just to be sure...
        if ( counter == 10 ) {
            //do something
            counter = 0
        }
    }
}