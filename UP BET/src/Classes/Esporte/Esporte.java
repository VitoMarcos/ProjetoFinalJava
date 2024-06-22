package Classes.Esporte;


public abstract class Esporte {
    
    private String nome;

    public Esporte(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



}
