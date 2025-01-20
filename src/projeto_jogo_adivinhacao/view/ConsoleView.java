package projeto_jogo_adivinhacao.view;

import java.util.Scanner;
import projeto_jogo_adivinhacao.controller.JogoController;

public class ConsoleView {

    private final JogoController controller;

    public ConsoleView(JogoController controller) {
        this.controller = controller;
    }

    public void iniciarJogo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao Jogo de Adivinhação!");

        while (true) {
            System.out.print("Digite seu palpite (ou -1 para sair): ");
            int palpite = scanner.nextInt();

            if (palpite == -1) {
                System.out.println("Saindo do Jogo");
                break;
            }

            String resultado = controller.processarPalpite(palpite);
            System.out.println(resultado);

            if (controller.getTentativasRestantes() <= 0 || resultado.contains("Parabéns")) {
                System.out.println("Pontuação final: " + controller.getPontuacao());
                System.out.print("Deseja jogar novamente? (s/n): ");
                String resposta = scanner.next();

                if (resposta.equalsIgnoreCase("s")) {
                    controller.reiniciarJogo();
                } else {
                    System.out.println("Obrigado por jogar!");
                    break;
                }
            }
        }
        scanner.close();
    }
}


