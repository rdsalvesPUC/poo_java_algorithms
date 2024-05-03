import java.time.*;
import java.io.*;
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
    }

    public static ArrayList<Consulta> getListaConsultas() {
        return consultas;
    }
}
