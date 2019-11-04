
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
        var itDoesNeedHeating : Boolean = false

        last10measurements.forEach{
            if( it <= (20).toFloat() ) itDoesNeedHeating = true
        }
        return itDoesNeedHeating
    }
}

class ReasonableHeatingStrategy : HeatingStrategy {

    override fun needsHeating( last10measurements : List<Float> ) : Boolean {
        var instantNeeded = 0
        var calmNeed = 0

        last10measurements.forEach{
            if( it <= (15).toFloat() ) instantNeeded++
            if( it <= (19).toFloat() ) calmNeed++
        }
        return (instantNeeded >= 1) || (calmNeed >= 5)
    }
}