package lab1.two;

public class demo {
    public static void bubbleSort(Display[] arr) {
        boolean flag;
        for (int m = arr.length - 1; m > 0; m--) {
            flag = true;
            for (int j = 0; j < m; j++)
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    Display b = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = b;
                    flag = false;
                }
            if (flag) break;
        }
    }

    public static void putArr(Display[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.printf("%s, хешкод %d\n", arr[i].toString(), arr.hashCode());
    }


    public static void main(String args[]) {
        Display lwh0 = new Display();
        lwh0.setFirm("Samsung");
        lwh0.setTitle("Lazy");
        lwh0.setLength(228);
        lwh0.setWidth(9);
        lwh0.setHeight(120);
        lwh0.setDisplay("QLED");

        Display lwh1 = new Display("Tashiba", "3714", 115, 8, 50, "ЭЛТ");
        Display lwh2 = lwh1;
        Display lwh3 = new Display(lwh1);
        Display lwh4 = new Display("LEGE", "3914", 23, 2, 89, "LCD");
        Display lwh5 = null;
        System.out.printf("lwh1: %s, хэшкод: %d\n", lwh1, lwh1.hashCode());
        System.out.printf("lwh2: %s, хэшкод: %d\n", lwh2, lwh2.hashCode());
        System.out.printf("lwh3: %s, хэшкод: %d\n", lwh3, lwh3.hashCode());
        System.out.printf("lwh4: %s, хэшкод: %d\n", lwh4, lwh4.hashCode());
        System.out.printf("lwh5: %s\n", lwh5);
        System.out.println("Результаты сравнения на равенство");
        System.out.printf("lwh1==lwh2: %s\n", lwh1.equals(lwh2));
        System.out.printf("lwh1==lwh3: %s\n", lwh1.equals(lwh3));//true
        System.out.printf("lwh1==lwh4: %s\n", lwh1.equals(lwh4));//false
        System.out.printf("lwh4==lwh5: %s\n", lwh4.equals(lwh5));//false
        lab1_2 lid = lwh1;
        System.out.println("Выполнен оператор Lid lid = lwh1;");
        System.out.printf("lid==lwh3: %s\n", lid.equals(lwh3));//true
        Display[] arr = new Display[5];
        arr[0] = new Display("Tashiba", "3714", 115, 8, 50, "ЭЛТ");
        arr[1] = new Display("LEGE", "3914", 23, 2, 89, "LCD");
        arr[2] = new Display("GIVICI", "PUZAN", 60, 50, 40, "QLED");
        arr[3] = new Display("Samsung", "BIG", 72, 1, 50, "QLED");
        arr[4] = new Display("SANI", "KD-100ZD9", 225, 9, 130, "LCD");
        System.out.println("Массив телевизоров до сортировки");
        putArr(arr);
        bubbleSort(arr);
        System.out.println("Массив тулувизоров после сортировки");
        putArr(arr);
    }
}
