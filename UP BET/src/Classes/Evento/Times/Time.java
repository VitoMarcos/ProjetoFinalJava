package Classes.Evento.Times;


public class Time {
    
    private String nome;
    private double odd;

    public Time(String nome, double odd) {
        this.nome = nome;
        this.odd = odd;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getOdd() {
        return odd;
    }

    public void setOdd(double odd) {
        this.odd = odd;
    }
}
