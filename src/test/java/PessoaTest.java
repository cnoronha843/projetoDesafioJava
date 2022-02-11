import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

public class PessoaTest {
    static Pessoa pessoa = new Pessoa();
    static Endereco endereco;



    @BeforeClass
    public static void gerarPessoa() throws InterruptedException {
        //1 - setar a url
        Navegador.getNavegadorAberto().setUrl("https://www.4devs.com.br/gerador_de_pessoas");
        //2 - acessar o site
        Navegador.getNavegadorAberto().acessarSite();
        // gerar a pessoa
        Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("bt_gerar_pessoa")).click();
        Thread.sleep(5000);
        // pegar os elementos da tela e colocar na variavel de pessoa
        pessoa.setNome(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("nome")).getText());
        pessoa.getCpf().setNumCpf(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("cpf")).getText());
        pessoa.setRg(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("rg")).getText());
        pessoa.setDataNascimento(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("data_nasc")).getText());
        pessoa.setSexo(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("sexo")).getText());
        pessoa.setSigno(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("signo")).getText());
        pessoa.getMae().setNome(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("mae")).getText());
        pessoa.getPai().setNome(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("pai")).getText());
        pessoa.setEmail(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("email")).getText());
        pessoa.setSenha(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("senha")).getText());
        pessoa.getTelefone().setTelefoneFixo(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("telefone_fixo")).getText());
        pessoa.getTelefone().setCelular(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("celular")).getText());
        pessoa.setAltura(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("altura")).getText());
        pessoa.setPeso(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("peso")).getText());
        pessoa.setTipoSanguineo(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("tipo_sanguineo")).getText());
        pessoa.setCor(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("cor")).getText());
        for (int i = 5; i >pessoa.getListaEnderecos().size(); i--){
            endereco = new Endereco();
            endereco.setCep(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("cep")).getText());
            endereco.setLougradouro(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("endereco")).getText());
            endereco.setNumero(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("numero")).getText());
            endereco.setBairro(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("bairro")).getText());
            endereco.setCidade(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("cidade")).getText());
            endereco.setEstado(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("estado")).getText());
            pessoa.getListaEnderecos().add(endereco);

            Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("bt_gerar_pessoa")).click();

        }
    }

    @Test
    public void teste() {
        System.out.println(pessoa);
        System.out.println(pessoa.getListaEnderecos());
//        System.out.println(pessoa.getNome());
//        System.out.println(pessoa.getCpf().getNumCpfFormatado());
//        System.out.println(pessoa.getRg());
//        System.out.println(pessoa.getDataNascimento());
//        System.out.println(pessoa.getSexo());
//        System.out.println(pessoa.getSigno());
//        System.out.println(pessoa.getMae().getNome());
//        System.out.println(pessoa.getPai().getNome());
//        System.out.println(pessoa.getEmail());
//        System.out.println(pessoa.getSenha());
//        System.out.println(pessoa.getEndereco().getCep());
//        System.out.println(pessoa.getEndereco().getLougradouro());
//        System.out.println(pessoa.getEndereco().getNumero());
//        System.out.println(pessoa.getEndereco().getBairro());
//        System.out.println(pessoa.getEndereco().getCidade());
//        System.out.println(pessoa.getEndereco().getEstado());
//        System.out.println(pessoa.getTelefone().getTelefoneFixo());
//        System.out.println(pessoa.getTelefone().getCelular());
//        System.out.println(pessoa.getIdade());
//        System.out.println(pessoa.getPeso());
//        System.out.println(pessoa.getTipoSanguineo());
//        System.out.println(pessoa.getCor());
    }
    @AfterClass
    public static void fecharSite() {
        Navegador.getNavegadorAberto().fecharSite();
    }

}
