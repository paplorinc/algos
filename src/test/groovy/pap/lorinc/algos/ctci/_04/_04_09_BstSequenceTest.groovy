package pap.lorinc.algos.ctci._04

import pap.lorinc.algos.ctci._04.utils.BiNodeBuilder
import spock.lang.*

import static _04_05_CheckBst.isBst
import static _04_09_BstSequence.sources

@Unroll class _04_09_BstSequenceTest extends Specification {
    /*@formatter:off*/
    def 'bstSequence from #tree?'() {
        when:   def bst = BiNodeBuilder.from(tree)
                assert isBst(bst)
        then:   sources(bst) == result.toSet()

        where:
        tree                      || result
        [0:[]]                    || [[0]]
                                
        [0:[null,1]]              || [[0,1]]
        [1:0]                     || [[1,0]]
                             
        [0:[null,1],1:[null,2]]   || [[0,1,2]]
        [0:[null,2],2:1]          || [[0,2,1]]
        [1:[0,2]]                 || [[1,0,2],[1,2,0]]
        [2:0,0:[null,1]]          || [[2,0,1]]
        [2:1,1:0]                 || [[2,1,0]]
                                 
        [0:[null,2],2:[1,3]]      || [[0,2,1,3],[0,2,3,1]]
        [1:[0,3],3:2]             || [[1,0,3,2],[1,3,0,2],[1,3,2,0]]
        [2:[1,3],1:0]             || [[2,1,3,0],[2,1,0,3],[2,3,1,0]]
        [3:2,2:1,1:0]             || [[3,2,1,0]]
                                
        [2:[1,4],1:0,4:3]         || [[2,1,4,0,3],[2,1,4,3,0],[2,1,0,4,3],[2,4,1,3,0],[2,4,1,0,3],[2,4,3,1,0]]
        [3:[1,5],1:[0,2],5:[4,6]] || [[3,1,0,2,5,4,6],[3,1,0,5,2,4,6],[3,1,0,5,4,2,6],[3,1,0,5,4,6,2],[3,1,5,0,2,4,6],[3,1,5,0,4,2,6],[3,1,5,0,4,6,2],[3,1,5,4,0,2,6],[3,1,5,4,0,6,2],[3,1,5,4,6,0,2],[3,5,1,0,2,4,6],[3,5,1,0,4,2,6],[3,5,1,0,4,6,2],[3,5,1,4,0,2,6],[3,5,1,4,0,6,2],[3,5,1,4,6,0,2],[3,5,4,1,0,2,6],[3,5,4,1,0,6,2],[3,5,4,1,6,0,2],[3,5,4,6,1,0,2],[3,1,0,2,5,6,4],[3,1,0,5,2,6,4],[3,1,0,5,6,2,4],[3,1,0,5,6,4,2],[3,1,5,0,2,6,4],[3,1,5,0,6,2,4],[3,1,5,0,6,4,2],[3,1,5,6,0,2,4],[3,1,5,6,0,4,2],[3,1,5,6,4,0,2],[3,5,1,0,2,6,4],[3,5,1,0,6,2,4],[3,5,1,0,6,4,2],[3,5,1,6,0,2,4],[3,5,1,6,0,4,2],[3,5,1,6,4,0,2],[3,5,6,1,0,2,4],[3,5,6,1,0,4,2],[3,5,6,1,4,0,2],[3,5,6,4,1,0,2],[3,1,2,0,5,4,6],[3,1,2,5,0,4,6],[3,1,2,5,4,0,6],[3,1,2,5,4,6,0],[3,1,5,2,0,4,6],[3,1,5,2,4,0,6],[3,1,5,2,4,6,0],[3,1,5,4,2,0,6],[3,1,5,4,2,6,0],[3,1,5,4,6,2,0],[3,5,1,2,0,4,6],[3,5,1,2,4,0,6],[3,5,1,2,4,6,0],[3,5,1,4,2,0,6],[3,5,1,4,2,6,0],[3,5,1,4,6,2,0],[3,5,4,1,2,0,6],[3,5,4,1,2,6,0],[3,5,4,1,6,2,0],[3,5,4,6,1,2,0],[3,1,2,0,5,6,4],[3,1,2,5,0,6,4],[3,1,2,5,6,0,4],[3,1,2,5,6,4,0],[3,1,5,2,0,6,4],[3,1,5,2,6,0,4],[3,1,5,2,6,4,0],[3,1,5,6,2,0,4],[3,1,5,6,2,4,0],[3,1,5,6,4,2,0],[3,5,1,2,0,6,4],[3,5,1,2,6,0,4],[3,5,1,2,6,4,0],[3,5,1,6,2,0,4],[3,5,1,6,2,4,0],[3,5,1,6,4,2,0],[3,5,6,1,2,0,4],[3,5,6,1,2,4,0],[3,5,6,1,4,2,0],[3,5,6,4,1,2,0]]
    }
    /*@formatter:on*/
}
