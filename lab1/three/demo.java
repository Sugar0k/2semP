package lab1.three;

public class demo {
    public static void bubbleSort(Comparable[] arr) {
        boolean flag;
        for (int m = arr.length - 1; m > 0; m--) {
            flag = true;
            for (int j = 0; j < m; j++)
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    Comparable b = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = b;
                    flag = false;
                }
            if (flag) break;
        }
    }

    public static void putArr(lab1_3[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.printf("%s, хэшкод: %d\n", arr[i], arr[i].hashCode());
        System.out.println();
    }

    public static void putArr(Display[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.printf("%s, хешкод %d\n", arr[i].toString(), arr.hashCode());
        System.out.println();
    }
    public static void main(String args[]) {
        lab1_3[] arr = new lab1_3[5];
        arr[0] = new lab1_3("Tashiba", "3714", 116, 8, 50);
        arr[1] = new lab1_3("LEGE", "3914", 24, 2, 89);
        arr[2] = new lab1_3("GIVICI", "PUZAN", 62, 50, 40);
        arr[3] = new lab1_3("Samsung", "BIG", 71, 1, 50);
        arr[4] = new lab1_3("SANI", "KD-100ZD9", 215, 9, 130);
        System.out.println ("Массив крышек Lid до сортировки");
        putArr(arr);
        bubbleSort(arr);
        System.out.println ("Массив крышек Lid после сортировки");
        putArr(arr);
        Display[] arr1 = new Display[5];
        arr1[0] = new Display("Tashiba", "37414", 115, 8, 50, "ЭЛТ");
        arr1[1] = new Display("LEGE", "39144", 23, 2, 89, "LCD");
        arr1[2] = new Display("GIVICI", "PUZANi", 60, 50, 40, "QLED");
        arr1[3] = new Display("Samsung", "BIG", 72, 1, 50, "QLED");
        arr1[4] = new Display("SANI", "KD-100ZD9", 225, 9, 130, "LCD");
        System.out.println ("Массив крышек LidWithHandle  до сортировки");
        putArr(arr1);
        bubbleSort(arr1);
        System.out.println ("Массив крышек LidWithHandle после сортировки");
        putArr(arr1);
    }
}




