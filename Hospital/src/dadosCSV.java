import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class dadosCSV {

    public static BufferedReader ler_csv(String path) throws FileNotFoundException {
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(path));

        return reader;
    }

    public static ArrayList criar_medicos(String path) {
        ArrayList<Medico> medicos = new ArrayList<>();
        BufferedReader reader = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            reader = new BufferedReader(new FileReader(path));
            while ((line = reader.readLine()) != null) {

                String[] medico = line.split(cvsSplitBy);
                String nome = medico[0];
                int crm = Integer.parseInt(medico[1]);

                medicos.add(new Medico(nome, crm));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return medicos;
    }

    public static ArrayList criar_pacientes(String path) {
        ArrayList<Paciente> pacientes = new ArrayList<>();
        BufferedReader reader = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            reader = new BufferedReader(new FileReader(path));
            while ((line = reader.readLine()) != null) {

                String[] paciente = line.split(cvsSplitBy);
                String nome = paciente[0];
                String cpf = (paciente[1]);

                pacientes.add(new Paciente(nome, cpf));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pacientes;
    }

    public static ArrayList criar_consultas(String path) {
        ArrayList<Consulta> consultas = new ArrayList<>();
        BufferedReader reader = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            reader = new BufferedReader(new FileReader(path));
            while ((line = reader.readLine()) != null) {

                String[] consulta = line.split(cvsSplitBy);
                LocalDate data = LocalDate.parse(consulta[0]);
                LocalTime horario = LocalTime.parse(consulta[1]);
                int crm = Integer.parseInt(consulta[2]);
                String cpf = (consulta[3]);

                consultas.add(new Consulta(data, horario, crm, cpf));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return consultas;
    }
}

