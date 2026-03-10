public interface BankAccount {

    int checkbalance(String password);
    int deposit(int amount);
    void withdraw(int amount, String password);
    void changepassword(String oldpassword, String newpassword);
    double calculateinterest(int years);
}
