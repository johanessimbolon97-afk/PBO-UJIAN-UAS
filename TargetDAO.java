import java.sql.Connection;
import java.sql.PreparedStatement;

public class TargetDAO {

    private Connection connection;

    public TargetDAO() {

        connection = DatabaseKoneksi
                .getInstance()
                .getConnection();

    }

    public void simpanTarget(Target t) {

        try {

            // [UAS] - Bukti Pemahaman
            // Menggunakan PreparedStatement agar aman dari SQL Injection
            String sql = "INSERT INTO bounty_list(nama_target,harga_bounty) VALUES(?,?)";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, t.getNamaTarget());

            ps.setInt(2, t.getHargaBounty());

            ps.executeUpdate();

            SecurityLogger.getInstance()
                    .catatLog("Menambahkan Target : " + t.getNamaTarget());

            System.out.println("Data berhasil disimpan.");

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}