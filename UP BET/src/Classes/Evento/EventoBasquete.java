package Classes.Evento;
import Classes.Esporte.Basquete;


public class EventoBasquete extends Aposta{
    
    private Basquete esporte;

    public EventoBasquete(int id, String campeonato, String jogo, TimeA timeA, TimeB timeB, Basquete esporte) {
        super(id, campeonato, jogo, timeA, timeB);
        this.esporte = new Basquete();
        
    }

    public Basquete getEsporte() {
        return esporte;
    }

    public void setEsporte(Basquete esporte) {
        this.esporte = esporte;
    }

    





}
