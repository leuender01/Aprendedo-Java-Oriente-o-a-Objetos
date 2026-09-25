import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;


public class TelaEmJava{
    public static void main(String[] args) {
        JLabel texto = new JLabel("Ola mundo?", JLabel.CENTER);
        JFrame janela = new JFrame("Minha primeria janela");
        janela.setSize(280, 200);
        janela.setLocationRelativeTo(null);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.add(texto);
        janela.getContentPane().setBackground(Color.BLACK);
        janela.setVisible(true);
    }
}

