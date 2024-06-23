package Classes.Pessoa;

public class Administrador extends Pessoa {
    
    public Administrador(String nome, String email){
        super(nome, email);
    }


    @Override
    public String exibirDados() {
        
        return "Administrador\nNome: " + getNome() + "\nEmail: " + getEmail();
    }



    @Override
    public String toString() {
        return "Administrador\\n" + //
                        "Id: \" + getId() + \"Nome: \" + getNome() + \"\\n" + //
                        "CPF: \" + getCpf() + \"\\n" + //
                        "Email: \" + getEmail();";
    }

    



}
