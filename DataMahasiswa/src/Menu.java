import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Menu extends JFrame{
    public static void main(String[] args) {
        // buat object window
        Menu window = new Menu();

        // atur ukuran window
        window.setSize(480, 560);
        // letakkan window di tengah layar
        window.setLocationRelativeTo(null);
        // isi window
        window.setContentPane(window.mainPanel);
        // ubah warna background
        window.getContentPane().setBackground(Color.white);
        // tampilkan window
        window.setVisible(true);
        // agar program ikut berhenti saat window diclose
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    // index baris yang diklik
    private int selectedIndex = -1;
    // list untuk menampung semua mahasiswa
    private ArrayList<Mahasiswa> listMahasiswa;

    private JPanel mainPanel;
    private JTextField nimField;
    private JTextField namaField;
//    private JTextField bakatanehField;
    private JTable mahasiswaTable;
    private JButton addUpdateButton;
    private JButton cancelButton;
    private JComboBox jenisKelaminComboBox;
    private JButton deleteButton;
    private JLabel titleLabel;
    private JLabel nimLabel;
    private JLabel namaLabel;
    private JLabel jenisKelaminLabel;
    private JLabel bakatAnehLabel;
    private JTextField bakatanehField;
    private JComboBox asalPlanetComboBox;
    private JLabel asalPlanetLabel;

    // constructor
    public Menu() {
        // inisialisasi listMahasiswa
        listMahasiswa = new ArrayList<>();

        // isi listMahasiswa
        populateList();

        // isi tabel mahasiswa
        mahasiswaTable.setModel((setTable()));

        // ubah styling title
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 20f));

        // atur isi combo box
        String[] jenisKelaminData = {"", "Laki-laki", "Perempuan"};
        jenisKelaminComboBox.setModel(new DefaultComboBoxModel(jenisKelaminData));

        String[] asalPlanetData = {"", "Matahari", "Merkurius", "Venus", "Mars", "Bumi", "Jupiter", "Saturnus", "Neptunus", "Pluto"};
        asalPlanetComboBox.setModel(new DefaultComboBoxModel(asalPlanetData));

        // sembunyikan button delete
        deleteButton.setVisible(false);

        // saat tombol add/update ditekan
        addUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if (selectedIndex == -1){
                insertData();
            }
            else{
                updateData();
            }

            }
        });
        // saat tombol delete ditekan
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedIndex >= 0){
                    deleteData();
                }
            }
        });
        // saat tombol cancel ditekan
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // saat tombol
                clearForm();
            }
        });
        // saat salah satu baris tabel ditekan
        mahasiswaTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // ubah selectedIndex menjadi baris tabel yang diklik
                    selectedIndex = mahasiswaTable.getSelectedRow();

                // simpan value textfield dan combo box
                String selectedNim = mahasiswaTable.getModel().getValueAt(selectedIndex, 1).toString();
                String selectedNama = mahasiswaTable.getModel().getValueAt(selectedIndex, 2).toString();
                String selectedJenisKelamin = mahasiswaTable.getModel().getValueAt(selectedIndex, 3).toString();
                String selectedbakatAneh = mahasiswaTable.getModel().getValueAt(selectedIndex, 4).toString();
                String selectedAsalPlanet = mahasiswaTable.getModel().getValueAt(selectedIndex, 5).toString();


                // ubah isi textfield dan combo box
                nimField.setText(selectedNim);
                namaField.setText(selectedNama);
                jenisKelaminComboBox.setSelectedItem(selectedJenisKelamin);
                bakatanehField.setText(selectedbakatAneh);
                asalPlanetComboBox.setSelectedItem(selectedAsalPlanet);

                // ubah button "Add" menjadi "Update"
                addUpdateButton.setText("update");
                // tampilkan button delete
                deleteButton.setVisible(true);
            }
        });
    }

    public final DefaultTableModel setTable() {
        // tentukan kolom tabel
        Object[] column = {"No", "NIM", "Nama", "Jenis Kelamin","Bakat Aneh", "Asal Planet"};

        // buat objek tabel dengan kolom yang sudan dibuat

        DefaultTableModel temp = new DefaultTableModel( null, column);

        //isi tabel dengan ListMahasiswa
        for (int i = 0; i < listMahasiswa.size(); i++) {

            Object[] row = new Object[6];

            row[0] = i + 1;

            row[1] = listMahasiswa.get(i).getNim();

            row[2] = listMahasiswa.get(i).getNama();

            row[3] = listMahasiswa.get(i).getJenisKelamin();

            row[4] = listMahasiswa.get(i).getBakatAneh();

            row[5] = listMahasiswa.get(i).getAsalPlanet();

            temp.addRow(row);
        }
            return temp;
    }

    public void insertData() {
        /// ambil value deri textfield dan combobox

        String nim = nimField.getText();

        String nama = namaField.getText();

        String jeniskelamin = jenisKelaminComboBox.getSelectedItem().toString();

        String bakataneh = bakatanehField.getText();

        String asalplanet = asalPlanetComboBox.getSelectedItem().toString();


        // tambahkan data ke dalam Lint

        listMahasiswa.add(new Mahasiswa (nim, nama, jeniskelamin, bakataneh, asalplanet));

        // update tabel
        mahasiswaTable.setModel(setTable());

        // bersihkan form
        clearForm();

        //feedback
        System.out.println("Insert berhasil!");
        JOptionPane.showMessageDialog( null,  "Data berhasil ditambahkan");


    }

    public void updateData() {
        // ambil data dari form
        String nim = nimField.getText();

        String nama = namaField.getText();

        String jeniskelamin = jenisKelaminComboBox.getSelectedItem().toString();

        String bakataneh = bakatanehField.getText();

        String asalplanet = asalPlanetComboBox.getSelectedItem().toString();


        // ubah data mahasiswa di list

        listMahasiswa.get(selectedIndex).setNim(nim);

        listMahasiswa.get(selectedIndex).setNama(nama);

        listMahasiswa.get(selectedIndex).setJenisKelamin(jeniskelamin);

        listMahasiswa.get(selectedIndex).setBakatAneh(bakataneh);

        listMahasiswa.get(selectedIndex).setAsalplanet(asalplanet);

        // update tabel
        mahasiswaTable.setModel(setTable());

        // bersinkan form
        clearForm();

        // feedback
        System.out.println("Update Berhasil!");
        JOptionPane.showMessageDialog( null,  "Data berhasil diubah!");


    }

//    public void deleteData() {
//        // hapus data dari list
//        listMahasiswa.remove((selectedIndex));
//
//        // update tabel
//        mahasiswaTable.setModel(setTable());
//
//        // bersihkan form
//        clearForm();
//
//        // feedback
//        System.out.println("Delete Berhasil!");
//        JOptionPane.showMessageDialog( null,  "Data berhasil diubah!");
//
//    }

    public void deleteData() {
        int choice = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            // hapus data dari list
            listMahasiswa.remove(selectedIndex);

            // update tabel
            mahasiswaTable.setModel(setTable());

            // bersihkan form
            clearForm();

            // feedback
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
        }
    }


    public void clearForm() {
        // kosongkan semua texfield dan combo box
        nimField.setText("");
        namaField.setText("");
        jenisKelaminComboBox.setSelectedItem("");
        bakatanehField.setText("");
        asalPlanetComboBox.setSelectedItem("");



        // ubah button "Update" menjadi "Add"
        addUpdateButton.setText("Add");
        // sembunyikan button delete
        deleteButton.setVisible(false);
        // ubah selectedIndex menjadi -1 (tidak ada baris yang dipilih)
        selectedIndex = -1;
    }

    private void populateList() {
        listMahasiswa.add(new Mahasiswa("2203999", "Amelia Zalfa Julianti", "Perempuan", "Menghafal urutan kartu remi dalam waktu singkat", "Matahari"));
        listMahasiswa.add(new Mahasiswa("2202292", "Muhammad Iqbal Fadhilah", "Laki-laki", "Bisa membuat suara alat musik tanpa alat musiknya", "Merkurius"));
        listMahasiswa.add(new Mahasiswa("2202346", "Muhammad Rifky Afandi", "Laki-laki", "Memiliki kemampuan menari tarian tradisional Mesir dengan sangat baik", "Venus"));
        listMahasiswa.add(new Mahasiswa("2210239", "Muhammad Hanif Abdillah", "Laki-laki", "Dapat membuat struktur bangunan kompleks dari korek api", "Mars"));
        listMahasiswa.add(new Mahasiswa("2202046", "Nurainun", "Perempuan", "Mampu menyanyikan lagu-lagu dalam bahasa alien yang diciptakannya sendiri", "Bumi"));
        listMahasiswa.add(new Mahasiswa("2205101", "Kelvin Julian Putra", "Laki-laki", "Bisa memperkirakan cuaca dengan mencium angin", "Jupiter"));
        listMahasiswa.add(new Mahasiswa("2200163", "Rifanny Lysara Annastasya", "Perempuan", "Memiliki kemampuan mengingat tanggal dan hari untuk setiap peristiwa yang pernah dialami", "Saturnus"));
        listMahasiswa.add(new Mahasiswa("2202869", "Revana Faliha Salma", "Perempuan", "Dapat menirukan suara hewan dengan sangat sempurna", "Neptunus"));
        listMahasiswa.add(new Mahasiswa("2209489", "Rakha Dhifiargo Hariadi", "Laki-laki", "Bisa membaca pikiran orang lain lewat gerakan alisnya", "Pluto"));
        listMahasiswa.add(new Mahasiswa("2203142", "Roshan Syalwan Nurilham", "Laki-laki", "Memiliki kemampuan membuat karya seni dari sisa-sisa makanan", "Matahari"));
        listMahasiswa.add(new Mahasiswa("2200311", "Raden Rahman Ismail", "Laki-laki", "Dapat berkomunikasi dengan hewan menggunakan gerakan tubuh", "Merkurius"));
        listMahasiswa.add(new Mahasiswa("2200978", "Ratu Syahirah Khairunnisa", "Perempuan", "Bisa memprediksi masa depan lewat mimpi", "Venus"));
        listMahasiswa.add(new Mahasiswa("2204509", "Muhammad Fahreza Fauzan", "Laki-laki", "Mampu menemukan benda yang hilang hanya dengan menyentuh benda terdekat", "Mars"));
        listMahasiswa.add(new Mahasiswa("2205027", "Muhammad Rizki Revandi", "Laki-laki", "Bisa membedakan air mineral berdasarkan rasa tanpa membaca label", "Bumi"));
        listMahasiswa.add(new Mahasiswa("2203484", "Arya Aydin Margono", "Laki-laki", "Memiliki kemampuan berbicara dengan hantu", "Jupiter"));
        listMahasiswa.add(new Mahasiswa("2200481", "Marvel Ravindra Dioputra", "Laki-laki", "Bisa mengetahui letak benda-benda tersembunyi dengan menyentuh tanah", "Saturnus"));
        listMahasiswa.add(new Mahasiswa("2209889", "Muhammad Fadlul Hafiizh", "Laki-laki", "Dapat mencium bau makanan dan mengetahui bahan-bahan yang digunakan dalam makanan tersebut", "Neptunus"));
        listMahasiswa.add(new Mahasiswa("2206697", "Rifa Sania", "Perempuan", "Memiliki kemampuan meramal cuaca dengan menggunakan daun teh", "Pluto"));
        listMahasiswa.add(new Mahasiswa("2207260", "Imam Chalish Rafidhul Haque", "Laki-laki", "Dapat melihat aura manusia dengan menatap mata mereka", "Matahari"));
        listMahasiswa.add(new Mahasiswa("2204343", "Meiva Labibah Putri", "Perempuan", "Bisa memperbaiki barang elektronik hanya dengan memandangi mereka dalam waktu yang lama", "Merkurius"));
    }
}
