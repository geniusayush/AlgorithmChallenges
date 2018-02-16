package solved;
/*\
Given a string -> thereisaboy
Given a dictionary of words.
TODO: there is a boy.
Set -> there, is, a, boy.
theredfox -> the red fox.
private String[] getValidSentence(String s, Set<String> dict) {
int List<String>[][] words= new List<String>[][];
initialize(words);// set all to null;
getData(0,s.length());
}
private String [] getData(int i,int j,int words,String s){
if(words[i][j]!==null)retunr  words;
else{
if(i==j)
}
}
boolean isInSet(String word);


 i,j- 0,i && j,n

 //if size==0 .. d\false;

 for(i 0to n){



 inset(0to i)&&
 getValidSAentense(i to n );

return  subset(0,i)
+" "+ getValidSAentense(i to n );
 }


* */
public class ifStringCanBeSplit {
    boolean dictionaryContains(String word) {
        String dictionary[] = {"the","there","red","fox"};

        for (int i = 0; i < dictionary.length; i++)
            if (dictionary[i].equals(word))
                return true;
        return false;
    }

    // Returns true if string can be segmented into space separated
// words, otherwise returns false
    String wordBreak(String str) {
        int size = str.length();
        // if (size == 0)   return true;

        // The value wb[i]will be true if str[0..i-1] can be segmented into dictionary words,
        // otherwise false.
        String wb[] = new String[size + 1];
        for (int i = 1; i <= size; i++) {
            // if wb[i] is false, then check if current substring can make it true.

            if (wb[i]==null & dictionaryContains(str.substring(0, i)))
                wb[i] = new String(str.substring(0, i));

            // wb[i] is true, then check for all substrings starting from
            // (i+1)th character and store their results. the optimal substructure hewere will be
            //  (wb[i]!=null  && dictionaryContains(str.substring(i,j))) then wb[j] is also valid

            if (wb[i]!=null) {
                // If we reached the last prefix
                if (i == size)
                    return wb[i];
                for (int j = i + 1; j <= size; j++) {
                    // Update wb[j] if it is false and can be updated
                    if (wb[j]==null  && dictionaryContains(str.substring(i,j)))
                        wb[j] = wb[i]+" "+str.substring(i,j);

                    // If we reached the last character
                    if (j == size &&wb[j]!=null )
                        return wb[j];
                }
            }
        }

        return "";
    }

    public static void main(String[] args) {
        System.out.println(new ifStringCanBeSplit().wordBreak("theredfox"));
    }
}
