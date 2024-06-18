package grafo.util;

import grafo.core.Digrafo;
import grafo.core.Vertice;
import java.util.HashMap;
import java.util.Map;

public class AlgoritmoFloydWarshall {
    private static AlgoritmoFloydWarshall algoritmoFloydWarshall;

    private AlgoritmoFloydWarshall() {
    }

    public static AlgoritmoFloydWarshall getInstance() {
        if (algoritmoFloydWarshall == null) {
            return new AlgoritmoFloydWarshall();
        }
        return algoritmoFloydWarshall;
    }
    
    public Map<String, Map<String, Info>> processar(Digrafo digrafo) {
        Map<String, Map<String, Info>> matriz = new HashMap<>();
        for (Vertice u : digrafo.getVertices()) {
            Map<String, Info> linha = new HashMap();
            matriz.put(u.getRotulo(), linha);
            for (Vertice v : digrafo.getVertices()) {
                int peso = digrafo.getPeso(u.getRotulo(), v.getRotulo());
                int valor = peso == 0 ? Integer.MAX_VALUE : peso;
                Info info = new Info();
                info.porQualVertice = v;
                info.distancia
                        = u.getRotulo().equalsIgnoreCase(v.getRotulo()) ? 0 : valor;
                linha.put(v.getRotulo(), info);
            }
        }
        for (Vertice k : digrafo.getVertices()) {
            Map<String, Info> linhaK = matriz.get(k.getRotulo());
            for (Vertice u : digrafo.getVertices()) {
                Map<String, Info> linhaU = matriz.get(u.getRotulo());
                Info uk = linhaU.get(k.getRotulo());
                for (Vertice v : digrafo.getVertices()) {
                    Info kv = linhaK.get(v.getRotulo());
                    
                    int soma = uk.distancia == Integer.MAX_VALUE
                            || kv.distancia == Integer.MAX_VALUE ? Integer.MAX_VALUE : uk.distancia
                                    + kv.distancia;
                    if (soma < linhaU.get(v.getRotulo()).distancia) {
                        Info info = new Info();
                        info.porQualVertice = uk.porQualVertice;
                        info.distancia = soma;
                        linhaU.put(v.getRotulo(), info);
                    }
                }
            }
        }
        return matriz;
    }
    
    public class Info {

        public int distancia;
        public Vertice porQualVertice;
    }

}
