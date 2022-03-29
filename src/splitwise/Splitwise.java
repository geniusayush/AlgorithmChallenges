package splitwise;

public class Splitwise {
    public static void main(String[] args) {
        Splitwise system = new Splitwise();
        User ayush = system.createUser("ayush");
        User ramesh = system.createUser("ramesh");
        User a = system.createUser("a");
        User b = system.createUser("b");
        User c = system.createUser("c");

        User[] arr1 = {a, c,b};

        Groups g1 = null;

        try {
            g1 = system.createGroup("g1",arr1);


        } catch (Exception e) {
            e.printStackTrace();
        }


        Bill b1 = system.generateBill(g1,true);

        Balances bal1=new Balances(a,33.4,100);
        Balances bal3=new Balances(c,33.3,0);
        Balances bal2=new Balances(b,33.3,0);

        Balances[] money = new Balances[]{bal1,bal2,bal3};

        system.addBalance(b1, money);

        Bill b2 = system.generateBill(g1,true);

        Balances bal12=new Balances(a,33.4,50);
        Balances bal32=new Balances(c,33.3,50);
        Balances bal22=new Balances(b,33.3,0);

        Balances[] money2 = new Balances[]{bal12,bal22,bal32};

        system.addBalance(b2, money2);





        // system.generateBill(null, true);

        c.getStatus(true);

    }

    public  void addBalance(Bill b1, Balances[] money) {

        try {
            b1.addBalances(100, money);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Bill generateBill(Groups g1, boolean perecentage) {
        Bill bill;
        if (g1 == null) {
            bill = new Bill(null,perecentage);
        } else {
            bill = new Bill(g1, perecentage);
            g1.addBill(bill);
        }

        return bill;


    }

    private Groups createGroup(String name, User[] arr) throws Exception {
        if (arr.length == 0) throw new Exception("empty group cannot be made");
        for (User u : arr) {
            if (u == null) throw new Exception("users cant be null");
        }
        Groups g1 = new Groups(name,arr);
        for (User u : arr) {
            u.groups.add(g1);
        }

        return g1;

    }

    private User createUser(String name) {
        User u = new User(name);
        return u;
    }
}
