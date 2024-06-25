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
        return getNome() + ", " + getOdd();
    }

    public static TimeA fromString(String data) {
        String[] parts = data.split(", ");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid data format for TimeA: " + data);
        }
        String nome = parts[0];
        double odd = Double.parseDouble(parts[1]);
        return new TimeA(nome, odd);
    }

    @Override
    public String toString() {
        return "TimeA{" +
                "nome='" + getNome() + '\'' +
                ", odd=" + getOdd() +
                ", gols=" + gols +
                '}';
    }

}