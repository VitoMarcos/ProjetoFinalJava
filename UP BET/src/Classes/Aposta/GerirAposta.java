package Classes.Aposta;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class GerirAposta{

    private static final String ARQUIVO = "apostas.txt";

    public static void salvarAposta(Aposta aposta) {

        try (FileWriter fWriter = new FileWriter(ARQUIVO, true);
                BufferedWriter bWriter = new BufferedWriter(fWriter)) {

            bWriter.write(aposta + "\n");

        } catch (IOException e) {
            System.out.println("Houve um erro ao criar ou acessar o arquivo " + ARQUIVO);
        }

    }

    public static void lerApostas() throws IOException {

        try (FileReader fReader = new FileReader(ARQUIVO);
                BufferedReader bReader = new BufferedReader(fReader)) {

            String linha;

            while ((linha = bReader.readLine()) != null) {

                System.out.println(linha);

            }

        }

    }

    public static void excluirAposta(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}


    

