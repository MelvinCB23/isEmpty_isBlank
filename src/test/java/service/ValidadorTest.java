package service;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ValidadorTest {

    private Validador<String> validadorNulo;
    private Validador<String> validadorVacio;
    private Validador<String> validadorBlanco;

    @Before
    public void setUp() {
        validadorNulo = new ValidadorNoNulo();
        validadorVacio = new ValidadorNoVacio();
        validadorBlanco = new ValidadorNoBlanco();

        validadorNulo.setSiguiente(validadorVacio);
        validadorVacio.setSiguiente(validadorBlanco);
    }

    @Test
    public void testCasoUnoNull() {
        String caso1 = null;
        assertFalse(validadorNulo.procesar(caso1));
    }

    @Test
    public void testCasoDosVacio() {
        String caso2 = "";
        assertFalse(validadorNulo.procesar(caso2));
    }

    @Test
    public void testCasoTresEspaciosEnBlanco() {
        String caso3 = "   ";
        assertFalse(validadorNulo.procesar(caso3));
    }

    @Test
    public void testCasoCuatroTextoValido() {
        String caso4 = "Texto Válido";
        assertTrue(validadorNulo.procesar(caso4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExcepcionCicloInfinito() {
        validadorNulo.setSiguiente(validadorNulo);
    }
}