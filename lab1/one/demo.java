package lab1.one;

public class demo {
    public static void bubbleSort(lab1_1[] arr) {
        boolean flag;
        for (int m = arr.length - 1; m > 0; m--) {
            flag = true;
            for (int j = 0; j < m; j++)
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    lab1_1 b = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = b;
                    flag = false;
                }
            if (flag) break;
        }
    }

    public static void putLidArr(lab1_1[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i].toString());
    }

    public static void main(String args[]) {
        lab1_1 lid0 = new lab1_1();
        lid0.setFirm("Samsung");
        lid0.setTitle("BIG");
        lid0.setLength(72);
        lid0.setWidth(1);
        lid0.setHeight(50);

        lab1_1 lid1 = new lab1_1("Tashiba", "3714", 115, 8, 50);
        lab1_1 lid2 = lid1;
        lab1_1 lid3 = new lab1_1(lid1);
        lab1_1 lid4 = new lab1_1("LEGE", "3914", 23, 2, 89);
        lab1_1 lid5 = null;

        System.out.printf("lid1: %s, хэшкод: %d\n", lid1, lid1.hashCode());
        System.out.printf("lid2: %s, хэшкод: %d\n", lid2, lid2.hashCode());
        System.out.printf("lid3: %s, хэшкод: %d\n", lid3, lid3.hashCode());
        System.out.printf("lid4: %s, хэшкод: %d\n", lid4, lid4.hashCode());
        System.out.printf("lid5: %s\n", lid5);

        System.out.println("Результаты сравнения на равенство");
        System.out.printf("lid1==lid2: %s\n", lid1.equals(lid2));
        System.out.printf("lid1==lid3: %s\n", lid1.equals(lid3));
        System.out.printf("lid1==lid4: %s\n", lid1.equals(lid4));
        System.out.printf("lid4==lid5: %s\n", lid4.equals(lid5));

        lab1_1[] arr = new lab1_1[5];
        arr[0] = new lab1_1("Tashiba", "3714", 115, 8, 50);
        arr[1] = new lab1_1("LEGE", "3914", 23, 2, 89);
        arr[2] = new lab1_1("GIVICI", "PUZAN", 60, 50, 40);
        arr[3] = new lab1_1("Samsung", "BIG", 72, 1, 50);
        arr[4] = new lab1_1("SANI", "KD-100ZD9", 225, 9, 130);
        System.out.println("\nМассив теливозов до сортировки");
        putLidArr(arr);
        bubbleSort(arr);
        System.out.println("\nМассив телизоров после сортировки");
        putLidArr(arr);
    }
}