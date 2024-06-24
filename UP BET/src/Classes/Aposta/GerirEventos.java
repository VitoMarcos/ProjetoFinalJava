package Classes.Aposta;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class GerirEventos {
   
    private static final String ARQUIVO = "eventos.txt";

    public static void salvarEvento(Evento evento) {

        ArrayList<Evento> listaEventos = (ArrayList<Evento>) CadastrarEvento.getEventos();

        try (FileWriter fWriter = new FileWriter(ARQUIVO, true);
                BufferedWriter bWriter = new BufferedWriter(fWriter)) {

                    for (Evento tempE : listaEventos) {

                        bWriter.write(tempE.toString() + "\n");
        
                    }

        } catch (IOException e) {
            System.out.println("Houve um erro ao criar ou acessar o arquivo " + ARQUIVO);
        }

    }

     public static List<Evento> lerEventos() throws Exception {

        ArrayList<Evento> listaEventos = (ArrayList<Evento>) CadastrarEvento.getEventos();
        listaEventos.clear();

        try (FileReader fReader = new FileReader(ARQUIVO);
                BufferedReader bReader = new BufferedReader(fReader)) {

            String linha;

            while ((linha = bReader.readLine()) != null) {

                Evento tempE = new Evento();

                tempE.fromString(linha);

                CadastrarEvento.adicionarEvento(tempE);

            }
        }
        if (listaEventos.isEmpty()) {
            throw new Exception("Não há jogos criados.");
        }
        return listaEventos;
    }

    public static void criarArquivoSeNaoExistir() {

        try {
            File arquivo = new File(ARQUIVO);

            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }

        } catch (IOException exception) {

            exception.printStackTrace();
        }

    }

    public static Evento buscarEvento(int id) throws Exception {
        ArrayList<Evento> eventos = (ArrayList<Evento>) lerEventos();
    
        for (Evento tempEvento : eventos) {
            if (tempEvento.getId() == id) {
                return tempEvento;
            }
        }
    
        throw new Exception("Evento com o ID " + id + " não encontrado!");

}
}