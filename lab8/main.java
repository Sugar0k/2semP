package lab8;
import java.io.*;

public class main {
    public static void main (String[] args) throws IOException {
        String fileName;
        String line="";
        String flag="";
        double[][] matr;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("Введите имя файла для ввода матрицы");
            fileName = (br.readLine()).trim();
            matr = IO.inpMatr(fileName);
            if (matr != null){
                System.out.println ("Матрица введена успешно");
                IntellectMatr imatr = new IntellectMatr(matr);
                System.out.println("Введена матрица:");
                imatr.putMatr();
                System.out.println("Вектор суммы положительных элементов столбцов");
                IO.putArr(imatr.getVector());
                System.out.println("Все положительные элементы матрици -5");
                imatr.decNumber(5);
                imatr.putMatr();
                System.out.println("Удаляет столбци матрици в которых есть трицательные элементы");
                imatr.delNegativCol();
                imatr.putMatr();
                System.out.println("Введите имя файла для вывода матрицы");
                fileName = (br.readLine()).trim();
                if (IO.outMatr(fileName, imatr.getMatr()))
                    System.out.println ("Успешный вывод");
            }
            System.out.println("Продолжить?: Да - <Enter>, Нет - <n>");
            flag = br.readLine().trim();
        } while(!flag.equals("n"));
    }
}



