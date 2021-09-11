import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class GestaoAlunos {
    private int indice = 0;
    private Aluno [] alunos;

    public GestaoAlunos(Aluno[] alunos) {
        this.alunos = alunos;
    }

    Scanner scn = new Scanner(System.in);

    void criar() {

        Aluno a1 = new Aluno();
        if(indice > 0){
            a1.setId(alunos[indice-1].getId()+1);
        }else{
            a1.setId(1);
        }
        System.out.println("Digite o nome do aluno: ");
        a1.setNome(scn.nextLine());
        System.out.println("Digite a data de nascimento: (dd/MM/yyyy)");

        Calendar c = Calendar.getInstance();
        String data = scn.nextLine();
        int ano = Integer.parseInt(data.substring(6,10));
        int mes = (Integer.parseInt(data.substring(3, 5)) -1);
        int dia = Integer.parseInt(data.substring(0, 2));
        c.set(ano, mes, dia);
        a1.setNascimento(c.getTime());

        System.out.println("Digite o RA do aluno: ");
        a1.setRa(scn.nextLine());

        alunos[this.indice] = a1;
        this.indice++;
    }


    void atualizar() {
        if(indice == 0){
            System.out.println("Não existem alunos cadastrados");

        }else{
            boolean encontrou = false;
            System.out.println("Digite o RA do aluno que deseja excluir: ");
            String ra = scn.nextLine();

            for (int i = 0; i < indice; i++) {
                if(alunos[i].getRa().equals(ra)){
                    encontrou = true;
                    System.out.println("Nome antigo: "+alunos[i].getNome()+" \nDigite o novo nome: ");
                    alunos[i].setNome(scn.nextLine());
                    System.out.println("Data antiga: "+alunos[i].getNascimento() + " \nDigite a nova data de nascimento: (dd/MM/yyyy)");
                    Calendar c = Calendar.getInstance();
                    String data = scn.nextLine();
                    int ano = Integer.parseInt(data.substring(6,10));
                    int mes = (Integer.parseInt(data.substring(3, 5)) -1);
                    int dia = Integer.parseInt(data.substring(0, 2));
                    c.set(ano, mes, dia);
                    alunos[i].setNascimento(c.getTime());

                    System.out.println("Atualizado");
                }
            }
            if(encontrou == false) {
                System.out.println("Aluno não encontrado;");
            }
        }
    }

    void excluir(){
        if(indice == 0){
            System.out.println("Não existem alunos cadastrados");
        }else{
            boolean encontrou = false;
            System.out.println("Digite o RA do aluno que deseja excluir: ");
            String ra = scn.nextLine();
            int posicao = 0;

            for (int i = 0; i < indice; i++) {
                if(alunos[i].getRa().equals(ra)){
                    posicao = i;
                    i = indice;
                    encontrou = true;
                }
            }
            if(encontrou){
                for (int i = posicao; i < indice -1; i++) {
                    alunos[i] = alunos[i+1];
                }
                indice--;
            }
            else{
                System.out.println("Aluno não encontrado");
            }
        }

    };

    void exibir(){
        if(indice == 0){
            System.out.println("Não existem alunos cadastrados");
        }
        else{
            boolean encontrou = false;
            System.out.println("Digite o RA do aluno desejado: ");
            String ra = scn.nextLine();

            for (int i = 0; i < indice; i++) {
                if(alunos[i].getRa().equals(ra)){
                    System.out.println(alunos[i]);
                    i = indice;
                    encontrou = true;
                }
            }
            if(encontrou == false){
                System.out.println("Aluno não encontrado");
            }

        }
    };
    void menu() {
        Scanner scan = new Scanner(System.in);
        String textoMaisculo;
        char letra;
        boolean verificador = true;
        while(verificador){
            System.out.println("Digite uma das letras em parenteses para executar a ação");
            System.out.println("(C)riar | (E)xibir | (R)emover | \n(A)tualizar | (S)air");
            textoMaisculo = scan.nextLine().toUpperCase();
            letra = textoMaisculo.charAt(0);

            switch(letra){
                case 'C':
                    criar();
                    break;
                case 'E':
                    exibir();
                    break;
                case 'R':
                    excluir();
                    break;
                case 'A':
                    atualizar();
                    break;
                case 'I':
                    imprimir();
                    break;
                case 'S':
                    verificador = false;
                    System.out.println("Saindo da Aplicação");
                    break;
                default:
                    System.out.println("Não é uma opção válida.");
                    break;
            }
         }
    }
    void imprimir(){
        for (int i = 0; i < indice; i++) {
            System.out.println(alunos[i]);
            System.out.println(alunos[i].getRa());
        }
    }
}
