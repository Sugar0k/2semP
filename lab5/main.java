package lab5;


public class main {

    public static void SetStatus(NewList list, String status){
        list.setTitle(list.getTitle() + " " + status);
    }

    public static void main(String args[]){
        NewList of1 = new Firm("First", 5);
        NewList of2 = new OfficeList("First");

        of1.addOffice(new Office(13, "Кузнецов 10", 10, 2));
        of1.addOffice(new Office(2, "Суворвская 14", 20, 1));
        of1.addOffice(new Office(1, "Сурикова 12", 40, 10));
        of1.addOffice(new Office(56, "Воставших 1", 100, 3));
        of1.addOffice(new Office(228, "Стрелков 11", 19, 1));

        of2.addOffice(new Office(151, "Кирова 15", 15, 2));
        of2.addOffice(new Office(11, "Театральная 22", 150, 2));
        of2.addOffice(new Office(21, "Садовая 10", 100, 2));
        of2.addOffice(new Office(8, "Улица числа Пи", 3.14159, 1));
        of2.addOffice(new Office(9, "Тверская 8", 30, 1));

        System.out.println ("Сформированы следующие фирмы:");
        System.out.printf ("%s,\n%s\n\n", of1, of2);

        if (!of1.addOffice(new Office (10, "Кузнецов 10", 10, 2))) {
            System.out.printf("В фирму %s добавить офис не удалось:\n", of1.getTitle());
            System.out.println("превышен лимит");
        }

        if (!of2.addOffice(new Office (21, "Садовая 10", 100, 2))) {
            System.out.printf("В фирму %s добавить офис не удалось:\n", of2.getTitle());
            System.out.println("нарушена уникальность ключа.");
        }
        System.out.println();
        of1.print();
        of1.overAvgArea().print();
        of1.betweenArea(20,100).print();
        of1.delOffice(1);
        System.out.println("После удаления офиса:");
        of1.print();
        of2.print();
        of2.overAvgArea().print();
        of2.betweenArea(10,30).print();
        of2.delOffice(21);
        System.out.println("После удаления офиса:");
        of2.print();

        System.out.println("Проверка наличия офисов");
        int n = 1;
        Office of = of1.getOffice(n);
        System.out.printf ("В листе %s:\n",of1.getTitle());
        if (of == null) System.out.printf ("Нет офиса с id %d\n",n);
        else System.out.println(of);

        n = 151;
        of = of2.getOffice(n);
        System.out.printf ("В листе %s:\n",of1.getTitle());
        if (of == null) System.out.printf ("Нет офиса с id %d\n",n);
        else System.out.println(of);
        System.out.println();

        SetStatus(of1, "SomeOne");
        SetStatus(of2, "AnyOne");
        System.out.println("После назначения статуса");
        System.out.println(of1.getTitle());
        System.out.println(of2.getTitle());

        System.out.println("До сортировки:");
        of1.print();
        System.out.println();
        System.out.println("После сортировки:");
        of1.sort();
        of1.print();
        System.out.println();
        System.out.println("Добавим ещё несколько значений");
        of2.addOffice(new Office(13, "Кузнецов 10", 10, 2));
        of2.addOffice(new Office(2, "Суворвская 14", 20, 1));
        of2.addOffice(new Office(1, "Сурикова 12", 40, 10));
        of2.addOffice(new Office(56, "Воставших 1", 100, 3));
        of2.addOffice(new Office(228, "Стрелков 11", 19, 1));
        System.out.println();
        System.out.println("До сортировки:");
        of2.print();
        System.out.println();
        System.out.println("После сортировки:");
        of2.sort();
        of2.print();
    }
}
