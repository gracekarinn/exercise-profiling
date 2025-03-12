Nama: Grace Karina <br />
Kelas: B <br />
NPM: 2306275834

# Optimasi Performa Aplikasi dengan JMeter dan IntelliJ Profiler

## Perbedaan JMeter vs IntelliJ Profiler
JMeter digunakan untuk uji performa dengan simulasi beban pengguna. Fokusnya mengukur respons server di berbagai kondisi. Sedangkan IntelliJ Profiler membantu melihat penggunaan CPU, memori, dan thread secara real-time untuk menemukan bottleneck di kode.

## Manfaat Profiling
Profiling membantu mengidentifikasi fungsi atau bagian kode yang lambat, penggunaan memori yang boros, atau deadlock thread yang memperlambat aplikasi.

## Efektivitas IntelliJ Profiler
IntelliJ Profiler sangat efektif dalam menganalisis performa kode, terutama untuk melihat penggunaan CPU dan memori secara mendalam. Hal ini membantu menemukan akar penyebab masalah performa.

## Tantangan dalam Pengujian Performa & Profiling
Mengoptimisasi kode merupakan hal yang lumayan menantang karena saya harus mencari beberapa solusi dan run ulang profiler untuk mendapatkan hasil yang diinginkan.

## Keuntungan Menggunakan IntelliJ Profiler
- Visualisasi data yang jelas.
- Built-in jadi gausah download aplikasi lagi.
- Bisa melihat call stack dan alur eksekusi kode.
- Identifikasi bottleneck lebih cepat dan presisi.

## Menangani Perbedaan Hasil Profiling & JMeter
Tidak ada perbedaan yang signifikan pada saat saya menguji

## Strategi Optimasi Kode
1. **Hindari String Concatenation dalam Loop** - Gunakan `StringBuilder` agar lebih efisien.
2. **Kurangi Query ke Database** - Gunakan batch processing seperti `findByStudentIdIn()` untuk menghindari N+1 query.
3. **Gunakan Struktur Data yang Tepat** - Misalnya `Map` untuk lookup cepat dibandingkan iterasi dalam list.
4. **Gunakan Stream API untuk Operasi yang Lebih Efisien** - Misalnya `max()` untuk mencari nilai tertinggi tanpa loop manual.
5. **Reuse Object** - Kurangi alokasi objek baru untuk mengurangi beban Garbage Collection.
6. **Gunakan Caching** - Hindari query atau pemrosesan berulang dengan menerapkan caching.
7. **Profiling Berulang** - Cek dampak perubahan dengan profiling setelah optimasi.
8. **Load Testing Ulang** - Pastikan performa meningkat tanpa mengorbankan fungsionalitas.





## JMeter Result