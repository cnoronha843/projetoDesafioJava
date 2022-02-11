import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;






////

////    @Test // 19 - SANGUE é valido se a pessoa pode doar para no mínimo duas pessoas (dois tipos de sangue)
////    @Test // 20 - COR é valida SE for azul (da premier hehe)

public class CamposTest {
    private static Pessoa pessoa;
    @BeforeClass
    public static void inicializandoObjetoPessoa() {
        pessoa = new Pessoa();
        pessoa.getCpf().setNumCpf("123.01767728");
        pessoa.setSigno("Áries");
        pessoa.setSexo("M");
        pessoa.getMae().setNome("Eliana Trigueiro Noronha Sant'anna");
        pessoa.getPai().setNome("João Carlos Candido Sant'anna");
        pessoa.setEmail("c_arlosanoronha@hotmail.com");
        pessoa.setSenha("Sucesso2022");
        pessoa.getEndereco().setCep("89030-850");
        pessoa.getEndereco().setLougradouro("Av Farmaceutico Reinaldo Pfau");
        pessoa.getEndereco().setNumero("20");
        pessoa.getEndereco().setBairro("It");
        pessoa.getEndereco().setCidade("Blumenau");
        pessoa.getEndereco().setEstado("SP");
        pessoa.getTelefone().setCelular("(11)97213-6937");
        pessoa.getTelefone().setTelefoneFixo("(21)7213-6937");
        pessoa.setAltura("1.81");
        pessoa.setPeso("80");
        pessoa.setTipoSanguineo("AB-");
        pessoa.setCor("azul");
        pessoa.setRg("21.796.756-7");
        pessoa.setDataNascimento("07/01/2023");
    }

////    @Test // 1 - NOME passa SE conter apenas letras E possuir 4 nomes ("da" e "de" não conta como nome, nomes válidos possuem no minimo 3 letras)

//    @BeforeClass
//    public static void gerarPessoa() throws InterruptedException {
//        // toda a parte de buscar na web
//        Navegador.getNavegadorAberto().setUrl("https://www.4devs.com.br/gerador_de_pessoas");
//        //2 - acessar o site
//        Navegador.getNavegadorAberto().acessarSite();
//        // gerar a pessoa
//        Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("bt_gerar_pessoa")).click();
//        Thread.sleep(5000);
//        pessoa.setNome(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("nome")).getText());
//    }
    @Test
    //1 - NOME passa SE conter apenas letras E possuir 4 nomes ("da" e "de" não conta como nome, nomes válidos possuem no minimo 3 letras)
    public void validacaoNome(){

        String nomeInserido = pessoa.getNome().trim();     // <- Tira os espaços do inicio e do final;

        if (nomeInserido.matches("[a-zA-Z\s]+" )) {  // <- verifica se tem apenas letras

            String[] nomeArray = nomeInserido.split(" ");  // <- quebra o nome em array
            int resultado = 0;

            for (int i = 0; i < nomeArray.length; i++) {
                if (nomeArray[i].length() >= 3) {  //<- verifica se o nome tem mais de 3 letras
                    resultado++;                    // <- se tiver incrementa aqui
                }
            }
            if (resultado == 4) {   // <- verifica se o que incrementou (quantos nomes tem mais de 3 letras) se é maior que 4
                System.out.println("\n Seu nome " + pessoa.getNome() + " está correto.");
                Assert.assertTrue(true);
            } else {
                Assert.fail("\nSeu nome " + pessoa.getNome() + " não tem exatamente 4 nomes.");  // <- se não tiver 4 dá erro
            }
        } else {
            Assert.fail("\nSeu nome " + pessoa.getNome() + " não contém apenas letras"); // <- se não contém apenas letra dá erro
        }
    }
   // 2 - CPF passa SE o calculo do CPF for válido E possuir formatação (XXX.XXX.XXX-XX)
    @Test
    public void validacaoCPF(){
        boolean validacaoCpf = false;
        int resultado = 0;
        for (int i = 0; i < 11; i++){
           resultado = resultado + Character.getNumericValue(pessoa.getCpf().getNumCpfSemFormatacao().charAt(i));
        }
        System.out.println(resultado);

        Integer[] cpfValido = new Integer[]{11,12,21,22,23,32,33,34,43,44,45,54,55,56,65,66,67,76,77,78,87,88};
        for (int i = 0; i < cpfValido.length; i++){

            if (resultado == cpfValido[i] && pessoa.getCpf().getNumCpfFormatado().charAt(3) =='.'
                    && pessoa.getCpf().getNumCpfFormatado().charAt(7) == '.'
                    && pessoa.getCpf().getNumCpfFormatado().charAt(11) == '-'){
                validacaoCpf = true;
            }
        }
        Assert.assertTrue("O cpf não é valido",validacaoCpf);
    }
    // 3 - SEXO passa SE no getSexo() retornar 'F' para feminino ou 'M' para Masculino
    @Test
    public void validaSexo(){
        boolean validacaoSexo = false;
        String[] conjutoSexo = {"M","F"};
        for (int i = 0; i < conjutoSexo.length; i++){
            if (conjutoSexo[i].equals(pessoa.getSexo()) ){
                validacaoSexo = true;
            }
        }Assert.assertTrue(validacaoSexo);
    }
    // 4 - SIGNO passa SE for um signo válido (guardar os signos válidos em um array)
    @Test
    public void validaSigno(){
        boolean validacaoSiggo = false;
        String[] conjutoSignos = {"Virgem","Libra","Escorpião","Sagitário", "Capricórnio", "Aquário", "Peixes", "Áries", "Touro", "Gêmeos", "Câncer", "Leão"};

        for (int i = 0; i < conjutoSignos.length; i++){
            if (conjutoSignos[i].equals(pessoa.getSigno()) ){
               validacaoSiggo = true;
            }
        }Assert.assertTrue(validacaoSiggo);

    }
    //6 - MAE passa SE conter apenas letras E possuir 4 nomes ("da" e "de" não conta como nome, nomes válidos possuem no minimo 3 letras)
    @Test
    public void validaMae(){
        String tratamentoPreposicoes = pessoa.getMae().getNome().replace("de", "").replace("da", "").replace("do", "").replace("dos", "");
        String[] nomeDividido =tratamentoPreposicoes.split(" ");
        Assert.assertTrue("deu ruim",nomeDividido.length >= 4 && pessoa.getMae().getNome().matches("[a-zA-Z['][é]\s]+"));
    }
//    PAI passa SE conter apenas letras E possuir 4 nomes ("da" e "de" não conta como nome, nomes válidos possuem no minimo 3 letras)
    @Test
    public void validaPai(){
        String tratamentoPreposicoes = pessoa.getPai().getNome().replace("de", "").replace("da", "").replace("do", "").replace("dos", "");
        String[] nomeDividido =tratamentoPreposicoes.split(" ");
        Assert.assertTrue("deu ruim",nomeDividido.length >= 4 && pessoa.getPai().getNome().matches("[a-zA-Z['][ã]\s]+"));
    }
//    @Test // 8 - EMAIL passa SE tiver @ e .
    @Test
    public void validaEmail(){
        Assert.assertTrue("deu ruim",pessoa.getEmail().matches("^[_a-z0-9-\\+]+(\\.[_a-z0-9-]+)*@"
                + "[a-z0-9-]+(\\.a-z]+)*(\\.[a-z]{2,})$"));
    }
    // 9 - SENHA passa SE conter letras maiusculas E letras minusculas E numeros
    @Test
    public void validaSenha(){
        Assert.assertTrue("Deu ruim" ,pessoa.getSenha().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$"));
    }
    // 10 - CEP passa SE conter a formatação certa (apenas numeros e no formato XXXXX-XXX)
    @Test
    public void validaCep(){
       Assert.assertTrue("Deu ruim", pessoa.getEndereco().getCep().matches("[0-9]{5}-[0-9]{3}" ));

    }
    ////    @Test // 11 - ENDEREÇO/RUA passa SE começar com "Rua" ou "Av" (avenida)
    @Test
    public void validaEndereco(){
        Assert.assertTrue("Deu ruim", pessoa.getEndereco().
                getLougradouro().substring(0,3).contains("Rua") ||
                pessoa.getEndereco().getLougradouro().substring(0,2).contains("Av") );

    }
    ////    @Test // 12 - NUMERO passa SE conter apenas numeros
    @Test
    public void validaNumero(){
        Assert.assertTrue(pessoa.getEndereco().getNumero().matches("[0-9]+" ));
    }
    // 13 - BAIRRO passa SE for um nome válido (nomes válidos não possuem numeros e possuem no minimo 3 letras)
    @Test
    public void validaBairro(){
        Assert.assertTrue("Deu ruim", pessoa.getEndereco().getBairro().matches("[A-Za-z].{2}"));
    }
    // 14 - CIDADE passa SE for um nome válido (nomes válidos não possuem numeros e possuem no minimo 3 letras)
    @Test
    public void validaCidade(){
        Assert.assertTrue("Deu ruim", pessoa.getEndereco().getCidade().matches("[A-Za-z].{2,}"));
    }
    // 15 - ESTADO passa SE for um estado válido (guardar os signos válidos em um array)
    @Test
    public void validaEstado(){
        boolean validacaoEstado = false;
        String[] conjutoEstados = {
                "ES","RJ","MG","SP", "PR", "SC", "RS", "AC", "AL", "AP",
                "AM", "CE","DF","GO", "MA", "MT", "MS", "PA", "PB", "RN",
                "RO", "RR","SE","TO","PI","PE","BA"};

        for (int i = 0; i < conjutoEstados.length; i++){
            if (conjutoEstados[i].equals(pessoa.getEndereco().getEstado()) ){
                validacaoEstado = true;
            }
        }Assert.assertTrue(validacaoEstado);

    }
    // 16 - TELEFONE fixo válido SE conter apenas numeros e com formatação (XX)XXXX-XXXX)
    @Test
    public void validaTelefoneFixo(){
        Assert.assertTrue("Deu ruim",pessoa.getTelefone().getTelefoneFixo().matches("[(][0-9]{2}[)][0-9]{4}-[0-9]{4}"));
    }
    // 17 - CELULAR é válido SE conter apenas numeros e com formatação (XX)X XXXX-XXXX)
    @Test
    public void validaCelular(){
        Assert.assertTrue("Deu ruim",pessoa.getTelefone().getCelular().matches("[(][0-9]{2}[)][0-9]{5}-[0-9]{4}"));
    }
    // 18 - CARACTERISTICAS FISICAS é valido SE o IMC da pessoa for saudável
    @Test
    public void validaImc(){
        double altura = Double.parseDouble(pessoa.getAltura());
        double peso = Double.parseDouble(pessoa.getPeso());
        double alturaQuadrado = altura*altura;
        double imc = peso/alturaQuadrado;
        double saudavelMin = 18.5;
        double saudavelMax = 24.5;
        Assert.assertTrue("Deu ruim", imc>=saudavelMin && imc<=saudavelMax);
    }
    // 19 - SANGUE é valido se a pessoa pode doar para no mínimo duas pessoas (dois tipos de sangue)
    @Test
    public void validaTipoSanguineo(){
        String[] tipoValido = {"B+", "O+", "A-", "B-", "AB-", "O-"};
        boolean validaTipo = false;
        for (int i = 0; i< tipoValido.length; i++){
            if (tipoValido[i].equals(pessoa.getTipoSanguineo())){
                validaTipo = true;
            }
        }
        Assert.assertTrue("Deu ruim",validaTipo);
    }
    // 20 - COR é valida SE for azul (da premier hehe)
    @Test
    public void validaCor(){
        Assert.assertTrue("", pessoa.getCor().contains("azul premier"));
    }
    @Test
    public void validaRg(){
        Assert.assertTrue("",pessoa.getRg().matches("[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{1}"));
    }
    @Test
    public void validaDataNascimento() throws ParseException {
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(pessoa.getDataNascimento());
        Assert.assertTrue("", new Date().compareTo(date1) == 1);
    }

    @Test
    public void validaDDDEstado(){
//        System.out.println(pessoa.getTelefone().getCelular().substring(1,3));
        Assert.assertTrue("deu ruim",
                pessoa.getEndereco().getEstado().matches("RJ") && pessoa.getTelefone().getCelular().substring(1,3).matches("21||22||23||24") ||
                pessoa.getEndereco().getEstado().matches("SP") && pessoa.getTelefone().getCelular().substring(1,3).matches("11||12||13||14||15||16||17"));

    }









}
