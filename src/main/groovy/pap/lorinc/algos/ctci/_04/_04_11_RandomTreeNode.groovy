package pap.lorinc.algos.ctci._04

import pap.lorinc.algos.ctci._04.utils.BiNode

class _04_11_RandomTreeNode {
    static getRandomNode(BiNode root, Random rand = new Random()) {
        def (randomIndex, rootIndex) = [rand.nextInt(root.size), root.getSize(root.left)]
        switch (randomIndex <=> rootIndex) {
            case -1: return getRandomNode(root.left)
            case 0: return root
            case +1: return getRandomNode(root.right)
        }
    }
}
