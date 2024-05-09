
import cadastrobd.model.PessoaFisica;
import cadastrobd.model.PessoaJuridica;
import java.util.Scanner;


public class CadastroBDTeste {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    incluirOpcao(scanner);
                    break;
                case 2:
                    alterarOpcao(scanner);
                    break;
                case 3:
                    excluirOpcao(scanner);
                    break;
                case 4:
                    exibirPorIdOpcao(scanner);
                    break;
                case 5:
                    exibirTodosOpcao();
                    break;
                case 0:
                    System.out.println("Finalizando programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("==============================");
        System.out.println("1 - Incluir");
        System.out.println("2 - Alterar");
        System.out.println("3 - Excluir");
        System.out.println("4 - Exibir pelo ID");
        System.out.println("5 - Exibir Todos");
        System.out.println("0 - Finalizar Programa");
        System.out.println("==============================");
        System.out.print("Escolha uma opção: ");
    }

}

    private static void incluirOpcao(Scanner scanner) {
        System.out.println("Escolha o tipo de pessoa:");
        System.out.println("F - Pessoa Física | J - Pessoa Jurídica");
        String tipoPessoa = scanner.nextLine().toUpperCase();

        switch (tipoPessoa) {
            case "F":
                incluirPessoaFisica(scanner);
                break;
            case "J":
                incluirPessoaJuridica(scanner);
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
}
    private static void incluirPessoaFisica(Scanner scanner) {
        PessoaFisica pessoaFisica = new PessoaFisica();
        System.out.print("Nome: ");
        pessoaFisica.setNome(scanner.nextLine());

        System.out.print("Logradouro (ID): ");
        int logradouroId = scanner.nextInt();
        scanner.nextLine();
        pessoaFisica.setCidade(logradouroId);

        System.out.print("Cidade (ID): ");
        int cidadeId = scanner.nextInt();
        scanner.nextLine();
        pessoaFisica.setCidade(cidadeId);

        System.out.print("Estado (ID): ");
        int estadoId = scanner.nextInt();
        scanner.nextLine();
        pessoaFisica.setCidade(estadoId);

        System.out.print("Telefone: ");
        pessoaFisica.setTelefone(scanner.nextLine());

        System.out.print("Cpf: ");
        pessoaFisica.setCpf(scanner.nextLine());

        PessoaFisicaDAO.incluir(pessoaFisica);
        System.out.println("Pessoa Física incluída com sucesso!");
}

    private static void incluirPessoaJuridica(Scanner scanner) {
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        System.out.print("Nome: ");
        pessoaJuridica.setNome(scanner.nextLine());

        PessoaJuridicaDAO.incluir(pessoaJuridica);
        System.out.println("Pessoa Jurídica incluída com sucesso!");
    }

    private static void alterarOpcao(Scanner scanner) {
        // Implementar lógica para alteração
    }

    private static void excluirOpcao(Scanner scanner) {
        // Implementar lógica para exclusão
    }

    private static void exibirPorIdOpcao(Scanner scanner) {
        // Implementar lógica para exibição por ID
    }

    private static void exibirTodosOpcao() {
        // Implementar lógica para exibição de todos
    }
}
