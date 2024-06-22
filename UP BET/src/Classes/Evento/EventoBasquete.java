package Classes.Evento;
import Classes.Esporte.Basquete;
import Classes.Esporte.Resultados;

public class EventoBasquete extends Evento{
    
    private Basquete esporte;

    public EventoBasquete(int id, String campeonato, String jogo, String resultado, Basquete esporte) {
        super(id, campeonato, jogo);
        this.esporte = new Basquete();
        this.setResultado(Resultados.gerarResultadoBasquete());
    }

    public Basquete getEsporte() {
        return esporte;
    }

    public void setEsporte(Basquete esporte) {
        this.esporte = esporte;
    }

    





}
