
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import cadastrobd.model.PessoaFisica;
import cadastrobd.model.util.ConectorBD;

public class PessoaFisicaDAO {

    public static PessoaFisica getPessoa(int idpessoa) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PessoaFisica pessoa = null;

        try {
            conn = ConectorBD.getConnection();
            String sql = """
                         SELECT pes.nome, pes.logradouro, pes.cidade, pes.estado, pes.telefone, pes.email, pef.cpf 
                         FROM pessoafisica pef 
                         INNER JOIN pessoa pes ON (pes.idpessoa = pef.idpessoa)
                         WHERE pes.idpessoa=?""";

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idpessoa);
            rs = stmt.executeQuery();

            if (rs.next()) {
                pessoa = new PessoaFisica(
                        idpessoa,
                        rs.getString("nome"),
                        rs.getInt("logradouro"),
                        rs.getInt("cidade"),
                        rs.getInt("estado"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("cpf")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConectorBD.close(conn, stmt, rs);
        }

        return pessoa;
    }

    public static List<PessoaFisica> getPessoas() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<PessoaFisica> pessoas = new ArrayList<>();

        try {
            conn = ConectorBD.getConnection();
            String sql = """
                         SELECT pes.nome, pes.logradouro, pes.cidade, pes.estado, pes.telefone, pes.email, pef.cpf 
                         FROM pessoafisica pef 
                         INNER JOIN pessoa pes ON (pes.idpessoa = pef.idpessoa)
                         """;
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                PessoaFisica pessoa = new PessoaFisica(
                        rs.getInt("idpessoa"),
                        rs.getString("nome"),
                        rs.getInt("logradouro"),
                        rs.getInt("cidade"),
                        rs.getInt("estado"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("cpf")
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

    public static void incluir(PessoaFisica pessoa) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConectorBD.getConnection();
            String sqlPessoa = "INSERT INTO Pessoa (nome, logradouro, cidade, estado, telefone, email, tipo) VALUES (?, ?, ?, ?, ?, ?, 'F')";
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

            String sqlPessoaFisica = "INSERT INTO PessoaFisica (idpessoa, cpf) VALUES (?, ?)";
            stmt = conn.prepareStatement(sqlPessoaFisica);
            stmt.setInt(1, idPessoa);
            stmt.setString(2, pessoa.getCpf());
            stmt.executeUpdate();

            System.out.println("Pessoa física inserida com sucesso:");
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("Logradouro: " + pessoa.getLogradouro());
            System.out.println("Cidade: " + pessoa.getCidade());
            System.out.println("Estado: " + pessoa.getEstado());
            System.out.println("Telefone: " + pessoa.getTelefone());
            System.out.println("Email: " + pessoa.getEmail());
            System.out.println("CPF: " + pessoa.getCpf());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConectorBD.close(conn, stmt, rs);
        }
    }

    public static void alterar(PessoaFisica pessoa) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConectorBD.getConnection();
            String sqlPessoaFisica = "UPDATE PessoaFisica SET cpf=? WHERE idpessoa=?";
            PreparedStatement stmt2 = conn.prepareStatement(sqlPessoaFisica);
            stmt2.setString(1, pessoa.getCpf());
            stmt2.setInt(2, pessoa.getId());
            stmt2.executeUpdate();
            
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
            String sqlPessoaFisica = "DELETE FROM PessoaFisica WHERE idpessoa=?";
            stmt = conn.prepareStatement(sqlPessoaFisica);
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
