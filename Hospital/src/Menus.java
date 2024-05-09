import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Pattern;

public class Menus {
    private static ArrayList<Medico> listaMedicos = Medico.get_lista_medicos();
    private static ArrayList<Paciente> listaPacientes = Paciente.get_lista_pacientes();

    public static void exibirMenuPrincipal() {
        System.out.println("\nBem-vindo ao Hospital XPTO");
        System.out.println("------------------------------------");
        System.out.println("# Você deseja informações sobre um Médico ou um Paciente?");
        System.out.println("1 - Médico >");
        System.out.println("2 - Paciente >");
        System.out.println("3 - Sair");
    }

    public static void menuMedico(Scanner scanner) {
        int escolha;

        do {
            System.out.println("\n### Selecione a informação desejada:");
            System.out.println("1. Consultar a lista de pacientes de um médico");
            System.out.println("2. Consultar a agenda de um médico");
            System.out.println("3. Consultar lista de pacientes inativos de um médico");
            System.out.println("4. Voltar ao menu principal");

            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (escolha) {
                case 1:
                    consultarListaPacientes(scanner);
                    break;
                case 2:
                    consultarAgendaMedico(scanner);
                    break;
                case 3:
                    consultarPacientesInativos(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        } while (true);
    }

    public static void menuPaciente(Scanner scanner) {
        int escolha;

        do {
            System.out.println("\n### Selecione a informação desejada:");
            System.out.println("1. Médicos responsáveis pelo paciente");
            System.out.println("2. Consultar a agenda de um paciente");
            System.out.println("3. Histórico de consultas do paciente com um médico");
            System.out.println("4. Voltar ao menu principal");

            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (escolha) {
                case 1:
                    consultarMedicosResponsaveis(scanner);
                    break;
                case 2:
                    consultarAgendaPaciente(scanner);
                    break;
                case 3:
                    consultarHistoricoConsultas(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        } while (true);
    }

    // DONE
    // 1 Quais são todos os pacientes de um determinado médico?
    public static void consultarListaPacientes(Scanner scanner) {
        System.out.println("\nPor favor, informe o CRM do médico desejado: ");
        int crm = scanner.nextInt();
        scanner.nextLine();
        String conteudo = "";

        boolean encontrado = false;
        for (Medico medico : listaMedicos) {
            if (crm == medico.get_crm()) {
                conteudo = medico.exibir_pacientes_by_medico();
                System.out.println(medico.exibir_pacientes_by_medico());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("--- Esse CRM não pertece à um médico em nossa base, tente novamente!");
        }
        else
            Menus.consultarSalvarResultado(scanner, conteudo);
    }

    // DONE
    // 2 Quais são todas as consultas agendadas para um determinado médico em determinado período (definido por uma data
    // inicial e uma data final), na ordem crescente dos horários? (O período pode cobrir tanto o tempo passado como o tempo futuro.)
    public static void consultarAgendaMedico(Scanner scanner) {
        System.out.println("\nPor favor, informe o CRM do médico desejado: ");
        int crm = scanner.nextInt();
        scanner.nextLine();

        LocalDate data_inicial = null;
        while (data_inicial == null) {
            System.out.println("Informe a data inicial (dd/mm/aaaa): ");
            String data_string = scanner.nextLine();
            data_inicial = Consulta.str_to_data(data_string);

            if (data_inicial == null) {
                System.out.println("A data informada é inválida. Por favor, tente novamente.");
            }
        }

        LocalDate data_final = null;
        while (data_final == null) {
            System.out.println("Informe a data final (dd/mm/aaaa): ");
            String data_string = scanner.nextLine();
            data_final = Consulta.str_to_data(data_string);

            if (data_final == null) {
                System.out.println("A data informada é inválida. Por favor, tente novamente.");
            }
        }

        String conteudo = "";

        boolean encontrado = false;
        for (Medico medico : listaMedicos) {
            if (crm == medico.get_crm()) {
                conteudo = medico.exibir_consultas_by_medico(data_inicial, data_final);
                System.out.println(medico.exibir_consultas_by_medico(data_inicial, data_final));
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("--- Esse CRM não pertece à um médico em nossa base, tente novamente!");
        }
        else
            Menus.consultarSalvarResultado(scanner, conteudo);
    }

    // DONE
    // 6 Quais são os pacientes de um determinado médico que não o consulta há mais
    // que um determinado tempo (em meses)?
    public static void consultarPacientesInativos(Scanner scanner) {
        System.out.println("\nPor favor, informe o CRM do médico desejado: ");
        int crm = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Informe o tempo de inatividade em meses (exemplo: 1, 2, 3...): ");
        int meses = scanner.nextInt();
        scanner.nextLine();

        String conteudo = "";
        boolean encontrado = false;
        for (Medico medico : listaMedicos) {
            if (crm == medico.get_crm()) {
                conteudo = medico.exibir_pacientesInativos_by_medico(meses);
                System.out.println(conteudo);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("--- Esse CRM não pertece à um médico em nossa base, tente novamente!");
        }
        else
            Menus.consultarSalvarResultado(scanner, conteudo);
    }

    // DONE
    // 3 Quais são todos os médicos que um determinado paciente já consultou ou tem consulta agendada?
    public static void consultarMedicosResponsaveis(Scanner scanner) {
        String conteudo = "";
        String cpfRegex = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";
        String cpf = "";

        while (!Pattern.matches(cpfRegex, cpf)) {
            System.out.println("\nPor favor, informe o CPF do paciente desejado: ");
            cpf = scanner.nextLine();

            if (!Pattern.matches(cpfRegex, cpf)) {
                System.out.println("--- CPF inválido! Informe o CPF no formato 000.000.000-00, respeitando a pontuação.");
            }
        }
        boolean encontrado = false;
        for (Paciente paciente : listaPacientes) {
            if (Objects.equals(cpf, paciente.get_cpf())) {
                conteudo = paciente.exibir_medicos_by_paciente();
                System.out.println(paciente.exibir_medicos_by_paciente());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("--- Esse CPF não pertece à um paciente em nossa base, tente novamente!");
        }
        else
            Menus.consultarSalvarResultado(scanner, conteudo);
    }

    // DONE
    // 5 Quais são todas as consultas agendadas que um determinado paciente possui?
    // (Somente consultas agendadas para um tempo posterior ao momento atual são consideradas.)
    public static void consultarAgendaPaciente(Scanner scanner) {
        String conteudo = "";
        String cpfRegex = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";
        String cpf = "";

        while (!Pattern.matches(cpfRegex, cpf)) {
            System.out.println("\nPor favor, informe o CPF do paciente desejado: ");
            cpf = scanner.nextLine();

            if (!Pattern.matches(cpfRegex, cpf)) {
                System.out.println("--- CPF inválido! Informe o CPF no formato 000.000.000-00, respeitando a pontuação.");
            }
        }
        boolean encontrado = false;
        for (Paciente paciente : listaPacientes) {
            if (Objects.equals(cpf, paciente.get_cpf())) {
                conteudo = paciente.exibir_consultas_by_paciente();
                System.out.println(paciente.exibir_consultas_by_paciente());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("--- Esse CPF não pertece à um paciente em nossa base, tente novamente!");
        }
        else
            Menus.consultarSalvarResultado(scanner, conteudo);
    }

    // DONE
    // Quais são todas as consultas que um determinado paciente realizou com determinado médico?
    // (Somente consultas realizadas em um tempo passado são consideradas.)
    public static void consultarHistoricoConsultas(Scanner scanner) {
        String conteudo = "";
        String cpfRegex = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";
        String cpf = "";

        while (!Pattern.matches(cpfRegex, cpf)) {
            System.out.println("\nPor favor, informe o CPF do paciente desejado: ");
            cpf = scanner.nextLine();

            if (!Pattern.matches(cpfRegex, cpf)) {
                System.out.println("--- CPF inválido! Informe o CPF no formato 000.000.000-00, respeitando a pontuação.");
            }
        }

        System.out.println("\nPor favor, informe o CRM do médico desejado: ");
        int crm = scanner.nextInt();
        scanner.nextLine();

        boolean paciente_encontrado = false;
        boolean medico_encontrado = false;
        for (Paciente paciente : listaPacientes) {
            if (Objects.equals(cpf, paciente.get_cpf())) {
                paciente_encontrado = true;
                if (paciente.check_medico(crm)) {
                    medico_encontrado = true;
                    conteudo = paciente.exibir_consultas_by_paciente_and_medico(crm);
                    System.out.println(paciente.exibir_consultas_by_paciente_and_medico(crm));
                    break;
                }
                else {
                    System.out.println("--- Esse paciente nunca foi atendido por esse médico. Tente novamente!");
                }
            }
        }
        if (!paciente_encontrado) {
            System.out.println("--- Esse CPF não pertece à um paciente em nossa base, tente novamente!");
        }
        if (paciente_encontrado && medico_encontrado)
            Menus.consultarSalvarResultado(scanner, conteudo);
    }


    // Metodos para salvar os resultados em arquivos de TXT
    public static void consultarSalvarResultado(Scanner scanner, String conteudo) {
        System.out.println("\n+++ Deseja salvar o resultado? (S/N)");
        String resposta = scanner.nextLine().trim().toUpperCase();
        if (resposta.equals("S")) {
            System.out.println("Salvando o resultado em arquivo TXT...");
            salvar_arquivo(conteudo, "consulta-" + consultarDataHora());
        } else if (resposta.equals("N")) {
            System.out.println("Voltando para o menu...");
        } else {
            System.out.println("--- Resposta inválida. Voltando para o menu...");
        }
    }

    public static void salvar_arquivo(String conteudo, String nomeArquivo) {
        String extensao_arquivo = ".txt";
        nomeArquivo += extensao_arquivo;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write(conteudo);
            System.out.println("+++ Resultado salvo em " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("--- Erro ao salvar o resultado em arquivo: " + e.getMessage());
        }
    }

    public static String consultarDataHora() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String dataHora = now.format(formatter);
        return dataHora;
    }
}
