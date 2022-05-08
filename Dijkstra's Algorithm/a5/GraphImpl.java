package a5;

import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;

public class GraphImpl implements Graph {
    Map<String, Node> nodes; //Do not delete.  Use this field to store your nodes.

    // key: name of node. value: a5.Node object associated with name
    public GraphImpl() {
        nodes = new HashMap<>(0);
    }

    private int nodeCount = 0;
    private int edgeCount = 0;

    @Override
    public boolean addNode(String name) {
        //creating an adding a new node
        if (nodes.containsKey(name) == true) {
            return false;
        }
        Node newNode = new NodeImpl(name);
        nodes.put(name, newNode);

        nodeCount++;
        return true;  //Dummy return value.  Remove when you implement!
    }


    @Override
    public boolean addEdge(String src, String dest, double weight) {
        if (weight < 0) {
            return false;
        }
        if (!nodes.containsKey(src)) {
            return false;
        }
        if (!nodes.containsKey(dest)) {
            return false;
        }
        if (nodes.get(src).getEdges().containsKey(dest)) {
            return false;
        }
        /*
        if (nodes.get(dest).getEdges().containsKey(src)) {
            return false;
        }
        */
        Edge newEdge = new EdgeImpl(src, dest, weight);

        nodes.get(src).addEdge(dest, weight);
        //nodes.get(dest).addEdge(src, weight);

        edgeCount++;
        return true;  //Dummy return value.  Remove when you implement!
    }

    @Override
    public boolean deleteNode(String name) {
        //Hint: Do you need to remove edges when you delete a node?
        if (!nodes.containsKey(name)) {
            return false;
        }
        //Go through edges list in "name"
        //For each node in edges, delete "name" from that node's edge list
        for (String test: nodes.keySet()) {
            if (nodes.get(test).getEdges().containsKey(name)) {
                nodes.get(test).getEdges().remove(name);
                edgeCount--;
            }
        }
        //clear "name"'edge list
        edgeCount = edgeCount - nodes.get(name).getEdges().size();
        nodes.get(name).getEdges().clear();
        nodes.remove(name);
        nodeCount--;
        return true;  //Dummy return value.  Remove when you implement!
    }

    @Override
    public boolean deleteEdge(String src, String dest) {
        if (!nodes.get(src).getEdges().containsKey(dest)) {
            return false;
        }
        nodes.get(src).delEdge(dest);
        //nodes.get(dest).delEdge(src);
        edgeCount--;
        return true;  //Dummy return value.  Remove when you implement!
    }

    @Override
    public int numNodes() {
        return nodeCount;  //Dummy return value.  Remove when you implement!
    }

    @Override
    public int numEdges() {
        return edgeCount;  //Dummy return value.  Remove when you implement!
    }

    public class ShortestPathQueueObject {
        public String label;
        public double distance;

        public ShortestPathQueueObject(String label, double distance) {
            this.label = label;
            this.distance = distance;
        }
    }

    @Override
    public Map<String, Double> dijkstra(String start) {
        //returns a map with the shortest distance to all the nodes in the graph.
        if (!nodes.containsKey(start)) {
            return null;
        }
        Map<String, Double> distance = new HashMap<String, Double>(0);

        Comparator<ShortestPathQueueObject> compare = (a, b) -> Double.compare(a.distance, b.distance);
        PriorityQueue<ShortestPathQueueObject> queue = new PriorityQueue<ShortestPathQueueObject>(compare);
        // Adds ("A", 0)
        queue.add(new ShortestPathQueueObject(start, 0));
        Node startNode = nodes.get(start);

        for (String edge: startNode.getEdges().keySet()) {
            // Adds all neighbors edges of A
            //Also adds them to an
            queue.add(new ShortestPathQueueObject(edge, startNode.getEdges().get(edge)));
        }

        ShortestPathQueueObject minimum = queue.remove();
        distance.put(minimum.label, minimum.distance);

        for (int i = 0; i <= nodes.size(); i++) {
            // find node with minimum distance in PQ
            if (!queue.isEmpty()) {
                minimum = queue.remove();
                Node minNode = nodes.get(minimum.label);
                //look through each of the nodes in minimum node

                for (String name: minNode.getEdges().keySet()) {
                    //if node is in final hashmap then move on to next node in name.edges

                    if (!distance.containsKey(name)) {
                        //checking to see if edge is in PQ already
                        ShortestPathQueueObject element = new ShortestPathQueueObject(name, minimum.distance + minNode.getEdges().get(name));
                        queue.add(element);

                        for (ShortestPathQueueObject test: queue) {
                            if (test.label.equals(element.label)) {
                                // if element already exists, sort them in order of increasing distance
                                if (compare.compare(test, element) == 1){
                                    //queue.remove(test);
                                    test.distance = element.distance;
                                }
                                else if (compare.compare(test, element) == -1) {
                                    //queue.remove(element);
                                    element.distance = test.distance;
                                }
                            }
                        }
                    }
                }
                if (!distance.containsKey(minimum.label)) {
                    distance.put(minimum.label, minimum.distance);
                }
            }
        }
        System.out.println(distance);
        return distance;
    }


}
