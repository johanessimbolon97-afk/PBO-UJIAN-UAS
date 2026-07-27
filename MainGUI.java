import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainGUI extends JFrame {

    JTextField txtNama;
    JTextField txtBounty;
    JButton btnTambah;

    JTable tabel;
    DefaultTableModel model;

    public MainGUI() {

        setTitle("Data Bounty");
        setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        txtNama = new JTextField(15);
        txtBounty = new JTextField(15);
        btnTambah = new JButton("Tambahkan");

        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nama");
        model.addColumn("Bounty");

        tabel = new JTable(model);

        JScrollPane scroll = new JScrollPane(tabel);

        JPanel atas = new JPanel();

        atas.add(new JLabel("Nama"));
        atas.add(txtNama);

        atas.add(new JLabel("Bounty"));
        atas.add(txtBounty);

        atas.add(btnTambah);

        add(atas, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        // Lambda Listener
        btnTambah.addActionListener(e -> {

            try {

                String nama = txtNama.getText();

                int bounty = Integer.parseInt(txtBounty.getText());

                Target t = new Target();
                t.setNamaTarget(nama);
                t.setHargaBounty(bounty);

                TargetDAO dao = new TargetDAO();
                dao.simpanTarget(t);

                // Refresh JTable
                model.setRowCount(0);
                loadData();

                txtNama.setText("");
                txtBounty.setText("");

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Bounty harus berupa angka!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);

            }

        });

    }

    private void loadData() {
        // Diisi mengambil data dari MySQL
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainGUI().setVisible(true);
        });
    }

}