package Times;

public class TimeB extends Time{

    private int gols;

    public TimeB(String nome, double odd) {
        super(nome, odd);
        this.gols = setGols(Resultados.gerarResultado());
    }

    public int getGols() {
        return gols;
    }

    public int setGols(int gols) {
        return this.gols = gols;
    }

    public String toFileString() {
        return getNome() + ", " + getOdd() + ", ";
    }

    public static TimeB fromString(String data) {
        String[] partes = data.split(", ");
        return new TimeB(partes[0], Double.parseDouble(partes[1]));
    }
}