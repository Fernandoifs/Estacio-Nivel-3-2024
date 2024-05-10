
import cadastrobd.model.PessoaFisica;
import cadastrobd.model.PessoaJuridica;
import java.util.Scanner;

public class CadastroBDTeste {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("==============================");
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Exibir pelo ID");
            System.out.println("5 - Exibir Todos");
            System.out.println("0 - Finalizar Programa");
            System.out.println("==============================");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

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
        scanner.close();
    }

    private static void incluirOpcao() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o tipo de pessoa:");
        System.out.println("F - Pessoa Física | J - Pessoa Jurídica");
        String tipoPessoa = scanner.nextLine().toUpperCase();

        switch (tipoPessoa) {
            case "F" -> incluirPessoaFisica();
            case "J" -> incluirPessoaJuridica();
            default -> System.out.println("Opção inválida.");
        }
    }

    private static void incluirPessoaFisica() {
        PessoaFisica pessoaFisica = new PessoaFisica();
        Scanner scanner = new Scanner(System.in);

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

        System.out.print("Email: ");
        pessoaFisica.setEmail(scanner.nextLine());

        System.out.print("Cpf: ");
        pessoaFisica.setCpf(scanner.nextLine());

        PessoaFisicaDAO.incluir(pessoaFisica);
        System.out.println("Pessoa Física incluída com sucesso!");
    }

    private static void incluirPessoaJuridica() {
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        Scanner scanner = new Scanner(System.in);

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

        System.out.print("Email: ");
        pessoaJuridica.setEmail(scanner.nextLine());

        System.out.print("Cnpj: ");
        pessoaJuridica.setCnpj(scanner.nextLine());

        PessoaJuridicaDAO.incluir(pessoaJuridica);
        System.out.println("Pessoa Jurídica incluída com sucesso!");
    }

    private static void alterarOpcao(Scanner scanner) {
        System.out.println("Digite o ID do registro que deseja alterar:");
        //int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Escolha o tipo de pessoa:");
        System.out.println("F - Pessoa Física | J - Pessoa Jurídica");
        String tipoPessoa = scanner.nextLine().toUpperCase();

        switch (tipoPessoa) {
            case "F" -> alterarPessoaFisica();
            case "J" -> alterarPessoaJuridica();
            default -> System.out.println("Opção inválida.");
        }
}
       private static void alterarPessoaFisica() { //adicionar a partir daqui
            PessoaFisica pessoaFisica = getId(id);
            if (pessoaFisica != null) {
                exibirPorId(pessoaFisica);

                System.out.println("Insira os dados...");
                System.out.println("Nome:");
                String novoNome = scanner.nextLine();
                System.out.println("Logradouro:");
                String novoLogradouro = scanner.nextLine();
                System.out.println("Cidade:");
                int novaCidade = scanner.nextInt();
                System.out.println("Estado:");
                int novaEstado = scanner.nextInt();
                System.out.println("Telefone:");
                int novaTelefone = scanner.nextInt();
                System.out.println("Cpf:");
                int novaCpf = scanner.nextInt();
                scanner.nextLine();

                pessoaFisica.setNome(novoNome);
                pessoaFisica.setLogradouro(novoLogradouro);
                pessoaFisica.setCidade(novaCidade);
                pessoaFisica.setEstado(novaEstado);
                pessoaFisica.setTelefone(novaTelefone);
                pessoaFisica.setCidade(novaCidade);

                System.out.println("Pessoa Física alterada com sucesso!");
            } else {
                System.out.println("Pessoa Física não encontrada com o ID informado.");
            }
        } else if (tipoPessoa.equals("J")) {
            PessoaJuridica pessoaJuridica = repoJuridica.obter(id);
            if (pessoaJuridica != null) {
                exibirOpcao(pessoaJuridica);

                System.out.println("Insira os dados...");
                System.out.println("Nome:");
                String novoNome = scanner.nextLine();
                System.out.println("CNPJ:");
                String novoCnpj = scanner.nextLine();

                pessoaJuridica.setNome(novoNome);
                pessoaJuridica.setCnpj(novoCnpj);

                System.out.println("Pessoa Jurídica alterada com sucesso!");
            } else {
                System.out.println("Pessoa Jurídica não encontrada com o ID informado.");
            }
        }
       }
       private static void alterarPessoaJuridica() {
       }


    private static void excluirOpcao(Scanner scanner) {
        System.out.println("Digite o ID do registro que deseja excluir:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Escolha o tipo de pessoa:");
        System.out.println("F - Pessoa Física | J - Pessoa Jurídica");
        String tipoPessoa = scanner.nextLine().toUpperCase();

        switch (tipoPessoa) {
            case "F" -> excluirPessoaFisica();
            case "J" -> excluirPessoaJuridica();
            default -> System.out.println("Opção inválida.");
        }
    }
       private static void excluirPessoaFisica() {
       }
       private static void excluirPessoaJuridica() {
       }

    private static void exibirOpcao(Scanner scanner) {
        System.out.println("Digite o ID do registro que deseja alterar:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Escolha o tipo de pessoa:");
        System.out.println("F - Pessoa Física | J - Pessoa Jurídica");
        String tipoPessoa = scanner.nextLine().toUpperCase();

        switch (tipoPessoa) {
            case "F" -> exibirPessoaFisica();
            case "J" -> exibirPessoaJuridica();
            default -> System.out.println("Opção inválida.");
        }
    }
       private static void exibirPessoaFisica() {
       }
       private static void exibirPessoaJuridica() {
       }

    private static void exibirTodosOpcao( ) {
        System.out.println("Exibindo todas as pessos cadastradas:");

        }
       private static void exibirTodosPessoaFisica() {
       }
       private static void exibirTodosPessoaJuridica() {
       }
}
