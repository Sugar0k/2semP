package lab6_2;

import static lab6_2.StringProcessLib.*;

public class Test {
    public static void main (String[] arg){
        int N = 6;
        String o = "в";
        String ta = "та";
        String a = "а";
        String s = "  Абсолютно случайно составленная строка в которой написано всё что угодно  ";
        System.out.println(s);
        System.out.printf("Вывести слова с подстрокой %s\n", o);
        for(String i : wordsWithSubstring(s, o)) System.out.println(i);
        System.out.println();
        System.out.printf("Вывести слова с подстрокой %s\n", ta);
        for(String i : wordsWithSubstring(s, ta)) System.out.println(i);
        System.out.println();
        System.out.printf("Вывести строку слов в которых есть подстрока %s и длина более %s\n", a, N);
        System.out.println(stringContainsLength(s, a, N));
    }
}

