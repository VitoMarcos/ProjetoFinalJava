package Times;

public class TimeA extends Time{

    private int gols;

    public TimeA(String nome, double odd) {
        super(nome, odd);
        this.gols = setGols(Resultados.gerarResultado());
    }

    public int getGols() {
        return gols;
    }

    public int setGols(int gols) {
        return this.gols = gols;
    }


}