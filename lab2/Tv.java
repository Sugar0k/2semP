package lab2;

public class Tv implements Comparable <Tv> {

    private final   String lab1_1_FORMAT_STRING = "%5s, %5s, %5s, %10s, %15s";

    private int length;
    private int width;
    private int weight;
    private String material;

    public Tv() {
        this.length = 0;
        this.width = 0;
        this.weight = 0;
        this.material = " ";
    }

    public Tv(int length, int width, int weight, String material) {
        this.length = length;
        this.width = width;
        this.weight = weight;
        this.material = material;
    }

    public Tv(Tv obj) {
        length = obj.length;
        width = obj.width;
        weight = obj.weight;
        material = obj.material;
    }


    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getWeight() {
        return weight;
    }

    public String getMaterial() {
        return material;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setMaterial(String material) {
        this.material = material;
    }


    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Tv obj1 = (Tv) obj;
        return (length == obj1.length) && (width == obj1.width) &&
                (weight == obj1.weight) && (material == obj1.material);
    }

    public int hashCode() {
        return +13 * (Integer.valueOf(length)).hashCode()
                + 17 * (Integer.valueOf(width)).hashCode()
                + 24 * (Integer.valueOf(weight)).hashCode()
                + 11 * material.hashCode();
    }

    public String toString() {
        return String.format(lab1_1_FORMAT_STRING, length, width, weight, material, hashCode());
    }

    public int compareTo(Tv obj) {
        if (length < obj.length) return -1;
        if ((length == obj.length) &&
                (width < obj.width)) return -1;
        if ((length == obj.length) &&
                (width == obj.width) && (weight < obj.weight)) return -1;
        if ((length == obj.length) && (width == obj.width) &&
                (weight == obj.weight) && (material.compareTo(material) < 0)) return -1;
        if ((length == obj.length) && (width == obj.width) &&
                (weight == obj.weight) && (material.compareTo(obj.material) == 0)) return 0;
        else return 1;
    }

    public boolean accord(Stand obj) {
        if ((length <= obj.getLength()) && (width <= obj.getWidth()) &&
                (weight <= obj.getWeight())) return true;
        else return false;
    }

}
