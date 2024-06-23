import java.util.Scanner;

// RASCUNHO PROVISORIO DO MENU 

public class Sistema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            
            System.out.println("Bem-vindo a UP Bet!");
            System.out.println("1. ");
            System.out.println("2. ");
            System.out.println("3. ");
            System.out.println("4. ");
            System.out.println("5. "); 
            System.out.println("0. Sair!"); 

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println();
                    break;

                case 2:
                    System.out.println();
                    break;

                case 3:
                    System.out.println();
                    break;

                case 4:
                    System.out.println();
                    break;

                case 5:
                    System.out.println();
                    break;

                case 0:
                    System.out.println("Obrigado por ultilizar a UP Bet!");
                    break;
                
                default:
                    System.out.println("A opção digitada é inválida, digite novamente!");
                    break;

            }

            System.out.println();
            
        } while (opcao != 0);

    }

}