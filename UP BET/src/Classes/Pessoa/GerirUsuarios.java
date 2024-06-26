package Classes.Pessoa;
import java.util.ArrayList;


public class GerirUsuarios {
    private static ArrayList<Usuario> usuarios = new ArrayList<>();

    public static void adicionarUsuario(Usuario u) {
    usuarios.add(u);
}

    public static Usuario buscarUsuario(String nome) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nome)) {
                return usuario;
            }
        }
        throw new IllegalArgumentException("Usuário não encontrado: " + nome);
    }

    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

        
}
