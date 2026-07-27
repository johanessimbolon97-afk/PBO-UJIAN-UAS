import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseKoneksi {

    // [UAS] - Bukti Pemahaman
    // Singleton instance hanya satu untuk seluruh aplikasi
    private static DatabaseKoneksi instance;

    private Connection connection;

    // [UAS] - Bukti Pemahaman
    // Constructor dibuat private agar tidak bisa dibuat menggunakan new
    private DatabaseKoneksi() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/uas_java",
                    "root",
                    ""
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized DatabaseKoneksi getInstance() {

        if (instance == null) {
            instance = new DatabaseKoneksi();
        }

        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

}