
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContaBancariaTest {
    ContaBancaria conta1;
    ContaBancaria conta2;
    @BeforeEach
    public void setUp() {
        conta1 = new ContaBancaria("12345678900", "12345", 500);
        conta2 = new ContaBancaria("98765432100", "54321", 100);
        conta2.depositar(200);
    }
    @Test
    public void testDepositar(){
        assertEquals(0.0d, conta1.getSaldo(),0.01);
        conta1.depositar(100);
        assertEquals(100.0d, conta1.getSaldo(),0.01);
    }
    @Test 
    public void testDepositarNegativo(){
        conta1.depositar(-100);
        assertEquals(0.0d, conta1.getSaldo(),0.01);
    }
    @Test
    public void testDepositarComTaxa(){
        conta2.sacar(250);
        assertEquals(-50.0d, conta2.getSaldo(),0.01);
        conta2.depositar(100);
        assertEquals(48.5d, conta2.getSaldo(),0.01);
    }
    @Test
    public void testSacar(){
        conta2.sacar(50);
        assertEquals(150.0d, conta2.getSaldo(),0.01);

    }
    @Test
    public void testSacarLimite(){
        conta2.sacar(250);
        assertEquals(-50.0d, conta2.getSaldo(),0.01);
    }
    @Test
    public void testSacarLimiteExcedido(){
        conta2.sacar(350);
        assertEquals(200.0d, conta2.getSaldo(),0.01);
    }
    @Test
    public void testToStringCorreto(){
        assertEquals("Conta ID: 54321, CPF: 98765432100, Saldo: 200.0, Limite: 100.0", conta2.toString());
    }
    @Test
    public void testToStringIncorreto(){
        ContaBancaria conta3 = new ContaBancaria("12345678900", "1234", 500);
        assertEquals("Id da conta Invalido", conta3.toString());
    }
    @Test
    public void testSetIdIncorreto(){
        ContaBancaria conta3 = new ContaBancaria("12345678900", "1234", 500);
        assertEquals("Id da conta Invalido", conta3.toString());
    }
    @Test
    public void testSetIdCorreto(){
        assertEquals("Conta ID: 12345, CPF: 12345678900, Saldo: 0.0, Limite: 500.0", conta1.toString());
    }


}
