package grafo.core;

public class MainTemporaria {
    public static void main(String[] args) throws Exception {
        Grafo g = new Grafo();
        
        g.adicionarVertice("RJ");
        g.adicionarVertice("SP");
        g.adicionarVertice("BH");
        g.adicionarVertice("PT");
        g.adicionarVertice("OS");
        g.adicionarVertice("SV");
        g.adicionarVertice("CR");
        g.adicionarVertice("PA");
        
        System.out.println("O grafo G possui os seguintes vértices: \n");
        for(Vertice vertice : g.getVertices()){
            System.out.println("- Vertice " + vertice.getRotulo());
        }
        
    }
}
