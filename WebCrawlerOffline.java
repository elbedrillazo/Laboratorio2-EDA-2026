import java.util.List;
/**
Clase principal del web crawler.
Se encarga de revisar que el html este bien armado y de recorrer los links de las paginas.
*/
public class WebCrawlerOffline {
    /**
    Revisa que las etiquetas del documento se abran y cierrern en el orden correcto.
    @param tokens Arreglo con las etiquetas que se van a leer.
    @param pila Pila vacia para ir guardando y sacando las etiquetas.
    @return true si todo esta bien cerrado, false si hay algun error.
    */
    public boolean validarEtiquetas(String[] tokens, Pila<String> pila) {
        for (int i = 0; i < tokens.length; i++) {
            String etiquetaActual = tokens[i];
            if (etiquetaActual.startsWith("</")){
                if (pila.isEmpty()) {
                    return false;
                }
                String ultimaApertura = pila.pop();
                String cierreEsperado = "</" + ultimaApertura.substring(1);
                if (!etiquetaActual.equals(cierreEsperado)) {
                    return false;
                }
            } 
            else {
                pila.push(etiquetaActual);
            }
        }
        return pila.isEmpty(); //se abrio todo correctamente
    }
    /**
    Recorre todas las paginas del sitio web usando una fila para no perden el orden.
    @param sitio El sitio web que vamos a explorar
    @param paginaInicial El numero de la pagina por donde empezamos
    @return La cantidad de paginas que logramos visitar.
    */
    public int recorrerSitio(GeneradorWeb sitio, int paginaInicial, Fila<Integer> frontera) { 
        int totalPaginas = sitio.cantidadPaginas();
        boolean[] descubiertas = new boolean[totalPaginas]; //para guardar paginas revisadas y no repetirlas
        descubiertas[paginaInicial] = true; 
        frontera.enqueue(paginaInicial);
        int paginasProcesadas = 0;
        while (!frontera.isEmpty()) {
            int paginaActual = frontera.dequeue();
            paginasProcesadas++; //le suma 1 al contador
            List<Integer> enlaces = sitio.obtenerEnlaces(paginaActual); //obtenemo el enlace de la pagina
            if (enlaces != null){
            for (int i = 0; i < enlaces.size(); i++) {
                int paginaDestino = enlaces.get(i);
                if (descubiertas[paginaDestino] == false) {
                    descubiertas[paginaDestino] = true; //se marca como descubierta
                    frontera.enqueue(paginaDestino);
                }
            }
            }
        }
        return paginasProcesadas;
    }
}
