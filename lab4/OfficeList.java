package lab4;

public class OfficeList {
    private final static String OFFICE_LIST_FORMAT_STRING = "Офис: %s, кол-во элементов: %s";

    private Office data;
    private OfficeList head;
    private int size;

    public OfficeList() {
        data = new Office();
        head = null;
        size = 0;
    }

    public OfficeList(String location) {
        data = new Office();
        data.setLocation(location);

    }

    OfficeList(Office office) {
        data = office;
        head = null;
    }

    public void setTitle(String location) {
        data.setLocation(location);
    }

    public String getTitle() {
        return data.getLocation();
    }

    public int getSize() {
        return size;
    }

    public Office getOffice(int id) {
        if (head == null) return null;
        OfficeList next = head;
        while (next != null) {
            if (next.data.getId() == id) return next.data;
            next = next.head;
        }
        return null;
    }

    public String toString() {
        return String.format(OFFICE_LIST_FORMAT_STRING, data.getLocation(), getSize());
    }

    public boolean addOffice(Office of) {
        if (getOffice(of.getId()) != null) return false;
        OfficeList el = new OfficeList(of);
        if (head == null) head = el;
        else {
            OfficeList old = head;
            head = el;
            el.head = old;
        }
        size++;
        return true;
    }

    public boolean delOffice(int id) {
        OfficeList el = this;
        while (el.head != null) {
            if (el.head.data.getId() == id) {
                el.head = el.head.head;
                size--;
                return true;
            }
            el = el.head;
        }
        return false;
    }

    public double avgArea() {
        if (head == null) return 0;
        double avg = 0.;
        int num = 0;
        OfficeList el = head;
        while (el != null) {
            avg = avg + el.data.getArea();
            num = num + 1;
            el = el.head;
        }
        return avg / num;
    }

    public OfficeList aboveAvgArea() {
        double avg = avgArea();
        OfficeList newHead = new OfficeList(String.format("Офисы, с площадью больше средней %s: ", avg));
        OfficeList el = head;
        while (el != null) {
            if (el.data.getArea() > avg)
                newHead.addOffice(el.data);
            el = el.head;
        }
        return newHead;
    }
    public OfficeList betweenArea (double b1, double b2) {
        OfficeList newHead = new OfficeList(String.format("Офисы, с площадью в диапазоне от %.2f до %.2f: ", b1, b2));
        OfficeList el = head;
        while (el != null) {
            double b = el.data.getArea();
            if ((b >= b1) && (b <= b2))
                newHead.addOffice(new Office(el.data));
            el = el.head;
        }
        return newHead;
    }
    public void putStudList(){
        System.out.println(data.getLocation());
        System.out.printf("%-11s%-10s%-18s%-13s%-10s\n", "Название", "ID", "Адрес", "Площадь", "Кол-во комнта");
        OfficeList el = head;
        int i = 1;
        while (el != null){
            System.out.printf("  %-7d  %-8s  %-16s  %-12s %-10s\n", i, el.data.getId(), el.data.getLocation(), el.data.getArea(), el.data.getRooms());
            el = el.head;
            i++;
        }
        System.out.println();
    }
}



















































































