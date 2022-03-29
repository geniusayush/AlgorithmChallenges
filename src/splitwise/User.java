package splitwise;

import java.util.ArrayList;

public class User {
    public User(String id) {
        this.id = id;
        this.directBills= new ArrayList<Bill>();
        this.groups= new ArrayList<Groups>();
    }

    String id;


    public ArrayList<Groups> getGroups() {
        return groups;
    }

    public void addGroups(Groups group) {
        this.groups.add(group);
    }

    ArrayList<Groups> groups;

    public ArrayList<Bill> getDirectBills() {
        return directBills;
    }

    public void addDirectBills(Bill directBills) {
        this.directBills.add(directBills);
    }



    ArrayList<Bill> directBills;
     double total_contri;
     double total_owned;

    public void getStatus(boolean byGroup) {
        for(Groups g:groups){
            String name =g.name;
            double balance=0;
            for (Bill b:g.groupBills){
                for (Balances bal:b.balances){
                    if(bal.getUser()==this){
                        balance+=bal.getBalance();
                        break;
                    }
                }
            }
            System.out.println(name +"  balance is "+balance);
        }
    }
}
