package lab9_1;

import java.io.*;
public class Demo{
    static void p (String s){ // Выводит строку s
        System.out.println(s);
    }
    static void fileInfo(File f){ //Выводит свойства файла (папки)
        p("Имя файла: " + f.getName());
        p("Путь: " + f.getPath());
        p("Абсолютный путь: " + f.getAbsolutePath());
        p("Надкаталог: " + f.getParent());
        p(f.exists() ? "существует" : "не существует");
        p(f.canWrite() ? "для записи" : "не для записи");
        p(f.canRead() ? "для чтения" : "не для чтения");
        p((f.isDirectory()? "каталог":"не каталог"));
        p(f.isFile() ? "нормальный файл" : "возможно именованный канал");
        p(f.isAbsolute() ? "абсолютный" : "не абсолютный");
        p("последняя модификация файла: " + f.lastModified ());
        p("размер файла: " + f.length() + " байтов");
        System.out.println();
    }
    public static void main (String args[ ]) {
        File f1 = new File("C:\\Users\\User\\Desktop\\some one\\picture1.jpg"); //файл
        fileInfo(f1);
        File f2 = new File("C:\\Users\\User\\Desktop\\some one"); //папка
        fileInfo(f2);
        FilenameFilter a = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.contains(".jpg")) return true;
                return false;
            }
        };
        String[] S = f2.list(a); //получить список файлов папки
        System.out.printf("Список файлов каталога %s:\n " , f2.getName());
        for (int i = 0; i < S.length; i++) System.out.println(S[i]);
        try{
            //-------------------ввод----------------------------------------------------
            byte [ ] arr = IOFile.inputRAFile(f1);
            if (arr != null) System.out.printf (
                    "Информация из файлa %s загружена успешно\n",
                    f1.getAbsolutePath());
            else System.out.printf (
                    "Ошибка ввода из файлa %s\n", f1.getAbsolutePath());
            //--------------------вывод без замены---------------------------------
            File f3 = new File("C:\\Users\\User\\Desktop\\some one\\picture1_1.jpg"); //файл
            if (IOFile.outputRAFile(f3, arr, 0, arr.length, 0))
                System.out.printf (
                        "Копирование в файл %s произведено успешно\n",
                        f3.getAbsolutePath());
            else System.out.printf ("Ошибка вывода в файл %s\n",
                    f3.getAbsolutePath());
            //--------------------вывод и замена-------------------------------------
            f3 = new File("C:\\Users\\User\\Desktop\\some one\\picture1_2.jpg"); //файл

            if (IOFile.outputRAFile(f3, arr, 0, arr.length, 0))
                System.out.printf (
                        "Копирование в файл %s произведено успешно\n",
                        f3.getAbsolutePath());
            else System.out.printf ("Ошибка вывода в файл %s\n",
                    f3.getAbsolutePath());
            int n = 15000;
            byte[] arr1 = new byte[n];
            for (int i = 0; i < n; i++) arr1[i] = (byte)0xF7;
            if (IOFile.outputRAFile(f3, arr1, 0, arr1.length, 5000))
                System.out.printf (
                        "Вывод помехи в в файл %s произведен успешно\n",
                        f3.getAbsolutePath());
            else System.out.printf ("\nОшибка вывода в файл %s\n",
                    f3.getAbsolutePath());
            //----------------------------------------------------------------------------------
            S = f2.list(a);
            System.out.printf("Список файлов каталога %s:\n", f2.getName());
            for (int i = 0; i < S.length;i++) System.out.println(S[i]);
        }
        catch (Exception e) { } finally{ }
    }
}