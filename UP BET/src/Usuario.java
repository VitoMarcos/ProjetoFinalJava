public class Usuario extends Pessoa {
    
    private double saldo = 50.0;

    public Usuario(int id, String nome, String cpf, String email, double saldo) {
        super(id, nome, cpf, email);
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "USUÁRIO:\nId: " + getId() + "\nNome: " + getNome() + "\nCPF: " + getCpf() + "\nEmail: " + getEmail() + "Saldo atual: " + saldo;
    }

    @Override
    public String exibirDados(){
        return "USUÁRIO:\nId: " + getId() + "\nNome: " + getNome() + "\nCPF: " + getCpf() + "\nEmail: " + getEmail() + "Saldo atual: " + saldo;
    }

}
