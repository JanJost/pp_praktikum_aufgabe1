

interface TemperatureObserver {

    fun update( newValue : Float ){
        // does something
    }
}

class WeatherReport : TemperatureObserver {

    val valueList = ArrayList<Float>()
    var counter = 0

    override fun update( newValue : Float ) {
        counter++
        valueList.add(newValue.toFloat())       //just to be sure...
        if ( counter == 100 ) {
            print("Es wurden die Werte: ")
            valueList.forEach{
                print("${it}, ")
            }
            print(" gemessen")
            counter = 0
        }
    }
}

class TemperatureAlert : TemperatureObserver {
    var notifyValue = 37

    override fun update( newValue : Float ) {
        if ( newValue > notifyValue )
            println("Dang thats hot!")
    }
}

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