
class rippling {
    public static void main(String args[]) {
        int[] a = {2,1,5,6,7};
        int amount =11;
        int matrix[][] = new int[amount+1][a.length];
        for(int i=0;i<=amount;i++){
            for(int j=0;j<a.length;j++){
                matrix[i][j]=-1;
            }
        }
        System.out.println(calc(amount,0,matrix, a)-1);
    }
    public static int calc(int i,int j,int[][] matrix,int a[]){
        if(i<0)return -1;

        if(matrix[i][j]!=-1) return matrix[i][j]; //memoization
        int result=0;

        if(j==matrix[0].length-1 ){if(i>a[j])return -1;else return 1;} // lsat step telling ewhether sum is valid or not

        result=calc(i-a[j],j+1,matrix,a);
        if(result!=-1){
            result+=1;
            result = Math.max(calc(i,j+1,matrix,a),result); //
        }
        else{
            result = calc(i,j+1,matrix,a); // if we pic the number the rest of the sum cannot be possible
        }
        matrix[i][j]=result;
        return result;
    }
}
// 10 minutes
// 2 5 6 4 7
/*
f[i][j]
i - 0 to 10
j - 1 to n
answer is gooinna be be in f[0][n]
f(i,j)= max(f(i,j+1),f(i-a[j],j+1));
*/
