package pap.lorinc.algos.ctci._04.utils

import groovy.transform.*

@TupleConstructor @ToString(includePackage = false, excludes = 'parent')
class BiNode<T> {
    T value
    BiNode<T> left, right, parent

    private Integer sizeCache
    def getSize(def node = this) {
        node ? node.sizeCache ?: (node.sizeCache = 1 + getSize(node.left) + getSize(node.right))
             : 0
    }
    private invalidateCaches() {
        for (def node = this; node?.sizeCache != null; node = node.parent)
            node.sizeCache = null
    }

    boolean getIsRightChild() { parent?.right == this }
    boolean getIsLeftChild() { parent?.left == this }
    void setLeft(BiNode<T> left) {
        left?.parent = this
        this.left = left
        invalidateCaches()
    }
    void setRight(BiNode<T> right) {
        right?.parent = this
        this.right = right
        invalidateCaches()
    }
    private void setParent(BiNode<T> parent) {
        this.parent = parent
        invalidateCaches()
    }
    private void setValue(T value) { this.value = value }

    boolean equals(o) {
        if (this.is(o)) return true
        else if (this.class != o.class) return false

        BiNode that = (BiNode) o
        (value == that.value
        && left == that.left
        && right == that.right)
    }
    int hashCode() { Objects.hash(value, left, right) }
}

abstract class BiNodeBuilder<T> {
    static from(Map<T, List<T>> values, BiNode<T> node = getRoot(values)) {
        if (node?.value == null) return null

        def children = [] + values.getOrDefault(node.value, [])
        switch (children.size()) {
            case 2: node.right = from(values, new BiNode(children[1])) /*noinspection GroovyFallthrough*/
            case 1: node.left = from(values, new BiNode(children[0])); break
            case 0: break
            default: throw new IllegalArgumentException('Not a binary tree!')
        }
        node
    }
    private static getRoot(Map<T, List<T>> values) {
        def root = (values.keySet() - values.values().flatten())
        switch (root.size()) {
            case 1: return new BiNode<T>(root.first())
            case 0: return null
            default: throw new IllegalArgumentException('Not a tree!')
        }
    }
}
