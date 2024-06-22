package Classes.Evento;
import Classes.Esporte.Futebol;
import Classes.Esporte.Resultados;

public class EventoFutebol extends Evento{
    
    private Futebol esporte;

    public EventoFutebol(int id, String campeonato, String jogo, TimeA timeA, TimeB timeB, String resultado, Futebol esporte) {
        super(id, campeonato, jogo, timeA, timeB);
        this.esporte = new Futebol();
        this.setResultado(Resultados.gerarResultadoFutebol());
    }

    public Futebol getEsporte() {
        return esporte;
    }

    public void setEsporte(Futebol esporte) {
        this.esporte = esporte;
    }

    



}
