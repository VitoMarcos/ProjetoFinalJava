package Classes.Evento.Times;

import Classes.Esporte.Resultados;

public class TimeB extends Time{

    private int gols;

    public TimeB(String nome, double odd) {
        super(nome, odd);
        this.gols = setGols(Resultados.gerarResultadoFutebol());
    }

    public int getGols() {
        return gols;
    }

    public int setGols(int gols) {
        return this.gols = gols;
    }

}