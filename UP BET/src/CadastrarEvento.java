import java.util.ArrayList;
import java.util.List;
import Classes.Evento.Aposta;

public class CadastrarEvento{
    
private static List<Aposta> eventos = new ArrayList<>();

public void adicionarEvento(Aposta evento) {
    eventos.add(evento);
}

public List<Aposta> listarEventos() {
    return eventos;
}

public void atualizarEvento(Aposta eventoAlterado) {
    for (int i = 0; i < eventos.size(); i++) {
        if (eventos.get(i).getId() == eventoAlterado.getId()) {
            eventos.set(i, eventoAlterado);
            return;
        }
    }
}

public void removerEvento(Aposta evento) {
    eventos.remove(evento);
}

public static List<Aposta> getEventos() {
    return eventos;
}



}
