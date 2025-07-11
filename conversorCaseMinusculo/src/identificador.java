import java.util.Scanner;

public class identificador {
    public static void main(String[] args) {
           // Criando um objeto Scanner para ler entrada do usuário
           System.out.println("BEM VINDO AO CRIADOR DE IDENTIFICADOR UNICO!!");
        Scanner scanner = new Scanner(System.in);
        // Lendo a string (nome)
        System.out.println("Por favor, insira seu nome: ");
        String nome = scanner.nextLine();

        // Lendo o número inteiro (ID)
        System.out.println("Por Favor, insira sua idade: ");
        int id = scanner.nextInt();

        // TODO: Formate o identificador (minúsculas e sem espaços):
        String identificador = (nome + "-" + id).toLowerCase();

        // TODO: Exiba o resultado:
        System.out.println("IDENTIFICADOR GERADO!!");
        System.out.println(identificador);

        // Fechando o scanner
        scanner.close();
    }
}
