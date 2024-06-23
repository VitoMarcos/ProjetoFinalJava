import java.util.ArrayList;
import java.util.List;

import Classes.Evento.Evento;

public class CadastrarApostas {
    
private static List<Evento> apostas = new ArrayList<>();

public void adicionarAposta(Evento aposta) {
    apostas.add(aposta);
}

public List<Evento> listarApostas() {
    return apostas;
}

public void atualizarAposta(Evento apostaAlterada) {
    for (int i = 0; i < apostas.size(); i++) {
        if (apostas.get(i).getId() == apostaAlterada.getId()) {
            apostas.set(i, apostaAlterada);
            return;
        }
    }
}

public void removerAposta(Evento aposta) {
    apostas.remove(aposta);
}

public static List<Evento> getApostas() {
    return apostas;
}


}
