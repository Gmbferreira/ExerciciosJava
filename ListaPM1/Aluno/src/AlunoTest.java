import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class AlunoTest {
    Aluno aluno;
    Aluno aluno2;

    @BeforeEach
     public void setUp() {
        aluno = new Aluno("João", 12345);
        aluno.setNota(0, 5.0);
        aluno.setNota(1, 6.0);
        aluno.setNota(2, 7.0);
        aluno.setNota(3, 8.0);
        aluno2 = new Aluno("Maria", 67890);
        aluno2.setNota(0, 6.0);
        aluno2.setNota(1, 6.0);
        aluno2.setNota(2, 5.0);
        aluno2.setNota(3, 6.0);
        
     }
    @Test
    public void testNotaFinal() {
        assertEquals(6.5, aluno.notaFinal(), 0.01);
    }
    @Test
    public void testNotaFinalComReavaliacao() {
        aluno.setReavaliacao(9.0);
        assertEquals(7.75, aluno.notaFinal(), 0.01);
    }
    @Test
    public void testSituacaoAprovado() {
        assertEquals("Aprovado", aluno.situacao());
    }
    @Test
    public void testSituacaoReavaliacao() {
        assertEquals("Reavaliação", aluno2.situacao());
    }
    @Test
    public void testSituacaoReprovado() {
        aluno2.setReavaliacao(3.0);
        assertEquals("Reprovado", aluno2.situacao());
    }
    @Test
    public void testSetNotaInvalida() {
        aluno.setNota(4, 11.0); 
        assertEquals(6.5, aluno.notaFinal(), 0.01); 
    }
    @Test
    public void testSetReavaliacaoInvalida() {
        aluno.setReavaliacao(11.0); 
        assertEquals(6.5, aluno.notaFinal(), 0.01); 
    }
    

}
