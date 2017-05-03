package analysis;

import base.Count;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * A conceptualization of rhythm as gradual, equal subdivisions of some concrete amount of time.
 * RhythmTrees operate like many other data structures save that their only "real" storage is in
 * their leaf nodes.
 */
public class RhythmTree {

    /** Saves the root RhythmNode **/
    private RhythmNode root;

    /**
     * The rhythmTree default constructor
     */
    public RhythmTree() {
        root = new RhythmNode(this,null,Count.ZERO,Count.ONE);
    }

    /**
     * Quick constructor to make rhythm tree (mainly for testing)
     * @param subDiv list of subdivisions in Breadth First order
     */
    public RhythmTree(int[] subDiv) throws IllegalArgumentException{
        Queue<RhythmNode> constructQueue = new ArrayDeque<RhythmNode>();

        root = new RhythmNode(this,null, Count.ZERO,Count.ONE);
        constructQueue.add(root);

        RhythmNode currentNode;

        for (int aSubDiv : subDiv) {
            if (constructQueue.size() != 0) {
                currentNode = constructQueue.poll();
            } else {
                throw new IllegalArgumentException("List cannot be converted to a rhythm tree, not enough divisions");
            }
            if(aSubDiv != 1) {
                currentNode.subdivide(aSubDiv);
                constructQueue.addAll(currentNode.getChildren());
            }
        }

        if(constructQueue.size() != 0){
            throw new IllegalArgumentException("List cannot be converted to a rhythm tree, leftover divisions");
        }
    }

    /**
     * Returns a nicely-formatted string
     * representing this rhythmTree.
     * @return A String of this rhythmTree.
     */
    public String toString() {
        return root.toString();
    }

    /**
     * Getter for the root RhythmNode which fills the whole measure.
     * @return Gets the root RhythmNode of this RhythmTree.
     */
    public RhythmNode getRoot() {
        return root;
    }

    /**
     * Converts this RhythmTree to a List of Integer subdivisions
     * @return A List of Integer subdivisions.
     */
    public ArrayList<Integer> toList() {
        return root.toList();
    }
}