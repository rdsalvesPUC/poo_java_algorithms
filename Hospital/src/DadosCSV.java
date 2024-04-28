import java.io.*;
import java.util.ArrayList;

public class DadosCSV {
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

                medicos.add(new Medico(medico[0], Integer.parseInt(medico[1])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Medico medico : medicos) {
            medico.exibir();
        }
    }
}

