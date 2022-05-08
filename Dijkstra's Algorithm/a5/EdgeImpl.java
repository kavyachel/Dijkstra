package a5;

public class EdgeImpl implements Edge {
    /* You will include the implementations for any edge methods you need in this file. */

    /*Hint: Make sure you update the Edge interface in Edge.java when you add a new method implementation
    in EdgeImpl.java, and vice-versa.  getName() in Node.java and NodeImpl.java is an example.  Also, files in
    previous homeworks (e.g., BST.java and BSTImpl.java in homework 3) are good examples of
    interfaces and their implementations.
     */

    /*Also, any edge fields you want to add for the object should go in this file.  */

    private String start_name;
    private String end_name;
    private double weight;


    public EdgeImpl(String first, String last, double weight) {
        this.start_name = first;
        this.end_name = last;
        this.weight = weight;
    }

    public EdgeImpl(String first, String last) {
        this.start_name = first;
        this.end_name = last;
        this.weight = 1;
    }


}
