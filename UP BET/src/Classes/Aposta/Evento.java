package Classes.Aposta;
import Times.TimeA;
import Times.TimeB;

public class Evento{
    
    private static int nextId = 1;
    private int id;
    private String campeonato;
    private TimeA timeA;
    private TimeB timeB;
    
    public Evento(){}

    public Evento(String campeonato, TimeA timeA, TimeB timeB) {
        this.id = nextId++;
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
        return "[" + id + "] " + campeonato + "\n" + timeA.getNome() + " x " + timeB.getNome();
    }

    public String toFileString() {
        return id + ", " + campeonato + ", " + timeA.toFileString() + ", " + timeB.toFileString();
    }

    public static Evento fromString(String data) {
        String[] parts = data.split(", ");
        if (parts.length != 6) { // Verificando se há 6 partes
            throw new IllegalArgumentException("Invalid data format for Evento: " + data);
        }
        int id = Integer.parseInt(parts[0]);
        String campeonato = parts[1];
        TimeA timeA = TimeA.fromString(parts[2] + ", " + parts[3]);
        TimeB timeB = TimeB.fromString(parts[4] + ", " + parts[5]);
        Evento evento = new Evento(campeonato, timeA, timeB);
        evento.setId(id);
        return evento;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", campeonato='" + campeonato + '\'' +
                ", timeA=" + timeA +
                ", timeB=" + timeB +
                '}';
    }
    }


