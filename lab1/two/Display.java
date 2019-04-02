package lab1.two;

public class Display extends lab1_2 {
    private final static String Handle_FORMAT_STRING = "%s, тип экрана: %5s";
    private String display;

    public Display() {
        super();
        display = "";
    }

    public Display(String firm, String title, int length, int width, int height, String display) {
        super(firm, title, length, width, height);
        this.display = display;
    }

    public Display(Display obj) {
        super(obj);
        display = obj.display;
    }


    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String toString() {
        return String.format(Handle_FORMAT_STRING, super.toString(), display);
    }

    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Display lwh = (Display) obj;
        return display.equals(lwh.display);
    }


    public int hashCode() {
        return super.hashCode()
                -  display.hashCode();
    }


    public int compareTo(lab1_2 com) {
        int comp = super.compareTo(com);
        if (comp < 0) return -1;
        Display c = (Display) com;
        if ((comp == 0) && (display.compareTo(c.display) < 0)) return -1;
        if ((comp == 0) && (display.compareTo(c.display) == 0)) return 0;
        return 1;
    }
}
