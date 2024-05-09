
import cadastrobd.model.PessoaFisica;
import cadastrobd.model.PessoaJuridica;
import java.util.Scanner;

public class CadastroBDTeste {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int opcao;

            do {
                exibirMenu();

                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1 -> incluirOpcao();
                    case 2 -> alterarOpcao(scanner);
                    case 3 -> excluirOpcao(scanner);
                    case 4 -> exibirPorIdOpcao(scanner);
                    case 5 -> exibirTodosOpcao();
                    case 0 -> System.out.println("Finalizando programa...");
                    default -> System.out.println("Opção inválida!");
                }
            } while (opcao != 0);
        }
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

    private static void incluirOpcao() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Escolha o tipo de pessoa:");
            System.out.println("F - Pessoa Física | J - Pessoa Jurídica");
            String tipoPessoa = scanner.nextLine().toUpperCase();

            switch (tipoPessoa) {
                case "F" -> incluirPessoaFisica(scanner);
                case "J" -> incluirPessoaJuridica(scanner);
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private static void incluirPessoaFisica(Scanner scanner) {
        PessoaFisica pessoaFisica = new PessoaFisica();
        System.out.print("Nome: ");
        pessoaFisica.setNome(scanner.nextLine());

        System.out.print("Logradouro (ID): ");
        int logradouroId = scanner.nextInt();
        scanner.nextLine();
        pessoaFisica.setLogradouro(logradouroId);

        System.out.print("Cidade (ID): ");
        int cidadeId = scanner.nextInt();
        scanner.nextLine();
        pessoaFisica.setCidade(cidadeId);

        System.out.print("Estado (ID): ");
        int estadoId = scanner.nextInt();
        scanner.nextLine();
        pessoaFisica.setEstado(estadoId);

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

        System.out.print("Logradouro (ID): ");
        int logradouroId = scanner.nextInt();
        scanner.nextLine();
        pessoaJuridica.setLogradouro(logradouroId);

        System.out.print("Cidade (ID): ");
        int cidadeId = scanner.nextInt();
        scanner.nextLine();
        pessoaJuridica.setCidade(cidadeId);

        System.out.print("Estado (ID): ");
        int estadoId = scanner.nextInt();
        scanner.nextLine();
        pessoaJuridica.setEstado(estadoId);

        System.out.print("Telefone: ");
        pessoaJuridica.setTelefone(scanner.nextLine());

        System.out.print("Cnpj: ");
        pessoaJuridica.setCnpj(scanner.nextLine());

        PessoaJuridicaDAO.incluir(pessoaJuridica);
        System.out.println("Pessoa Jurídica incluída com sucesso!");
    }

    private static void alterarOpcao(Scanner scanner) {
        System.out.println("metodo alterarOpcao!");
    }

    private static void excluirOpcao(Scanner scanner) {
        System.out.println("metodo excluirOpcao!");
    }

    private static void exibirPorIdOpcao(Scanner scanner) {
        System.out.println("metodo exibirPorIdOpcao!");
    }

    private static void exibirTodosOpcao() {
        // Implementar lógica para exibição de todos
    }
}
