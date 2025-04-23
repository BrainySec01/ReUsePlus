import java.util.Scanner;

public class ReUseApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = -1;
        Usuario usuarioLogado = null;

        // Menu Principal
        while (opcao != 0) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Cadastro de Usuário");
            System.out.println("2. Login");
            System.out.println("3. Definir Interesse");
            System.out.println("4. Listar Meus Interesses");
            System.out.println("5. Remover Meu Interesse");
            System.out.println("6. Recomendar Itens");
            System.out.println("7. Manifestar Interesse em um Item");
            System.out.println("8. Listar Interesses em Meus Itens");
            System.out.println("9. Confirmar Troca");
            System.out.println("10. Visualização de Reputação");
            System.out.println("0. Sair");
            System.out.print("Digite a opção: ");
            
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    // Cadastro de Usuário
                    usuarioLogado = Usuario.cadastrarUsuario();
                    break;
                case 2:
                    // Login
                    usuarioLogado = Usuario.login();
                    break;
                case 3:
                    // Definir Interesse
                    if (usuarioLogado != null) {
                        usuarioLogado.definirInteresse();
                    } else {
                        System.out.println("Faça login primeiro.");
                    }
                    break;
                case 4:
                    // Listar Meus Interesses
                    if (usuarioLogado != null) {
                        usuarioLogado.listarInteresses();
                    } else {
                        System.out.println("Faça login primeiro.");
                    }
                    break;
                case 5:
                    // Remover Meu Interesse
                    if (usuarioLogado != null) {
                        usuarioLogado.removerInteresse();
                    } else {
                        System.out.println("Faça login primeiro.");
                    }
                    break;
                case 6:
                    // Recomendar Itens
                    if (usuarioLogado != null) {
                        List<Item> recomendados = usuarioLogado.recomendarItens();
                        recomendados.forEach(item -> System.out.println(item));
                    } else {
                        System.out.println("Faça login primeiro.");
                    }
                    break;
                case 7:
                    // Manifestar Interesse em um Item
                    if (usuarioLogado != null) {
                        usuarioLogado.manifestarInteresseEmItem();
                    } else {
                        System.out.println("Faça login primeiro.");
                    }
                    break;
                case 8:
                    // Listar Interesses em Meus Itens
                    if (usuarioLogado != null) {
                        usuarioLogado.listarInteressesEmMeusItens();
                    } else {
                        System.out.println("Faça login primeiro.");
                    }
                    break;
                case 9:
                    // Confirmar Troca
                    if (usuarioLogado != null) {
                        usuarioLogado.confirmarTroca();
                    } else {
                        System.out.println("Faça login primeiro.");
                    }
                    break;
                case 10:
                    // Visualização de Reputação
                    if (usuarioLogado != null) {
                        usuarioLogado.visualizarReputacao();
                    } else {
                        System.out.println("Faça login primeiro.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        sc.close();
    }
}