package solved;

public class AlternateDigitsOfNimber {
    public static  int solution(int A) {
        char[] array=(A+"").toCharArray();
        int num=0;
        int power=0;

        for(int i=0;i<array.length/2;i++){
            num=(num*10)+array[i]-48;
            num= (num*10)+array[array.length-1-i]-48;
        }
        if(array.length%2!=0){
            num=(num*10)+array[array.length/2]-48;
        }
        return num;
    }
}
