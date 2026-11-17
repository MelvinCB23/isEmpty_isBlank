package service;

public abstract class Validador<T> {
    protected Validador<T> siguiente;

    public void setSiguiente(Validador<T> siguiente) {
        if (siguiente == this) {
            throw new IllegalArgumentException("Un validador no puede enlazarse consigo mismo.");
        }
        this.siguiente = siguiente;
    }

    public abstract boolean procesar(T dato);

    protected boolean verificarSiguiente(T dato) {
        if (this.siguiente == null) {
            return true;
        }
        return this.siguiente.procesar(dato);
    }
}