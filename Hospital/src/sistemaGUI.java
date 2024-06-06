import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class sistemaGUI {
    private JFrame frame;

    public sistemaGUI() {
        frame = new JFrame("Hospital XPTO");
        frame.setSize(1024, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    public void criarTelaInicial() {
        JPanel painel = new JPanel();
        painel.setBorder(new EmptyBorder(10, 20, 10, 20));
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Bem-vindo ao Hospital XPTO", SwingConstants.CENTER);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        painel.add(title);

        painel.add(Box.createRigidArea(new Dimension(0, 10)));
        painel.add(new JSeparator(SwingConstants.HORIZONTAL));
        painel.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel question = new JLabel("Você deseja informações sobre um Médico ou um Paciente?");
        question.setAlignmentX(Component.CENTER_ALIGNMENT);
        painel.add(question);

        JPanel buttonsRow = criarPainelBotoes();

        painel.add(buttonsRow);

        frame.getContentPane().removeAll();
        frame.add(painel);
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }

    private JPanel criarPainelBotoes() {
        JPanel buttonsRow = new JPanel();
        buttonsRow.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton buttonMedico = new JButton("Médicos");
        JButton buttonPaciente = new JButton("Pacientes");

        buttonMedico.setActionCommand("Médicos");
        buttonPaciente.setActionCommand("Pacientes");

        ActionListener listener = new LeitorBotoes();

        buttonMedico.addActionListener(listener);
        buttonPaciente.addActionListener(listener);

        buttonsRow.add(buttonMedico);
        buttonsRow.add(buttonPaciente);

        return buttonsRow;
    }

    public void mostrar() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                criarTelaInicial();
            }
        });
    }
}
