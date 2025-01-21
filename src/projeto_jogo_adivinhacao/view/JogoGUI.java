package projeto_jogo_adivinhacao.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import projeto_jogo_adivinhacao.controller.JogoController;

public class JogoGUI {

    private final JogoController controller;
    private JLabel feedbackLabel;
    private JLabel tentativasLabel;
    private JLabel pontuacaoLabel;
    private JTextField inputField;

    public JogoGUI(JogoController controller) {
        this.controller = controller;
        criarInterface();
    }

    private void criarInterface() {
        // Criação da janela principal
        JFrame frame = new JFrame("Jogo de Adivinhação");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout(10, 10));

        // Título
        JLabel titleLabel = new JLabel("Jogo de Adivinhação");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(titleLabel, BorderLayout.NORTH);

        // Instrução para o jogador
        JLabel instructionLabel = new JLabel("Digite um número de 1 a 100:");
        instructionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        instructionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        instructionLabel.setForeground(Color.BLACK);
        frame.add(instructionLabel, BorderLayout.SOUTH);

        // Painel de Feedback e Status
        feedbackLabel = new JLabel("Faça seu palpite com números de 1 a 100!");
        feedbackLabel.setHorizontalAlignment(SwingConstants.CENTER);
        feedbackLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        feedbackLabel.setForeground(Color.BLUE);

        tentativasLabel = new JLabel("Tentativas restantes: " + controller.getTentativasRestantes());
        tentativasLabel.setHorizontalAlignment(SwingConstants.LEFT);

        pontuacaoLabel = new JLabel("Pontuação atual: " + controller.getPontuacao());
        pontuacaoLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        JPanel statusPanel = new JPanel(new GridLayout(1, 2));
        statusPanel.add(tentativasLabel);
        statusPanel.add(pontuacaoLabel);

        frame.add(feedbackLabel, BorderLayout.CENTER);
        frame.add(statusPanel, BorderLayout.SOUTH);

        // Painel de entrada e botões
        inputField = new JTextField();
        JButton submitButton = new JButton("Enviar Palpite");
        JButton restartButton = new JButton("Reiniciar Jogo");

        submitButton.addActionListener(e -> processarPalpite());
        restartButton.addActionListener(e -> reiniciarJogo());

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        buttonPanel.add(submitButton);
        buttonPanel.add(restartButton);

        JPanel inputPanel = new JPanel(new BorderLayout(10, 10));
        inputPanel.add(new JLabel("Digite seu palpite:"), BorderLayout.WEST);
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(buttonPanel, BorderLayout.EAST);

        frame.add(inputPanel, BorderLayout.NORTH);

        // Exibir a janela
        frame.setVisible(true);
    }

    private void processarPalpite() {
        try {
            int palpite = Integer.parseInt(inputField.getText());
            String resultado = controller.processarPalpite(palpite);
            feedbackLabel.setText(resultado);

            if (resultado.contains("Parabéns")) {
                feedbackLabel.setForeground(Color.GREEN);
            } else if (resultado.contains("menor") || resultado.contains("maior")) {
                feedbackLabel.setForeground(Color.ORANGE);
            } else {
                feedbackLabel.setForeground(Color.RED);
            }

            tentativasLabel.setText("Tentativas restantes: " + controller.getTentativasRestantes());
            pontuacaoLabel.setText("Pontuação atual: " + controller.getPontuacao());

            inputField.setText("");

        } catch (NumberFormatException ex) {
            feedbackLabel.setText("Por favor, insira um número válido.");
            feedbackLabel.setForeground(Color.RED);
        }
    }

    private void reiniciarJogo() {
        controller.reiniciarJogo();
        feedbackLabel.setText("Novo jogo ! Faça palpite com números de 1 a 100!");
        feedbackLabel.setForeground(Color.BLUE);

        tentativasLabel.setText("Tentativas restantes: " + controller.getTentativasRestantes());
        pontuacaoLabel.setText("Pontuação atual: " + controller.getPontuacao());

        inputField.setText("");
    }
}
