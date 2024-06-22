package Classes.Evento;
import Classes.Esporte.Futebol;


public class EventoFutebol extends Aposta{
    
    private Futebol esporte;

    public EventoFutebol(int id, String campeonato, String jogo, TimeA timeA, TimeB timeB, Futebol esporte) {
        super(id, campeonato, jogo, timeA, timeB);
        this.esporte = new Futebol();
        
    }

    public Futebol getEsporte() {
        return esporte;
    }

    public void setEsporte(Futebol esporte) {
        this.esporte = esporte;
    }

    



}
