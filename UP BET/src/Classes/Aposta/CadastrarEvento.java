package Classes.Aposta;
import java.util.ArrayList;
import java.util.List;

public class CadastrarEvento{
    
private static ArrayList<Evento> eventos = new ArrayList<>();

public static void adicionarEvento(Evento evento) {
    eventos.add(evento);
}

public static List<Evento> listarEventos() {
    return eventos;
}

public static void atualizarEvento(Evento eventoAlterado) {
    for (int i = 0; i < eventos.size(); i++) {
        if (eventos.get(i).getId() == eventoAlterado.getId()) {
            eventos.set(i, eventoAlterado);
            return;
        }
    }
}

public static void removerEvento(Evento evento) {
    eventos.remove(evento);
}

public static List<Evento> getEventos() {
    return eventos;
}

public static void setEventos(ArrayList<Evento> e) {
    eventos = e;
}

public static void verificarListaVazia() throws Exception {

    if (eventos.isEmpty()) {
        throw new Exception("\nATENÇÃO: Não há eventos disponíveis");
    }
}


}
