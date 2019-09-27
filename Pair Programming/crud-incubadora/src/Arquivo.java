import javax.imageio.stream.ImageOutputStream;
import java.io.*;

public class Arquivo {

    public static void alterarNome(String rFilename,String nomeAntigo, String nomeNovo) throws IOException {
        File file = new File("Arquivos/", rFilename);

        String line;
        StringBuilder text = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(file));

        while ((line = br.readLine()) != null) {
            if(!line.equals(nomeAntigo)) {
                text.append(line);
                text.append('\n');
            }else{
                text.append(nomeNovo);
                text.append('\n');
            }
        }


        FileWriter writer = new FileWriter(file);
        writer.append(text);
        writer.flush();
        writer.close();

    }


    public static void removerNome(String rFilename,String nome) throws IOException {
        File file = new File("Arquivos/", rFilename);

        String line;
        StringBuilder text = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(file));

        while ((line = br.readLine()) != null) {
            if(!line.equals(nome)) {
                text.append(line);
                text.append('\n');
            }
        }


        FileWriter writer = new FileWriter(file);
        writer.append(text);
        writer.flush();
        writer.close();

    }

    public static String lerArquivo(String rFilename) {
        File file = new File("Arquivos/", rFilename);
        StringBuilder text = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            br.close();
        } catch (IOException e) { }

        return text.toString();
    }

    public static void escreverArquivo(String nomeArquivo, String nomeTime) {
        try {
            File root = new File("Arquivos");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, nomeArquivo);
            StringBuilder conteudoArquivoExistente = new StringBuilder();

            if(gpxfile.exists())
            {
                String conteudoArquivo = lerArquivo(nomeArquivo);
                conteudoArquivoExistente.append(conteudoArquivo);
            }
            conteudoArquivoExistente.append(nomeTime);
            conteudoArquivoExistente.append("\n");

            FileWriter writer = new FileWriter(gpxfile);
            writer.append(conteudoArquivoExistente);
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
