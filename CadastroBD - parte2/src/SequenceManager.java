import cadastrobd.model.util.ConectorBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SequenceManager {

    public static int getNextId(String tableName) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int nextId = -1;

        try {
            conn = ConectorBD.getConnection();
            String sql = "SELECT IDENT_CURRENT('" + tableName + "') + 1 AS nextId";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            if (rs.next()) {
                nextId = rs.getInt("nextId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, stmt, rs);
        }

        return nextId;
    }

    private static void close(Connection conn, PreparedStatement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
