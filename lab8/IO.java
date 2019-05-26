package lab8;

import java.io.*;

public class IO {
    public static double[][] inpMatr (String fileName) throws IOException {
        double[][] matr;
        String line;
        int i = 0;
        String[] numbers;
        int n;
        int m;
        BufferedReader inp = null;
        try {
            inp = new BufferedReader(new FileReader(fileName));
            while ((line = inp.readLine()) != null) if (!line.trim().equals("")) break;
            try {
                if (line == null) throw new MyException(
                        String.format ("Файл %s пуст ", fileName));
                numbers = line.trim().split("\\s+");
                if (numbers.length < 2) throw new MyException(
                        String.format("В файле %s не задано число столбцов матрицы", fileName));
                n = Integer.parseInt(numbers[0]); m = Integer.parseInt(numbers[1]);
                if ((n <= 0) || (m <= 0)) throw new MyException(
                        String.format("В файле %s неправильно задано число строк или столбцов матрицы",fileName));
                matr = new double[n][m];
                while ((line = inp.readLine()) != null) {
                    line = line.trim();
                    if (line.equals("")) continue;
                    numbers = line.split("\\s+");
                    if (numbers.length < m) throw new MyException(
                            String.format("В строке %d матрицы из файла %s не хватает чисел", i, fileName));
                    for(int j = 0; j < m; j++)matr[i][j] = Double.parseDouble(numbers[j]);
                    i++;
                    if (i == n) break;
                }
                if (i < n) throw new MyException(
                        String.format("В файле %s не хватает строк", fileName));
            }
            catch (MyException e){
                System.out.println (e); return null;}
            catch (NumberFormatException e){
                System.out.printf ("В строке %d матрицы из файла %s", i, fileName);
                System.out.println (" обнаружена недопустимая последовательность символов");
                return null;}
        }
        catch (FileNotFoundException e){
            System.out.printf ("Файл %s не найден\n", fileName);
            return null;}

        catch (IOException e){
            System.out.printf ("Ошибка при вводе данных из файла %s\n",
                    fileName);
            return null;}
        finally { if (inp != null) inp.close();
        }
        return matr;
    }

    public static boolean outMatr (String fileName, double[][]matr) throws IOException {
        PrintWriter out = null;
        try {
            if (matr == null) throw new MyException("Матрица пуста");
            out = new PrintWriter(new FileWriter(fileName));
            out.println(matr.length + " " + matr[0].length);
            for (int i = 0; i < matr.length; i++){

                StringBuilder line = new StringBuilder();
                for (int j = 0; j < matr[0].length; j++){
                    line.append(" ");
                    line.append(matr[ i ][ j ]);
                }
                line.delete(0, 1);
                out.println(line.toString());
            }
        }
        catch (IOException e){
            System.out.printf ("Ошибка при выводе данных в файл %s\n",
                    fileName);
            return false;}
        catch (MyException e){
            System.out.println (e); return false;}
        finally { if (out != null) out.close(); }
        return true;
    }
    public static void putArr (double X[ ]){
        for (int i=0; i<X.length; i++)
            System.out.printf ("%5s",X[i]);
        System.out.println();
    }
}
