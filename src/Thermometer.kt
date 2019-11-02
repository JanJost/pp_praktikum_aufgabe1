
class Thermometer( private var meinSensor : Sensor ) {

    fun startChecking ( n : Int ) {
        var durchlaufe = n
        while ( durchlaufe != 0 ){
            println ("@Thermometer misst: ${meinSensor.getTemperature()} Grad")
            durchlaufe--
        }
    }
}