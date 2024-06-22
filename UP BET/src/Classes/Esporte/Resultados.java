package Classes.Esporte;

import java.util.Random;

public class Resultados {
    
private static Random random = new Random();
 public static String gerarResultadoBasquete(){


    int pontosTimeA = random.nextInt(60) + 80; // Pontos de 80 a 139
    int pontosTimeB = random.nextInt(60) + 80; 
    return pontosTimeA + " - " + pontosTimeB;

 }

 public static int gerarResultadoFutebol(){

    int golsTime = random.nextInt(5); // Gols de 0 a 4
        return golsTime;

 }

}
