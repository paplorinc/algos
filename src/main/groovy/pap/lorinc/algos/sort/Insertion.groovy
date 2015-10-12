package pap.lorinc.algos.sort

import groovy.transform.CompileStatic

import static java.util.Collections.swap

@CompileStatic class Insertion {
    static <T extends Comparable<T>> Collection<T> sort(Collection<T> originalElems) {
        def elems = originalElems.toList()
        elems.indices.each { int i ->
            (i..<0).find { int j ->
                !((elems[j] < elems[j - 1])
                        && !swap(elems, j, j - 1))
            }
        }
        elems
    }
}