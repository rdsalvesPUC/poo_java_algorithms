import java.util.Scanner;

public class Menus {
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
            System.out.println("# Selecione a informação desejada:");
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
            System.out.println("# Selecione a informação desejada:");
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
        System.out.println("\nConsultar a lista de pacientes de um médico");
        // Implemente a lógica aqui
    }

    public static void consultarAgendaMedico(Scanner scanner) {
        System.out.println("\nConsultar a agenda de um médico");
        // Implemente a lógica aqui
    }

    public static void consultarPacientesInativos(Scanner scanner) {
        System.out.println("\nConsultar lista de pacientes inativos de um médico");
        // Implemente a lógica aqui
    }

    public static void consultarMedicosResponsaveis(Scanner scanner) {
        System.out.println("\nMédicos responsáveis pelo paciente");
        // Implemente a lógica aqui
    }

    public static void consultarAgendaPaciente(Scanner scanner) {
        System.out.println("\nConsultar a agenda de um paciente");
        // Implemente a lógica aqui
    }

    public static void consultarHistoricoConsultas(Scanner scanner) {
        System.out.println("\nHistórico de consultas do paciente com um médico");
        // Implemente a lógica aqui
    }
}
