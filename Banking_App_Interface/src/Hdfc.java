import java.util.UUID;

public class Hdfc implements BankAccount {

    private String accountno;
    private String holdername;
    private String password;
    private int balance;
    private final double rateofinterest;


    public Hdfc(String holdername, String password, int balance){
        this.holdername = holdername;
        this.password = password;
        this.balance = balance;
        this.rateofinterest = 7.5;
    }

    public String getAccountno(){
        if(accountno == null) {
            this.accountno = String.valueOf(UUID.randomUUID());
        }
        return accountno;
    }


    @Override
    public int checkbalance(String password) {
        if(this.password.equals(password)){
            return this.balance;
        }
        return -1;
    }

    @Override
    public int deposit(int amount) {
        this.balance += amount;
        return balance;
    }

    @Override
    public void withdraw(int amount, String password) {
        if(!this.password.equals(password)){
            System.out.println("Wrong password");
            return;
        }
        if(amount > this.balance){
            System.out.println("Insufficient balance");
            return;
        }
        this.balance -= amount;
        System.out.println("Your final bal="+ this.balance);
    }

    @Override
    public void changepassword(String currpassword, String newpassword) {
        if (!this.password.equals(currpassword)) {
            System.out.println("current password is wrong");
            return;
        }
        this.password = newpassword;
        System.out.println("your password changed successfully");
    }

    @Override
    public double calculateinterest(int years) {
        return (this.balance * this.rateofinterest * years)/100.0;
    }
}
