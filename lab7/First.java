package lab7;

import java.io.IOException;
import java.io.FileOutputStream;

public class First {
    public static void main(String args[]) throws IOException{
        byte[] b = { (byte)0x47, (byte)0x52, (byte)0x45, (byte)0x45, (byte)0x4E, (byte)0xC3, (byte)0xCE, (byte)0xD0, (byte)0xCE, (byte)0xC4};
        FileOutputStream fo = null;
        for(int i = 0; i < b.length; i++){
            System.out.printf("Код: %02x ", b[i]);
            System.out.println("Можно интерпретировать как символ: " + (char)b[i]+" ");
        }

        try {
            fo = new FileOutputStream("byte1_Павлюк_ИВТ12.txt");
            fo.write(b);
        }
            catch (IOException e){
                System.out.println("error:\n"+e);
            }
            finally {
            if (fo != null) fo.close();
        }
    }
}
