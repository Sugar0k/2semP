package lab1.one;

public class lab1_1 {
    private final static String lab1_1_FORMAT_STRING =
            "%10s, %10s, %5s, %5s, %5s, %15s";

    private String firm;
    private String title;
    private int length;
    private int width;
    private int height;

    public lab1_1() {
        this.firm = "";
        this.title = "";
        this.length = 0;
        this.width = 0;
        this.height = 0;
    }

    public lab1_1(String firm, String title, int length, int width, int height) {
        this.firm = firm;
        this.title = title;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public lab1_1(lab1_1 obj) {
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
        lab1_1 li = (lab1_1) obj;
        return firm.equals(li.firm) && title.equals(li.title) &&
                (length == li.length) && (width == li.width) &&
                (height == li.height);
    }

    public int hashCode() {
        return 7 * firm.hashCode()
                + 11 * title.hashCode()
                + 13 * (Integer.valueOf(length)).hashCode()
                + 17 * (Integer.valueOf(width)).hashCode()
                + 24 * (Integer.valueOf(height)).hashCode();
    }

    public String toString() {
        return String.format(lab1_1_FORMAT_STRING, firm, title, length, width, height, hashCode());
    }

    public int compareTo(lab1_1 li) {
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
