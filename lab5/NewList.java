package lab5;

public interface NewList {
    void setTitle(String name);

    String getTitle();

    int getSize();

    Office getOffice(int id);

    boolean addOffice(Office office);

    public boolean delOffice(int id);

    public double avgArea();

    public NewList overAvgArea();

    public NewList betweenArea(double spanB, double spanE);

    public void sort();

    public void print();
}



