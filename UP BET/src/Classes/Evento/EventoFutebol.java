package Classes.Evento;
import Classes.Esporte.Futebol;

public class EventoFutebol extends Evento{
    
    private Futebol esporte;

    public EventoFutebol(int id, String campeonato, String jogo, String resultado, Futebol esporte) {
        super(id, campeonato, jogo);
        this.esporte = new Futebol();
        this.setResultado(GeradorResultados.gerarResultadoFutebol);
    }

    public Futebol getEsporte() {
        return esporte;
    }

    public void setEsporte(Futebol esporte) {
        this.esporte = esporte;
    }

    



}
