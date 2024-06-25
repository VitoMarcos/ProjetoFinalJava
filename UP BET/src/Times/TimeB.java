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
        return getNome() + ", " + getOdd();
    }

    public static TimeB fromString(String data) {
        String[] parts = data.split(", ");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid data format for TimeB: " + data);
        }
        String nome = parts[0];
        double odd = Double.parseDouble(parts[1]);
        return new TimeB(nome, odd);
    }

    @Override
    public String toString() {
        return "TimeB{" +
                "nome='" + getNome() + '\'' +
                ", odd=" + getOdd() +
                ", gols=" + gols +
                '}';
    }
}