package splitwise;

import java.util.ArrayList;
import java.util.Arrays;

public class Groups {
     final String name;
    ArrayList<User>  userList;
ArrayList<Bill> groupBills;

    public Groups(String name, User[] users) {
this.name=name;
        this.userList = new ArrayList<>();
        userList.addAll(Arrays.asList(users));
        this.groupBills = new ArrayList<>();
    }

    public void addBill(Bill bill) {
        groupBills.add(bill);
    }

    public boolean contains(User b) {
        return userList.contains(b);
    }


}
