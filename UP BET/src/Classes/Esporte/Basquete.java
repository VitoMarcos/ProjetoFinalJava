package Classes.Esporte;
import java.util.Arrays;
import java.util.List;

public class Basquete extends Esporte{
    
    public Basquete(){
        super("Basquete");
    }

    @Override
    public List<String> tiposAposta() {
        return Arrays.asList("Pontos", "Arremessos", "Rebotes", "Assistências");
    }

    

}
