package splitwise;

public class Balances {
    User user;
    double share;
    double contribution;

    public User getUser() {
        return user;
    }

    public Balances(User user, double share, double contribution) {
        this.user = user;
        this.share = share;
        this.contribution = contribution;
        this.balance=share-contribution;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getShare() {
        return share;
    }

    public void setShare(double share) {
        this.share = share;
        this.balance=share-contribution;
    }

    public double getContribution() {
        return contribution;
    }

    public void setContribution(double contribution) {
        this.contribution = contribution;
        this.balance=share-contribution;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Balances(User user, double share) {

        this.user = user;
        this.share = share;
    }

    double balance;
}
