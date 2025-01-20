package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projeto_jogo_adivinhacao.model.Jogo;

class JogoControllerTest {

	private Jogo jogo;

	@BeforeEach
	void setUp() {
		jogo = new Jogo();
		jogo.reiniciarJogo(); // Reinicia o jogo antes de cada teste
	}

	// Testa o caso quando o jogador acerta o número secreto
	@Test
	void testProcessarPalpite_Correto() {
		// Pega o número secreto que foi gerado aleatoriamente
		int numeroSecreto = jogo.getNumeroSecreto();
		String resultado = jogo.processarPalpite(numeroSecreto);

		// Verifica que o jogador acertou e a jornada foi finalizada
		assertEquals("Parabéns! Você acertou.", resultado);
		assertTrue(jogo.getTentativasRestantes() >= 0);
		assertEquals(7 + jogo.getTentativasRestantes(), jogo.getPontuacao());
	}

	// Testa o caso quando o jogador faz um palpite maior que o número secreto
	@Test
	void testProcessarPalpite_ErroMaior() {
		// Vamos supor que o número secreto seja 50
		int palpite = 60; // Palpite menor que o número secreto
		String resultado = jogo.processarPalpite(palpite);

		// O número secreto é 50, então a resposta correta deve ser "Errado! Maior"
		assertEquals("Errado! Maior", resultado);

	}

	// Testa o caso quando o jogador faz um palpite menor que o número secreto
	@Test
	void testProcessarPalpite_ErroMenor() {
		// Vamos supor que o número secreto seja 50
		int palpite = 40; // Palpite maior que o número secreto
		String resultado = jogo.processarPalpite(palpite);

		// O número secreto é 50, então a resposta correta deve ser "Errado! Menor"
		assertEquals("Errado! Menor", resultado);
	}

	// Testa o caso quando o número de tentativas chega a zero
	@Test
	public void testFimDeJogo() {
		Jogo jogo = new Jogo();

		// Simulando tentativas até o jogo acabar
		while (jogo.getTentativasRestantes() > 0) {
			jogo.processarPalpite(jogo.getNumeroSecreto() + 1); // Palpites errados
		}

		// Chamar o processarPalpite após o fim das tentativas
		String resultado = jogo.processarPalpite(jogo.getNumeroSecreto());

		// Verifique a mensagem
		String mensagemEsperada = "Você perdeu! O número era " + jogo.getNumeroSecreto();
		assertEquals(mensagemEsperada, resultado);
	}

	// Testa o método de reiniciar o jogo
	@Test
	void testReiniciarJogo() {
		jogo.reiniciarJogo();
		assertEquals(7, jogo.getTentativasRestantes()); // Verifica o número de tentativas após reiniciar
		assertEquals(0, jogo.getPontuacao()); // Verifica a pontuação após reiniciar
	}
}
