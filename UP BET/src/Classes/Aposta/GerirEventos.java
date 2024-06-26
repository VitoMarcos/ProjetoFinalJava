package Classes.Aposta;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import Times.Resultados;


public class GerirEventos {
   
    private static final String ARQUIVO = "eventos.txt";

    public static void salvarEvento(Evento evento) throws IOException {
        
        ArrayList<Evento> eventos = new ArrayList<>();
        try {
            eventos = lerEventos();
        } catch (Exception e) {
            // Se não houver eventos existentes continua com a lista vazia
        }
    
        
        eventos.add(evento);
    
        
        try (FileWriter fWriter = new FileWriter(ARQUIVO, false);
             BufferedWriter bWriter = new BufferedWriter(fWriter)) {
            for (Evento e : eventos) {
                bWriter.write(e.toFileString() + "\n");
            }
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
        
        for (Evento evento : eventos) {
           
            if (evento.getId() == id) {
                
                return evento;
            }
        }

        throw new Exception("Evento com o ID " + id + " não encontrado!");
    }

    public static Evento buscarEventoPeloId(int id) throws Exception {
        for (Evento tempE : CadastrarEvento.getEventos()) {
            if (tempE.getId() == id) {
                return tempE;
            }
        }
        throw new IllegalArgumentException("Evento não encontrado");
    }

//Metodos da classe gerirEventos para os resultados dos jogos: 
    public static void processarResultados() {
    try {
        // Ler todos os eventos
        ArrayList<Evento> eventos = lerEventos();

        // Gerar resultados aleatórios para cada evento
        for (Evento evento : eventos) {
            evento.getTimeA().setGols(Resultados.gerarResultado());
            evento.getTimeB().setGols(Resultados.gerarResultado());
        }

        
        // Verificar apostas
        verificarApostas(eventos);

    } catch (Exception e) {
        System.out.println("Erro ao processar resultados: " + e.getMessage());
        
    }
}

    private static void verificarApostas(ArrayList<Evento> eventos) {
    try {
        ArrayList<Aposta> apostas = GerirAposta.lerApostas();
        Set<Integer> eventosVerificados = new HashSet<>();

        for (Evento e : eventos) {
            if (!eventosVerificados.contains(e.getId())) {
                int golsA = e.getTimeA().getGols();
                int golsB = e.getTimeB().getGols();
                System.out.println("Verificando aposta para o evento: " + e.getId());
                System.out.println("Resultado do jogo: " + e.getTimeA().getNome() + " " + golsA + " x " + golsB + " " + e.getTimeB().getNome() + "\n");
                eventosVerificados.add(e.getId());

                for (Aposta aposta : apostas) {
                    if (aposta.getEvento().getId() == e.getId()) {
                        if (aposta.getPrevGolsA() == golsA && aposta.getPrevGolsB() == golsB) {
                            double valorGanho = aposta.calcularValorGanho();
                            aposta.getUsuario().atualizarSaldo(valorGanho);
                            System.out.println("Aposta ganha! Valor ganho: " + valorGanho);
                        } else {
                            System.out.println("Aposta perdida.");
                        }
                    }
                }
            }
        }
    } catch (Exception e) {
        System.out.println("Erro ao verificar apostas: " + e.getMessage());
    }
}

    public static void removerTodosEventos() {  
        try {
        
         ArrayList<Evento> eventos = new ArrayList<>();
          CadastrarEvento.setEventos(eventos);

        
        try (FileWriter fWriter = new FileWriter(ARQUIVO, false)) {
            
            fWriter.write("");
        }

    } catch (Exception e) {
        System.out.println("Erro ao remover eventos: " + e.getMessage());
    }
}


    public static void atualizarEvento(Evento eventoAtualizado) throws IOException, Exception {
    ArrayList<Evento> eventos = lerEventos();
    boolean eventoEncontrado = false;

    
    for (int i = 0; i < eventos.size(); i++) {
        if (eventos.get(i).getId() == eventoAtualizado.getId()) {
            eventos.set(i, eventoAtualizado);
            eventoEncontrado = true;
            break;
        }
    }

    if (!eventoEncontrado) {
        throw new Exception("Evento não encontrado para atualização.");
    }

    
    try (FileWriter fWriter = new FileWriter(ARQUIVO, false);
         BufferedWriter bWriter = new BufferedWriter(fWriter)) {
        for (Evento e : eventos) {
            bWriter.write(e.toFileString() + "\n");
        }
    }
}


    public static void excluirEvento(int id) throws IOException, Exception {
    ArrayList<Evento> eventos = lerEventos();
    boolean eventoEncontrado = false;

    // Remover o evento da lista
    for (int i = 0; i < eventos.size(); i++) {
        if (eventos.get(i).getId() == id) {
            eventos.remove(i);
            eventoEncontrado = true;
            break;
        }
    }

    if (!eventoEncontrado) {
        throw new Exception("Evento não encontrado para exclusão.");
    }

    // Reescrever todos os eventos no arquivo
    try (FileWriter fWriter = new FileWriter(ARQUIVO, false);
         BufferedWriter bWriter = new BufferedWriter(fWriter)) {
        for (Evento e : eventos) {
            bWriter.write(e.toFileString() + "\n");
        }
    }
}
}
