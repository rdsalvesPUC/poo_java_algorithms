import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class sistemaHospitalar {
    public static void main(String[] args) throws FileNotFoundException {
        Medico.criar_medicos("Hospital/arquivos_csv/medicos.csv");
        Paciente.criar_pacientes("Hospital/arquivos_csv/pacientes.csv");
        Consulta.criar_consultas("Hospital/arquivos_csv/consultas.csv");

        Scanner scanner = new Scanner(System.in);

        int escolha;
        boolean sair = false;

        do {
            Menus.exibirMenuPrincipal();
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (escolha) {
                case 1:
                    Menus.menuMedico(scanner);
                    break;
                case 2:
                    Menus.menuPaciente(scanner);
                    break;
                case 3:
                    sair = true;
                    System.out.println("Saindo do sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        } while (!sair);
        scanner.close();
    }
}
