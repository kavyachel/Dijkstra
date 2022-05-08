package a5;

public class Main {


    public static void main(String[] args) {

        //You are encouraged (but not required) to include your testing code here.

        //Hint: Try to test basic operations (e.g., adding a few nodes and edges to graphs)
        //before you implement more complex methods
        Graph test = new GraphImpl();

        test.addNode("A");
        test.addNode("B");
        test.addNode("C");
        test.addNode("D");
        test.addNode("E");
        test.addNode("F");
        test.addNode("G");
        test.addEdge("A", "B", 9);
        test.addEdge("A", "D", 4);
        test.addEdge("B", "E", 3);
        test.addEdge("C", "B", 1);
        test.addEdge("D", "B", 1);
        test.addEdge("D", "F", 5);
        test.addEdge("D", "G", 6);
        test.addEdge("E", "F", 1);
        test.addEdge("F", "C", 2);



        /*test.addNode("A");
        test.addNode("B");
        test.addNode("C");
        test.addNode("D");

        test.addEdge("A", "B", 1);
        test.addEdge("A", "C", 1);
        test.addEdge("B", "C", 1);
        test.addEdge("C", "D", 1);*/
        System.out.println(test.numEdges());

        //test.deleteNode("B");
        System.out.println(test.numEdges());
        System.out.println(test.numNodes());
        //System.out.print(test);
        test.dijkstra("A");
    }

}
