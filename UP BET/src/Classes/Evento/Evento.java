package Classes.Evento;
public class Evento {
    
    private int id;
    private String campeonato;
    private String jogo;
    private TimeA timeA;
    private TimeB timeB;
    private String resultado;
    public Evento(int id, String campeonato, String jogo, TimeA timeA, TimeB timeB) {
        this.id = id;
        this.campeonato = campeonato;
        this.jogo = jogo;
        this.timeA = timeA;
        this.timeB = timeB;
        this.resultado = "";
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
    public String getJogo() {
        return jogo;
    }
    public void setJogo(String jogo) {
        this.jogo = jogo;
    }
    public String getResultado() {
        return resultado;
    }
    public void setResultado(String resultado) {
        this.resultado = resultado;
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

    


}
