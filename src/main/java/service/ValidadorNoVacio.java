package service;

public class ValidadorNoVacio extends Validador<String> {
    @Override
    public boolean procesar(String texto) {
        if (texto == null || texto.isEmpty()) {
            System.out.println("Fallo: El texto tiene longitud cero (isEmpty).");
            return false;
        }
        return verificarSiguiente(texto);
    }
}