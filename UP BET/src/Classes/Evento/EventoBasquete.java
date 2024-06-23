package Classes.Evento;
import Classes.Esporte.Basquete;
import Classes.Evento.Times.TimeA;
import Classes.Evento.Times.TimeB;
import Classes.Evento.Times.TimeBasqueteA;
import Classes.Evento.Times.TimeBasqueteB;


public class EventoBasquete{
    
    private int id = 0;
    private String campeonato;
    private TimeBasqueteA timeA;
    private TimeBasqueteB timeB;
    private Basquete esporte;

    public EventoBasquete(String campeonato, TimeBasqueteA timeA, TimeBasqueteB timeB) {
        this.id = id++;
        this.campeonato = campeonato;
        this.timeA = timeA;
        this.timeB = timeB;
        this.esporte = new Basquete();
    }

    public Basquete getEsporte() {
        return esporte;
    }

    public void setEsporte(Basquete esporte) {
        this.esporte = esporte;
    }

    public String exibirDadosEvento() {
        return "[" + id + "] Jogo\n" + campeonato + "\n" + timeA + " x " + timeB;
    }

    





}
