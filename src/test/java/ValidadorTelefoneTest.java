import org.junit.BeforeClass;

public class ValidadorTelefoneTest {
    private static Pessoa pessoa;
    @BeforeClass
    public static void inicializandoObjetoPessoa() {
        pessoa = new Pessoa();
        pessoa.getTelefone().setTelefoneFixo("(21)2531-9637");
    }

}
