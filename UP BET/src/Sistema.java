import Classes.Aposta.Aposta;
import Classes.Aposta.CadastrarApostas;
import Classes.Aposta.CadastrarEvento;
import Classes.Aposta.Evento;
import Classes.Aposta.GerirAposta;
import Classes.Aposta.GerirEventos;
import Classes.Pessoa.Administrador;
import Classes.Pessoa.GerirUsuarios;
import Classes.Pessoa.Usuario;
import Times.TimeA;
import Times.TimeB;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    
    static String nome;
    static String email;
    private static Usuario usuarioAtual;
    private static Scanner leitor = new Scanner(System.in);
    
        private static void menuPrincipal() {
    
            System.out.println("Bem-vindo a UP Bet! Escolha uma das opções!");
            System.out.println("[1] Administrador");
            System.out.println("[2] Usuário");
            System.out.print("[0] Sair!\n"); 
    
        }
    
        private static void verificarOpcaoMenuPrincipal(int opcao) throws Exception {
            
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
                    login(nome);
                    enterParaSeguir();
                    System.out.println("Bem-vindo " + usuarioAtual.getNome());
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
    
            System.out.println("Bem-vindo administrador");
                    System.out.println("[1] Criar Evento");
                    System.out.println("[2] Listar Eventos");
                    System.out.println("[3] Atualizar Evento");
                    System.out.println("[4] Excluir Evento");
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
    
                    atualizarEvento();
                    break;
    
                case 4:
    
                   
                    excluirEvento();
                    break;
                case 0:
    
                    break;
    
                default:
    
                    System.out.println("A opção digitada é inválida, digite novamente!");
                    break;
    
            }
    
        }
    
        private static void menuUsu() {
    
                    System.out.println("[1] Apostar!");
                    System.out.println("[2] Ver Apostas");
                    System.out.println("[3] Gerenciar salddo");
                    System.out.println("[4] Ver resultados");
                    System.out.print("[0] Voltar para o Menu Principal!\n");
    
        }
    
        private static void verificarOpcaoMenuUsu(int opcaoUsu) {
    
            switch (opcaoUsu) {
    
                case 1:

                    cadastrarAposta();
                    break;
    
                case 2:
    
                    verApostas();
                    break;
    
                case 3:
                    Usuario u = obterUsuarioAtual();
                    exibirSaldoUsuario(u);
                    recarregarSaldo(u);
                    break;
    
                case 4:
    
                GerirEventos.processarResultados();
                GerirAposta.removerTodasApostas();
                GerirEventos.removerTodosEventos();
                    break;
                case 0:
                //Usuario voltou ao menu principal
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
        Usuario usuario = new Usuario(nome, email);
        GerirUsuarios.adicionarUsuario(usuario);
        System.out.println("\nSucesso!\nA UP BET te proporciona um saldo inicial de R$50,00 para suas apostas.\nCaso deseje aumenta-lo, é só acessar a opção 'saldo' no menu.");
    }
    
    public static void login(String nomeDeUsuario) throws Exception {
    
        Usuario usuario = buscarUsuarioPorNome(nomeDeUsuario);
        if (usuario != null) {
            usuarioAtual = usuario;
            System.out.println("Usuário " + nomeDeUsuario + " logado com sucesso.");
        } else {
            throw new Exception("Usuário não encontrado.");
        }
    }

    public static Usuario obterUsuarioAtual() {
        return usuarioAtual;
    }

    private static Usuario buscarUsuarioPorNome(String nomeDeUsuario) {
       
        ArrayList<Usuario> usuarios = GerirUsuarios.getUsuarios(); 
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nomeDeUsuario)) {
                return usuario;
            }
        }
        return null;
    }

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
            List<Evento> eventos = GerirEventos.lerEventos();
            for (Evento tempEvento : eventos) {
                System.out.println("\n[" + tempEvento.getId() + "] " + tempEvento.getCampeonato());
                System.out.println(tempEvento.getTimeA().getNome() + " (" + tempEvento.getTimeA().getOdd() + ") x " + tempEvento.getTimeB().getNome() + " (" + tempEvento.getTimeB().getOdd() + ")");
                System.out.println();
                if (eventos.isEmpty()) {
                    System.out.println("Sem eventos...");
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar eventos: " + e.getMessage());
        }
    }
    
    private static void atualizarEvento() {
        listarEventos();
        System.out.print("Escolha o jogo que você deseja atualizar: \n");
        int id = Console.lerInt();

       try {

            Evento evento = GerirEventos.buscarEvento(id);
            System.out.print("Atualizar o campeonato: ");
            String camp = Console.lerString();
            System.out.print("Atualizar primeiro time: ");
            String nome = Console.lerString();
            evento.setCampeonato(camp);
            System.out.print(nome + " odd: ");
            double odd = Console.lerDouble();

            evento.getTimeA().setNome(nome);
            evento.getTimeA().setOdd(odd);

            System.out.print("Atualizar segundo time: ");
            String nome2 = Console.lerString();
            System.out.print(nome2 + " odd: ");
            double odd2 = Console.lerDouble();

            evento.getTimeB().setNome(nome2);
            evento.getTimeB().setOdd(odd2);

            GerirEventos.atualizarEvento(evento);
            System.out.println("\nEvento atualizado com sucesso!\n");
            evento.exibirDadosEvento();

        } catch (Exception e) {

            System.out.println(e.getMessage());
        } 

    }

    private static void excluirEvento() {
        listarEventos();
        System.out.print("Informe o jogo que deseja excluir: ");
        int id = Console.lerInt();

         try {

            GerirEventos.excluirEvento(id);
            System.out.println("Evento excluído com sucesso!\n");

        } catch(Exception exception) {

            System.out.println(exception.getMessage());
        } 

    }

    public static void processarAposta(Evento evento) {
        
        System.out.println("Processando aposta para o evento: " + evento.getCampeonato());
        System.out.println(evento.getTimeA().getNome() + " x " + evento.getTimeB().getNome());
        
        System.out.print("Digite o valor da aposta: ");
        double valorAposta = Console.lerDouble();
         
        Usuario usuario = obterUsuarioAtual();
        if (usuario.getSaldo() < valorAposta) {
        System.out.println("Saldo insuficiente para realizar a aposta.\nSeu saldo atual: R$" + usuario.getSaldo() + "\n");
        return;
    }

        System.out.print("Digite o número de gols do " + evento.getTimeA().getNome() + ": ");
        int golsA = Console.lerInt();

        System.out.print("Digite o número de gols do " + evento.getTimeB().getNome() + ": ");
        int golsB = Console.lerInt();

         
        Aposta aposta = new Aposta(usuarioAtual, evento, valorAposta, evento.getTimeA(), evento.getTimeB(), golsA, golsB);
        
        usuario.atualizarSaldo(-valorAposta);
        
        CadastrarApostas.adicionarAposta(aposta);

        try {

            GerirAposta.salvarAposta(aposta);
            System.out.println("\nAposta feita com sucesso!");

        } catch (Exception exception) {

            System.out.println(exception.getMessage());
        }

        System.out.println("Saldo atual: " + usuario.getSaldo());
    }


    private static void cadastrarAposta() {

    int op;
    
    do {

        listarEventos();
        System.out.println("\nSelecione o número de qual jogo você deseja apostar");
        System.out.print("Digite '0' para voltar ao menu de usuário\n");
        op = Console.lerInt();
       

        try {
            Evento eventoSelecionado = GerirEventos.buscarEvento(op);
            processarAposta(eventoSelecionado);
            if (op == 0) {
                System.out.println("Voltando ao menu principal...\n");
            }
        } catch (Exception e) {
            System.out.println("Jogo inexistente. Por favor, digite novamente...");
            
        }

        
    } while (op!=0);

        return;
    }


    // *** Novo Método ***
    private static void verApostas() {
         
        Usuario usuarioAtual = Sistema.obterUsuarioAtual();

    if (usuarioAtual == null) {
        System.out.println("Nenhum usuário logado. Faça login para continuar.");
        return;
    }
        
    ArrayList<Aposta> listaApostas = CadastrarApostas.getApostas();

    try {
        CadastrarApostas.verificarListaVazia();
        System.out.println("\nApostas realizadas por " + usuarioAtual.getNome() + ":");

        boolean encontrouApostas = false;

        for (Aposta tempA : listaApostas) {
            if (tempA.getUsuario().equals(usuarioAtual)) {
                System.out.println(tempA.exibirDadosAposta());
                encontrouApostas = true;
            }
        }

        if (!encontrouApostas) {
            System.out.println("Nenhuma aposta encontrada para o usuário " + usuarioAtual.getNome() + ".");
        }

    } catch (Exception exception) {
        System.out.println(exception.getMessage());
    }
    }

    // Novo método para exibir o saldo do usuário
    private static void exibirSaldoUsuario(Usuario u) {
        u.exibirDados();
        System.out.println("Seu saldo atual é: R$" + u.getSaldo());
    }
    
    private static void recarregarSaldo(Usuario u) {
        System.out.print("Digite a quantia que deseja adicionar ao saldo: ");
        double quantia = Console.lerDouble();
        u.atualizarSaldo(quantia);
        System.out.println("Saldo atualizado com sucesso! Seu novo saldo é: R$" + u.getSaldo());
        enterParaSeguir();
    }

    public static void executar() throws Exception {

        int op;

        do { 
            menuPrincipal();
            op = Console.lerInt();
            verificarOpcaoMenuPrincipal(op);
        } while (op != 0);

    }
    
}

