package splitwise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Bill {

    private final boolean percentage;
    Groups group;
    List<Balances> balances;

    public Bill(Groups group, boolean perecentage) {
        this.group = group;
        balances = new ArrayList<>();
        this.percentage = perecentage;
    }

    public void addBalances(double totalBill, Balances[] tally) throws Exception {
        validateBill(totalBill, tally);
         processBalance(totalBill, tally);
        this.balances = Arrays.asList(tally);
        if(group==null){
            for (Balances b : tally) {
                b.getUser().addDirectBills(this);
            }
        }
    }

    private void processBalance(double totalBill, Balances[] tally) {

        for (Balances b:tally){
            b.setShare(b.getShare()*totalBill/100);
        }
    }

    private void validateBill(double totalBill, Balances[] tally) throws Exception {
        if (group != null) {
            for (Balances b : tally) {
                if (!group.contains(b.getUser())) throw new Exception("the bill is invalid");
            }
        }

        double total_sum = 0;
        double total_exp = 0;
        for (Balances b : tally) {
            total_sum += b.getContribution();
            total_exp += b.getShare();
        }
        if (total_exp !=  100 || total_sum != totalBill) {
            throw new Exception("bill is incopmplete");
        }


    }
    public static String maskify(String creditCardNumber) {
        if(creditCardNumber.length()<6)return creditCardNumber;
        char[] arr = creditCardNumber.toCharArray();
        for (int i = 0; i <arr.length; i++) {

            if(Character.isDigit(arr[i])){
                if(i>0 && i<arr.length-4  )arr[i]='#';
            }

        }
        return arr.toString();
    }
    public double evaluate(String expr) {
        double returnValue = 0;
        if(expr.length()==0)return 0;
        String[] tokens=expr.split(" ");

        String operators = "+-*/";

        Stack<String> stack = new Stack<String>();

        for(String t : tokens){
            if(!operators.contains(t)){
                stack.push(t);
            }else{
                double a = Double.valueOf(stack.pop());
                double b = Double.valueOf(stack.pop());
                int index = operators.indexOf(t);
                switch(index){
                    case 0:
                        stack.push(String.valueOf(a+b));
                        break;
                    case 1:
                        stack.push(String.valueOf(b-a));
                        break;
                    case 2:
                        stack.push(String.valueOf(a*b));
                        break;
                    case 3:
                        stack.push(String.valueOf(b/a));
                        break;
                }
            }
        }

        returnValue = Double.valueOf(stack.pop());

        return returnValue;
    }
}
