package service;

public class ValidadorNoBlanco extends Validador<String> {
    @Override
    public boolean procesar(String texto) {
        if (texto == null || texto.isBlank()) {
            System.out.println("Fallo: El texto solo contiene espacios (isBlank).");
            return false;
        }
        return verificarSiguiente(texto);
    }
}