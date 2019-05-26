package bla;

import java.io.*;
import java.util.Random;
public class Demo{
    public static void main (String args[]) {
        int n = 4, m = 4; String t = "long";
//В папке проекта предварительно должна быть создана папка Matr
        File f1 = new File("Matr/matr_" + n + "_" + m + "_" + t + ".bin"); //файл
        System.out.printf (
                "В файл выводятся %d матриц %dx%d c элементами типа %s\n",
                n, m, m, t);
//Формирование элементов матриц
        Random r = new Random(); //генератор псевдо-случайных чисел
        long [] arr = new long[n*m*m]; //всего чисел для вывода в файл
        for (int i = 0; i < arr.length; i++)
            arr[i] = r.nextInt(99999999); //получаем очередное число
        try{
//-------------------вывод--------------------------------------------------------------------
            IO.outLongFile(f1, arr, 0);
//----------------ввод всего файла и контроль-----------------------------------
//очистка arr:
            for (int i = 0; i < arr.length; i++) arr[i] = 0;
//ввод в одномерный массив всех чисел из файла
            System.out.printf (
                    "Содержимое файла %s, интерпретированное как long-значения:\n",
                    f1.getName());
            arr = IO.inpLongArrFile(f1);
            MatrProc.putArr (arr, m * m); //выводим массив arr в окно терминала
//--------ввод из файла 1 и 3 матрицы--------------------
            long[][] matr1= IO.inpLongMatrFile(f1, m, m * m * 8 * (1 - 1));
            System.out.println ("Введена матрица номер 1:");
            MatrProc.putMatr(matr1); //выводим матрицу в окно терминала
            System.out.printf ("Сумма элементов матрицы: %10s\n",
                    MatrProc.sumElMatr(matr1));
            long[][] matr2 = IO.inpLongMatrFile(f1, m, m * m * 8 * (3 - 1));
            System.out.println ("Введена матрица номер 3:");
            MatrProc.putMatr(matr2); //выводим матрицу в окно терминала
            System.out.printf ("Сумма элементов матрицы: %10s\n",
                    MatrProc.sumElMatr(matr2));
//вычисление суммы матриц
            matr1 = MatrProc.sumTwoMatr(matr1, matr2);
            System.out.println ("Сумма матриц:");
            MatrProc.putMatr(matr1);
//--------------Вывод результирующей матрицы в файл-------------------
//-------------------------на место третьей матрицы-----------------------------
            long[] arr1 = MatrProc.matrToArr(matr1); //преобразуем матрицу
// в массив
            System.out.println ("После преобразования матрицы в массив:");
            MatrProc.putArr(arr1,m * m); //выводим на терминал
            IO.outLongFile(f1, arr1, m * m * 8 * (3 - 1)); //выводим в файл
//----------------ввод всего файла и контроль------------------------------------
//очистка arr:
            for (int i = 0; i < arr.length; i++) arr[i] = 0;
//ввод в одномерный массив всех чисел из файла
            System.out.printf (
                    "Новое содержимое файла %s, интерпретированное как long-значения:\n",
                    f1.getName());
            arr = IO.inpLongArrFile(f1);
            MatrProc.putArr(arr,m * m); //вывод на терминал
        } catch (Exception e) { } finally{ }
    } //main
} //Demo