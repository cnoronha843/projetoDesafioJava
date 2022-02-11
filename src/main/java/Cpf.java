import jdk.dynalink.beans.StaticClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cpf {
    private String numCpf;
    public Cpf(){
    }
    public  String getNumCpfFormatado() {
        return numCpf;
    }
    public String getNumCpfSemFormatacao() {
        return this.numCpf.replaceAll("\\D", "");
    }
    public void setNumCpf(String numCpf) {
        this.numCpf = numCpf;
    }
    public boolean numeroRepetido() {
        //6 - verificar se tem algum numero que aparece mais de uma vez, se tiver guardar em uma variavel
//        String str
        char [] str = getNumCpfSemFormatacao().toCharArray();
        String resultado = "";
        for (int  i = 0; i < str.length; i++){
            for (int j = i+1; j < str.length; j++){
                if (str[j] == str[i]){
//                    if (resultado.contains(str[j])){
                    resultado += str[j];
                }
            }
        }
        if (resultado != ""){
            System.out.println(resultado);
            return true;
        } else {
            return false;
        }
    }
    public boolean concatenarCpf() {
//             3 - imprimir a palavra "CPF: " e concatenar ao numero do CPF lido e armazenar em uma string
//             4 - reimprimir o passo 1 com um "*" no fim e guardar em ums string
        String cpf = getNumCpfFormatado();
        cpf = "CPF: " + cpf + "*";
        if (cpf.contains("*") && cpf.contains("CPF")){
            return true;
        }

        return false;
    }
    public boolean converterCampo() {
        String cpf = getNumCpfSemFormatacao();
        try {
            Double.parseDouble(cpf);
            return true;
        }catch (NumberFormatException e){}
        return false;
    }
    public  boolean contemNove() {
        String cpf = getNumCpfFormatado();
        //        5 - Verificar se tem o numero 9
        if (cpf.contains("9")){
            return true;
        }return false;
    }
    public boolean validarCaracterEspecial() {
//        2 - verificar se veio pontuação/formatação do CPF
//        Pattern pattern = Pattern.compile("-", Pattern.CASE_INSENSITIVE);
//        Pattern pattern2 = Pattern.compile("\\.", Pattern.CASE_INSENSITIVE);
//        Matcher matcher = pattern.matcher(cpf);
//        Matcher matcher2 = pattern2.matcher(cpf);
//        boolean matchFound = matcher.find();
//        boolean matchFound2 = matcher2.find();
        String cpf = getNumCpfFormatado();
        if(cpf.charAt(3) =='.' && cpf.charAt(7) == '.' && cpf.charAt(11) == '-') {
            return true;
        }
        return false;
    }
      public  boolean verificarCpfValido() {
        String cpf = getNumCpfFormatado();
        String s1, s2 , s3, s4, s5, s6, s7, s8, s9, confere = "";
        int n1, n2, n3, n4, n5, n6, n7, n8, n9, verificador1, verificador2;
        s1 = cpf.substring(0,1);n1 = Integer.parseInt(s1);
        s2 = cpf.substring(1,2);n2 = Integer.parseInt(s2);
        s3 = cpf.substring(2,3);n3 = Integer.parseInt(s3);
        s4 = cpf.substring(4,5);n4 = Integer.parseInt(s4);
        s5 = cpf.substring(5,6);n5 = Integer.parseInt(s5);
        s6 = cpf.substring(6,7);n6 = Integer.parseInt(s6);
        s7 = cpf.substring(8,9);n7 = Integer.parseInt(s7);
        s8 = cpf.substring(9,10);n8 = Integer.parseInt(s8);
        s9 = cpf.substring(10,11);n9 = Integer.parseInt(s9);

        verificador1 = (n1*10+n2*9+n3*8+n4*7+n5*6+n6*5+n7*4+n8*3+n9*2);
        if ((verificador1)<2){
            verificador1 = 0;
        }else {
            verificador1 = 11 - (verificador1 % 11);
        }
        verificador2 = (n1*11+n2*10+n3*9+n4*8+n5*7+n6*6+n7*5+n8*4+n9*3+verificador1*2);
        if((verificador2 % 11)<2){
            verificador2 = 0;
        }else {
            verificador2 = 11 - (verificador2%11);
        }

        confere = (s1+s2+s3+"."+ s4+s5+s6+"."+s7+s8+s9+"-"+ verificador1 +""+verificador2);
        System.out.println(confere);
        if (confere.equals(cpf) ){
            return true;
        }else {

            return false;
        }


    }
    public boolean validarQuantidadeCaracteresCPF() {
//        1 - Conferir se tem 11 caracteres numericos
        String cpf = getNumCpfFormatado();

        int tamanhoCpf = cpf.length();

        if(tamanhoCpf == 14){
            return true;
//            System.out.println("O CPF tem a quantidade correta de caracteres");
        }else {
            return false;
//            System.out.println("Favor preencher o CPF com a quantidade correta de caracteres");
        }


    }

}
