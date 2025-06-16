import java.util.Scanner;

public class contaTerminal{
    public static void main(String[] args) throws Exception {

        Scanner terminal = new Scanner(System.in);

        System.out.println("Insira seu nome: ");
        var name = terminal.next(); 

        System.out.println("Insira o numero de sua conta: ");
        var account = terminal.nextInt();

        System.out.println("Insira a sua agencia: ");
        var agency = terminal.next();

        System.out.println("Insira o saldo e conta: ");
        var balance = terminal.nextDouble();

        terminal.close();

        System.out.println("\n Olá, " + name + ", obrigado por criar uma conta em nosso banco!");
        System.out.println("Seus dados sao: \n");
        System.out.println("Agencia: " + agency + "\n" + "Conta: " + account);
        System.out.printf("Saldo disponivel: %.2f", balance);
    }
}
