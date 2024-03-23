# LP5DPBO2024C1

## Janji
Saya Ravindra Maulana Sahman dengan NIM 2108724 mengerjakan Latihan Praktikum 5 dalam mata kuliah DPBO untuk keberkahan-Nya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

## Deskripsi Tugas
Tugas:
1. Ketik ulang code di atas untuk melengkapi file Menu.java.
2. Tambahkan satu atribut baru di class Mahasiswa sekaligus component input-nya di form. (Usahakan setiap orang atribut barunya berbeda)
3. Tambah confirmation prompt sebelum delete.
4. Bonus (+20) Jika component baru yang ditambahkan bukan JTextField (Component baru berupa JComboBox, JSlider, JRadioButton, dsb).

## Desain Program
Program ini mempunyai 2 kelas diantaranya, class 'Mahasiswa' dan class 'Menu'.
Setiap atribut dari masing masing class juga memiliki Getter dan Setternya.

1. Mahasiswa
   Kelas Mahasiswa adalah representasi dari seorang mahasiswa dalam sebuah sistem informasi.
Pada class Mahasiswa terdapat 5 atribut :
* nim (String): Nomor Induk Mahasiswa.
* nama (String): Nama lengkap mahasiswa.
* jenisKelamin (String): Jenis kelamin mahasiswa.
* bakatAneh (String): Bakat aneh atau unik yang dimiliki oleh mahasiswa.
* asalPlanet (String): Nama planet asal mahasiswa (dalam konteks fiksi ilmiah).
2. Menu
  Kelas Menu adalah kelas utama yang bertanggung jawab untuk menampilkan antarmuka pengguna dan mengelola data mahasiswa dalam sebuah sistem informasi.
  Pada class Menu terdapat 10 atribut :
  * nimField (JTextField): Bidang input untuk NIM mahasiswa.
  * namaField (JTextField): Bidang input untuk nama mahasiswa.
  * jenisKelaminComboBox (JComboBox): Kotak kombinasi untuk memilih jenis kelamin mahasiswa.
  * bakatanehField (JTextField): Bidang input untuk bakat aneh mahasiswa.
  * asalPlanetComboBox (JComboBox): Kotak kombinasi untuk memilih asal planet mahasiswa.
  * mahasiswaTable (JTable): Tabel yang menampilkan data mahasiswa.
  * addUpdateButton (JButton): Tombol untuk menambahkan atau memperbarui data mahasiswa.
  * cancelButton (JButton): Tombol untuk membatalkan operasi saat menambahkan atau mengubah data mahasiswa.
  * deleteButton (JButton): Tombol untuk menghapus data mahasiswa.
  * titleLabel (JLabel): Label untuk judul menu.
  Kelas Menu memiliki Method :
* insertData(): Metode untuk menambahkan data mahasiswa baru ke dalam daftar.
* updateData(): Metode untuk memperbarui data mahasiswa yang sudah ada dalam daftar.
* deleteData(): Metode untuk menghapus data mahasiswa dari daftar.
* clearForm(): Metode untuk mengosongkan semua bidang input dan mengembalikan antarmuka ke kondisi awal.
* setTable(): Metode untuk mengatur dan mengisi tabel dengan data mahasiswa yang ada.
* populateList(): Metode untuk mengisi daftar mahasiswa dengan data awal.

## Alur Program
1. Jalankan program dengan menjalankan metode main pada kelas Menu.
2. Tambahkan data mahasiswa baru dengan mengisi bidang input dan mengklik tombol "Add".
3. Ubah data mahasiswa yang sudah ada dengan mengklik baris yang ingin diubah pada tabel, mengubah data di bidang input, dan mengklik tombol "Update".
4. Hapus data mahasiswa yang sudah ada dengan mengklik baris yang ingin dihapus pada tabel dan mengklik tombol "Delete".

## Dokumentasi
* Tampilan Awal
![Screenshot tampilan_awalpng](https://github.com/Ravindraa181/LP5DPBO2024C1/assets/100990733/e869087d-d3c7-43d7-91eb-b084b2d98238)
