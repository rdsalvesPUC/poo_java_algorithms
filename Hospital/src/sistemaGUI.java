import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Pattern;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

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

    public void mostrarTelaSolicitarAgendaMedico() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                criarTelaSolicitarAgendaMedico();
            }
        });
    }

    private void criarTelaSolicitarAgendaMedico() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(new EmptyBorder(10, 20, 10, 20));

        JLabel crmLabel = new JLabel("CRM do médico:");
        JTextField crmField = new JTextField();
        panel.add(crmLabel);
        panel.add(crmField);

        JLabel dataInicialLabel = new JLabel("Data inicial (dd/mm/aaaa):");
        JTextField dataInicialField = new JTextField();
        panel.add(dataInicialLabel);
        panel.add(dataInicialField);

        JLabel dataFinalLabel = new JLabel("Data final (dd/mm/aaaa):");
        JTextField dataFinalField = new JTextField();
        panel.add(dataFinalLabel);
        panel.add(dataFinalField);

        int result = JOptionPane.showConfirmDialog(frame, panel, "Consultar Agenda de Médico", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String crmText = crmField.getText().trim();
            String dataInicialText = dataInicialField.getText().trim();
            String dataFinalText = dataFinalField.getText().trim();

            if (!crmText.isEmpty() && !dataInicialText.isEmpty() && !dataFinalText.isEmpty()) {
                try {
                    int crm = Integer.parseInt(crmText);
                    LocalDate dataInicial = Consulta.str_to_data(dataInicialText);
                    LocalDate dataFinal = Consulta.str_to_data(dataFinalText);

                    if (dataInicial == null || dataFinal == null) {
                        JOptionPane.showMessageDialog(frame, "Uma ou ambas as datas são inválidas. Por favor, tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                    } else if (dataFinal.isBefore(dataInicial)) {
                        JOptionPane.showMessageDialog(frame, "A data final não pode ser anterior à data inicial.", "Erro", JOptionPane.ERROR_MESSAGE);
                    } else {
                        executarConsultaAgendaMedico(crm, dataInicial, dataFinal);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira um CRM válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Todos os campos são obrigatórios. Por favor, tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void executarConsultaAgendaMedico(int crm, LocalDate dataInicial, LocalDate dataFinal) {
        String conteudo = "";
        boolean encontrado = false;
        for (Medico medico : listaMedicos) {
            if (crm == medico.get_crm()) {
                conteudo = medico.exibir_consultas_by_medico(dataInicial, dataFinal);
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

    public void mostrarTelaSolicitarPacientesInativos() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                criarTelaSolicitarPacientesInativos();
            }
        });
    }

    private void criarTelaSolicitarPacientesInativos() {
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.setBorder(new EmptyBorder(10, 20, 10, 20));

        JLabel crmLabel = new JLabel("CRM do médico:");
        JTextField crmField = new JTextField();
        panel.add(crmLabel);
        panel.add(crmField);

        JLabel mesesLabel = new JLabel("Tempo de inatividade (em meses):");
        JTextField mesesField = new JTextField();
        panel.add(mesesLabel);
        panel.add(mesesField);

        int result = JOptionPane.showConfirmDialog(frame, panel, "Consultar Pacientes Inativos", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String crmText = crmField.getText().trim();
            String mesesText = mesesField.getText().trim();

            if (!crmText.isEmpty() && !mesesText.isEmpty()) {
                try {
                    int crm = Integer.parseInt(crmText);
                    int meses = Integer.parseInt(mesesText);

                    executarConsultaPacientesInativos(crm, meses);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira valores válidos para CRM e tempo de inatividade.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Todos os campos são obrigatórios. Por favor, tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void executarConsultaPacientesInativos(int crm, int meses) {
        String conteudo = "";
        boolean encontrado = false;
        for (Medico medico : listaMedicos) {
            if (crm == medico.get_crm()) {
                conteudo = medico.exibir_pacientesInativos_by_medico(meses);
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

    public void mostrarTelaSolicitarMedicosPaciente() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                criarTelaSolicitarMedicosPaciente();
            }
        });
    }

    private void criarTelaSolicitarMedicosPaciente() {
        String cpfRegex = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";
        String cpf = JOptionPane.showInputDialog(frame, "Informe o CPF do paciente (formato 000.000.000-00):");

        if (cpf != null && Pattern.matches(cpfRegex, cpf)) {
            executarConsultaMedicosPaciente(cpf);
        } else {
            JOptionPane.showMessageDialog(frame, "CPF inválido! Informe o CPF no formato 000.000.000-00.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void executarConsultaMedicosPaciente(String cpf) {
        String conteudo = "";
        boolean encontrado = false;
        for (Paciente paciente : listaPacientes) {
            if (Objects.equals(cpf, paciente.get_cpf())) {
                conteudo = paciente.exibir_medicos_by_paciente();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(frame, "Esse CPF não pertence a um paciente em nossa base, tente novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            mostrarResultadoConsulta(conteudo, "Pacientes", new String[]{
                    "Médicos responsáveis pelo paciente",
                    "Consultar a agenda de um paciente",
                    "Histórico de consultas do paciente com um médico"
            });
        }
    }

    public void mostrarTelaSolicitarAgendaPaciente() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                criarTelaSolicitarAgendaPaciente();
            }
        });
    }

    private void criarTelaSolicitarAgendaPaciente() {
        String cpfRegex = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";
        String cpf = JOptionPane.showInputDialog(frame, "Informe o CPF do paciente (formato 000.000.000-00):");

        if (cpf != null && Pattern.matches(cpfRegex, cpf)) {
            executarConsultaAgendaPaciente(cpf);
        } else {
            JOptionPane.showMessageDialog(frame, "CPF inválido! Informe o CPF no formato 000.000.000-00.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void executarConsultaAgendaPaciente(String cpf) {
        String conteudo = "";
        boolean encontrado = false;
        for (Paciente paciente : listaPacientes) {
            if (Objects.equals(cpf, paciente.get_cpf())) {
                conteudo = paciente.exibir_consultas_by_paciente();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(frame, "Esse CPF não pertence a um paciente em nossa base, tente novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            mostrarResultadoConsulta(conteudo, "Pacientes", new String[]{
                    "Médicos responsáveis pelo paciente",
                    "Consultar a agenda de um paciente",
                    "Histórico de consultas do paciente com um médico"
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

    public void mostrarTelaSolicitarHistoricoConsultas() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                criarTelaSolicitarHistoricoConsultas();
            }
        });
    }

    private void criarTelaSolicitarHistoricoConsultas() {
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.setBorder(new EmptyBorder(10, 20, 10, 20));

        JLabel cpfLabel = new JLabel("CPF do paciente:");
        JTextField cpfField = new JTextField();
        panel.add(cpfLabel);
        panel.add(cpfField);

        JLabel crmLabel = new JLabel("CRM do médico:");
        JTextField crmField = new JTextField();
        panel.add(crmLabel);
        panel.add(crmField);

        int result = JOptionPane.showConfirmDialog(frame, panel, "Consultar Histórico de Consultas", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String cpf = cpfField.getText().trim();
            String crmText = crmField.getText().trim();

            String cpfRegex = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";
            String crmRegex = "\\d+";

            if (!cpf.isEmpty() && !crmText.isEmpty() && Pattern.matches(cpfRegex, cpf) && Pattern.matches(crmRegex, crmText)) {
                int crm = Integer.parseInt(crmText);
                executarConsultaHistoricoConsultas(cpf, crm);
            } else {
                JOptionPane.showMessageDialog(frame, "CPF ou CRM inválido! Verifique os campos e tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void executarConsultaHistoricoConsultas(String cpf, int crm) {
        String conteudo = "";
        boolean pacienteEncontrado = false;
        boolean medicoEncontrado = false;
        for (Paciente paciente : listaPacientes) {
            if (Objects.equals(cpf, paciente.get_cpf())) {
                pacienteEncontrado = true;
                if (paciente.check_medico(crm)) {
                    medicoEncontrado = true;
                    conteudo = paciente.exibir_consultas_by_paciente_and_medico(crm);
                    break;
                } else {
                    JOptionPane.showMessageDialog(frame, "Esse paciente nunca foi atendido por esse médico. Tente novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (!pacienteEncontrado) {
            JOptionPane.showMessageDialog(frame, "Esse CPF não pertence a um paciente em nossa base, tente novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        if (pacienteEncontrado && medicoEncontrado) {
            mostrarResultadoConsulta(conteudo, "Pacientes", new String[]{
                    "Médicos responsáveis pelo paciente",
                    "Consultar a agenda de um paciente",
                    "Histórico de consultas do paciente com um médico"
            });
        }
    }

    public static void setListaMedicos(ArrayList<Medico> medicos) {
        listaMedicos = medicos;
    }

    public static void setListaPacientes(ArrayList<Paciente> pacientes) {
        listaPacientes = pacientes;
    }

    public static ArrayList get_lista_pacientes() {
        return listaPacientes;
    }

    //public static void setListaConsultas(ArrayList<Paciente> pacientes) {
    //    listaPacientes = pacientes;
    //}
}