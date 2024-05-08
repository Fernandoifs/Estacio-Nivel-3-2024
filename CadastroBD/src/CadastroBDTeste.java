import cadastrobd.model.PessoaFisica;
import cadastrobd.model.PessoaJuridica;
import java.util.List;

public class CadastroBDTeste {

    public static void main(String[] args) {
        // Instanciar uma pessoa física e persistir no banco de dados
        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setNome("Fulano");
        pessoaFisica.setLogradouro(1); 
        pessoaFisica.setCidade(1);     
        pessoaFisica.setEstado(21);    
        pessoaFisica.setTelefone("123456789");
        pessoaFisica.setEmail("fulano@example.com");
        pessoaFisica.setCpf("123.456.789-00");

        PessoaFisicaDAO.incluir(pessoaFisica);

        // Alterar os dados da pessoa física no banco
        pessoaFisica.setNome("Fulano da Silva");
        pessoaFisica.setCidade(2); // Alterando a cidade para o ID 2
        PessoaFisicaDAO.alterar(pessoaFisica);

        // Consultar todas as pessoas físicas do banco de dados e listar no console
        List<PessoaFisica> pessoasFisicas = PessoaFisicaDAO.getPessoas();
        System.out.println("Pessoas físicas cadastradas:");
        for (PessoaFisica pf : pessoasFisicas) {
            System.out.println(pf);
        }

        // Excluir a pessoa física criada anteriormente no banco
        PessoaFisicaDAO.excluir(pessoaFisica.getId());

        // Instanciar uma pessoa jurídica e persistir no banco de dados
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setNome("Empresa XYZ");
        pessoaJuridica.setLogradouro(1); 
        pessoaJuridica.setCidade(1);     
        pessoaJuridica.setEstado(21);    
        pessoaJuridica.setTelefone("987654321");
        pessoaJuridica.setEmail("contato@empresa.com");
        pessoaJuridica.setCnpj("12.345.678/0001-00");

        PessoaJuridicaDAO.incluir(pessoaJuridica);

        // Alterar os dados da pessoa jurídica no banco
        pessoaJuridica.setNome("Nova Empresa XYZ");
        pessoaJuridica.setCidade(1); 
        PessoaJuridicaDAO.alterar(pessoaJuridica);

        // Consultar todas as pessoas jurídicas do banco de dados e listar no console
        List<PessoaJuridica> pessoasJuridicas = PessoaJuridicaDAO.getPessoas();
        System.out.println("Pessoas jurídicas cadastradas:");
        for (PessoaJuridica pj : pessoasJuridicas) {
            System.out.println(pj);
        }

        // Excluir a pessoa jurídica criada anteriormente no banco
        PessoaJuridicaDAO.excluir(pessoaJuridica.getId());
    }
}
