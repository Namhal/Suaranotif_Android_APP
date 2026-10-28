# 🔊 Suara Notif

**Bacakan notifikasi dari aplikasi pilihanmu, tanpa perlu alat tambahan.**

[![Download APK](https://img.shields.io/badge/⬇_Download_APK-44A8EB?style=for-the-badge&logoColor=white)](https://github.com/Namhal/Suaranotif_Android_APP/releases/latest/download/SuaraNotif.apk)
&nbsp;
[![Semua versi](https://img.shields.io/badge/Semua_versi-0D3F5C?style=for-the-badge)](https://github.com/Namhal/Suaranotif_Android_APP/releases)

> Android 7.0 (Nougat) ke atas · Gratis · Tanpa iklan · Tanpa internet

---

## 📖 Tentang aplikasi

**Suara Notif** adalah aplikasi Android yang membuat HP-mu bersuara setiap kali ada notifikasi dari aplikasi yang kamu pilih. Aplikasi ini bisa dibuat membacakan isi notifikasi dengan suara, atau memutar file suara buatanmu sendiri.

### Kenapa dibuat?
Banyak pemilik warung dan toko memakai **QRIS (GoPay, dll.)** dan membutuhkan pengingat suara ketika ada pembayaran masuk, misalnya *"Pembayaran diterima seratus ribu rupiah"*. Alat speaker khusus dari penyedia QRIS umumnya disewa dengan biaya bulanan atau tahunan. Dengan Suara Notif, **HP yang sudah kamu punya bisa berfungsi sebagai alat itu, gratis.**

### Fitur
| Fitur | Keterangan |
|---|---|
| 🎯 **Pilih aplikasi** | Tentukan aplikasi mana saja yang notifikasinya diproses |
| 🗣️ **Dibacakan** | Judul dan isi notifikasi dibacakan dengan suara Indonesia |
| 🎵 **Suara sendiri** | Pilih file audio (mp3, wav, dll.) untuk tiap aplikasi |
| ⚙️ **Default** | Aplikasi tidak ikut campur, suara bawaan aplikasi tetap dipakai |
| 🌙 **Layar mati** | Tetap berbunyi saat layar HP dimatikan (tombol power) |
| 🔁 **Anti dobel** | Notifikasi yang sama dalam 3 detik tidak dibacakan dua kali |
| 🔍 **Cari aplikasi** | Kolom pencarian untuk menemukan aplikasi dengan cepat |

---

## 🚀 Cara pakai

### Langkah 1 · Download dan install

1. Di HP Android, ketuk tombol **Download APK** di atas.
2. Buka file `SuaraNotif.apk` yang sudah terunduh.
3. Kalau muncul peringatan *"Pemasangan dari sumber tidak dikenal"*, ketuk **Pengaturan**, aktifkan **Izinkan dari sumber ini**, lalu kembali dan ketuk **Install**.
4. Kalau muncul peringatan Play Protect, ketuk **Install saja** (*Install anyway*).

> Kodenya terbuka dan bisa kamu periksa sendiri di repository ini.

### Langkah 2 · Berikan izin akses notifikasi (wajib)

1. Buka aplikasi **Suara Notif**.
2. Ketuk tombol **Izin Akses**.
3. Aktifkan sakelar **Suara Notif**, lalu ketuk **Izinkan** pada konfirmasi.
4. Kembali ke aplikasi. Teks di bagian atas harus berubah menjadi **"Akses notifikasi aktif ✓"**.

> ❗ **Sakelar abu-abu, tidak bisa diaktifkan, atau muncul "Aplikasi tidak diberi akses"?**
> Itu fitur keamanan Android, bukan kerusakan aplikasi. Lihat solusinya di [Pemecahan masalah #1](#1-izin-akses-notifikasi-tidak-bisa-diaktifkan-abu-abu--aplikasi-tidak-diberi-akses).

### Langkah 3 · Matikan penghematan baterai (wajib supaya tetap bunyi saat layar mati)

1. Di aplikasi, ketuk **Baterai**, lalu pilih **Izinkan**.
2. Lanjutkan pengaturan sesuai merek HP-mu di bagian [Pengaturan per merek HP](#-pengaturan-per-merek-hp).

### Langkah 4 · Tes suara

Ketuk **Tes Suara**. Kalau terdengar suara membaca *"Pembayaran diterima sebesar seratus ribu rupiah"*, berarti suara siap. Kalau tidak terdengar, lihat [masalah #4](#4-tes-suara-tidak-bersuara).

### Langkah 5 · Pilih aplikasi dan mode suara

1. Cari aplikasi yang ingin dibacakan, misalnya **GoPay Merchant** atau **GoBiz**.
2. Ketuk menu di bawah nama aplikasi, lalu pilih mode:

| Mode | Fungsi |
|---|---|
| **Default (bawaan aplikasi)** | Aplikasi ini tidak melakukan apa-apa |
| **Dibacakan** | Isi notifikasi dibacakan dengan suara |
| **Suara sendiri** | Memutar file audio pilihanmu. Ketuk **Pilih file suara** untuk memilih file |

3. Aplikasi yang modenya bukan *Default* otomatis muncul paling atas saat aplikasi dibuka berikutnya.

### Langkah 6 · Uji sampai yakin

1. Ubah mode aplikasi yang dipilih menjadi **Dibacakan**.
2. Picu satu notifikasi, misalnya kirim chat ke diri sendiri atau lakukan transaksi QRIS nominal kecil.
3. **Matikan layar** (tekan tombol power), tunggu 1-2 menit, lalu picu notifikasi lagi. Suara harus tetap terdengar.

---

## 📱 Pengaturan per merek HP

Beberapa merek HP sering menutup aplikasi di latar belakang. Lakukan pengaturan sesuai HP-mu supaya aplikasi tidak mati sendiri.

### Xiaomi / Redmi / POCO (HyperOS atau MIUI)
1. **Pengaturan → Aplikasi → Kelola aplikasi → Suara Notif → Hemat baterai → Tanpa batasan**.
2. Di halaman yang sama, aktifkan **Mulai otomatis** (*Autostart*).
3. Buka **Aplikasi terbaru**, tahan kartu Suara Notif, lalu ketuk ikon **gembok 🔒**.
4. **Info aplikasi → Notifikasi**: izinkan semua.

### Samsung (One UI)
1. **Pengaturan → Baterai → Batas penggunaan di latar belakang**, lalu matikan **Tidurkan aplikasi yang tidak digunakan**.
2. Pada **Aplikasi yang tidak pernah tidur**, tambahkan **Suara Notif**.
3. **Info aplikasi → Baterai → Tidak dibatasi**.

### Oppo / Realme / OnePlus (ColorOS atau OxygenOS)
1. **Info aplikasi → Penggunaan baterai → Izinkan aktivitas latar belakang** dan **Izinkan aktivitas otomatis**.
2. **Pengaturan → Baterai → Optimalisasi baterai**, lalu pilih **Suara Notif → Jangan optimalkan**.
3. Kunci aplikasi di **Aplikasi terbaru** (ikon gembok).

### Vivo / iQOO (Funtouch atau OriginOS)
1. **Pengaturan → Baterai → Konsumsi daya latar belakang**, lalu pilih **Suara Notif → Izinkan**.
2. **Pengaturan → Aplikasi → Autostart**, lalu aktifkan **Suara Notif**.

### Infinix / Tecno / Itel
1. **Manajer Telepon → Autostart**, lalu aktifkan **Suara Notif**.
2. **Pengaturan → Baterai → Optimalisasi baterai**, lalu pilih **Suara Notif → Jangan optimalkan**.

### Google Pixel / Android murni
1. **Info aplikasi → Baterai → Tidak dibatasi**.

> Menunya berbeda di HP-mu? Cari di Google: *"cara agar aplikasi tidak dimatikan di latar belakang [merek HP-mu]"*.

---

## 🛠️ Pemecahan masalah

### 1. Izin akses notifikasi tidak bisa diaktifkan (abu-abu / "Aplikasi tidak diberi akses")

**Gejala:** Di Pengaturan, sakelar *Izinkan akses notifikasi* berwarna abu-abu dan bertuliskan *"Dikontrol oleh Setelan Terbatas"*. Atau muncul jendela *"Aplikasi tidak diberi akses"*, sehingga status di aplikasi tetap *"Akses notifikasi belum aktif"*.

**Penyebab:** Android 13 ke atas memblokir izin sensitif untuk aplikasi yang diinstal dari file APK (bukan dari Play Store). Fitur ini bernama **Setelan Terbatas**, dan bisa dibuka dengan sekali pengaturan.

**Solusi A: lewat Info aplikasi (paling mudah)**
1. Ketuk **Tutup** pada jendela peringatan.
2. Buka **Pengaturan → Aplikasi → Kelola aplikasi → Suara Notif**. Atau tahan lama ikon aplikasi di layar utama, lalu pilih **Info aplikasi**.
3. Ketuk **titik tiga (⋮)** di pojok kanan atas.
4. Pilih **Izinkan setelan terbatas**, lalu konfirmasi dengan PIN, sidik jari, atau **Izinkan**.
5. Buka kembali aplikasi, ketuk **Izin Akses**, lalu aktifkan sakelarnya. Sakelar sudah tidak abu-abu lagi.

> Menu ⋮ biasanya baru muncul **setelah kamu pernah mencoba mengaktifkan izin tadi**. Kalau belum muncul, buka halaman izin akses notifikasi, ketuk sakelar yang abu-abu sampai muncul peringatan, lalu ulangi dari langkah 2.

**Solusi B: install ulang lewat File Manager**
1. Hapus aplikasi Suara Notif.
2. Buka file APK dari aplikasi **File Manager / Berkas** bawaan HP, **bukan dari WhatsApp, Telegram, atau browser**.
3. Install, lalu berikan izin seperti di Langkah 2.

> Cara ini sering membuat Android tidak memasang label "terbatas".

**Solusi C: lewat laptop (pasti berhasil)**
1. Di HP, aktifkan **Opsi pengembang**: **Pengaturan → Tentang ponsel**, ketuk **Versi/Nomor build** 7 kali.
2. Masuk ke **Opsi pengembang**, lalu aktifkan **Debugging USB**.
3. Sambungkan HP ke laptop dengan kabel USB dan izinkan debugging di HP.
4. Di laptop yang sudah terpasang [ADB](https://developer.android.com/tools/releases/platform-tools), jalankan:
   ```
   adb shell appops set com.suaranotif ACCESS_RESTRICTED_SETTINGS allow
   ```
5. Aktifkan izin akses notifikasi seperti biasa.

### 2. Status tetap "Akses notifikasi belum aktif" padahal sudah diaktifkan
- Tutup aplikasi sepenuhnya lalu buka lagi (status diperbarui saat aplikasi dibuka).
- Buka **Pengaturan → Notifikasi → Akses notifikasi** dan pastikan **Suara Notif** menyala.
- Matikan lalu nyalakan lagi sakelarnya.
- Restart HP.

### 3. Notifikasi masuk tapi tidak dibacakan
Periksa satu per satu:
- [ ] Sakelar utama di aplikasi dalam keadaan **hidup**.
- [ ] Mode aplikasi yang dituju adalah **Dibacakan** atau **Suara sendiri**, bukan *Default*.
- [ ] Status aplikasi **"Akses notifikasi aktif ✓"**.
- [ ] **Volume media** tidak nol (aplikasi ini memakai volume media, bukan volume dering).
- [ ] Mode **Jangan Ganggu** dimatikan.
- [ ] Notifikasi aplikasi asal tidak dimatikan di pengaturan HP. Kalau notifikasinya diblokir, aplikasi ini tidak bisa membacanya.
- [ ] Notifikasi bukan jenis *ongoing* (yang menetap, seperti pemutar musik). Notifikasi seperti ini sengaja diabaikan.

### 4. Tes Suara tidak bersuara
- Naikkan **volume media**.
- Install atau perbarui **Speech Services by Google** (*Layanan Ucapan Google*) di Play Store.
- Buka **Pengaturan → Sistem → Bahasa & input → Output text-to-speech**, pilih **Layanan Ucapan Google**, lalu pastikan bahasa **Indonesia** terunduh.
- Kalau memakai headset atau Bluetooth, lepas sambungannya untuk menguji lewat speaker HP.

### 5. Suara hanya berbunyi saat layar menyala, mati saat layar dimatikan
Penyebabnya hampir selalu penghematan baterai. Lakukan:
1. Ketuk tombol **Baterai** di aplikasi, lalu **Izinkan**.
2. Ikuti [Pengaturan per merek HP](#-pengaturan-per-merek-hp).
3. Kunci aplikasi di **Aplikasi terbaru** (ikon gembok).
4. Matikan mode **Hemat Baterai** / **Ultra Hemat** di HP.

### 6. Suara berhenti bekerja setelah beberapa jam atau esok hari
- Pastikan **Autostart** aktif dan baterai diatur **Tanpa batasan** (lihat bagian merek HP).
- Pastikan aplikasi tidak ikut tertutup saat kamu membersihkan semua aplikasi. Kunci dengan ikon gembok di *Aplikasi terbaru*.
- Di **Pengaturan → Notifikasi → Akses notifikasi**, matikan lalu nyalakan lagi **Suara Notif** untuk memulai ulang layanannya.
- Biarkan HP tetap tercolok pengisi daya jika dipakai sepanjang hari.

### 7. Terdengar dua suara sekaligus (suara bawaan aplikasi dan suara Suara Notif)
Suara bawaan aplikasi asal (misalnya GoPay) tetap berbunyi bersamaan. Matikan suaranya di:
**Info aplikasi (mis. GoPay Merchant) → Notifikasi → pilih kategori notifikasi → Suara → Tanpa suara.**

### 8. Pembayaran dibacakan terlalu cepat, atau nominal terdengar aneh
Pengucapan angka mengikuti mesin suara bawaan HP. Untuk hasil terbaik:
- Perbarui **Speech Services by Google**.
- Atur kecepatan bicara di **Pengaturan → Bahasa & input → Output text-to-speech → Kecepatan bicara**.
- Kalau masih kurang cocok, gunakan mode **Suara sendiri** dengan rekaman pendek seperti *"Pembayaran masuk"*.

### 9. Mode "Suara sendiri" tidak berbunyi
- Pastikan sudah memilih file lewat tombol **Pilih file suara** (tertulis *"✓ Suara dipilih"*).
- Gunakan format umum: **mp3, wav, m4a, ogg**.
- Kalau file dipindahkan atau dihapus, pilih ulang filenya.
- Jika file gagal diputar, aplikasi otomatis membacakan notifikasi dengan suara sebagai cadangan.

### 10. Aplikasi yang kucari tidak muncul di daftar
- Hanya aplikasi yang punya ikon di layar utama yang tampil.
- Gunakan kolom **Cari aplikasi…** di atas daftar.
- Kalau aplikasi baru diinstal, tutup dan buka lagi Suara Notif.

### 11. Tidak bisa install APK ("Aplikasi tidak terpasang" / "Gagal parsing")
- Unduh ulang filenya sampai selesai. File bisa rusak kalau unduhan terputus.
- Pastikan ruang penyimpanan HP cukup.
- Hapus versi lama Suara Notif sebelum memasang versi baru, jika terjadi konflik.
- Pastikan HP berbasis Android 7.0 atau lebih baru.

### 12. Muncul peringatan Play Protect / "Aplikasi berbahaya"
Karena aplikasi ini tidak ada di Play Store, Google menampilkan peringatan standar. Ketuk **Detail → Install saja**.

---

## 🔐 Privasi

- Aplikasi ini **tidak memakai internet** dan tidak mengirim data ke mana pun.
- Isi notifikasi hanya dibaca di HP-mu dan langsung dibacakan, tanpa disimpan.
- Pengaturan (aplikasi yang dipilih dan file suaramu) tersimpan lokal di HP.

---
