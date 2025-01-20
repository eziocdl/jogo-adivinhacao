package projeto_jogo_adivinhacao.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import org.slf4j.LoggerFactory;

public class Jogo {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Jogo.class);

	// Regras do jogo
	private int numeroSecreto;
	private int tentativasRestantes;
	private int pontuacao;

	public Jogo() {
		reiniciarJogo();
	}

	public int getTentativasRestantes() {
		return tentativasRestantes;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public int getNumeroSecreto() {
		return numeroSecreto;
	}

	public boolean temTentivas() {
		return tentativasRestantes > 0;
	}

	// Reiniciar o jogo
	public void reiniciarJogo() {
		Random random = new Random();
		numeroSecreto = random.nextInt(100) + 1;
		tentativasRestantes = 7;
		pontuacao = 0;
		logger.info("Jogo reiniciado com o número secreto: {}", numeroSecreto);
	}

	// Verificar o palpite do jogador
	public boolean verificarPalpite(int palpite) {
		// Diminui uma tentativa a cada palpite
		tentativasRestantes--;

		// Verifica se o palpite está correto
		if (palpite == numeroSecreto) {
			// Se o palpite estiver correto, soma a pontuação
			pontuacao += 7 + tentativasRestantes;
			logger.info("Jogador acertou o número secreto: {}", numeroSecreto);
			return true;
		}

		// Caso o palpite não seja correto, retorna false
		return false;
	}

	// Processar o palpite do jogador
	public String processarPalpite(int palpite) {
		logger.info("Jogador fez o palpite: {}", palpite);

		if (tentativasRestantes <= 0) {
			// Alterado para a mensagem que o teste espera
			String mensagem = "Você perdeu! O número era " + numeroSecreto;
			logger.info("Fim de jogo! Jogador não tem mais tentativas. Número secreto: {}", numeroSecreto);
			return mensagem;
		}

		// Verificar se o palpite é correto
		if (verificarPalpite(palpite)) {
			return "Parabéns! Você acertou.";
		} else {
			String dica = dica(palpite);
			logger.info("Jogador errou. Restam {} tentativas. Dica: {}", tentativasRestantes, dica);
			return "Errado! " + dica;
		}
	}

	// Dar uma dica sobre o número secreto
	public String dica(int palpite) {
		return palpite > numeroSecreto ? "Menor" : "Maior";
	}

	// Salvar pontuação em um arquivo
	public void salvarPontuacao() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("placar.txt", true))) {
			writer.write(String.valueOf(pontuacao));
			writer.newLine();
			logger.info("Pontuação salva com sucesso: {}", pontuacao);
		} catch (IOException e) {
			logger.error("Erro ao salvar pontuação", e);
		}
	}
}
