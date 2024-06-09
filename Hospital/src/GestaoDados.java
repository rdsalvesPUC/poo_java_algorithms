import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

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

    public static String binMedicos(String caminhoDiretorio) {
        File diretorio = new File(caminhoDiretorio);
        File[] arquivos = diretorio.listFiles();
        String arquivoMedicos = null;

        assert arquivos != null;
        for (File arquivo : arquivos) {
            if (arquivo.getName().matches("Save-Medicos")) {
                arquivoMedicos = arquivo.getName();
            }
        }
        return arquivoMedicos;
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

    public static <T> T abrir(String nome_arquivo, Class<T> tipoClasse) throws IOException, ClassNotFoundException {
        T list = null;

        FileInputStream arquivo = new FileInputStream(nome_arquivo);
        ObjectInputStream restaurador = new ObjectInputStream(arquivo);

        list = tipoClasse.cast(restaurador.readObject());

        restaurador.close();
        arquivo.close();

        return list;
    }
}
