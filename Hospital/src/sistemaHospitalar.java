import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class sistemaHospitalar {
    public static void main(String[] args) throws FileNotFoundException {
        Medico.criar_medicos("Hospital/arquivos_csv/medicos.csv");
        ArrayList<Medico> listaMedicos = Medico.get_lista_medicos();

        Paciente.criar_pacientes("Hospital/arquivos_csv/pacientes.csv");
        ArrayList<Paciente> listaPacientes = Paciente.get_lista_pacientes();

        Consulta.criar_consultas("Hospital/arquivos_csv/consultas.csv");
        ArrayList<Consulta> listaConsultas = Consulta.get_lista_consultas();

        Paciente.alocar_paciente();

       // listaConsultas.get(0).exibir();
       // System.out.println(Consulta.exibir());
       // System.out.println(listaMedicos.getFirst().exibir_consultas_by_medico());
       //  System.out.println(listaPacientes.getFirst().exibir_consultas_by_paciente());

       // Locale localeBR = new Locale("pt", "BR");
       // LocalDate date = LocalDate.of(2024, 05, 11);
       // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", localeBR);
       // String text = date.format(formatter);
       // LocalDate parsedDate = LocalDate.parse(text, formatter);

       // SimpleDateFormat fmt = new SimpleDateFormat("dd MM yyyy", localeBR);
       // System.out.println( fmt.format(new Date()) );

       // System.out.println(parsedDate);

       // LocalDate data = listaConsultas.getFirst().get_data();

       // if (data.isAfter(LocalDate.now()))
       //     System.out.println("True");
       // else System.out.println("False");

       // String data2 = "07/05/2024";
       // System.out.println(Consulta.str_to_data(data2));

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
