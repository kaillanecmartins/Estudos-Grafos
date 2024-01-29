package grafo.core;

import java.util.List;
import grafo.search.BuscaEmLargura;
import grafo.search.BuscaEmProfundidade;

public class MainTemporaria {
    public static void main(String[] args) throws Exception {
        Grafo g = new Grafo();
        
        g.adicionarVertice("A");
        g.adicionarVertice("B");
        g.adicionarVertice("C");
        g.adicionarVertice("D");
        g.adicionarVertice("E");
        g.adicionarVertice("F");
        g.adicionarVertice("G");
        g.adicionarVertice("H");
        g.adicionarVertice("I");
        
        g.conectarVertices("A", "B");
        g.conectarVertices("A", "C");
        g.conectarVertices("A", "D");
        g.conectarVertices("B", "F");
        g.conectarVertices("B", "I");
        g.conectarVertices("D", "E");
        g.conectarVertices("D", "I");
        g.conectarVertices("D", "G");
        g.conectarVertices("I", "A");
        g.conectarVertices("I", "D");
        g.conectarVertices("I", "C");
        g.conectarVertices("I", "H");
        g.conectarVertices("E", "A");
        
        System.out.println("Grau do vértice A: " + g.getVertice("A").getGrau());
        System.out.println("Grau do vértice B: " + g.getVertice("B").getGrau());
        System.out.println("Grau do vértice C: " + g.getVertice("C").getGrau());
        System.out.println("Grau do vértice D: " + g.getVertice("D").getGrau());
        System.out.println("Grau do vértice E: " + g.getVertice("E").getGrau());
        System.out.println("Grau do vértice F: " + g.getVertice("F").getGrau());
        System.out.println("Grau do vértice G: " + g.getVertice("G").getGrau());
        System.out.println("Grau do vértice H: " + g.getVertice("H").getGrau());
        System.out.println("Grau do vértice I: " + g.getVertice("I").getGrau());
        
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
        
        System.out.println("");
        
        List<String> caminho = BuscaEmProfundidade.getInstance().buscar(g, "D", "H");
        System.out.print("Caminho feito por uma busca em profundidade: ");
        for(String passo : caminho) {
         System.out.print(passo + " ");
        }
        caminho = BuscaEmLargura.getInstance().buscar(g, "B", "G");
        System.out.println();
        System.out.print("Caminho feito por uma busca em largura: ");
        for(String passo : caminho) {
         System.out.print(passo + " ");
        }
        System.out.println("");

    }
}
