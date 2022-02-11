import java.util.ArrayList;

public class Pessoa {
    private String nome;
    private String rg;
    private String dataNascimento;
    private String sexo;
    private String signo;
    private Pessoa mae;
    private Pessoa pai;
    private String email;
    private String senha;

//    private Telefone[] telefone;
    private Telefone telefone;
    private Cpf cpf;
    private String altura;
    private String peso;
    private String tipoSanguineo;
    private String cor;
    private int idade;
    private ArrayList <Endereco> listaEnderecos;
    private Endereco endereco;

    public Pessoa(){
        listaEnderecos = new ArrayList<>();

    }

    public Endereco getEndereco() {
        if (endereco == null){
            endereco= new Endereco();
            return endereco;
        }
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Endereco> getListaEnderecos() {

        return listaEnderecos;
    }


    public void setListaEnderecos(ArrayList<Endereco> listaEnderecos) {
        this.listaEnderecos = listaEnderecos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cpf getCpf() {
        if (cpf == null){
            cpf= new Cpf();
            return cpf;
        }
        return cpf;
    }

//    public Telefone getTelefone() {
//        if (telefone == null){
//            telefone = new Telefone[10];
//            return telefone[];
//        }
//        return telefone[];
//    }

        public Telefone getTelefone() {
        if (telefone == null){
            telefone = new Telefone();
            return telefone;
        }

        return telefone;
    }


    public String getNome() {
        return nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSigno() {
        return signo;
    }

    public void setSigno(String signo) {
        this.signo = signo;
    }

    public Pessoa getMae() {
        if (mae == null){
            mae= new Pessoa();
            return mae;
        }
        return mae;
    }

    public void setMae(Pessoa mae) {
        this.mae = mae;
    }

    public Pessoa getPai() {
        if (pai == null){
            pai= new Pessoa();
            return pai;
        }

        return pai;
    }

    public void setPai(Pessoa pai) {
        this.pai = pai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

//    public Endereco getEndereco() {
//        if (endereco == null){
//            endereco= new Endereco();
//            return endereco;
//        }
//        return endereco;
//    }
//
//    public void setEndereco(Endereco endereco) {
//        this.endereco = endereco;
//    }
    public  void addEndereco(Endereco endereco){
        getListaEnderecos().add(endereco);

    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public void setCpf(Cpf cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", rg='" + rg + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", sexo='" + sexo + '\'' +
                ", signo='" + signo + '\'' +
                ", mae=" + mae +
                ", pai=" + pai +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", telefone=" + telefone +
                ", cpf=" + cpf +
                ", altura='" + altura + '\'' +
                ", peso='" + peso + '\'' +
                ", tipoSanguineo='" + tipoSanguineo + '\'' +
                ", cor='" + cor + '\'' +
                ", idade=" + idade +
                ", listaEnderecos=" + listaEnderecos +
                '}';
    }
}
