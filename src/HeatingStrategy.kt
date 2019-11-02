
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
        var isit : Boolean = false

        last10measurements.forEach{
            if( it <= (20).toFloat() ) isit = true
        }
        return isit
    }
}

class ReasonableHeatingStrategy : HeatingStrategy {

    override fun needsHeating( last10measurements : List<Float> ) : Boolean {
        var counter = 0

        last10measurements.forEach{
            if( it <= (15).toFloat() ) counter++
        }
        return counter >= 5
    }
}