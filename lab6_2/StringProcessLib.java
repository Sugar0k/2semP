package lab6_2;

public class StringProcessLib {

    public static String[] wordsWithSubstring(String inStr, String str){
        String temp = inStr.trim();
        if (temp.length() == 0) return null;
        int start = 0, end;
        end = temp.indexOf(" ");
        StringBuilder bStr = new StringBuilder();
        while (end > 0){
            String a = temp.substring(start, end);
            if (a.contains(str)){
                bStr.append(a);
                bStr.append(" ");
            }
            while (temp.charAt(end) == ' ') end++;
            start = end;
            end = temp.indexOf(" ", start);
        }
        String a = temp.substring(start);
        if (a.contains(str)){
            bStr.append(a);
        }
        return bStr.toString().split(" ");
    }

    public static String stringContainsLength(String inStr, String str, int n){
        String temp = inStr.trim();
        boolean bool = false;
        if (temp.length() == 0) return null;
        int start = 0, end;
        end = temp.indexOf(" ");
        StringBuilder bStr = new StringBuilder();
        while (end > 0){
            String a = temp.substring(start, end);
            if (a.contains(str) && a.length() > n){
                bStr.append(a);
                bStr.append(" ");
                bool = true;
            }
            while (temp.charAt(end) == ' ') end++;
            start = end;
            end = temp.indexOf(" ", start);
        }
        String a = temp.substring(start);
        if (a.contains(str) && a.length() > n){
            bStr.append(a);
            bool = false;
        }
        if (bool) bStr.delete(bStr.length() -1, bStr.length());
        return bStr.toString();
    }
}
