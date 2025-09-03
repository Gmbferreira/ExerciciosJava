import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;


public class CalculadoraTest {
    private Calculadora calculadora;
    
    @Test
    public void testSoma() {
        calculadora = new Calculadora(5, 3, '+');
        assertEquals(8, calculadora.calcular(), 0.001);
    }
    @Test
    public void testSubtracao() {
        calculadora = new Calculadora(5, 3, '-');
        assertEquals(2, calculadora.calcular(), 0.001);
    }
    @Test
    public void testMultiplicacao() {
        calculadora = new Calculadora(5, 3, '*');
        assertEquals(15, calculadora.calcular(), 0.001);
    }
    @Test
    public void testDivisao() {
        calculadora = new Calculadora(6, 3, '/');
        assertEquals(2, calculadora.calcular(), 0.001);
    }

    @Test
    public void testDivisaoPorZero() {
        calculadora = new Calculadora(6, 0, '/');
        assertEquals(0, calculadora.calcular(), 0.001);
    }   
    @Test
    public void testToString() {
        calculadora = new Calculadora(5, 3, '+');
        calculadora.calcular();
        assertEquals("Resultado: 8.0", calculadora.toString());
    }

}
