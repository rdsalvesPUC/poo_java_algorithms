import java.time.*;
import java.io.*;
import java.util.*;

public class testeCSV {
    public static void main(String[] args) {
        ArrayList<Medico> medicos = new ArrayList<>();
        String file = "Hospital/arquivos_csv/medicos.csv";
        BufferedReader reader = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {

                String[] medico = line.split(cvsSplitBy);
                String nome = medico[0];
                int crm = Integer.parseInt(medico[1]);

                medicos.add(new Medico(nome, crm));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Medico medico : medicos) {
            medico.exibir();
        }
    }
}

