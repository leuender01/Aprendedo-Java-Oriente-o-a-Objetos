import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;


public class TelaEmJava{
    public static void main(String[] args) {
        JLabel texto = new JLabel("Ola mundo?", Font.BOLD, JLabel.CENTER);
        JFrame janela = new JFrame("Minha primeria janela");
        janela.setSize(500, 400);
        janela.setLocationRelativeTo(null);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.add(texto);
        janela.setBackground(Color.BLACK);
        janela.setVisible(true);
    }
}

