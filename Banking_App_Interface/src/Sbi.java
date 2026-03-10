import java.util.UUID;

public class Sbi implements BankAccount{

    private String holdername;
    private String accountno;
    private String password;
    private int balance;
    private final double rateofinterest;

    public Sbi(String holdername, String password, int balance){
        this.holdername = holdername;
        this.password = password;
        this.balance = balance;
        rateofinterest = 6.5;
    }

    public String getAccountno(){
        if(accountno == null){
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
            System.out.println("wrong password");
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
        if(!this.password.equals(currpassword)){
            System.out.println("curr password is wrong");
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
