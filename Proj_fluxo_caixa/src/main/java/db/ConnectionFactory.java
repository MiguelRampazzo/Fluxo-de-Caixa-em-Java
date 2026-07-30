package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() {
        try {
            // Substitua 'fluxo_caixa_db' pelo nome do seu banco de dados
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/fluxo_caixa_db", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados!", e);
        }
    }
}