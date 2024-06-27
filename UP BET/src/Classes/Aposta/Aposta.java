package Classes.Aposta;
import Classes.Pessoa.GerirUsuarios;
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

    public double calcularValorGanho() {
        return valorApostado * (timeA.getOdd() + timeB.getOdd());
    }

    public double calcularValorGanhoReduzido() {
        return valorApostado * (Math.max(timeA.getOdd(), timeB.getOdd()) / 2); // Recompensa reduzida pela metade da maior odd
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

    public String toFileString() {
        return usuario.getNome() + ", " + evento.getId() + ", " + valorApostado + ", " + timeA.getNome() + ", " + timeB.getNome() + ", " + prevGolsA + ", " + prevGolsB;
    }

    public static Aposta fromString(String data) throws Exception {
        String[] parts = data.split(", ");
        if (parts.length != 7) {
            throw new IllegalArgumentException("Invalid data format for Aposta: " + data);
        }

        String usuarioNome = parts[0];
        int eventoId = Integer.parseInt(parts[1]);
        double valorApostado = Double.parseDouble(parts[2]);
        String timeANome = parts[3];
        String timeBNome = parts[4];
        int prevGolsA = Integer.parseInt(parts[5]);
        int prevGolsB = Integer.parseInt(parts[6]);

        // Aqui você precisa buscar o usuário e o evento de acordo com o nome e o ID fornecidos
        Usuario usuario = GerirUsuarios.buscarUsuario(usuarioNome);
        Evento evento = GerirEventos.buscarEvento(eventoId);

        if (usuario == null || evento == null) {
            throw new IllegalArgumentException("Usuario ou Evento não encontrado");
        }

        TimeA timeA = evento.getTimeA();
        TimeB timeB = evento.getTimeB();

        return new Aposta(usuario, evento, valorApostado, timeA, timeB, prevGolsA, prevGolsB);
    }
    
    @Override
    public String toString() {
        return "Aposta{" +
                "usuario=" + usuario.getNome() +
                ", evento=" + evento.getId() +
                ", valorApostado=" + valorApostado +
                ", timeA=" + timeA +
                ", timeB=" + timeB +
                ", prevGolsA=" + prevGolsA +
                ", prevGolsB=" + prevGolsB +
                '}';
    }

    public String exibirDadosAposta(){
        return "[ " + evento.getId() + " ] " + evento.getCampeonato() + "\nResultado apostado: " + timeA.getNome() + " " + prevGolsA + " x " + prevGolsB + " " + timeB.getNome() + "\nValor apostado: R$" + valorApostado + "\n"; 
    }

}
