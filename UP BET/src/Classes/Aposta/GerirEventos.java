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

                    bWriter.write(evento.toFileString() + "\n");

        } catch (IOException e) {
            System.out.println("Houve um erro ao criar ou acessar o arquivo " + ARQUIVO);
        }

    }

    public static ArrayList<Evento> lerEventos() throws IOException, Exception {
        ArrayList<Evento> eventos = new ArrayList<>();

        try (FileReader fReader = new FileReader(ARQUIVO);
             BufferedReader bReader = new BufferedReader(fReader)) {
            String linha;

            while ((linha = bReader.readLine()) != null) {
                Evento evento = Evento.fromString(linha);
                eventos.add(evento);
                System.out.println("Evento carregado: " + evento); // Linha de depuração
            }
        }

        if (eventos.isEmpty()) {
            throw new Exception("Não há eventos salvos.");
        }

        return eventos;
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
        ArrayList<Evento> eventos = lerEventos();
        System.out.println("Eventos disponíveis: " + eventos); 
        
        for (Evento evento : eventos) {
            System.out.println("Verificando evento com ID: " + evento.getId()); // Linha de depuração
            if (evento.getId() == id) {
                System.out.println("Evento encontrado: " + evento); // Linha de depuração
                return evento;
            }
        }

        throw new Exception("Evento com o ID " + id + " não encontrado!");
    }
    
}