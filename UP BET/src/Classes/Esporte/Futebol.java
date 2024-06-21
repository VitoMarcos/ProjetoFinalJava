package Classes.Esporte;

import java.util.Arrays;
import java.util.List;

public class Futebol extends Esporte{
    
    public Futebol(){
        super("Futebol");
    }

    @Override
    public List<String> tiposAposta() {
        return Arrays.asList("Gols", "Chutes a gol", "Escanteios", "Posse de bola");
    }

    



}
