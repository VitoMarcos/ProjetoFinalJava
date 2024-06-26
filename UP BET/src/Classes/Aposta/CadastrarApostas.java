package Classes.Aposta;
import java.util.ArrayList;
import java.util.List;

public class CadastrarApostas {
    
private static List<Aposta> apostas = new ArrayList<>();

public static void adicionarAposta(Aposta aposta) {
    apostas.add(aposta);
}

    public static void verificarListaVazia() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

public List<Aposta> listarApostas() {
    return apostas;
}

public static void atualizarAposta(Aposta apostaAlterada) {
    for (int i = 0; i < apostas.size(); i++) {
        if (apostas.get(i).getEvento() == apostaAlterada.getEvento()) {
            apostas.set(i, apostaAlterada);
            return;
        }
    }
}

public static void removerAposta(Aposta aposta) {
    apostas.remove(aposta);
}

public static List<Aposta> getApostas() {
    return apostas;
}


}
