import javax.swing.*;
import java.awt.*;

public class BoxLayoutExample {
    public static void main(String[] args) {
        // Criação do frame
        JFrame frame = new JFrame("BoxLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Criação do painel com BoxLayout no eixo Y
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        // Adicionando botões ao painel
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");

        // Definindo alinhamento
        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);
        button3.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Adicionando botões ao painel
        panel.add(button1);
        panel.add(Box.createRigidArea(new Dimension(0, 5))); // Espaçamento entre os botões
        panel.add(button2);
        panel.add(Box.createRigidArea(new Dimension(0, 5))); // Espaçamento entre os botões
        panel.add(button3);

        // Adicionando o painel ao frame
        frame.add(panel);

        // Exibindo o frame
        frame.setVisible(true);
    }
}
