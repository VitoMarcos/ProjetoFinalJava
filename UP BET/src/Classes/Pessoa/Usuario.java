package Classes.Pessoa;

public class Usuario extends Pessoa {
    
    private double saldo = 50.0;

    public Usuario(String nome, String email, double saldo) {
        super(nome, email);
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void atualizarSaldo(double valorGanho) {
        this.saldo += valorGanho;
    }

    @Override
    public String toString() {
        return "USUÁRIO:\nNome: " + getNome() + "\nEmail: " + getEmail() + "Saldo atual: " + saldo;
    }

    @Override
    public String exibirDados(){
        return "USUÁRIO:\nNome: " + getNome() + "\nEmail: " + getEmail() + "Saldo atual: " + saldo;
    }

}
