package lab7;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Second {
    public static byte byteProcess(byte b) {
        int c = b;
        c = c & 0x57;
        return (byte)c;
    }

    public static String byteToString(byte b) {
        String str = "";
        for (int i = 1; i <= 8; i++) {
            str = b < 0 ? str + "1" : str + "0";
            b = (byte) (b << 1);
        }
        return str;
    }

    public static void main(String[] args) throws IOException {
        byte b = 0;
        int d = 0;
        FileInputStream fi = null;
        FileOutputStream fo = null;
        try {
            fi = new FileInputStream("byte1_Павлюк_ИВТ12.txt");
            fo = new FileOutputStream("byte2_Павлюк_ИВТ12.txt");
            while ((d = fi.read()) != -1) {
                b = (byte) d;
                System.out.print(byteToString(b) + " --> ");
                b = byteProcess(b);
                System.out.println(byteToString(b));
                fo.write(b);
            }
        } catch (IOException e) {
            System.out.println("error:\n" + e);
        }

        finally {
            if (fi != null) fi.close();
            if (fo != null) fo.close();
        }
    }
}

