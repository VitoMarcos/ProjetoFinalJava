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

import Classes.Pessoa.Usuario;
import Times.Resultados;


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
        e.printStackTrace(); // Adicionado para ajudar a identificar o problema
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
                System.out.println("Resultado do jogo: " + e.getTimeA().getNome() + " " + golsA + " x " + golsB + " " + e.getTimeB().getNome());
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
}
