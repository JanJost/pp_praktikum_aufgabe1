

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
            print(" gemessen.")
            println(" ")
            valueList.clear()
            counter = 0
        }
    }
}

class TemperatureAlert : TemperatureObserver {
    val notifyValue = 37

    override fun update( newValue : Float ) {
        if ( newValue > notifyValue )
            println("Dang, thats hot!")
    }
}

class HeatingSystem : TemperatureObserver {

    val valueList = ArrayList<Float>()
    var counter = 0
    var myHeatingStrategy : HeatingStrategy = ReasonableHeatingStrategy()

    override fun update( newValue : Float ) {
        counter++
        valueList.add(newValue.toFloat())       //just to be sure...
        if ( counter == 10 ) {
            if(myHeatingStrategy.needsHeating(valueList)){
                println("@Heizung AN")
            } else {
                println("@Heizung AUS")
            }
            valueList.clear()
            counter = 0
        }
    }

    fun addStrategy( HeatingStrategy: HeatingStrategy ) {
        myHeatingStrategy = HeatingStrategy
    }
}