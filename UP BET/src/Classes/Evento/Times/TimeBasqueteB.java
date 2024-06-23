package Classes.Evento.Times;

import Classes.Esporte.Resultados;

public class TimeBasqueteB extends Time{

   private int pontos;

    public TimeBasqueteB(String nome, double odd) {
        super(nome, odd);
        this.pontos = setPontos(Resultados.gerarResultadoBasquete());
    }

    public int getPontos() {
        return pontos;
    }

    public int setPontos(int pontos) {
        return this.pontos = pontos;
    }
    
}
