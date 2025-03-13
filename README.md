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

`all-student` before optimization:

JMeter:
- View Results Tree
![Screenshot 2025-03-13 at 10.28.54.png](public/Screenshot%202025-03-13%20at%2010.28.54.png)
- View Results in Table
![Screenshot 2025-03-13 at 10.28.59.png](public/Screenshot%202025-03-13%20at%2010.28.59.png)
- Summary Report
![Screenshot 2025-03-13 at 10.29.05.png](public/Screenshot%202025-03-13%20at%2010.29.05.png)
- Graph Results
![Screenshot 2025-03-13 at 10.29.10.png](public/Screenshot%202025-03-13%20at%2010.29.10.png)
- CLI
```aiignore
timeStamp,elapsed,label,responseCode,responseMessage,threadName,dataType,success,failureMessage,bytes,sentBytes,grpThreads,allThreads,URL,Latency,IdleTime,Connect
1741835969253,159842,all-student request,200,,Thread Group 1-2,text,true,,2753178,127,10,10,http://localhost:8080/all-student,159810,0,1
1741835969552,159553,all-student request,200,,Thread Group 1-5,text,true,,2753178,127,10,10,http://localhost:8080/all-student,159540,0,1
1741835969452,160001,all-student request,200,,Thread Group 1-4,text,true,,2753178,127,8,8,http://localhost:8080/all-student,159994,0,1
1741835969353,160248,all-student request,200,,Thread Group 1-3,text,true,,2753178,127,7,7,http://localhost:8080/all-student,160243,0,1
1741835969214,160949,all-student request,200,,Thread Group 1-1,text,true,,2753178,127,6,6,http://localhost:8080/all-student,160943,0,13
1741835969952,160301,all-student request,200,,Thread Group 1-9,text,true,,2753178,127,5,5,http://localhost:8080/all-student,160294,0,1
1741835969854,160550,all-student request,200,,Thread Group 1-8,text,true,,2753178,127,4,4,http://localhost:8080/all-student,160543,0,1
1741835970054,160544,all-student request,200,,Thread Group 1-10,text,true,,2753178,127,3,3,http://localhost:8080/all-student,160538,0,1
1741835969652,161031,all-student request,200,,Thread Group 1-6,text,true,,2753178,127,2,2,http://localhost:8080/all-student,161024,0,1
1741835969755,161026,all-student request,200,,Thread Group 1-7,text,true,,2753178,127,1,1,http://localhost:8080/all-student,161020,0,1
```

Profiler:
![Screenshot 2025-03-13 at 10.35.09 (2).png](public/Screenshot%202025-03-13%20at%2010.35.09%20%282%29.png)

After optimization:

JMeter
![Screenshot 2025-03-13 at 11.06.11.png](public/Screenshot%202025-03-13%20at%2011.06.11.png)

Profiler:
![Screenshot 2025-03-13 at 11.07.38 (2).png](public/Screenshot%202025-03-13%20at%2011.07.38%20%282%29.png)

| Before  | After  | Percentage |
|---------|--------|------------|
| 7059 ms | 500 ms | 92.91%     |

`all-student-name` before optimization:

JMeter:
- View Results Tree
![Screenshot 2025-03-13 at 10.05.54.png](public/Screenshot%202025-03-13%20at%2010.05.54.png)
- View Results in Table
![Screenshot 2025-03-13 at 10.05.59.png](public/Screenshot%202025-03-13%20at%2010.05.59.png)
- Summary Report
![Screenshot 2025-03-13 at 10.06.04.png](public/Screenshot%202025-03-13%20at%2010.06.04.png)
- Graph Results
![Screenshot 2025-03-13 at 10.06.09.png](public/Screenshot%202025-03-13%20at%2010.06.09.png)
- CLI
```aiignore
1741835764878,2320,all-student-name request,200,,Thread Group 1-4,text,true,,312371,132,10,10,http://localhost:8080/all-student-name,2294,0,0
1741835764637,2560,all-student-name request,200,,Thread Group 1-1,text,true,,312371,132,10,10,http://localhost:8080/all-student-name,2535,0,13
1741835764677,2520,all-student-name request,200,,Thread Group 1-2,text,true,,312371,132,10,10,http://localhost:8080/all-student-name,2495,0,1
1741835764777,2420,all-student-name request,200,,Thread Group 1-3,text,true,,312371,132,10,10,http://localhost:8080/all-student-name,2395,0,1
1741835765179,2141,all-student-name request,200,,Thread Group 1-7,text,true,,312371,132,6,6,http://localhost:8080/all-student-name,2140,0,1
1741835764978,2367,all-student-name request,200,,Thread Group 1-5,text,true,,312371,132,5,5,http://localhost:8080/all-student-name,2366,0,1
1741835765276,2083,all-student-name request,200,,Thread Group 1-8,text,true,,312371,132,4,4,http://localhost:8080/all-student-name,2082,0,1
1741835765077,2285,all-student-name request,200,,Thread Group 1-6,text,true,,312371,132,3,3,http://localhost:8080/all-student-name,2283,0,1
1741835765377,2002,all-student-name request,200,,Thread Group 1-9,text,true,,312371,132,2,2,http://localhost:8080/all-student-name,1999,0,1
1741835765482,1905,all-student-name request,200,,Thread Group 1-10,text,true,,312371,132,1,1,http://localhost:8080/all-student-name,1904,0,3
```

Profiler:
![Screenshot 2025-03-13 at 10.37.22 (2).png](public/Screenshot%202025-03-13%20at%2010.37.22%20%282%29.png)

After optimitization:

JMeter:
![Screenshot 2025-03-13 at 11.20.14.png](public/Screenshot%202025-03-13%20at%2011.20.14.png)
Profiler:
![Screenshot 2025-03-13 at 11.22.16.png](public/Screenshot%202025-03-13%20at%2011.22.16.png)

| Before | After  | Percentage |
|--------|--------|------------|
| 785 ms | 180 ms | 77.07%     |


`highest-gpa` before optimization:

JMeter:
- View Results Tree
![Screenshot 2025-03-13 at 10.08.04.png](public/Screenshot%202025-03-13%20at%2010.08.04.png)
- View Results in Table
![Screenshot 2025-03-13 at 10.08.09.png](public/Screenshot%202025-03-13%20at%2010.08.09.png)
- Summary Report
![Screenshot 2025-03-13 at 10.08.13.png](public/Screenshot%202025-03-13%20at%2010.08.13.png)
- Graph Results
![Screenshot 2025-03-13 at 10.08.18.png](public/Screenshot%202025-03-13%20at%2010.08.18.png)
- CLI
```aiignore
timeStamp,elapsed,label,responseCode,responseMessage,threadName,dataType,success,failureMessage,bytes,sentBytes,grpThreads,allThreads,URL,Latency,IdleTime,Connect
1741794536795,30883,all-student request,500,,Thread Group 1-1,text,false,,256,127,10,10,http://localhost:8080/all-student,30872,0,22
1741794536796,31132,all-student request,500,,Thread Group 1-2,text,false,,256,127,9,9,http://localhost:8080/all-student,31132,0,22
1741794536893,31201,all-student request,500,,Thread Group 1-3,text,false,,256,127,8,8,http://localhost:8080/all-student,31200,0,1
1741794536993,31257,all-student request,500,,Thread Group 1-4,text,false,,256,127,7,7,http://localhost:8080/all-student,31257,0,1
1741794537093,31255,all-student request,500,,Thread Group 1-5,text,false,,256,127,6,6,http://localhost:8080/all-student,31254,0,0
1741794537192,31256,all-student request,500,,Thread Group 1-6,text,false,,256,127,5,5,http://localhost:8080/all-student,31256,0,2
1741794537292,31269,all-student request,500,,Thread Group 1-7,text,false,,256,127,4,4,http://localhost:8080/all-student,31269,0,1
1741794537392,31264,all-student request,500,,Thread Group 1-8,text,false,,256,127,3,3,http://localhost:8080/all-student,31264,0,1
1741794537492,31266,all-student request,500,,Thread Group 1-9,text,false,,256,127,2,2,http://localhost:8080/all-student,31266,0,1
1741794537591,31464,all-student request,500,,Thread Group 1-10,text,false,,256,127,1,1,http://localhost:8080/all-student,31464,0,1
1741835902507,131,highest-gpa request,200,,Thread Group 1-1,text,true,,274,127,2,2,http://localhost:8080/highest-gpa,126,0,13
1741835902543,107,highest-gpa request,200,,Thread Group 1-2,text,true,,274,127,3,3,http://localhost:8080/highest-gpa,107,0,1
1741835902643,95,highest-gpa request,200,,Thread Group 1-3,text,true,,274,127,1,1,http://localhost:8080/highest-gpa,95,0,1
1741835902743,107,highest-gpa request,200,,Thread Group 1-4,text,true,,274,127,2,2,http://localhost:8080/highest-gpa,107,0,1
1741835902843,97,highest-gpa request,200,,Thread Group 1-5,text,true,,274,127,1,1,http://localhost:8080/highest-gpa,97,0,1
1741835902943,110,highest-gpa request,200,,Thread Group 1-6,text,true,,274,127,2,2,http://localhost:8080/highest-gpa,110,0,1
1741835903047,97,highest-gpa request,200,,Thread Group 1-7,text,true,,274,127,2,2,http://localhost:8080/highest-gpa,97,0,1
1741835903144,98,highest-gpa request,200,,Thread Group 1-8,text,true,,274,127,2,2,http://localhost:8080/highest-gpa,98,0,0
1741835903243,98,highest-gpa request,200,,Thread Group 1-9,text,true,,274,127,1,1,http://localhost:8080/highest-gpa,98,0,1
1741835903343,99,highest-gpa request,200,,Thread Group 1-10,text,true,,274,127,1,1,http://localhost:8080/highest-gpa,99,0,1
```

Profiler:
![Screenshot 2025-03-13 at 10.38.49 (2).png](public/Screenshot%202025-03-13%20at%2010.38.49%20%282%29.png)


After optimitization:

JMeter:
![Screenshot 2025-03-13 at 11.25.03.png](public/Screenshot%202025-03-13%20at%2011.25.03.png)
Profiler:
![Screenshot 2025-03-13 at 11.26.42.png](public/Screenshot%202025-03-13%20at%2011.26.42.png)

| Before | After | Percentage |
|--------|-------|------------|
| 180 ms | 90 ms | 50%        |