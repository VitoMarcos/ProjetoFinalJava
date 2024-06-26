import Classes.Aposta.Aposta;
import Classes.Aposta.CadastrarApostas;
import Classes.Aposta.CadastrarEvento;
import Classes.Aposta.Evento;
import Classes.Aposta.GerirAposta;
import Classes.Aposta.GerirEventos;
import Classes.Pessoa.Administrador;
import Classes.Pessoa.Usuario;
import Times.TimeA;
import Times.TimeB;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    
    static String nome;
    static String email;
    private static Scanner leitor = new Scanner(System.in);
    
        private static void menuPrincipal() {
    
            System.out.println("Bem-vindo a UP Bet! Escolha uma das opções!");
            System.out.println("[1] Administrador");
            System.out.println("[2] Usuário");
            System.out.print("[0] Sair!\n"); 
    
        }
    
        private static void verificarOpcaoMenuPrincipal(int opcao) {
            
            switch (opcao) {
    
                case 1:
                    int op;
                    cadastrarAdm();
                    enterParaSeguir();
                    do {
                    menuAdm();
                    op = Console.lerInt();
                    verificarOpcaoMenuAdm(op);
                } while (op != 0);
                    break;
    
                case 2:
                    int op2;
                    cadastrarUsuario();
                    enterParaSeguir();
                    do {

                        menuUsu();
                        op2 = Console.lerInt();
                        verificarOpcaoMenuUsu(op2);
                        
                    } while (op2 != 0);
                    break;
    
                case 0:
    
                    System.out.println("Obrigado por ultilizar a UP Bet!");
                    break;
    
                default:
    
                    System.out.println("A opção digitada é inválida, digite novamente!");
                    break;
    
            }
        
        }
    
        private static void menuAdm() {
    
            System.out.println("Bem-vindo administrador:" /*inserir variavel do nome do administrador */);
                    System.out.println("[1] Criar Evento");
                    System.out.println("[2] Listar Evento");
                    System.out.println("[3] Buscar Evento");
                    System.out.println("[4] Atualizar Evento");
                    System.out.println("[5] Excluir Evento");
                    System.out.print("[0] Voltar para o Menu Principal!\n");
        
        }
    
        private static void verificarOpcaoMenuAdm(int opcaoAdm) {
    
            switch (opcaoAdm) {
    
                case 1:

                    cadastrarEvento();
                    break;
    
                case 2:

                    listarEventos();
                    break;
    
                case 3:
    
                    break;
    
                case 4:
    
                    break;
    
                case 5:
    
                    break;
    
                case 0:
    
                    break;
    
                default:
    
                    System.out.println("A opção digitada é inválida, digite novamente!");
                    break;
    
            }
    
        }
    
        private static void menuUsu() {
    
            System.out.println("Bem-vindo usuário:" /*inserir variavel do nome do usuário */);
                    System.out.println("[1] Realizar Apostas");
                    System.out.println("[2] Ver Apostas");
                    System.out.println("[3] Alterar Apostas");
                    System.out.println("[4] Excluir Apostas");
                    System.out.print("[0] Voltar para o Menu Principal!\n");
    
        }
    
        private static void verificarOpcaoMenuUsu(int opcaoUsu) {
    
            switch (opcaoUsu) {
    
                case 1:

                    cadastrarAposta();
                    break;
    
                case 2:
    
                    break;
    
                case 3:
    
                    break;
    
                case 4:
    
                    break;
    
                case 0:
    
                    break;
    
                default:
    
                    System.out.println("A opção digitada é inválida, digite novamente!");
                    break;
    
            }
    
        }
    
        public static void enterParaSeguir() {
            System.out.println("\nClique em qualquer tecla para continuar");
            leitor.nextLine();
        }
                 
    

    private static void cadastrarUsuario() {

        System.out.println("\nÉ um prazer tê-lo aqui conosco!");
        System.out.println("Por favor, nos dê algumas infomrações para que possamos fazer seu cadastro");
        System.out.print("Seu nome: ");
        nome = Console.lerString();
        System.out.print("Seu email: ");
        email = Console.lerString();
        System.out.println("\nSucesso!\nA UP BET te proporciona um saldo inicial de R$50,00 para suas apostas.\nCaso deseje aumenta-lo, é só acessar a opção 'saldo' no menu.");
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
        System.out.println("\nÓtimo, agora você pode criar eventos esportivos e definir as Odd´s das apostas.");
    }

    private static void cadastrarEvento() {

        String camp;
        String nome;
        double odd;
        String nome2;
        double odd2;
        System.out.println("\nExcelente! Aqui você poderá criar os eventos esportivos que serão apostados. Vamos começar...");
        System.out.print("\nNos informe de qual campeonato é este jogo: ");
        camp = Console.lerString();
        System.out.println("\nAgora precisamos conhecer os times que se enfrentarão");
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

    public static void listarEventos() {
        try {
            List<Evento> eventos = CadastrarEvento.getEventos();
            for (Evento tempEvento : eventos) {
                System.out.println("[" + tempEvento.getId() + "] " + tempEvento.getCampeonato());
                System.out.println(tempEvento.getTimeA().getNome() + " (" + tempEvento.getTimeA().getOdd() + ") x " + tempEvento.getTimeB().getNome() + " (" + tempEvento.getTimeB().getOdd() + ")");
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar eventos: " + e.getMessage());
        }
    }
    
    // *** Novo Método ***
    private static void buscarEvento() {
        System.out.print("Informe o campeonato do evento que deseja buscar: ");
        int id = Console.lerInt();

        try {

            Evento evento = GerirEventos.buscarEvento(id);
            System.out.println(evento.exibirDadosEvento());

        } catch (Exception exception) {

            System.out.println(exception.getMessage());
        }

    }

    // *** Novo Método ***
    private static void atualizarEvento() {
        System.out.print("Informe o campeonato do evento que deseja atualizar: ");
        int id = Console.lerInt();

        /* try {

            Evento evento = GerirEventos.buscarEvento(id);
            System.out.print("Atualizar primeiro time: ");
            String nome = Console.lerString();
            System.out.print(nome + "Atualizar odd: ");
            double odd = Console.lerDouble();

            evento.getTimeA().setNome(nome);
            evento.getTimeA().setOdd(odd);

            System.out.print("Novo nome do segundo time: ");
            String nome2 = Console.lerString();
            System.out.print(nome2 + "Atualizar odd: ");
            double odd2 = Console.lerDouble();

            evento.getTimeB().setNome(nome2);
            evento.getTimeB().setOdd(odd2);

            GerirEventos.atualizarEvento(evento);
            System.out.println("Evento atualizado com sucesso!");

        } catch (Exception exception) {

            System.out.println(exception.getMessage());
        } */

    }

    // *** Novo Método ***
    private static void excluirEvento() {
        System.out.print("Informe o campeonato do evento que deseja excluir: ");
        int id = Console.lerInt();

        /* try {

            GerirEventos.excluirEvento(id);
            System.out.println("Evento excluído com sucesso!");

        } catch(Exception exception) {

            System.out.println(exception.getMessage());
        } */

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
            System.out.println("\nAposta feita com sucesso!");

        } catch (Exception exception) {

            System.out.println(exception.getMessage());
        }

    }


    private static void cadastrarAposta() {

    int op;
    
    do {

        listarEventos();
        System.out.println("\nSelecione o número de qual você deseja apostar");
        System.out.print("Digite '0' para voltar ao menu de usuário\n");
        op = Console.lerInt();
        System.out.println("ID selecionado: " + op); // Linha de depuração

        try {
            Evento eventoSelecionado = GerirEventos.buscarEvento(op);
            System.out.println("Evento selecionado: " + eventoSelecionado); // Linha de depuração
            processarAposta(eventoSelecionado);
        } catch (Exception e) {
            System.out.println("Jogo inexistente. Por favor, digite novamente...");
            e.printStackTrace(); // Adicionado para ver o stack trace
        }

        
    } while (op!=0);

        return;
    }

    // *** Novo Método ***
    private static void verApostas() {
        // ArrayList<Aposta> listaApostas = (ArrayList<Aposta>) CadastrarApostas.getApostas();

        /* try {

            CadastrarApostas.verificarListaVazia();
            System.out.println("\nApostas realizadas:");

            for (Aposta aposta : listaApostas) {
                System.out.println(aposta.exibirDadosAposta());
            }

        } catch(Exception exception) {

            System.out.println(exception.getMessage());
        } */

    }

    // *** Novo Método (Incompleto) ***
    private static void alterarAposta() {
        System.out.print("Digite o campeonato da aposta que deseja alterar: ");
        int id = Console.lerInt();

    }

    // *** Novo Método ***
    private static void excluirAposta() {
        System.out.print("Digite o campeonato da aposta que deseja excluir: ");
        int id = Console.lerInt();

        /* (try {

            GerirAposta.excluirAposta(id);
            System.out.println("Aposta excluída com sucesso!");

        } catch(Exception exception) {

            System.out.println(exception.getMessage());
        } */

    }

    public static void executar() {

        int op;

        do { 
            menuPrincipal();
            op = Console.lerInt();
            verificarOpcaoMenuPrincipal(op);
        } while (op != 0);

    }
    
}

