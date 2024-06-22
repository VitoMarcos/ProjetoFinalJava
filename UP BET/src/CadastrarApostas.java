import java.util.ArrayList;
import java.util.List;

import Classes.Evento.Aposta;

public class CadastrarApostas {
    
private static List<Aposta> apostas = new ArrayList<>();

public void adicionarAposta(Aposta aposta) {
    apostas.add(aposta);
}

public List<Aposta> listarApostas() {
    return apostas;
}

public void atualizarAposta(Aposta apostaAlterada) {
    for (int i = 0; i < apostas.size(); i++) {
        if (apostas.get(i).getId() == apostaAlterada.getId()) {
            apostas.set(i, apostaAlterada);
            return;
        }
    }
}

public void removerAposta(Aposta aposta) {
    apostas.remove(aposta);
}

public static List<Aposta> getApostas() {
    return apostas;
}


}
