package projeto_jogo_adivinhacao;

import projeto_jogo_adivinhacao.controller.JogoController;
import projeto_jogo_adivinhacao.view.ConsoleView;
import projeto_jogo_adivinhacao.view.JogoGUI;


// Para usar a interface gráfica, importe a linha abaixo
// import adivinhacao.view.JogoGUI;

public class Main {
	public static void main(String[] args) {
		JogoController controller = new JogoController();

		// Modo console
		//ConsoleView consoleView = new ConsoleView(controller);
	   // consoleView.iniciarJogo();

		// Modo gráfico (descomente para usar)
		 new JogoGUI(controller);
	}
}
