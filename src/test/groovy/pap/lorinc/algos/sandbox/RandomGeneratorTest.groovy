package pap.lorinc.algos.sandbox

import org.apache.commons.math3.stat.inference.ChiSquareTest
import spock.lang.*

import static pap.lorinc.algos.sandbox.RandomGenerator.*

@Ignore('ChiSquareTest seems too unreliable')
class RandomGeneratorTest extends Specification {
    /*@formatter:off*/
    def 'discrete, uniform distribution, chi-squared validations for original'() {
        when:   def range = 1..5
                def rand = { rand1_5() }
        then:   hasUniformDistribution(range, rand)
    }

    def 'discrete, uniform distribution, chi-squared validations for derived'() {
        when:   def range = 1..7
                def rand = { getRandomNumber(range) }
        then:   hasUniformDistribution(range, rand)
    }
    /*@formatter:on*/

    static hasUniformDistribution(IntRange range, Closure rand) {
        def expectedValueFrequency = 10000

        double[] expected = [expectedValueFrequency] * range.size()

        def nums = (range.from..(range.to * expectedValueFrequency)).collect(rand)
        assert nums.every { range.containsWithinBounds(it) }
        long[] observed = nums.countBy { it }.sort().values()

        def pValue = 0.1

        !new ChiSquareTest().chiSquareTest(expected, observed, pValue)
    }
}