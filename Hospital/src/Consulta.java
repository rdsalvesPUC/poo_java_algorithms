import java.time.*;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Consulta {
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

        try {
            reader = new BufferedReader(new FileReader(path));
            while ((line = reader.readLine()) != null) {

                String[] consulta = line.split(cvsSplitBy);

                LocalDate data = LocalDate.parse(consulta[0], date_formatter);
                LocalTime horario = LocalTime.parse(consulta[1]);
                int crm = Integer.parseInt(consulta[2]);
                String cpf = (consulta[3]);

                consultas.add(new Consulta(data, horario, crm, cpf));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void alocar_consultas(int crm, String cpf) {

    }

    public static ArrayList<Consulta> get_lista_consultas() {
        return consultas;
    }
}
