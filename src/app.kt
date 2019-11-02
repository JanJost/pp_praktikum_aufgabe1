

fun main (  ) {
    val thermometerOG = Thermometer(RoundValues(UpDownSensor()) )
    val thermometer1 = Thermometer(IgnoreDuplicates(RandomSensor()) )
    val thermometer2 = Thermometer(SensorLimits(UpDownSensor()) )
    val thermometer3 = Thermometer(SensorLogger(RandomSensor()) )

    thermometerOG.addObserver( WeatherReport() )
    thermometer1.addObserver( TemperatureAlert() )
    thermometer2.addObserver( HeatingSystem() )
    thermometer3.addObserver( HeatingSystem() )

    thermometerOG.startChecking(1000)
    thermometer1.startChecking(10)
    thermometer2.startChecking(10)
    thermometer3.startChecking(10)

}