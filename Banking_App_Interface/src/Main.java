public class Main {

    public static void main(String[]args){
        Hdfc Prashantaccount = new Hdfc("Prashant Parekh", "pqr", 1000);
        System.out.println(Prashantaccount.getAccountno());


        Prashantaccount.deposit(2000);
        System.out.println(Prashantaccount.checkbalance("abc"));
        System.out.println(Prashantaccount.checkbalance("pqr"));

        Prashantaccount.withdraw(1000, "hhy");
        Prashantaccount.withdraw(5000, "pqr");
        Prashantaccount.withdraw(1000, "pqr");

        Prashantaccount.changepassword("xyz", "pras0101");
        Prashantaccount.changepassword("pqr","pras0101");

        System.out.println(Prashantaccount.calculateinterest(2));

        //now making account in sbi bank
        System.out.println("sbi account");
        Sbi mrbeastaccount = new Sbi("Mr beast", "beast0101", 100);
        System.out.println(mrbeastaccount.getAccountno());

        mrbeastaccount.deposit(900);
        System.out.println(mrbeastaccount.checkbalance("yyz"));
        System.out.println(mrbeastaccount.checkbalance("beast0101"));

        mrbeastaccount.withdraw(100, "ttt");
        mrbeastaccount.withdraw(20000, "beast0101");
        mrbeastaccount.withdraw(200,"beast0101");

        mrbeastaccount.changepassword("pras0101", "beast0101");
        mrbeastaccount.changepassword("beast0101", "beast0202");

        System.out.println(mrbeastaccount.calculateinterest(3));
    }
}
