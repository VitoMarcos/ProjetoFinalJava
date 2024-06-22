package Classes.Evento;

public class TimeB {

    private String nome;
    private double odd;
    private int gols;

    public TimeB(String nome, double odd) {
        this.nome = nome;
        this.odd = odd;
        this.gols = setGols(resultados.gerarResultadoFutebol());
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

    public int getGols() {
        return gols;
    }

    public void setGols(int gols) {
        this.gols = gols;
    }

}