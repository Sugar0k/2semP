package bla;

import java.io.*;
public class IO{ //Функции ввода-вывода
    public static boolean outLongFile(File file, long[ ] arr, int pos)
            throws IOException {
//Выводит числа long (8 байт каждое) из массива arr в файл file,
//начиная с позиции pos в файле, возвращает true,
// если вывод закончился успешно
        RandomAccessFile outpFile = null;
        boolean f = true; //для возврата
        try { //контролируем исключения при выводе данных
//открываем файл для чтения и записи:
            outpFile = new RandomAccessFile(file,"rw");
            outpFile.seek (pos); // устанавливаем указатель файла
// на заданную позицию
            for (int i = 0; i < arr.length; i++)
                outpFile.writeLong(arr[i]); // выводим очередное число (8 байт)
        }
        catch (Exception e) {f = false;}
        finally{ if(outpFile != null) outpFile.close();} //закрываем файл
        return f;
    }
    public static long[][] inpLongMatrFile(File file, int m, int pos)
            throws IOException {
// Возвращает ссылку на матрицу с элементами long
// размером m x m, введенную из файла file, начиная
// с позиции pos; при ошибке ввода-вывода возвращает null
        RandomAccessFile inpFile = null;
        long toRead; //счетчик байтов в файле
        long [][] matr = new long[m][m]; // создаем матрицу m x m
        try { //контролируем исключения при вводе данных
//открываем файл для чтения:
            inpFile = new RandomAccessFile(file, "r");
            inpFile.seek (pos); //устанавливаем указатель файла в
//заданную позицию
            toRead = inpFile.length() - pos + 1; //число байтов в файле, начиная
//с позиции pos
//Вводим числа из файла в матрицу:
            M1:{for (int i = 0; i < m; i++) // блок помечен меткой M1
                for (int j = 0; j < m; j++){
                    matr[i][j] = inpFile.readLong(); //введено очередное число
                    toRead -= 8; // уменьшаем число оставшихся байт на 8
                    if (toRead <= 0) break M1; //если данные в файле закончились,
//переход на конец блока, отмеченного меткой M1
                }
            } //Конец блока, отмеченного меткой M1
        } //try
        catch (Exception e) {matr = null;} //если исключение, вернем null
        finally{ if(inpFile != null) inpFile.close();} // закрываем файл
        return matr; //возвращаем ссылку на матрицу или null
    }
    public static long[ ] inpLongArrFile(File file) throws IOException {
//Вводит все данные из файла в одномерный long-массив,
//возвращает ссылку на массив или null (если было исключение)
//Число байтов в файле должно быть кратно 8,
//иначе метод вернет null (объясните, почему)
        RandomAccessFile inpFile = null;
        long toRead; // счетчик байтов в файле
        long [ ]arr = null;
        try {inpFile = new RandomAccessFile(file, "r");
            toRead = inpFile.length(); //длина файла в байтах
            arr = new long[(int) toRead / 8 + 1]; // создаем long-массив
            int i = 0;
            while (toRead > 0){ //пока в файле есть числа
                arr[i] = inpFile.readLong(); //прочли очередное число (8 байт)
                i = i + 1;
                toRead -= 8; // уменьшаем число оставшихся байтов на 8
            }
        }
        catch (Exception e) {arr = null;} //если исключение, вернем null
        finally{ if (inpFile != null) inpFile.close();} // закрываем файл
        return arr; //возвращаем ссылку на массив или null
    }
} // IOFile