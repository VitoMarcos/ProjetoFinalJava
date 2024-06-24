import java.util.ArrayList;

import Classes.Aposta.Aposta;
import Classes.Aposta.Evento;
import Classes.Aposta.GerirAposta;
import Classes.Aposta.GerirEventos;
import Classes.Pessoa.Administrador;
import Classes.Pessoa.Usuario;
import Times.TimeA;
import Times.TimeB;

public class Sistema {
    
    static String nome;
    static String email;

    private static void cadastrarUsuario() {

        System.out.println("É um prazer tê-lo aqui conosco!");
        System.out.println("Por favor, nos dê algumas infomrações para que possamos fazer seu cadastro");
        System.out.print("Seu nome: ");
        nome = Console.lerString();
        System.out.print("Seu email: ");
        email = Console.lerString();
        System.out.println("Sucesso!\nA UP BET te proporciona um saldo inicial de R$50,00 para suas apostas.\nCaso deseje aumenta-lo, é só acessar a opção 'saldo' no menu.");
    }
    
    static Usuario u = new Usuario(nome, email);

    private static void cadastrarAdm(){

        String nome;
        String email;
        System.out.println("Antes de inicar sua sessão. Por favor, nos dê algumas infomrações para que possamos fazer seu cadastro");
        System.out.print("Seu nome: ");
        nome = Console.lerString();
        System.out.print("Seu email: ");
        email = Console.lerString();
        Administrador a = new Administrador(nome, email);
        a.exibirDados();
        System.out.println("Ótimo, agora você pode criar eventos esportivos e definir as Odd´s das apostas.");
    }

    private static void cadastrarEvento() {

        String camp;
        String nome;
        double odd;
        String nome2;
        double odd2;
        System.out.println("Excelente! Aqui você poderá criar os eventos esportivos que serão apostados. Vamos começar...");
        System.out.print("Nos informe de qual campeonato é este jogo: ");
        camp = Console.lerString();
        System.out.println("Agora precisamos conhecer os times que se enfrentarão");
        System.out.print("Nome do primeiro time: ");
        nome = Console.lerString();
        System.out.print(nome + " Odd: ");
        odd = Console.lerDouble();

        TimeA timeA = new TimeA(nome, odd);

        System.out.print("Nome do segundo time: ");
        nome2 = Console.lerString();
        System.out.print(nome2 + " Odd: ");
        odd2 = Console.lerDouble();

        TimeB timeB = new TimeB(nome2, odd2);

        Evento e = new Evento(camp, timeA, timeB);
        System.out.println("\n" + e.exibirDadosEvento());

        CadastrarEvento.adicionarEvento(e);

        try {

            GerirEventos.salvarEvento(e);
            System.out.println("\nEvento salvo com sucesso!");

        } catch (Exception exception) {

            System.out.println(exception.getMessage());
        }

    }

    private static void listarEventos(){

         ArrayList<Evento> listaEventos = (ArrayList<Evento>) CadastrarEvento.getEventos();

        try {
            CadastrarEvento.verificarListaVazia();
            
            System.out.println("\nEventos disponíveis:");
            for (Evento tempE : listaEventos) {
    
                System.out.println(tempE.exibirDadosEvento());
            }

        } catch (Exception exception) {

            System.out.println(exception.getMessage());
        }

    }

    public static void processarAposta(Evento evento) {
        
        System.out.println("Processando aposta para o evento: " + evento.getCampeonato());
        System.out.println(evento.getTimeA().getNome() + " x " + evento.getTimeB().getNome());
        
        System.out.print("Digite o valor da aposta: ");
        double valorAposta = Console.lerDouble();

        System.out.print("Digite o número de gols do " + evento.getTimeA().getNome() + ": ");
        int golsA = Console.lerInt();

        System.out.print("Digite o número de gols do " + evento.getTimeB().getNome() + ": ");
        int golsB = Console.lerInt();

         
        Aposta aposta = new Aposta(u, evento, valorAposta, evento.getTimeA(), evento.getTimeB(), golsA, golsB);
        
        CadastrarApostas.adicionarAposta(aposta);

        try {

            GerirAposta.salvarAposta(aposta);
            System.out.println("\nAposta criada com sucesso!");

        } catch (Exception exception) {

            System.out.println(exception.getMessage());
        }

    }


    private static void cadastrarAposta() {

    int op;
    
    do {

        listarEventos();
        System.out.println("Selecione o número de qual você deseja apostar");
        System.out.print("Digite 0 para voltar ao menu de usuário");
        op = Console.lerInt();

        try {
            Evento eventoSelecionado = GerirEventos.buscarEvento(op);
            processarAposta(eventoSelecionado);
        } catch (Exception e) {
            System.out.println("Jogo inexistente. Por favor, digite novamente...");
        }

        
    } while (op!=0);


    }



}
