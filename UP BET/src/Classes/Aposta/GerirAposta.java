package Classes.Aposta;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class GerirAposta{

    private static final String ARQUIVO = "apostas.txt";

    public static void salvarAposta(Aposta aposta) {
        try (FileWriter fWriter = new FileWriter(ARQUIVO, true);
             BufferedWriter bWriter = new BufferedWriter(fWriter)) {
            bWriter.write(aposta.toFileString() + "\n");
        } catch (IOException e) {
            System.out.println("Houve um erro ao criar ou acessar o arquivo " + ARQUIVO);
        }
    }

    public static ArrayList<Aposta> lerApostas() throws Exception {

        ArrayList<Aposta> apostas = new ArrayList<>();

        try (FileReader fReader = new FileReader(ARQUIVO);
                BufferedReader bReader = new BufferedReader(fReader)) {

            String linha;

            while ((linha = bReader.readLine()) != null) {

                Aposta aposta = Aposta.fromString(linha);
                apostas.add(aposta);

            }

        }

        if (apostas.isEmpty()) {
            throw new Exception("Não há apostas salvas.");
        }

        return apostas;

    }

    public static void removerTodasApostas() {
        try {
            
            ArrayList<Aposta> listaApostas = new ArrayList<>();
            CadastrarApostas.setApostas(listaApostas);
    
            
            try (FileWriter fWriter = new FileWriter(ARQUIVO, false)) {
                
                fWriter.write("");
            }
    
        } catch (Exception e) {
            System.out.println("Erro ao remover apostas: " + e.getMessage());
        }
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
    
}


    

