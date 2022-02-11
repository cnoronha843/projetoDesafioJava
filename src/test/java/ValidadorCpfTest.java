import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class ValidadorCpfTest {

    private static Pessoa pessoa;
    @BeforeClass
    public static void inicializandoObjetoPessoa() {
        pessoa = new Pessoa();
        pessoa.getCpf().setNumCpf("123.456.789-50");
    }
    @Test
    public void validarQuantidadeCaracteresCPFTest() {
            Assert.assertTrue("Favor preencher o CPF com a quantidade correta de caracteres" ,
                    pessoa.getCpf().validarQuantidadeCaracteresCPF());
    }
    @Test
    public  void numeroRepetido(){
        Assert.assertTrue( "Não existem numeros repetidos!",
                pessoa.getCpf().numeroRepetido());
    }
    @Test
    public  void concatenarCpf() {
//             3 - imprimir a palavra "CPF: " e concatenar ao numero do CPF lido e armazenar em uma string
//             4 - reimprimir o passo 1 com um "*" no fim e guardar em ums string
        Assert.assertTrue("Favor inserir o prefixo e o sufixo" ,
                pessoa.getCpf().concatenarCpf());
    }
    @Test
    public  void converterCampo(){
        Assert.assertTrue("O numero não foi convertido",
                pessoa.getCpf().converterCampo());
    }
    @Test
    public void contemNove(){
        Assert.assertTrue("Não contem o nove",
                pessoa.getCpf().contemNove());
    }
    @Test
    public void validarCaracteresEspecias(){
        Assert.assertTrue(pessoa.getCpf().validarCaracterEspecial());
    }
    @Test
    public void verificarCpfValido(){
        Assert.assertTrue(pessoa.getCpf().verificarCpfValido());
    }
}


