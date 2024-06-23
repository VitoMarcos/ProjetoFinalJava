package Classes.Evento;
import Classes.Esporte.Basquete;
import Classes.Esporte.Futebol;
import Classes.Evento.Times.TimeA;
import Classes.Evento.Times.TimeB;


public class EventoFutebol{
    
    private int id = 0;
    private String campeonato;
    private TimeA timeA;
    private TimeB timeB;
    private Futebol esporte;

    public EventoFutebol(String campeonato, TimeA timeA, TimeB timeB) {
        this.id = id++;
        this.campeonato = campeonato;
        this.timeA = timeA;
        this.timeB = timeB;
        this.esporte = new Futebol();
    }

    public Futebol getEsporte() {
        return esporte;
    }

    public void setEsporte(Futebol esporte) {
        this.esporte = esporte;
    }

    public String exibirDadosEvento() {
        return "[" + id + "] Jogo\n" + campeonato + "\n" + timeA + " x " + timeB;
    
    }

    



}
