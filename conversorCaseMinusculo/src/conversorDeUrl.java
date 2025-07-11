import java.util.Scanner;

public class conversorDeUrl {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Conversor de URL ===");
        // Lendo a entrada do usuário
        System.out.println("Insira uma url para converter em minúsculo: ");
        String url = scanner.nextLine();
        
        // TODO: Normalize a URL: removendo espaços e convertendo para minúsculas
        String novaUrl = url.toLowerCase().trim();
        
        // TODO: Exiba a URL normalizada
        System.out.println("URL convertida abaixo: ");
        System.out.println(novaUrl);
        
        scanner.close();
    }
}
