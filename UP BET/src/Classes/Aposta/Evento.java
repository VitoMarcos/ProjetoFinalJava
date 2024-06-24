package Classes.Aposta;
import Times.TimeA;
import Times.TimeB;

public class Evento{
    
    private int id = 0;
    private String campeonato;
    private TimeA timeA;
    private TimeB timeB;
    
    public Evento(){}

    public Evento(String campeonato, TimeA timeA, TimeB timeB) {
        this.id = id++;
        this.campeonato = campeonato;
        this.timeA = timeA;
        this.timeB = timeB;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCampeonato() {
        return campeonato;
    }
    public void setCampeonato(String campeonato) {
        this.campeonato = campeonato;
    }
    
    public TimeA getTimeA() {
        return timeA;
    }
    public void setTimeA(TimeA timeA) {
        this.timeA = timeA;
    }
    public TimeB getTimeB() {
        return timeB;
    }
    public void setTimeB(TimeB timeB) {
        this.timeB = timeB;
    }

    public String exibirDadosEvento(){
        return "[" + id + "] " + campeonato + "\n" + timeA + " x " + timeB;
    }

    public void fromString(String linha) {

        String[] partes = linha.split(", ");

        campeonato = partes[0].split("=")[1];
        TimeA timeA = TimeA.fromString(partes[2]);
        TimeB timeB = TimeB.fromString(partes[3]);

    }

}
