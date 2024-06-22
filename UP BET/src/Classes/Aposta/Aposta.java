package Classes.Aposta;

import Classes.Evento.Evento;
import Classes.Pessoa.Usuario;

public class Aposta {
    
    private Usuario usuario;
    private Evento evento;
    private double valorApostado;
    private boolean ganhou;
    
    public Aposta(Usuario usuario, Evento evento, double valorApostado) {
        this.usuario = usuario;
        this.evento = evento;
        this.valorApostado = valorApostado;
        this.ganhou = false;
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

    




}
