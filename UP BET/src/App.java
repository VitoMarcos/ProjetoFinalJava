import Classes.Aposta.Aposta;
import Classes.Evento.Evento;
import Classes.Evento.EventoBasquete;
import Classes.Evento.EventoFutebol;
import Classes.Evento.Times.TimeA;
import Classes.Evento.Times.TimeB;
import Classes.Evento.Times.TimeBasqueteA;
import Classes.Evento.Times.TimeBasqueteB;
import Classes.Pessoa.Usuario;

public class App {
    public static void main(String[] args) throws Exception {
        
        Usuario usuario = new Usuario("Vito", "vito@gmail.com", 100);
        TimeA timeA = new TimeA("Corinthians", 5.13);
        TimeB timeB = new TimeB("Palmeiras", 2.1);
        EventoFutebol evento = new EventoFutebol("Campeonato Brasileiro", timeA, timeB);

        Aposta aposta = new Aposta(usuario, evento, 22.90, timeA, timeB, 3, 0);

    System.out.println("Resultado:\n" + timeA.getNome() + " " + timeA.getGols() + " - " + timeB.getGols() + " " + timeB.getNome());
      
        if (aposta.isGanhou()) {
            double valorGanho = aposta.calcularValorGanho();
            System.out.println("Você venceu a aposta! Valor ganho: " + valorGanho);
        } else {
            System.out.println("Você perdeu a aposta.");
        }

        System.out.println("Saldo atual do usuário: " + usuario.getSaldo());

        TimeBasqueteA sla = new TimeBasqueteA("Brooklyn Nets", 9.7);
        TimeBasqueteB sla2 = new TimeBasqueteB("Boston Celtics", 2.5);

        EventoBasquete e = new EventoBasquete("NBA", sla, sla2);

        Aposta a = new Aposta(usuario, evento, 12.80, sla, sla2, 0, 0)


        
    }
}
