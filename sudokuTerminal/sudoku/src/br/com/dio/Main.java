package br.com.dio;

import br.com.dio.model.board;
import br.com.dio.model.space;
import br.com.dio.util.template;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {

        private static final Scanner scanner = new Scanner(System.in);

        private static board board;

        private static final int BOARD_LIMIT = 9;

    public static void main(String[] args) throws Exception {
        
        final var positions = Stream.of(args)
        .collect(Collectors.toMap(
        k -> k.split(";")[0],
        v -> v.split(";")[1]
        ));

        var option = -1;

        while (true) {
            System.out.println("Escolha uma opçao: ");
            System.out.println("1- Iniciar novo jogo.");
            System.out.println("2- Colocar um novo numero.");
            System.out.println("3- Remover um numero.");
            System.out.println("4- Visualizar jogo atual.");
            System.out.println("5- Status do jogo.");
            System.out.println("6- Limpar jogo.");
            System.out.println("7- Finalizar jogo.");
            System.out.println("8- Sair..");

            option = scanner.nextInt();

            switch (option) {
                case 1 -> startGame(positions);
                case 2 -> inputNumber();
                case 3 -> removeNumber();
                case 4 -> showCourrentGame();
                case 5 -> showGameStatus();
                case 6 -> clearGame();
                case 7 -> finishGame();
                case 8 -> System.exit(0);
                default -> System.out.println("Opcao inválida!");
            }
        }
    }

    private static void startGame(final Map<String, String> positions) {
        if (nonNull(board)){
            System.out.println("Jogo ja iniciado.");
            return;
        }

        List<List<space>> spaces = new ArrayList<>();
        for (int i = 0; i < BOARD_LIMIT; i++){
            spaces.add(new ArrayList<>());
            for (int j = 0; j < BOARD_LIMIT; j++){
                var positionConfig = positions.get("%s,%s".formatted(i, j));
                var expected = Integer.parseInt(positionConfig.split(",")[0]);
                var fixed = Boolean.parseBoolean(positionConfig.split(",")[1]);
                var currentSpace = new space(expected, fixed);
                spaces.get(i).add(currentSpace); 
            }
        }

        board = new board(spaces);
        System.out.println("Jogo iniciado!");
    }

    private static void inputNumber() {
        if (isNull(board)){
            System.out.println("Jogo ainda nao iniciou.");
            return;
        }

        System.out.println("Informe a coluna desejada: ");
        var col = runUntilValidNuber(0, 8);
        System.out.println("Informe a linha desejada: ");
        var row = runUntilValidNuber(0, 8);
        System.out.printf("Informe o nummero para o posiçao [%s, %s]", col, row);
        var value = runUntilValidNuber(1, 9);
        if (!board.changeValue(col, row, value)){
            System.out.println("Espaço com valor fixo, escolha outro!");
        }
    }

    private static void removeNumber() {
        if (isNull(board)){
            System.out.println("Jogo ainda nao iniciou.");
            return;
        }

        System.out.println("Informe a coluna desejada: ");
        var col = runUntilValidNuber(0, 8);
        System.out.println("Informe a linha desejada: ");
        var row = runUntilValidNuber(0, 8);
        if (!board.clearValue(col, row)){
            System.out.println("Espaço com valor fixo, escolha outro!");
        }
    }

    private static void showCourrentGame() {
        if (isNull(board)){
            System.out.println("Jogo ainda nao iniciou.");
            return;
        }

        var args = new Object[81];
        var argPos = 0;
        for(int i = 0; i < BOARD_LIMIT; i++){
            for(var col: board.getSpaces()){
                args[argPos++] = " " + ((isNull(col.get(i).getActual())) ? " " : col.get(i).getActual());
            }
        }

        System.out.println("Seu jogo esta assim: ");
        System.out.printf(template.BOARD_TEMPLATE + "\n", args);
    }

    private static void showGameStatus() {
        if (isNull(board)){
            System.out.println("Jogo ainda nao iniciou.");
            return;
        }

        System.out.printf("seu jogo esta no status %s: ", board.getStatus().getLabel());
        if(board.hasError()){
            System.out.println("Seu jogo possui erros!");
        }else{
            System.out.println("o jogo ainda possui erros!");
        }
    }

    private static void clearGame() {
        if (isNull(board)){
            System.out.println("Jogo ainda nao iniciou.");
            return;
        }

        System.out.println("Tem certeza?  (s/n)");
        var confirm = scanner.next();
        while(!confirm.equalsIgnoreCase("s") && !confirm.equalsIgnoreCase("n")){
            System.out.println("informe umm valor valido! (s/n)");
            confirm = scanner.next();
        }
    }

    private static void finishGame() {
        if (isNull(board)){
            System.out.println("Jogo ainda nao iniciou.");
            return;
        }
    }

    private static int runUntilValidNuber(final int min, final int max){
        var current = scanner.nextInt();
        while (current < min || current > max){
            System.out.printf("Insira um numero entre %s e %s\n", min, max);
            current = scanner.nextInt();
        }
        return current;
    }
}
