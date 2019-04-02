package lab1.two;

public class lab1_2{
    private final static String lab1_2_FORMAT_STRING =
            "Фирма %10s, модель %10s, длина %5d, ширина %5d, высота %5d";

    private String firm;
    private String title;
    private int length;
    private int width;
    private int height;

    public lab1_2() {
        this.firm = "";
        this.title = "";
        this.length = 0;
        this.width = 0;
        this.height = 0;
    }

    public lab1_2(String firm, String title, int length, int width, int height) {
        this.firm = firm;
        this.title = title;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public lab1_2(lab1_2 obj) {
        firm = obj.firm;
        title = obj.title;
        length = obj.length;
        width = obj.width;
        height = obj.height;
    }

    public String getFirm() {
        return firm;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void  setHeight(int height) {
        this.height = height;
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        lab1_2 li = (lab1_2) obj;
        return firm.equals(li.firm) && title.equals(li.title) &&
                (length == li.length) && (width == li.width) &&
                (height == li.height);
    }

    public int hashCode() {
        return  firm.hashCode()
                +  title.hashCode()
                + 2 * (Integer.valueOf(length)).hashCode()
                + 3 * (Integer.valueOf(width)).hashCode()
                + (Integer.valueOf(height)).hashCode();
    }

    public String toString() {
        return String.format(lab1_2_FORMAT_STRING, firm, title, length, width, height);
    }

    public int compareTo(lab1_2 li) {
        if (area() < li.area()) return -1;
        if ((area() == li.area()) &&
                (firm.compareTo(li.firm) < 0)) return -1;
        if ((area() == li.area()) &&
                (firm.compareTo(li.firm) == 0) && (title.compareTo(li.title) < 0)) return -1;
        else return 1;
    }


    public double area() {
        return (width * height * length);
    }
}


