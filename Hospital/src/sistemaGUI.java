import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class sistemaGUI {
    private JFrame frame;
    private static ArrayList<Medico> listaMedicos = Medico.get_lista_medicos();
    private static ArrayList<Paciente> listaPacientes = Paciente.get_lista_pacientes();

    public sistemaGUI() {
        frame = new JFrame("Hospital XPTO");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        criarTelaInicial();
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

        JPanel buttonsRow = criarPainelBotoesIniciais();

        painel.add(buttonsRow);

        frame.getContentPane().removeAll();
        frame.add(painel);
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }

    public void criarTelaSecundaria(String subtitle, String[] botoes) {
        JPanel painel = new JPanel();
        painel.setBorder(new EmptyBorder(10, 20, 10, 20));
        painel.setLayout(new BorderLayout());

        JButton voltarButton = new JButton("Voltar");
        voltarButton.setActionCommand("Voltar");
        voltarButton.addActionListener(new LeitorBotoes(this));
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(voltarButton);
        painel.add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JLabel subtitleLabel = new JLabel(subtitle, SwingConstants.CENTER);
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(subtitleLabel);

        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        centerPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));

        for (String botaoTexto : botoes) {
            JButton button = new JButton(botaoTexto);
            button.setMaximumSize(new Dimension(400, button.getMinimumSize().height));
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.setActionCommand(botaoTexto);
            button.addActionListener(new LeitorBotoes(this));
            buttonsPanel.add(button);
            buttonsPanel.add(Box.createRigidArea(new Dimension(0, 16)));
        }

        centerPanel.add(Box.createVerticalGlue());
        centerPanel.add(buttonsPanel);
        centerPanel.add(Box.createVerticalGlue());

        painel.add(centerPanel, BorderLayout.CENTER);

        frame.getContentPane().removeAll();
        frame.add(painel);
        frame.revalidate();
        frame.repaint();
    }

    private JPanel criarPainelBotoesIniciais() {
        JPanel buttonsRow = new JPanel();
        buttonsRow.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton buttonMedico = new JButton("Médicos");
        JButton buttonPaciente = new JButton("Pacientes");

        buttonMedico.setActionCommand("Médicos");
        buttonPaciente.setActionCommand("Pacientes");

        ActionListener listener = new LeitorBotoes(this);

        buttonMedico.addActionListener(listener);
        buttonPaciente.addActionListener(listener);

        buttonsRow.add(buttonMedico);
        buttonsRow.add(buttonPaciente);

        return buttonsRow;
    }

    public void mostrarTelaInicial() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                criarTelaInicial();
            }
        });
    }

    public void mostrarTelaSecundaria(String subtitle, String[] botoes) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                criarTelaSecundaria(subtitle, botoes);
            }
        });
    }

    public void mostrarTelaSolicitarCRM() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                criarTelaSolicitarCRM();
            }
        });
    }

    private void criarTelaSolicitarCRM() {
        String crmText = JOptionPane.showInputDialog(frame, "Informe o CRM do médico desejado:");

        if (crmText != null && !crmText.isEmpty()) {
            try {
                int crm = Integer.parseInt(crmText);
                executarConsultaPorCRM(crm);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Por favor, insira um CRM válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void executarConsultaPorCRM(int crm) {
        String conteudo = "";
        boolean encontrado = false;
        for (Medico medico : listaMedicos) {
            if (crm == medico.get_crm()) {
                conteudo = medico.exibir_pacientes_by_medico();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(frame, "Esse CRM não pertence a um médico em nossa base, tente novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            mostrarResultadoConsulta(conteudo, "Médicos", new String[]{
                    "Consultar a lista de pacientes de um médico",
                    "Consultar a agenda de um médico",
                    "Consultar lista de pacientes inativos de um médico"
            });
        }
    }

    public void mostrarResultadoConsulta(String conteudo, String subtitle, String[] botoes) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                criarTelaResultadoConsulta(conteudo, subtitle, botoes);
            }
        });
    }

    private void criarTelaResultadoConsulta(String conteudo, String subtitle, String[] botoes) {
        JPanel painel = new JPanel();
        painel.setBorder(new EmptyBorder(10, 20, 10, 20));
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        JTextArea resultadoArea = new JTextArea(conteudo);
        resultadoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));
        painel.add(scrollPane);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(e -> mostrarTelaSecundaria(subtitle, botoes));
        buttonPanel.add(voltarButton);

        JButton salvarButton = new JButton("Salvar Consulta");
        salvarButton.addActionListener(e -> Menus.salvar_arquivo(conteudo, Menus.consultarDataHora()));
        buttonPanel.add(salvarButton);

        painel.add(buttonPanel);

        frame.getContentPane().removeAll();
        frame.add(painel);
        frame.revalidate();
        frame.repaint();
    }
}
