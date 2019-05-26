package lab9_2;

import java.io.*;
import java.util.Random;
public class Demo{
    public static void main (String args[ ]) {
        int n = 7, m = 5; String t = "boolean";
        File f1 = new File("Matr/matr_" + n + "_" + m + "_" + t + ".bin");
        System.out.printf ("В файл выводятся %s матриц %sx%s c элементами типа %s\n", n, m, m, t);
        Random r = new Random();
        boolean[] arr = new boolean[n*m*m];
        for (int i = 0; i < arr.length; i++)
            arr[i] = r.nextBoolean();
        try{
            //-------------------вывод--------------------------------------------------------------------
            IOFile.outBooleanRAFile(f1, arr, 0);
            //----------------ввод всего файла и контроль-----------------------------------
            //очистка arr:
            for (int i = 0; i < arr.length; i++) arr[i] = false;
            //ввод в одномерный массив всех чисел из файла
            System.out.printf ("Содержимое файла %s, интерпретированное как Boolean-значения:\n", f1.getName());
            arr = IOFile.inpBooleanArrRAFile(f1);
            MatrProc.putArr (arr, m * m);
            //--------ввод из файла третьей и седьмой матрицы--------------------
            boolean[][] matr1= IOFile.inpBooleanMatrRAFile(f1, m, m * m  * (3 - 1));
            System.out.println ("Введена матрица номер 3:");
            MatrProc.putMatr(matr1); //выводим матрицу в окно терминала
            boolean[][] matr2 = IOFile.inpBooleanMatrRAFile(f1, m, m * m * (4 - 1));
            System.out.println ("Введена матрица номер 7:");
            MatrProc.putMatr(matr2); //выводим матрицу в окно терминала
            //вычисление суммы матриц
            matr1 = MatrProc.sumTwoMatr(matr1, matr2);
            System.out.println ("Сумма матриц:");
            MatrProc.putMatr(matr1);
            //--------------Вывод результирующей матрицы в файл-------------------
            //-------------------------на место третьей матрицы-----------------------------
            boolean[ ] arr1 = MatrProc.matrToArr(matr1); //преобразуем матрицу
            // в массив
            System.out.println ("После преобразования матрицы в массив:");
            MatrProc.putArr(arr1,m * m); //выводим на терминал
            IOFile.outBooleanRAFile(f1, arr1, m * m  * (3 - 1)); //выводим в файл
            //----------------ввод всего файла и контроль------------------------------------
            //очистка arr:
            for (int i = 0; i < arr.length; i++) arr[i] = false;

            //ввод в одномерный массив всех чисел из файла
            System.out.printf (
                    "Новое содержимое файла %s, интерпретированное как double-значения:\n",
                    f1.getName());
            arr = IOFile.inpBooleanArrRAFile(f1);
            MatrProc.putArr(arr,m * m); //вывод на терминал
        } catch (Exception e) { } finally{ }
    }
}