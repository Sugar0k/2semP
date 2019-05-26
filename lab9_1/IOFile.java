package lab9_1;
import java.io.*;

public class IOFile{
    public static byte[] inputRAFile(File file) throws IOException {
        RandomAccessFile inpFile = null;
        int nextByte;
        int i = 0;
        byte [ ] arr = null;
        try {
            inpFile = new RandomAccessFile(file,"r");
            // создаем массив байтов длиной, равной числу байтов в файле:
            arr = new byte[(int)inpFile.length()]; //используется явное
            // преобразование из long в int
            // пока в файле есть байты, читаем очередной байт и
            // и записываем его в arr:
            while ((nextByte = inpFile.read()) != -1){
                arr[i] = (byte)nextByte; // read() возвращает int, преобразуем в byte
                i = i+1;
            }
        }
        catch (Exception e) {arr = null;}
        finally{ if(inpFile != null) inpFile.close();}
        return arr;
    }
    public static boolean outputRAFile(File file, byte[ ] arr, int startInd, int num,
                                       long position) throws IOException {
        //Выводит num байтов, начиная с индекса startInd из массива arr
        // в файл, связанный с File-объектом file, начиная с позиции
        //position в файле
        RandomAccessFile outpFile = null;
        boolean f = true; //для возврата значения boolean
        int endInd = startInd + num; //граничный индекс в arr
        try { //открываем файл для чтения-записи:
            outpFile = new RandomAccessFile(file,"rw");
            outpFile.seek (position); //устанавливаем указатель файла на
            //заданную позицию
            // и выводим байты из массива arr файл:
            for (int i = startInd; i < endInd; i++) outpFile.write((int)arr[i]);
            // у метода write параметр типа int (используется
            // его последний байт)
        }
        catch (Exception e) {f = false;}
        finally{ if(outpFile != null) outpFile.close();}
        return f;
    }
}