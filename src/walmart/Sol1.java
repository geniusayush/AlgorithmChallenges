package walmart;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;

class Solution {

    /*
     * Complete the function below.
     */
    static String arrange(String sentence) {
        StringBuilder builder = new StringBuilder();
        String[] arr = sentence.split(" ");
        santitize(arr);
        O[] wordArray = new O[arr.length];
        for (int i = 0; i < arr.length; i++) {
            wordArray[i] = new O(arr[i], arr[i].length());
        }
        new LinkedHashMap<>();
        Arrays.sort(wordArray, new Comparator<O>() {
            @Override
            public int compare(O o1, O o2) {
                return o1.length - o2.length;
            }
        });
        for (int i = 0; i < wordArray.length; i++) {
            String word = wordArray[i].getWord();
            if (i == 0) {
                char charArray[] = word.toCharArray();
                charArray[0]=(char)(charArray[0]-32);
                word=new String(charArray);


            }
            builder.append(word);

            if (i == wordArray.length - 1) {
                builder.append('.');

            } else
                builder.append(' ');


        }
        return builder.toString();

    }

    private static void santitize(String[] arr) {
        arr[0] = arr[0].replace(arr[0].charAt(0), (char) (arr[0].charAt(0) + 32));
        arr[arr.length - 1] = arr[arr.length - 1].substring(0, arr[arr.length - 1].length() - 2);
    }

    static class O {
        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getWord() {

            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public O(String word, int length) {

            this.word = word;
            this.length = length;
        }

        String word;
        int length;
    }

    public static void main(String[] args) throws IOException {

        String sentence = "he is bad man";
        String res = arrange(sentence);
        System.out.println(res);
    }
}
