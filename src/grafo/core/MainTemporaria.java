package grafo.core;

import java.util.List;
import grafo.search.BuscaEmLargura;
import grafo.search.BuscaEmProfundidade;

public class MainTemporaria {
    public static void main(String[] args) throws Exception {
        /*Grafo g = new Grafo();
        
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

        Grafo arvore = g.arvoreGeradoraPorProfundidade();
        System.out.println();
        System.out.println("--- Árvore geradora ---");
        System.out.println("Vértices");
        for (Vertice v : arvore.getVertices()) {
            System.out.println("\t" + v.getRotulo());
        }
        System.out.println("Arestas");
        for (Vertice v : arvore.getVertices()) {
            for (Vertice adj : arvore.getAdjacencias(v.getRotulo())) {
                System.out.println("\t" + v.getRotulo() + adj.getRotulo());
            }
        }*/
        
        //novo teste com dígrafo
        
        Digrafo digrafo = new Digrafo();
        digrafo.adicionarVertice("RJ");
        digrafo.adicionarVertice("SP");
        digrafo.adicionarVertice("BH");
        digrafo.adicionarVertice("PT");
        digrafo.adicionarVertice("OS");
        digrafo.adicionarVertice("SV");
        digrafo.adicionarVertice("CR");
        digrafo.adicionarVertice("PA");
        digrafo.conectarVertices("RJ", "SP", null);
        digrafo.conectarVertices("RJ", "BH", null);
        digrafo.conectarVertices("RJ", "PT", null);
        digrafo.conectarVertices("RJ", "PA", null);
        digrafo.conectarVertices("SP", "BH", null);
        digrafo.conectarVertices("SP", "OS", null);
        digrafo.conectarVertices("SP", "SV", null);
        digrafo.conectarVertices("SP", "CR", null);
        digrafo.conectarVertices("SP", "PA", null);
        digrafo.conectarVertices("SV", "PA", null);
        digrafo.conectarVertices("CR", "PA", null);
        Grafo arvore = digrafo.arvoreGeradoraPorProfundidade("PT");
        System.out.println("--- Árvore geradora via busca por profundidade usando raiz-- -");
        System.out.println();
        
        for (Vertice v : arvore.getVertices()) {
            System.out.print("Vértice " + v.getRotulo() + " conectado a: ");
            List<Vertice> adjacencias = arvore.getAdjacencias(v.getRotulo());
            if (!adjacencias.isEmpty()) {
                for (Vertice adj : adjacencias) {
                    System.out.print(adj.getRotulo() + " ");
                }
            } else {
                System.out.print("-");
            }
            System.out.println();
        }

        //grafo ponderado
        
        Grafo grafoPonderado = new Grafo();
        grafoPonderado.adicionarVertice("A");
        grafoPonderado.adicionarVertice("B");
        grafoPonderado.adicionarVertice("C");
        grafoPonderado.adicionarVertice("D");
        grafoPonderado.adicionarVertice("E");
        grafoPonderado.conectarVertices("A", "B", 12);
        grafoPonderado.conectarVertices("C", "E", 10);
        grafoPonderado.conectarVertices("B", "D", 5);
        grafoPonderado.conectarVertices("D", "A", 2);
        grafoPonderado.conectarVertices("B", "E", 1);
        grafoPonderado.conectarVertices("A", "C", 7);
        System.out.println("Grafo Ponderado");
        int peso = grafoPonderado.getPeso("A", "C");
        System.out.println("Peso da aresta AC: " + peso);
        peso = grafoPonderado.getPeso("B", "E");
        System.out.println("Peso da aresta BE: " + peso);

        
       //digrafo ponderado
       
        Digrafo digrafoPonderado = new Digrafo();
        digrafoPonderado.adicionarVertice("X");
        digrafoPonderado.adicionarVertice("Y");
        digrafoPonderado.adicionarVertice("Z");
        digrafoPonderado.adicionarVertice("W");
        digrafoPonderado.adicionarVertice("V");
        digrafoPonderado.conectarVertices("X", "V", 44);
        digrafoPonderado.conectarVertices("Y", "W", 37);
        digrafoPonderado.conectarVertices("W", "Z", 38);
        digrafoPonderado.conectarVertices("X", "V", 16);
        digrafoPonderado.conectarVertices("V", "X", 22);
        digrafoPonderado.conectarVertices("V", "Y", 57);
        System.out.println("Dígrafo Ponderado");
        System.out.println("Vértices:");
        for (Vertice v : digrafoPonderado.getVertices()) {
            System.out.println("\t" + v.getRotulo());
        }
        System.out.println();
        System.out.println("Arestas:");
        for (Vertice v : digrafoPonderado.getVertices()) {
            for (Vertice adj : digrafoPonderado.getAdjacencias(v.getRotulo())) {
                System.out.println("\t" + v.getRotulo() + adj.getRotulo()
                        + " : " + digrafoPonderado.getPeso(v.getRotulo(),
                                adj.getRotulo()));
            }
        }

    }
}
