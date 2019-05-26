package lab3;

public class main {
    public static void putOfficeArr(Office [] arr) {
        if (arr == null) return;
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }
    public static void main(String args[]){
        Firm firm1 = new Firm("Sony" , 10);
        Firm firm2 = new Firm();
        firm2.setTitle("Panasonyk");

        firm1.addOffice(new Office(13, "Кузнецов 10", 10, 2));
        firm1.addOffice(new Office(2, "Суворвская 14", 20, 1));
        firm1.addOffice(new Office(1, "Сурикова 12", 40, 10));
        firm1.addOffice(new Office(56, "Воставших 1", 100, 3));
        firm1.addOffice(new Office(228, "Стрелков 11", 19, 1));

        firm2.addOffice(new Office(151, "Кирова 15", 15, 2));
        firm2.addOffice(new Office(11, "Театральная 22", 150, 2));
        firm2.addOffice(new Office(21, "Садовая 10", 100, 2));
        firm2.addOffice(new Office(8, "Улица числа Пи", 3.14159, 1));
        firm2.addOffice(new Office(9, "Тверская 8", 30, 1));
       // 13 "Кузнецов 10" 10 2 2 "Суворвская 14" 20 1 1 "Сурикова 12" 40 10 56 "Воставших 1" 100 3 228 "Стрелков 11" 19 1 151 "Кирова 15" 15 2 11 "Театральная 22" 150 2 21 "Садовая 10" 100 2 8 "Улица числа Пи" 3.14159 1 9 "Тверская 8" 30 1
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
        System.out.println ("Сформированы следующие фирмы:");
        System.out.printf ("%s,\n%s\n\n", firm1, firm2);
        if (!firm1.addOffice(new Office (13, "Садовая 10", 100, 2))) {
            System.out.printf("В фирму %s добавить офис не удалось:\n", firm1.getTitle());
            System.out.println("нарушена уникальность ключа.");
        }
        if (!firm2.addOffice(new Office (13, "Кузнецов 10", 10, 2))) {
            System.out.printf("В фирму %s добавить офис не удалось:\n", firm2.getTitle());
            System.out.println("превышен лимит");
        }
        System.out.println("\n" + firm1.getTitle());
        firm1.printListOffice();
        System.out.printf("Средняя площадь: %s\n", firm1.avgArea());
        System.out.println("\nОфисы с площадью выше средней:");
        putOfficeArr(firm1.overAvgArea());
        System.out.println("\nОфисы с площадью от 18 до 42:");
        putOfficeArr(firm1.spanAvgArea(18, 42));
        firm1.delOffice(2);
        System.out.printf("\nСписок офисов в фирме %s после удаления:\n", firm1.getTitle());
        firm1.printListOffice();
        System.out.printf("\nСортировки офисов фирмы %s:\n", firm2.getTitle());
        System.out.println("Изначальный:");
        firm2.printListOffice();
        System.out.println("\nОтсортирован по возрастанию площади:");
        putOfficeArr(firm2.sortByArea(-1));
        System.out.println("\nОтсортирован по убыванию площади:");
        putOfficeArr(firm2.sortByArea(1));
        System.out.println("\nБез сортировки");
        putOfficeArr(firm2.sortByArea(0));
    }
}
