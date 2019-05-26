package lab6_1;

class Sentence {
    private final static int МАХ_NUM_OF_WORDS = 20;
    private String sourceStr;
    private String[] words;
    private int counter;

    public Sentence(){
        sourceStr = ""; words = null; counter = 0;
    }
    public Sentence(String str){
        setSourceStr(str);
    }

    public void setSourceStr(String str){
        sourceStr = str.trim();
        if (str == ""){words = null; counter = 0;}
        else splitIntoWords();
    }

    public String[] getWords(){
        return words;
    }

    public int getCounter() {
        return counter;
    }

    public String toString(){
        return sourceStr;
    }

    private void splitIntoWords(){
        words = new String[МАХ_NUM_OF_WORDS];
        int start, end;
        counter = 0;
        start = 0;
        end = sourceStr.indexOf(" ");
        try{
            while (end > 0){
                words[counter] = sourceStr.substring(start, end);
                counter++;
                while (sourceStr.charAt(end) == ' ') end++;
                start = end;
                end = sourceStr.indexOf(" ", start);
            }
            words[counter] = sourceStr.substring(start);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println(
                    "В предложении слишком много слов, лишние придется обрезать: "
                            + "\n"+e);
            System.out.println();
            counter--;
        }
        counter++;
    }

    public String[] wordsWithSubstring(String str){
        if (counter == 0) return null;
        String[] arr = new String[counter];
        int j = 0;
        for (int i = 0; i < counter; i++) {
            if (words[i].contains(str)) {
                arr[j] = words[i];
                j = j + 1;
            }
        }
        return arr;
    }

    public String stringContainsLength(String str, int n){
        if (counter == 0) return "";
        StringBuilder result = new StringBuilder();
        int j = 0;
        for (int i = 0; i < counter; i++){
            if (words[i].contains(str) && words.length > n) {
                result.append(" ");
                result.append(words[i]);
            }
        }
        result.delete(0, 1);
        return result.toString();
    }

}


