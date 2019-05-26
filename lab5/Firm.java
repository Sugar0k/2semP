package lab5;

public class Firm implements NewList {
    private final static String FIRM_FORMAT_STRING = "Фирма: %s, число офисов: %s";
    private final static int MIN_NUM = 5;

    private String title;
    private Office[] arr;
    private int number;

    public Firm(){
        title= "";
        arr = new Office[MIN_NUM];
        number = 0;
    }

    public Firm(String title, int number){
        this.title = title;
        arr = new Office[number];
        this.number = 0;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getSize() {
        return number;
    }

    public Office getOffice(int id){
        for (int i = 0; i < number; i++) if (arr[i].getId() == id) return arr[i];
        return null;
    }

    public boolean addOffice(Office office) {
        if (number == arr.length) return false;
        for (int i = 0; i < number; i++)
            if (arr[i].getId() == office.getId()) return false;
        arr[number] = office;
        number++;
        return true;
    }

    public boolean delOffice(int id) {
        int i;
        for (i = 0; i < number; i++)
            if (arr[i].getId() == id) break;
        if (i == number)
            return false;
        for (i = i; i < number - 1; i++)
            arr[i] = arr[i + 1];
        arr[i] = null;
        number--;
        return true;
    }

    public double avgArea() {
        if (number == 0) return 0;
        double avg = 0;
        for (int i = 0; i < number; i++)
            avg += arr[i].getArea();
        return avg / number;
    }

    public OfficeList overAvgArea(){
        if (number == 0) return null;
        double avg = avgArea();
        OfficeList list = new OfficeList(String.format("Офисы, с площадью больше средней %s: ", avg));
        for (int i = 0; i < number; i++){
            if (arr[i].getArea() > avgArea()){
                list.addOffice(arr[i]);
            }
        }
        return list;
    }

    public OfficeList betweenArea(double b1, double b2){
        if (number == 0) return null;
        OfficeList list = new OfficeList(String.format("Офисы, с площадью в диапазоне от %.2f до %.2f: ", b1, b2));
        for (int i = 0; i < number; i++){
            double area = arr[i].getArea();
            if (area >= b1 && area <= b2){
                list.addOffice(arr[i]);
            }
        }
        return list;
    }

    public void print() {
        System.out.println(title);
        if (number != 0) {
            System.out.printf("%-6s %-10s %-18s %-12s %s\n", "Номер", "ID офиса", "Адрес", "Площадь", "Кол-во комнат");
            for (int i = 0; i < number; i++) System.out.printf("%-6s %-10s %-18s %-12.4f %s\n", i + 1, arr[i].getId(), arr[i].getLocation(), arr[i].getArea(), arr[i].getRooms());
        }
        System.out.println();
    }

    public String toString(){
        return String.format(FIRM_FORMAT_STRING, title, number);
    }

    public void sort() {
        for (int i = 0; i < number - 1; i++) {
            for (int j = i + 1; j < number; j++) {
                if (arr[i].getArea() < arr[j].getArea()) {
                    Office temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}





