package lab4;

public class main {
    public static void main(String args[]){
        OfficeList arr1 = new OfficeList("List 1");
        OfficeList arr2 = new OfficeList();
        arr2.setTitle("List 2");

        arr1.addOffice(new Office(13, "Кузнецов 10", 10, 2));
        arr1.addOffice(new Office(2, "Суворвская 14", 20, 1));
        arr1.addOffice(new Office(1, "Сурикова 12", 40, 10));
        arr1.addOffice(new Office(56, "Воставших 1", 100, 3));
        arr1.addOffice(new Office(228, "Стрелков 11", 19, 1));

        arr2.addOffice(new Office(151, "Кирова 15", 15, 2));
        arr2.addOffice(new Office(11, "Театральная 22", 150, 2));
        arr2.addOffice(new Office(21, "Садовая 10", 100, 2));
        arr2.addOffice(new Office(8, "Улица числа Пи", 3.14159, 1));
        arr2.addOffice(new Office(9, "Тверская 8", 30, 1));
        //13 "Кузнецов 10" 10 2 2 "Суворвская 14" 20 1 1 "Сурикова 12" 40 10 56 "Воставших 1" 100 3 228 "Стрелков 11" 19 1 151 "Кирова 15" 15 2 11 "Театральная 22" 150 2 21 "Садовая 10" 100 2 8 "Улица числа Пи" 3.14159 1 9 "Тверская 8" 30 1
        /*
        int j = 0;
        for (int i = 0; i < 5; i++) {
            int id = Integer.valueOf(args[j]);
            j++;
            String title = args[j];
            j++;
            float area = Float.valueOf(args[j]);
            j++;
            int rooms = Integer.valueOf((args[j]));
            j++;
            firm1.addOffice(new Office(id, title, area, rooms));
        }

        for (int i = 0; i < 5; i++) {
            int id = Integer.valueOf(args[j]);
            j++;
            String title = args[j];
            j++;
            float area = Float.valueOf(args[j]);
            j++;
            int rooms = Integer.valueOf((args[j]));
            j++;
            firm2.addOffice(new Office(id, title, area, rooms));
        }*/
//
//        System.out.println ("Сформированы следующие листы:");
//        System.out.printf ("%s,\n%s\n\n", arr1,arr2);
//        arr1.putStudList();
//        arr2.putStudList();
//
//        if (!arr1.addOffice(new Office (13, "Садовая 10", 100, 2))) {
//            System.out.printf("В фирму %s добавить офис не удалось:\n", arr1.getTitle());
//            System.out.println("нарушена уникальность ключа.");
//        }
//        arr1.putStudList();
//        arr1.aboveAvgArea().putStudList();
//        arr1.betweenArea(20,100).putStudList();
//        arr1.delOffice(228);
//        System.out.println("После удаления офиса:");
//        arr1.putStudList();
//        arr2.putStudList();
//        arr2.aboveAvgArea().putStudList();
//        arr2.betweenArea(10,30).putStudList();
//        arr2.delOffice(21);
//        System.out.println("После удаления офиса:");
//        arr2.putStudList();
//        System.out.println("Проверка наличия офиса");
//        int n = 222222222;
//        Office of = arr1.getOffice(n);
//        System.out.printf ("В листе %s:\n",arr1.getTitle());
//        if (of == null) System.out.printf ("Нет офиса с id %d\n",n);
//        else System.out.println(of);
        arr1.putStudList();
        //arr1.sort().putStudList();
    }
}



























