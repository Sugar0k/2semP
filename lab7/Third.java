package lab7;

import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

public class Third {
    public static void main(String[] args) throws IOException {
        char b = 0;
        int d = 0;
        FileReader fi = null;
        FileWriter fo = null;
        try {
            fi = new FileReader("char1_Павлюк_ИВТ12.txt");
            fo = new FileWriter("char2_Павлюк_ИВТ12.txt");
            while ((d = fi.read()) != -1) { //ввести код символа из fi (2 байта)
                b = (char) d;
                if (d == ' ') fo.write('-');
                else fo.write(d);
            }
        } catch (IOException e) {
            System.out.println("\nerror:\n" + e);
        } finally {
            if (fi != null) fi.close();
            if (fo != null) fo.close();
        }
    }

}
