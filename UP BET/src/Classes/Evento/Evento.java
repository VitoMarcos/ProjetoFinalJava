package Classes.Evento;
public class Evento {
    
    private int id;
    private String campeonato;
    private String jogo;
    private String resultado;
    public Evento(int id, String campeonato, String jogo) {
        this.id = id;
        this.campeonato = campeonato;
        this.jogo = jogo;
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

    


}
