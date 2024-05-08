
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import cadastrobd.model.PessoaJuridica;
import cadastrobd.model.util.ConectorBD;

public class PessoaJuridicaDAO {

    public static PessoaJuridica getPessoa(int idpessoa) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PessoaJuridica pessoa = null;

        try {
            conn = ConectorBD.getConnection();
            String sql = """
                         SELECT pes.nome, pes.logradouro, pes.cidade, pes.estado, pes.telefone, pes.email, pej.cnpj 
                         FROM pessoa pes
                         INNER JOIN PessoaJuridica pej ON (pes.idpessoa = pej.idpessoa)
                         WHERE pes.idpessoa=?""";

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idpessoa);
            rs = stmt.executeQuery();

            if (rs.next()) {
                pessoa = new PessoaJuridica(
                        idpessoa,
                        rs.getString("nome"),
                        rs.getInt("logradouro"),
                        rs.getInt("cidade"),
                        rs.getInt("estado"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("cnpj")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConectorBD.close(conn, stmt, rs);
        }

        return pessoa;
    }

    public static List<PessoaJuridica> getPessoas() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<PessoaJuridica> pessoas = new ArrayList<>();

        try {
            conn = ConectorBD.getConnection();
            String sql = """
                         SELECT pes.idpessoa, pes.nome, pes.logradouro, pes.cidade, pes.estado, pes.telefone, pes.email, pej.cnpj
                         FROM pessoa pes
                         INNER JOIN PessoaJuridica pej ON (pes.idpessoa = pej.idpessoa)
                         WHERE pes.tipo = 'J'""";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                PessoaJuridica pessoa = new PessoaJuridica(
                        rs.getInt("idpessoa"),
                        rs.getString("nome"),
                        rs.getInt("logradouro"),
                        rs.getInt("cidade"),
                        rs.getInt("estado"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("cnpj")
                );
                pessoas.add(pessoa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConectorBD.close(conn, stmt, rs);
        }

        return pessoas;
    }

    public static void incluir(PessoaJuridica pessoa) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConectorBD.getConnection();
            String sqlPessoa = "INSERT INTO Pessoa (nome, logradouro, cidade, estado, telefone, email, tipo) VALUES (?, ?, ?, ?, ?, ?, 'J')";
            stmt = conn.prepareStatement(sqlPessoa, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, pessoa.getNome());
            stmt.setInt(2, pessoa.getLogradouro());
            stmt.setInt(3, pessoa.getCidade());
            stmt.setInt(4, pessoa.getEstado());
            stmt.setString(5, pessoa.getTelefone());
            stmt.setString(6, pessoa.getEmail());
            stmt.executeUpdate();

            rs = stmt.getGeneratedKeys();
            int idPessoa = 0;
            if (rs.next()) {
                idPessoa = rs.getInt(1);
            }

            String sqlPessoaJuridica = "INSERT INTO PessoaJuridica (idpessoa, cnpj) VALUES (?, ?)";
            stmt = conn.prepareStatement(sqlPessoaJuridica);
            stmt.setInt(1, idPessoa);
            stmt.setString(2, pessoa.getCnpj());
            stmt.executeUpdate();

            System.out.println("Pessoa jurídica inserida com sucesso:");
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("Logradouro: " + pessoa.getLogradouro());
            System.out.println("Cidade: " + pessoa.getCidade());
            System.out.println("Estado: " + pessoa.getEstado());
            System.out.println("Telefone: " + pessoa.getTelefone());
            System.out.println("Email: " + pessoa.getEmail());
            System.out.println("CNPJ: " + pessoa.getCnpj());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConectorBD.close(conn, stmt, rs);
        }
    }

    public static void alterar(PessoaJuridica pessoa) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConectorBD.getConnection();
            String sqlPessoa = "UPDATE Pessoa SET nome=?, logradouro=?, cidade=?, estado=?, telefone=?, email=? WHERE idpessoa=?";
            stmt = conn.prepareStatement(sqlPessoa);
            stmt.setString(1, pessoa.getNome());
            stmt.setInt(2, pessoa.getLogradouro());
            stmt.setInt(3, pessoa.getCidade());
            stmt.setInt(4, pessoa.getEstado());
            stmt.setString(5, pessoa.getTelefone());
            stmt.setString(6, pessoa.getEmail());
            stmt.setInt(7, pessoa.getId());
            stmt.executeUpdate();

            String sqlPessoaJuridica = "UPDATE PessoaJuridica SET cnpj=? WHERE idpessoa=?";
            PreparedStatement stmt2 = conn.prepareStatement(sqlPessoaJuridica);
            stmt2.setString(1, pessoa.getCnpj());
            stmt2.setInt(2, pessoa.getId());
            stmt2.executeUpdate();

            ConectorBD.close(stmt2);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConectorBD.close(conn, stmt, null);
        }

    }

    public static void excluir(int idpessoa) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConectorBD.getConnection();
            String sqlPessoaJuridica = "DELETE FROM PessoaJuridica WHERE idpessoa=?";
            stmt = conn.prepareStatement(sqlPessoaJuridica);
            stmt.setInt(1, idpessoa);
            stmt.executeUpdate();

            String sqlPessoa = "DELETE FROM Pessoa WHERE idpessoa=?";
            stmt = conn.prepareStatement(sqlPessoa);
            stmt.setInt(1, idpessoa);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConectorBD.close(conn, stmt, null);
        }
    }
}
