package lab9_2;

import java.io.*;
public class IOFile{ //Функции ввода-вывода
    public static boolean outBooleanRAFile(File file, boolean[] arr, int pos) throws IOException {
        //Выводит числа double (8 байт каждое) из массива arr в файл file,
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
                outpFile.writeBoolean(arr[i]); // выводим очередное число (8 байт)
        }
        catch (Exception e) {f = false;}
        finally{ if(outpFile != null) outpFile.close();} //закрываем файл
        return f;
    }

    public static boolean[][] inpBooleanMatrRAFile(File file, int m, int pos) throws IOException {
        RandomAccessFile inpFile = null;
        long toRead;
        boolean[][] matr = new boolean[m][m];
        try {
            inpFile = new RandomAccessFile(file, "r");
            inpFile.seek (pos);
            toRead = inpFile.length() - pos + 1; //число байтов в файле, начиная
            //с позиции pos
            //Вводим числа из файла в матрицу:
            M1:{for (int i = 0; i < m; i++) // блок помечен меткой M1
                for (int j = 0; j < m; j++){
                    matr[i][j] = inpFile.readBoolean(); //введено очередное число
                    toRead -= 7; // уменьшаем число оставшихся байт на 8
                    if (toRead <= 0) break M1; //если данные в файле закончились,
                    //переход на конец блока, отмеченного меткой M1
                }
            } //Конец блока, отмеченного меткой M1
        } //try
        catch (Exception e) {matr = null;} //если исключение, вернем null
        finally{ if(inpFile != null) inpFile.close();} // закрываем файл
        return matr; //возвращаем ссылку на матрицу или null
    }
    public static boolean[] inpBooleanArrRAFile(File file) throws IOException {
        RandomAccessFile inpFile = null;
        long toRead; // счетчик байтов в файле
        boolean[] arr = null;
        try {
            inpFile = new RandomAccessFile(file, "r");
            toRead = inpFile.length();
            arr = new boolean[(int) toRead];
            int i = 0;
            while (toRead > 0){
                arr[i] = inpFile.readBoolean();
                i = i + 1;
                toRead -= 1;

            }
        }
        catch (Exception e) {arr = null;} //если исключение, вернем null
        finally{ if (inpFile != null) inpFile.close();} // закрываем файл
        return arr; //возвращаем ссылку на массив или null
    }
}