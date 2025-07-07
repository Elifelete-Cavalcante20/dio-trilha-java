package Contador;
import java.util.Scanner;
import Exeption.ParametrosInvalidosException;

public class Contador {
    public static void main(String[] args) throws Exception {
        Scanner terminal = new Scanner(System.in);
		System.out.println("Digite o primeiro parâmetro");
		int parametroUm = terminal.nextInt();
		System.out.println("Digite o segundo parâmetro");
		int parametroDois = terminal.nextInt();

        terminal.close();
		
		try {
			//chamando o método contendo a lógica de contagem
			contar(parametroUm, parametroDois);
		
		}catch (ParametrosInvalidosException exception) {
			System.err.println("Erro: " + exception.getMessage());
		}
		
	}
	static void contar(int parametroUm, int parametroDois ) throws ParametrosInvalidosException {
		//validar se parametroUm é MAIOR que parametroDois e lançar a exceção
		if (parametroUm > parametroDois){
            throw new ParametrosInvalidosException("O valor do segundo parâmetro deve ser maior que o do primeiro parâmetro!");
        }
		int contagem = parametroDois - parametroUm;
        //realizar o for para imprimir os números com base na variável contagem
        System.out.println("Iniciando contagem ate " + contagem + "...");
		for(int i=0; i <= contagem; i++){
            System.out.println(i);
        }
        System.out.println("Contagem finaizada...");
	}
}
