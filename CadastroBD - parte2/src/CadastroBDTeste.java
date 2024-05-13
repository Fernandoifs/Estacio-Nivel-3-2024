
import cadastrobd.model.PessoaFisica;
import cadastrobd.model.PessoaJuridica;
import cadastrobd.model.Pessoa;

import java.util.List;
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
                case 1 ->
                    incluirOpcao();
                case 2 ->
                    alterarOpcao(scanner);
                case 3 ->
                    excluirOpcao(scanner);
                case 4 ->
                    exibirPorIdOpcao(scanner);
                case 5 ->
                    exibirTodosOpcao();
                case 0 ->
                    System.out.println("Finalizando programa...");
                default ->
                    System.out.println("Opção inválida!");
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
            case "F" ->
                incluirPessoaFisica();
            case "J" ->
                incluirPessoaJuridica();
            default ->
                System.out.println("Opção inválida.");
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
    System.out.println("Escolha o tipo de pessoa:");
    System.out.println("F - Pessoa Física | J - Pessoa Jurídica");
    scanner.nextLine();
    String tipoPessoa = scanner.nextLine().toUpperCase();

    System.out.print("ID: ");
    int id = scanner.nextInt();
    scanner.nextLine();
    System.out.println("Recuperando os dados...");

    if (tipoPessoa.equals("F")) {
        Pessoa pessoaRecuperada = PessoaFisicaDAO.getPessoa(id);
        atualizarDadosPessoa(scanner, pessoaRecuperada);
    } else if (tipoPessoa.equals("J")) {
        Pessoa pessoaRecuperada = PessoaJuridicaDAO.getPessoa(id);
        atualizarDadosPessoa(scanner, pessoaRecuperada);
    } else {
        System.out.println("Tipo de pessoa inválido!");
    }
}

private static void atualizarDadosPessoa(Scanner scanner, Pessoa pessoaRecuperada) {
    if (pessoaRecuperada != null) {
        pessoaRecuperada.exibir();

        System.out.println("Insira os dados...");
        System.out.print("Nome: ");
        String novoNome = scanner.nextLine();
        System.out.print("Logradouro (ID): ");
        int novoLogradouro = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Cidade (ID): ");
        int novoCidade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Estado (ID): ");
        int novoEstado = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Telefone: ");
        String novoTelefone = scanner.nextLine();
        System.out.print("Email: ");
        String novoEmail = scanner.nextLine();

        pessoaRecuperada.setNome(novoNome);
        pessoaRecuperada.setLogradouro(novoLogradouro);
        pessoaRecuperada.setCidade(novoCidade);
        pessoaRecuperada.setEstado(novoEstado);
        pessoaRecuperada.setTelefone(novoTelefone);
        pessoaRecuperada.setEmail(novoEmail);

        if (pessoaRecuperada instanceof PessoaFisica) {
            System.out.print("CPF: ");
            String novoCPF = scanner.nextLine();
            ((PessoaFisica) pessoaRecuperada).setCpf(novoCPF);
        } else if (pessoaRecuperada instanceof PessoaJuridica) {
            System.out.print("CNPJ: ");
            String novoCNPJ = scanner.nextLine();
            ((PessoaJuridica) pessoaRecuperada).setCnpj(novoCNPJ);
        }

        System.out.println("Dados atualizados com sucesso!");
    } else {
        System.out.println("Pessoa não encontrada!");
    }
}

        private static void excluirOpcao(Scanner scanner) {
        System.out.println("Escolha o tipo de pessoa:");
        System.out.println("F - Pessoa Física | J - Pessoa Jurídica");
        scanner.nextLine();
        String tipoPessoa = scanner.nextLine().toUpperCase();

        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (tipoPessoa.equals("F")) {
            PessoaFisica pessoaFisicaRecuperada = PessoaFisicaDAO.getPessoa(id);
            if (pessoaFisicaRecuperada != null) {
                pessoaFisicaRecuperada.exibir();

                System.out.println("Deseja realmente excluir? Sim | Não");
                String resposta = scanner.nextLine().toUpperCase();
                if (resposta.equals("SIM")) {
                    PessoaFisicaDAO.excluir(id);
                    System.out.println("Dados excluídos com sucesso!");
                }
            } else {
                System.out.println("Pessoa não encontrada!");
            }
        } else if (tipoPessoa.equals("J")) {
            PessoaJuridica pessoaJuridicaRecuperada = PessoaJuridicaDAO.getPessoa(id);
            if (pessoaJuridicaRecuperada != null) {
                pessoaJuridicaRecuperada.exibir();

                System.out.println("Deseja realmente excluir? Sim | Não");
                String resposta = scanner.nextLine().toUpperCase();
                if (resposta.equals("SIM")) {
                    PessoaJuridicaDAO.excluir(id);
                    System.out.println("Dados excluídos com sucesso!");
                }
            } else {
                System.out.println("Pessoa não encontrada!");
            }
        } else {
            System.out.println("Tipo de pessoa inválido!");
        }
    }

    //-----------------------------------------------
    private static void exibirPorIdOpcao(Scanner scanner) {
        System.out.print("Digite o ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Recuperando os dados...");
        PessoaFisica pessoaFisicaRecuperada = PessoaFisicaDAO.getPessoa(id);
        if (pessoaFisicaRecuperada != null) {
            pessoaFisicaRecuperada.exibir();
        } else {
            System.out.println("Pessoa não encontrada!");
        }
    }

    //-----------------------------------------------
    private static void exibirTodosOpcao() {
        System.out.println("Exibindo todas as pessos cadastradas:");
        List<PessoaFisica> todasPessoas = PessoaFisicaDAO.getPessoas();
        for (PessoaFisica pessoa : todasPessoas) {
            pessoa.exibir();
        }
    }
}
