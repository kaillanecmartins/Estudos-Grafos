package grafo.core;

import java.util.List;

public class MainTemporaria {
    public static void main(String[] args) throws Exception {
        Grafo g = new Grafo();
        
        g.adicionarVertice("A");
        g.adicionarVertice("B");
        g.adicionarVertice("C");
        g.adicionarVertice("D");
        
        
        g.conectarVertices("A", "B");
        g.conectarVertices("A", "C");
        g.conectarVertices("A", "D");
        
        System.out.println("Grau do vértice A: " + g.getVertice("A").getGrau());
        System.out.println("Grau do vértice B: " + g.getVertice("B").getGrau());
        System.out.println("Grau do vértice C: " + g.getVertice("C").getGrau());
        System.out.println("Grau do vértice D: " + g.getVertice("D").getGrau());
        
        System.out.println("\nO vértice A possui as seguintes adjacências: ");
        List<Vertice> adjacentes = g.getAdjacencias("A");
        for(Vertice vertice : adjacentes){
            System.out.println(vertice.getRotulo() + " ");
        }
        
        System.out.println("\nO vértice C possui as seguintes adjacências: ");
        adjacentes = g.getAdjacencias("C");
        for(Vertice vertice : adjacentes){
            System.out.println(vertice.getRotulo() + " ");
        }
        
    }
}
