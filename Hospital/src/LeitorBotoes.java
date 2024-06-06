import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class LeitorBotoes implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton origem = (JButton) e.getSource();
        String comando = origem.getActionCommand();

        switch (comando) {
            case "Médicos":
                Menus.menuMedico(null); // Ajuste conforme necessário
                break;
            case "Pacientes":
                Menus.menuPaciente(null); // Ajuste conforme necessário
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção desconhecida: " + comando);
        }
    }
}
