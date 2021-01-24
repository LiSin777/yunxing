public class Bank {
    private String username;
    private double balance;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Bank(String username, double balance) {
        this.username = username;
        this.balance = balance;
    }

    public double findBalance(){
        return balance;
    }
}
