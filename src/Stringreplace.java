import java.util.Arrays;

public class Stringreplace {

        public String solution2(String S, int[] A) {
            char[] arr = S.toCharArray();
            int pos = -1;
            String mess = "";

            for (int i = 0; i < A.length && pos!=0; i++) {

                if (i == 0) {
                    pos = 0;
                }
                mess=mess.concat(String.valueOf(arr[pos]));
                pos=A[pos];
            }
            return mess;
        }
    public String solution(String riddle) {
        char[] arr = riddle.toCharArray();

        for (int i = 0; i <arr.length; i++) {
            char wrd='a';
            if(arr[i]=='?'){
                if(i>0 && arr[i-1]==wrd ||(i<arr.length-1 &&arr[i+1]==wrd))wrd++;
                if(i>0 && arr[i-1]==wrd ||(i<arr.length-1 &&arr[i+1]==wrd))wrd++;
                arr[i]=wrd;
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        //int  arr[] = {4, 3, 0, 1, 2, 5};
        System.out.println(new Stringreplace().solution("ab?ac?"));

    }


}
