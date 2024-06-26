package Classes.Aposta;
import Classes.Pessoa.Usuario;
import Times.TimeA;
import Times.TimeB;


public class Aposta {
    
    private Usuario usuario;
    private Evento evento;
    private double valorApostado;
    private TimeA timeA;
    private TimeB timeB;
    private int prevGolsA; //previsaoGolsTimeA
    private int prevGolsB; //previsaoGolsTimeB
    private boolean ganhou;
    
    public Aposta(Usuario usuario, Evento evento, double valorApostado, TimeA timeA, TimeB timeB, int prevGolsA, int prevGolsB) {
        this.usuario = usuario;
        this.evento = evento;
        this.valorApostado = valorApostado;
        this.timeA = timeA;
        this.timeB = timeB;
        this.prevGolsA = prevGolsA;
        this.prevGolsB = prevGolsB;
        this.ganhou = verificarAposta();
        atualizarSaldoUsuario();
    }

    private boolean verificarAposta() {
        return timeA.getGols() == prevGolsA && timeB.getGols() == prevGolsB;
    }

    // Método para calcular o valor ganho na aposta
    public double calcularValorGanho() {
        if (ganhou) {
            return valorApostado * timeA.getOdd() * timeB.getOdd(); 
        } else {
            return - valorApostado; 
        }
    }


    private void atualizarSaldoUsuario() {
        double valorGanho = calcularValorGanho();
        usuario.atualizarSaldo(valorGanho);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public double getValorApostado() {
        return valorApostado;
    }

    public void setValorApostado(double valorApostado) {
        this.valorApostado = valorApostado;
    }

    public boolean isGanhou() {
        return ganhou;
    }

    public void setGanhou(boolean ganhou) {
        this.ganhou = ganhou;
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

    public int getPrevGolsA() {
        return prevGolsA;
    }

    public void setPrevGolsA(int prevGolsA) {
        this.prevGolsA = prevGolsA;
    }

    public int getPrevGolsB() {
        return prevGolsB;
    }

    public void setPrevGolsB(int prevGolsB) {
        this.prevGolsB = prevGolsB;
    }

   /*  public String exibirAposta(){
        return 
        }
*/

    public boolean exibirDadosAposta() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
