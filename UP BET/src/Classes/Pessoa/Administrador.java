package Classes.Pessoa;

public class Administrador extends Pessoa {
    
    public Administrador(int id, String nome, String cpf, String email){
        super(id, nome, cpf, email);
    }

    
    
    @Override
    public String exibirDados() {
        
        return "Administrador\nId: " + getId() + "Nome: " + getNome() + "\nCPF: " + getCpf() + "\nEmail: " + getEmail();
    }



    @Override
    public String toString() {
        return "Administrador\\n" + //
                        "Id: \" + getId() + \"Nome: \" + getNome() + \"\\n" + //
                        "CPF: \" + getCpf() + \"\\n" + //
                        "Email: \" + getEmail();";
    }

    



}
