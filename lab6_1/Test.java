package lab6_1;

public class Test {
    public static void putArrayOfStrings (String [ ] strings){
        if (strings == null) return;
        for (int i = 0; i < strings.length; i++){
            if (strings[i] == null) break;
            System.out.println (strings[i]);
        }
    }

    public static void main (String[] arg){
        int N = 6;
        String o = "о";
        String ta = "та";
        String a = "а";
        Sentence sent = new Sentence("  Абсолютно случайно составленная строка в которой написано всё что угодно");
        System.out.println(sent);
        System.out.println();
        System.out.println("Слова исходной строки:");
        putArrayOfStrings(sent.getWords());
        System.out.println();
        System.out.printf("Вывести слова с подстрокой %s\n", o);
        putArrayOfStrings(sent.wordsWithSubstring(o));
        System.out.println();
        System.out.printf("Вывести слова с подстрокой %s\n", ta);
        putArrayOfStrings(sent.wordsWithSubstring(ta));
        System.out.println();
        System.out.printf("Вывести строку слов в которых есть подстрока %s и длина более %s\n", a, N);
        System.out.println(sent.stringContainsLength(a, N));
    }
}
