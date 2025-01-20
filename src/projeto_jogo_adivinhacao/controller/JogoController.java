package projeto_jogo_adivinhacao.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import projeto_jogo_adivinhacao.model.Jogo;

public class JogoController {

	// refinamento dos logs

	private static final Logger logger = LoggerFactory.getLogger(JogoController.class);

	private final Jogo jogo;

	public JogoController() {
		this.jogo = new Jogo();
		logger.info("Jogo iniciado com o número secreto: {}", jogo.getNumeroSecreto());
	}

	public String processarPalpite(int palpite) {
		 logger.debug("Recebido palpite: {}", palpite);
		 
		 
		    // Verifica se o palpite está correto
		    boolean palpiteCorreto = jogo.verificarPalpite(palpite);
		    logger.debug("Palpite correto? {}", palpiteCorreto);

		    if (palpiteCorreto) {
		        // Mensagem de acerto
		        String mensagem = "Parabéns! Você acertou.";
		        logger.info("Palpite correto! Número secreto: {}", jogo.getNumeroSecreto());
		        return mensagem;
		    }

		    // Verifica se o jogo acabou
		    if (jogo.getTentativasRestantes() <= 0) {
		        // Mensagem de fim de jogo
		        String mensagem = "Você perdeu! O número era " + jogo.getNumeroSecreto();
		        logger.info("Fim de jogo! Número secreto {}, jogador perde.", jogo.getNumeroSecreto());
		        return mensagem;
		    }

		    // Mensagem de palpite incorreto com dica
		    String mensagem = "Errado! " + jogo.dica(palpite);
		    logger.info("Tentativas restantes: {}", jogo.getTentativasRestantes());
		    return mensagem;
	}

	public void reiniciarJogo() {
		jogo.reiniciarJogo();
		logger.info("Jogo reiniciado com o novo número secreto: {}", jogo.getNumeroSecreto());
	}

	public int getTentativasRestantes() {
		return jogo.getTentativasRestantes();
	}

	public int getPontuacao() {
		return jogo.getPontuacao();
	}

}
