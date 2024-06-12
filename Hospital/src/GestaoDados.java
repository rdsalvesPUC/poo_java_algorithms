import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class GestaoDados {
    public static boolean existeArquivoBin(String caminhoDiretorio) {
        File diretorio = new File(caminhoDiretorio);

        if (!diretorio.isDirectory()) {
            System.out.println("O caminho fornecido não é um diretório.");
            return false;
        }

        File[] arquivos = diretorio.listFiles();
        if (arquivos == null) {
            System.out.println("Erro ao listar arquivos no diretório.");
            return false;
        }

        for (File arquivo : arquivos) {
            if (arquivo.isFile() && arquivo.getName().endsWith(".bin")) {
                return true;
            }
        }

        return false;
    }

    public static String FindbinMedicos(String caminhoDiretorio) {
        File diretorio = new File(caminhoDiretorio);
        File[] arquivos = diretorio.listFiles();
        String arquivoMedicos = null;

        assert arquivos != null;
        for (File arquivo : arquivos) {
            if (arquivo.getName().contains("Medicos")) {
                arquivoMedicos = arquivo.getName();
            }
        }
        return arquivoMedicos;
    }

    public static String FindbinPacientes(String caminhoDiretorio) {
        File diretorio = new File(caminhoDiretorio);
        File[] arquivos = diretorio.listFiles();
        String arquivoPacientes = null;

        assert arquivos != null;
        for (File arquivo : arquivos) {
            if (arquivo.getName().contains("Pacientes")) {
                arquivoPacientes = arquivo.getName();
            }
        }
        return arquivoPacientes;
    }

    public static String FindbinConsultas(String caminhoDiretorio) {
        File diretorio = new File(caminhoDiretorio);
        File[] arquivos = diretorio.listFiles();
        String arquivoConsultas = null;

        assert arquivos != null;
        for (File arquivo : arquivos) {
            if (arquivo.getName().contains("Consultas")) {
                arquivoConsultas = arquivo.getName();
            }
        }
        return arquivoConsultas;
    }

    public static void salvar(ArrayList objetos, String nome_arquivo) throws IOException {
        String extensao_arquivo = ".bin";
        nome_arquivo += "_" + Menus.consultarDataHora() + extensao_arquivo;

        FileOutputStream arquivo = new FileOutputStream(nome_arquivo);
        ObjectOutputStream gravador = new ObjectOutputStream(arquivo);

        gravador.writeObject(objetos);

        gravador.close();
        arquivo.close();
    }

    public static <T> ArrayList<T> abrir(String nome_arquivo) throws IOException, ClassNotFoundException {
        ArrayList<T> list = null;

        FileInputStream arquivo = new FileInputStream(nome_arquivo);
        ObjectInputStream restaurador = new ObjectInputStream(arquivo);

        list = (ArrayList<T>) restaurador.readObject();

        restaurador.close();
        arquivo.close();

        return list;
    }

    public static void criar_medicos_bin(String diretorio) throws IOException, ClassNotFoundException {
        String arquivoMedicos = GestaoDados.FindbinMedicos(diretorio);
        if (arquivoMedicos != null) {
            ArrayList<Medico> medicos = abrir(diretorio + arquivoMedicos);
            Medico.get_lista_medicos().clear();
            Medico.get_lista_medicos().addAll(medicos);
            sistemaGUI.setListaMedicos(medicos);
        }
    }

    public static void criar_pacientes_bin(String diretorio) throws IOException, ClassNotFoundException {
        String arquivoPacientes = GestaoDados.FindbinPacientes(diretorio);
        if (arquivoPacientes != null) {
            ArrayList<Paciente> pacientes = abrir(diretorio + arquivoPacientes);
            Paciente.get_lista_pacientes().clear();
            Paciente.get_lista_pacientes().addAll(pacientes);
            sistemaGUI.setListaPacientes(pacientes);
        }
    }

    public static void criar_consultas_bin(String diretorio, List<Exception> exceptions) throws IOException, ClassNotFoundException, PacienteNotFoundException {
        String arquivoConsultas = GestaoDados.FindbinConsultas(diretorio);
        if (arquivoConsultas != null) {
            ArrayList<Consulta> consultas = abrir(diretorio + arquivoConsultas);
            ArrayList<Paciente> listaPacientes = sistemaGUI.get_lista_pacientes();

            for (Consulta consulta : consultas) {
                Consulta.alocar_consultas(consulta, listaPacientes, exceptions);
            }
        }
    }

}
