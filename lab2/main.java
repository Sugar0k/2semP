package lab2;

public class main {
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

    public static void putArr(Tv[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.printf("%s\n", arr[i].toString());
        System.out.println();
    }

    public static void putArr(Stand[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.printf("%s\n", arr[i].toString());
        System.out.println();
    }

    public static void main(String args[]) {
        System.out.print("1)Демонстрируем работу методов toString(), equals()");
        System.out.println  ("и hashCode()для объектов класса Tv");
        Tv tv1 = new Tv(30, 20, 40, "metal");
        Tv tv2 = tv1;
        Tv tv3 = new Tv(tv1);
        Tv tv4 = new Tv(40, 25, 60, "metal");
        Tv tv5 = null;
        System.out.printf ("tv1: %s, хэшкод: %d\n", tv1, tv1.hashCode());
        System.out.printf ("tv2: %s, хэшкод: %d\n", tv2, tv2.hashCode());
        System.out.printf ("tv3: %s, хэшкод: %d\n", tv3, tv3.hashCode());
        System.out.printf ("tv4: %s, хэшкод: %d\n", tv4, tv4.hashCode());
        System.out.printf ("tv5: %s\n", tv5);

        System.out.println ("Результаты сравнения на равенство");
        System.out.printf ("tv1==tv2: %s\n", tv1.equals(tv2));
        System.out.printf ("tv1==tv3: %s\n", tv1.equals(tv3));
        System.out.printf ("tv1==tv4: %s\n", tv1.equals(tv4));
        System.out.printf ("tv4==tv5: %s\n", tv4.equals(tv5));
        System.out.println();
        System.out.print ("2)Демонстрируем сортировку элементов массивов");
        System.out.println  (" arr1 и arr2 одним и тем же методом bubbleSort().");

        Tv[] arr = new Tv[5];
        arr[0] = new Tv(116, 80, 50, "plastic");
        arr[1] = new Tv(24, 200, 89,"plastic");
        arr[2] = new Tv(62, 50, 40, "metal");
        arr[3] = new Tv(71, 12, 50, "metal");
        arr[4] = new Tv(215, 90, 130,"plastic");
        System.out.println ("Массив Tv до сортировки");
        putArr(arr);
        bubbleSort(arr);
        System.out.println ("Массив Tv после сортировки");
        putArr(arr);
        Stand[] arr1 = new Stand[5];
        arr1[0] = new Stand(100, 38, 50, "plastic");
        arr1[1] = new Stand(24, 20, 89,"plastic");
        arr1[2] = new Stand(20, 50, 40, "metal");
        arr1[3] = new Stand(71, 40, 50, "metal");
        arr1[4] = new Stand(215, 20, 10,"plastic");
        System.out.println ("Массив Stand  до сортировки");
        putArr(arr1);
        bubbleSort(arr1);
        System.out.println ("Массив Stand после сортировки");
        putArr(arr1);


        System.out.println();
        System.out.print ("3)Демонстрируем взаимодействие объектов при ");
        System.out.println  ("определении соответствия телевизора и подставки.");
        Tv tv = new Tv(80, 150, 10, "plastic");
        Stand stand1 = new Stand(80, 150, 10,"metal");
        Stand stand2 = new Stand(300, 300, 300,"plastic");
        Stand stand3 = new Stand(20, 200, 40, "metal");
        Stand stand4 = new Stand(90, 40, 50, "metal");
        Stand stand5 = new Stand(215, 200, 9,"plastic");
        System.out.printf("tv: %s\n", tv);
        System.out.printf("stand1: %s\n", stand1);
        System.out.printf("stand2: %s\n", stand2);
        System.out.printf("stand3: %s\n", stand3);
        System.out.printf("stand4: %s\n", stand4);
        System.out.printf("stand5: %s\n", stand5);
        System.out.printf("stand.accord(tv): %s\n", stand1.accord(tv));
        System.out.printf("tv.accord(stand1): %s\n", tv.accord(stand1));
        System.out.printf("stand.accord(tv): %s\n", stand2.accord(tv));
        System.out.printf("tv.accord(stand2): %s\n", tv.accord(stand2));
        System.out.printf("stand3.accord(tv): %s\n", stand3.accord(tv));
        System.out.printf("tv.accord(stand3): %s\n", tv.accord(stand3));
        System.out.printf("stand4.accord(tv): %s\n", stand4.accord(tv));
        System.out.printf("tv.accord(stand4): %s\n", tv.accord(stand4));
        System.out.printf("stand5.accord(tv): %s\n", stand5.accord(tv));
        System.out.printf("tv.accord(stand5): %s\n", tv.accord(stand5));
    }
}














