package Classes.Aposta;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class GerirAposta{

    private static final String ARQUIVO = "apostas.txt";

    //Salvar objeto apostas

    public static void salvarAposta(Aposta aposta) {
        
        ArrayList<Aposta> listaApostas = (ArrayList<Aposta>) CadastrarApostas.getApostas();

        try (FileWriter fWriter = new FileWriter(ARQUIVO, true);
                BufferedWriter bWriter = new BufferedWriter(fWriter)) {

                    for (Aposta tempA : listaApostas) {
                        bWriter.write(tempA.toFileString() + "\n");
                    }

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

        return apostas;

    }

    
}


    

