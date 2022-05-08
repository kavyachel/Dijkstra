package a5;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

public class NodeImpl implements Node {

    /* You will include the method signatures (return type, name, and arg types) for any node methods you
    need in this file. */

    /*Hint: Make sure you update the Node interface in Node.java when you add a new method implementation
    in NodeImpl.java, and vice-versa.  getName() in Node.java and NodeImpl.java is an example.  Also, files in
    previous homeworks (e.g., BST.java and BSTImpl.java in homework 3) are good examples of
    interfaces and their implementations.
     */

    /*Also, any node fields you want to add for the object should go in this file.  */
    private String name;
    private int value;
    private HashMap<String, Double> edges;


    public NodeImpl(String name) {
        this.name = name;
        this.edges = new HashMap<String, Double>();
    }

        @Override
    public HashMap<String, Double> getEdges() { return edges; }
    //see if edge exists method (takes in a node as an argument)
    public boolean addEdge(String dest, double value) {
        this.edges.put(dest, value);
        return true;
    }

    public boolean delEdge(String dest) {
        this.edges.remove(dest);
        return true;
    }
}
