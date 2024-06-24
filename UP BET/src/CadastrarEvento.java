import java.util.ArrayList;
import java.util.List;

public class CadastrarEvento{
    
private static List<Evento> eventos = new ArrayList<>();

public void adicionarEvento(Evento evento) {
    eventos.add(evento);
}

public List<Evento> listarEventos() {
    return eventos;
}

public void atualizarEvento(Evento eventoAlterado) {
    for (int i = 0; i < eventos.size(); i++) {
        if (eventos.get(i).getId() == eventoAlterado.getId()) {
            eventos.set(i, eventoAlterado);
            return;
        }
    }
}

public void removerEvento(Evento evento) {
    eventos.remove(evento);
}

public static List<Evento> getEventos() {
    return eventos;
}



}
