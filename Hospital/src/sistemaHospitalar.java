import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class sistemaHospitalar {
    public static void main(String[] args) throws FileNotFoundException {
        popular_bases();
        Medico.criar_medicos();
//        BufferedReader reader = dadosCSV.ler_csv("Hospital/arquivos_csv/medicos.csv");
        criar_medicos();

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

    public static void popular_bases() {
        ArrayList<Medico> medicos_criados = new ArrayList<>(dadosCSV.criar_medicos("Hospital/arquivos_csv/medicos.csv"));
        ArrayList<Paciente> pacientes_criados = new ArrayList<>(dadosCSV.criar_pacientes("Hospital/arquivos_csv/pacientes.csv"));
        ArrayList<Consulta> consultar_criadas = new ArrayList<>(dadosCSV.criar_consultas("Hospital/arquivos_csv/consultas.csv"));
    }

    public static void criar_medicos() throws FileNotFoundException {
        ArrayList<Medico> medicos = new ArrayList<>();
        BufferedReader reader = dadosCSV.ler_csv("Hospital/arquivos_csv/medicos.csv");
        String line = "";
        String cvsSplitBy = ",";

        try {
            while ((line = reader.readLine()) != null) {

                String[] medico = line.split(cvsSplitBy);
                String nome = medico[0];
                int crm = Integer.parseInt(medico[1]);

                medicos.add(new Medico(nome, crm));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
