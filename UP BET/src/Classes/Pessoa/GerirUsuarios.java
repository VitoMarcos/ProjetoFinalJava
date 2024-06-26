package Classes.Pessoa;
import java.util.ArrayList;

public class GerirUsuarios {
    private static ArrayList<Usuario> usuarios = new ArrayList<>();

    public static Usuario buscarUsuario(String nome) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nome)) {
                return usuario;
            }
        }
        throw new IllegalArgumentException("Usuário não encontrado: " + nome);
    }

    // Outros métodos para gerenciar usuários...
}
