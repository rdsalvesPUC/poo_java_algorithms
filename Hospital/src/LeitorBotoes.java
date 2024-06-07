import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class LeitorBotoes implements ActionListener {
    private sistemaGUI gui;

    public LeitorBotoes(sistemaGUI gui) {
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton origem = (JButton) e.getSource();
        String comando = origem.getActionCommand();

        switch (comando) {
            case "Médicos":
                gui.mostrarTelaSecundaria("Médicos", new String[]{
                        "Consultar a lista de pacientes de um médico",
                        "Consultar a agenda de um médico",
                        "Consultar lista de pacientes inativos de um médico"
                });
                break;
            case "Pacientes":
                gui.mostrarTelaSecundaria("Pacientes", new String[]{
                        "Médicos responsáveis pelo paciente",
                        "Consultar a agenda de um paciente",
                        "Histórico de consultas do paciente com um médico"
                });
                break;
            case "Voltar":
                gui.mostrarTelaInicial();
                break;
            case "Consultar a lista de pacientes de um médico":
                gui.mostrarTelaSolicitarCRM();
                break;
            default:
                System.out.println("Opção desconhecida: " + comando);
        }
    }
}
