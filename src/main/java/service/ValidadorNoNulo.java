package service;

public class ValidadorNoNulo extends Validador<String> {
    @Override
    public boolean procesar(String texto) {
        if (texto == null) {
            System.out.println("Fallo: El texto es nulo.");
            return false;
        }
        return verificarSiguiente(texto);
    }
}