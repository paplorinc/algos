package pap.lorinc.algos.ctci._1

import spock.lang.Specification

import static pap.lorinc.algos.ctci._1._1_5_EditDistance.isCloseEnough

class _1_5_EditDistanceTest extends Specification {
    /*@formatter:off*/
    def 'isCloseEnough?'() {
        expect: isCloseEnough(a, b) == isCloseEnough
        where:  a       | b      || isCloseEnough
                'pale'  | 'ale'  || true
                'pale'  | 'ple'  || true
                'pale'  | 'pae'  || true
                'pale'  | 'pal'  || true
                'pales' | 'pale' || true

                'pale'  | 'bale' || true
                'pale'  | 'pala' || true

                'pale'  | 'bake' || false
                'pale'  | 'pak'  || false
    }
    /*@formatter:on*/
}