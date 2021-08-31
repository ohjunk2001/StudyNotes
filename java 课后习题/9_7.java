import java.util.Date;

class Account {
    private int id;
    private double balance;
    private double annualInterstRate;
    Date accountCreatedDate;

    Account(){
        id=0;
        balance=0;
        accountCreatedDate=new Date();
    }
    Account(int id,double balance){
        this.id=id;
        this.balance=balance;
        accountCreatedDate=new Date();
    }
    void setAccount(int id,double balance,double annualInterstRate){
        this.id=id;
        this.balance=balance;
        this.annualInterstRate=annualInterstRate;
    }
    
    void setAccount(double annualInterstRate){
        this.annualInterstRate=annualInterstRate;
    }
    void getAccountCreatedDate(){
        System.out.println(accountCreatedDate.toString());
    }
    
    void getMonthlyInterestRate(){
        System.out.println(accountCreatedDate);
    }
    
    void getMonthlyInterest(){
        System.out.println(balance*annualInterstRate);
    }
    
    void withDraw(double balance){
        this.balance=this.balance-balance;
    }
    
    void desposit(double balance){
        this.balance=this.balance+balance;
    }


}