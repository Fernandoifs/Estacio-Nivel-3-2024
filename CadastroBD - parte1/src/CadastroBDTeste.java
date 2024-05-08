import cadastrobd.model.PessoaFisica;
import cadastrobd.model.PessoaJuridica;
import java.util.List;

public class CadastroBDTeste {

    public static void main(String[] args) {
        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setNome("Fulano");
        pessoaFisica.setLogradouro(1); 
        pessoaFisica.setCidade(1);     
        pessoaFisica.setEstado(21);    
        pessoaFisica.setTelefone("123456789");
        pessoaFisica.setEmail("fulano@example.com");
        pessoaFisica.setCpf("123.456.789-00");

        PessoaFisicaDAO.incluir(pessoaFisica);

        pessoaFisica.setNome("Fulano da Silva");
        pessoaFisica.setCidade(2);
        PessoaFisicaDAO.alterar(pessoaFisica);

        List<PessoaFisica> pessoasFisicas = PessoaFisicaDAO.getPessoas();
        System.out.println("Pessoas físicas cadastradas:");
        for (PessoaFisica pf : pessoasFisicas) {
            System.out.println(pf);
        }

        PessoaFisicaDAO.excluir(pessoaFisica.getId());

        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setNome("Empresa XYZ");
        pessoaJuridica.setLogradouro(1); 
        pessoaJuridica.setCidade(1);     
        pessoaJuridica.setEstado(21);    
        pessoaJuridica.setTelefone("987654321");
        pessoaJuridica.setEmail("contato@empresa.com");
        pessoaJuridica.setCnpj("12.345.678/0001-00");

        PessoaJuridicaDAO.incluir(pessoaJuridica);

        pessoaJuridica.setNome("Nova Empresa XYZ");
        pessoaJuridica.setCidade(1); 
        PessoaJuridicaDAO.alterar(pessoaJuridica);

        List<PessoaJuridica> pessoasJuridicas = PessoaJuridicaDAO.getPessoas();
        System.out.println("Pessoas jurídicas cadastradas:");
        for (PessoaJuridica pj : pessoasJuridicas) {
            System.out.println(pj);
        }

        PessoaJuridicaDAO.excluir(pessoaJuridica.getId());
    }
}
