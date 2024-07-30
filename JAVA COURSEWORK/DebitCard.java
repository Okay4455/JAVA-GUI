
/**
 * Write a description of class DebitCard here.
 *This is a class called "DebitCard" in Java that extends the "BankCard" class.
 *The class has a constructor that initializes these instance variables and sets the client information and balance amount by calling the parent class' constructor "BankCard". 
 *The class also has getter and setter methods for each instance variable.
 * @author (Sonam dhendup Gurung)
 * @version (2022)
 */
public class DebitCard extends BankCard
{
   private int PIN_number;
   private int Withdrawal_amount;
   private String Date_Of_Withdrawal;
   private boolean has_Withdrawn;
   
   public DebitCard(int Balance, int Card,String Bank, String Issuer, String client, int Pin_number )
   {
       super(Card,Balance,Bank,Issuer);
       super.setCLI1( client);
       this.PIN_number=Pin_number;
       this.has_Withdrawn=false;
}
  /*getters method----instance variable PIN_number*/ 
   public int getPIN_number()
   {
       return this.PIN_number;
}
/*getters method----instance variable Withdrawal_amount*/
   public int getWithdrawal_amount(){
       return this.Withdrawal_amount;
}
/*getters method----instance variable Date_Of_Withdrawal*/
   public String getDate_Of_Withdrawal(){
       return this.Date_Of_Withdrawal;
}
/*getters method----instance variable gethas_Withdrawn*/
   public boolean gethas_Withdrawn(){
       return this.has_Withdrawn;
}
/*setters method----instance variable Withdrawal_amount*/
   public void setWithdrawal_amount(int WITHDRAWAL_ACCOUNT) {
       this.Withdrawal_amount=WITHDRAWAL_ACCOUNT;
   }
   /*The "withdraw" method allows for a withdrawal from the account if the correct PIN number is entered and the withdrawal amount does not exceed the balance.*/
   public void withdraw(int withdrawal_amount, String date_Of_Withdrawal,int pin_number){
        if(this.PIN_number==pin_number && withdrawal_amount<=super.getBA()){
         this.has_Withdrawn=true;
         setWithdrawal_amount(withdrawal_amount);
         int new_balance= super.getBA()-withdrawal_amount;
         super.setbalance_amount(new_balance);
         this.Date_Of_Withdrawal=date_Of_Withdrawal;
         System.out.println("The transaction is successful");
        }
         else{
             System.out.println("The transaction is unsuccessful, wrong pin or insufficient balance");
         }
}
//display method for Debit card//
       public void display(){
       if(has_Withdrawn=true){
           System.out.println("Withdrawal amount:"+this.Withdrawal_amount);
           System.out.println("Date of withdrawal"+this.Date_Of_Withdrawal);
           System.out.println("Pin Number"+this.PIN_number);
           super.display();
       }
       else{
           System.out.println("Your Balance Amount is"+super.getBA() );
       }
}
}
   

