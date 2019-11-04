
interface HeatingStrategy {

    fun needsHeating( last10measurements : List<Float> ) : Boolean  {
        return false
    }

}

class InstantHeatingStrategy : HeatingStrategy {

    override fun needsHeating( last10measurements : List<Float> ) : Boolean {
        return last10measurements.last()<19
    }
}

class SensibleHeatingStrategy : HeatingStrategy {

    override fun needsHeating( last10measurements : List<Float> ) : Boolean {

        last10measurements.forEach{
            if( it <= (20).toFloat() ) return true
        }

        return false

    }
}

class ReasonableHeatingStrategy : HeatingStrategy {

    override fun needsHeating( last10measurements : List<Float> ) : Boolean {
        var counter = 0

        last10measurements.forEach{
            if( it <= (15).toFloat() ) return true
            if( it <= (19).toFloat() ) counter++
        }
        return (counter >= 5)
    }
}