import javax.print.ServiceUI;
import java.text.DateFormat;
import java.time.*;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Consulta implements Comparable<Consulta>, Serializable {
    private LocalDate data;
    private LocalTime horario;
    private int crm;
    private String cpf;
    private static ArrayList<Consulta> consultas = new ArrayList<>();

    public Consulta(LocalDate data, LocalTime horario, int crm, String cpf) {
        this.data = data;
        this.horario = horario;
        this.crm = crm;
        this.cpf = cpf;
    }

    public static void criar_consultas(String path) {
        BufferedReader reader = null;
        String line = "";
        String cvsSplitBy = ",";
        DateTimeFormatter date_formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        ArrayList<Paciente> listaPacientes = Paciente.get_lista_pacientes();

        try {
            reader = new BufferedReader(new FileReader(path));
            while ((line = reader.readLine()) != null) {

                String[] consulta = line.split(cvsSplitBy);

                LocalDate data = LocalDate.parse(consulta[0], date_formatter);
                LocalTime horario = LocalTime.parse(consulta[1]);
                int crm = Integer.parseInt(consulta[2]);
                String cpf = (consulta[3]);

                Consulta nova_consulta = new Consulta(data, horario, crm, cpf);
                consultas.add(nova_consulta);

                Consulta.alocar_consultas(nova_consulta, listaPacientes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String data_to_str(LocalDate data) {
        DateTimeFormatter date_formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String data_formatada = data.format(date_formatter);
        return data_formatada;

    }

    public static LocalDate str_to_data(String data) {
        String splitBy = "/";
        String[] array_data = data.split(splitBy);
        String data_iso = "";
        LocalDate data_formatada;
        try {
            data_iso = array_data[2] + "-" + array_data[1] + "-" + array_data[0];
            data_formatada = LocalDate.parse(data_iso);
        }
        catch (Exception e) {
            data_formatada = null;
        }
        return data_formatada;
    }

    public static ArrayList<Consulta> get_lista_consultas() {
        return consultas;
    }

    public LocalDate get_data() {
        return data;
    }

    public String get_data_str() {
        return data_to_str(data);
    }

    public LocalTime get_horario() {
        return horario;
    }

    public int get_crm() {
        return crm;
    }

    public String get_cpf() {
        return cpf;
    }

    public static void alocar_consultas(Consulta consulta, ArrayList<Paciente> pacientes) {
        for (Paciente p : pacientes) {
            if (consulta.cpf.equals(p.get_cpf())) {
                p.add_consulta(consulta);
                break;
            }
        }
    }

    @Override
    public int compareTo(Consulta outraConsulta) {
        int comparacaoData = this.data.compareTo(outraConsulta.data);
        if (comparacaoData != 0) {
            return comparacaoData;
        }

        return this.horario.compareTo(outraConsulta.horario);
    }
}
