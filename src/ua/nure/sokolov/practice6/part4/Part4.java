package ua.nure.sokolov.practice6.part4;

public class Part4 {
    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph();
        graph.addVertex("1");
        graph.addVertex("5");
        graph.addVertex("3");
        graph.addEdge("2","4");
        System.out.println(graph.getVertexMap());
        System.out.println(graph.hasVertex("6"));

    }
}
