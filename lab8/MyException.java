package lab8;

public class MyException extends Exception{
    private String msg;
    public MyException (String s) {
        msg = s;
    }
    public String toString() {
        return msg;
    }
}