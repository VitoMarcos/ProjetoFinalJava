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

    public String toFileString() {
        return getNome() + ", " + getOdd() + ", ";
    }

    public static TimeA fromString(String data) {
        String[] partes = data.split(", ");
        return new TimeA(partes[0], Double.parseDouble(partes[1]));
    }

}