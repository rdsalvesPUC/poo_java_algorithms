import java.io.*;
import java.util.*;

public class Menus {
    private static ArrayList<Medico> listaMedicos = Medico.get_lista_medicos();
    private static ArrayList<Paciente> listaPacientes = Paciente.get_lista_pacientes();
    private static ArrayList<Consulta> listaConsultas = Consulta.get_lista_consultas();

    public static void exibirMenuPrincipal() {
        System.out.println("Bem-vindo ao Hospital XPTO");
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

    public static void consultarListaPacientes(Scanner scanner) {
        System.out.println("\nPor favor, informe o CRM do médico desejado: ");
        int medico_desejado = scanner.nextInt();
        scanner.nextLine();

        boolean encontrado = false;
        for (Medico medico : listaMedicos) {
            if (medico_desejado == medico.get_crm()) {
                medico.exibir();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("--- Esse CRM não pertecem um médico em nossa base, tente novamente!");
        }
        else
            Menus.consultarSalvarResultado(scanner);
    }

    public static void consultarAgendaMedico(Scanner scanner) {
        System.out.println("\nConsultar a agenda de um médico");
        // Implemente a lógica aqui
        Menus.consultarSalvarResultado(scanner);
    }

    public static void consultarPacientesInativos(Scanner scanner) {
        System.out.println("\nConsultar lista de pacientes inativos de um médico");
        // Implemente a lógica aqui
        Menus.consultarSalvarResultado(scanner);
    }

    public static void consultarMedicosResponsaveis(Scanner scanner) {
        System.out.println("\nMédicos responsáveis pelo paciente");
        // Implemente a lógica aqui
        Menus.consultarSalvarResultado(scanner);
    }

    public static void consultarAgendaPaciente(Scanner scanner) {
        System.out.println("\nConsultar a agenda de um paciente");
        // Implemente a lógica aqui
        Menus.consultarSalvarResultado(scanner);
    }

    public static void consultarHistoricoConsultas(Scanner scanner) {
        System.out.println("\nHistórico de consultas do paciente com um médico");
        // Implemente a lógica aqui
        Menus.consultarSalvarResultado(scanner);
    }

    public static void consultarSalvarResultado(Scanner scanner) {
        System.out.println("Deseja salvar o resultado? (S/N)");
        String resposta = scanner.nextLine().trim().toUpperCase();
        if (resposta.equals("S")) {
            // Chama o método para salvar o resultado em arquivo TXT
            System.out.println("Salvando o resultado em arquivo TXT...");
        } else if (resposta.equals("N")) {
            // Volta para o menu
            System.out.println("Voltando para o menu...");
        } else {
            System.out.println("--- Resposta inválida. Voltando para o menu...");
        }
    }

    public static void salvar_arquivo(String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            // Escreve o resultado da exibição do médico no arquivo
//            writer.write(exibir());
            System.out.println("Resultado salvo em " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o resultado em arquivo: " + e.getMessage());
        }
    }
}
