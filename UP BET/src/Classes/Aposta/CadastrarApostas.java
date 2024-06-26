package Classes.Aposta;
import java.util.ArrayList;

public class CadastrarApostas {
    
private static ArrayList<Aposta> apostas = new ArrayList<>();

public static void adicionarAposta(Aposta aposta) {
    apostas.add(aposta);
}

    public static void verificarListaVazia() {
        if (apostas.isEmpty()) {
        throw new UnsupportedOperationException("Não há apostas.");
    }
}

/*public static void atualizarAposta(Aposta apostaAlterada) {
    for (int i = 0; i < apostas.size(); i++) {
        if (apostas.get(i).getEvento() == apostaAlterada.getEvento()) {
            apostas.set(i, apostaAlterada);
            return;
        }
    }
} */

/*public static void removerAposta(Aposta aposta) {
    apos*/

   

    public static ArrayList<Aposta> getApostas() {
        return apostas;
    }

    public static void setApostas(ArrayList<Aposta> a) {
        apostas = a;
    }
}