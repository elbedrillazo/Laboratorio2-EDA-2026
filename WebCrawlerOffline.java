public class WebCrawlerOffline {
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
