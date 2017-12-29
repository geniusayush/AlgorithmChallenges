import java.util.HashMap;
import java.util.HashSet;
/*
* the aim of this program is to get a binary representaion if a integer from msb to rsb
* input is the numner anbd output is with 0 index being the count and rest being the array
* */
public class binary {
    static int[] getOneBits(int num) {
        int binary[] = new int[40];
        int index = 0;

        int onec=0;
        while(num > 0){
            binary[index] = num%2;
            if(binary[index]==1){onec++;}
            num = num/2;
            index++;
        }
        // index contains the array  and onec is the number of ones
        int one[]=new int[onec+1];
        one[0]=onec; // 0 index value is the count
        onec=1; //onec is now acting as indx fr the the next loop hence at 1

        for(int i=index;i>=0;i--){// counting elements from msb to lsb
            if(binary[i]==1){one[onec]=index-i;onec++;}
        }
        return one;
    }

    public static void main(String[] args) {
        System.out.println(getOneBits(161));
    }
}
