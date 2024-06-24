package Times;

import java.util.Random;

public class Resultados {
    
private static Random random = new Random();

public static int gerarResultado(){

    int golsTime = random.nextInt(5); // Gols de 0 a 4
        return golsTime;

 }

}
