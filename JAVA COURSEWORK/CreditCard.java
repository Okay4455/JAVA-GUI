
/**
 * This is a Java class named "CreditCard" that extends the "BankCard" class.
 *  The class has a constructor to initialize these variables and setters and getters for each of these instance variables. 
 *  It also has methods to grant a credit limit, cancel a credit card, and display all information.
 * 
 * @author (Sonam Dhendup Gurung)
 * @version (2022)
 */
public class CreditCard extends BankCard
{
   private int Cvc_Number;
   private double Credit_Limit;
   private double Interest_Rate;
   private String Expiration_Date;
   private int Grace_Period;
   private boolean Is_Granted;
   public CreditCard(int balance, int Card,String Bank , String Issuer, String client, int cvc_num , double interest_rate, String expire_d)
   {
     super(Card,balance,Bank,Issuer);
     super.setCLI1(client);
     this.Cvc_Number=cvc_num;
     this.Interest_Rate=interest_rate;
     this.Expiration_Date=expire_d;
     this.Is_Granted=false;
   }
   /*getters method----instance variable Cvc_Number*/
   public int getCvc_Number(){
       return this.Cvc_Number;
   }
   /*getters method----instance variable Credit_Limit*/
   public double getCredit_Limit(){
       return this.Credit_Limit;
   }
   /*getters method----instance variable Interest_Rate*/
   public double getInterest_Rate(double interest_R){
       return this.Interest_Rate;
   }
   /*getters method----instance variable Grace_Period*/
   public int getGrace_Period(int Grace_P){
       return this.Grace_Period;
   }
   /*getters method----instance variable Expiration_Date*/
   public String getExpiration_Date(String exp_D){
       return this.Expiration_Date;
   }
   /*getters method----instance variable Is_Granted*/
   public boolean getIs_Granted(boolean is_Granted){
       return this.Is_Granted;
   }
   /*This method determines your Credit Limit and grants you credits*/
   public void setCredit_Limit(double newcredit_Limit , int grace_Period)
   {
   if(newcredit_Limit<=(2.5* getBA())){
       double new_Balance =(getBA()-newcredit_Limit);
       this.Grace_Period =grace_Period;
       this.Is_Granted=true;
       this.Credit_Limit = newcredit_Limit;
       System.out.println("Credit is granted");
   }
   else{
       System.out.println("Credit Limit Execeed. Credit Cannot Be Issued!");
   }}
   /*This method cancels all the credit card values and covert them to 0*/
   public void CancelCreditCard(){
     this.Cvc_Number=0;
     this.Credit_Limit=0;
     this.Grace_Period=0;
     this.Is_Granted=false;
   }
   /*The "display_All_Information" method displays the details of a credit card if credit has been granted, otherwise, it displays the details of the bank card.*/
   public void Display_All_Information(){
       if(Is_Granted=true){
           System.out.println("Your Details");
           super.display(); 
           System.out.println("Cvc Number" +this.Cvc_Number );
           System.out.println("Credit Limit"+this.Credit_Limit);
           System.out.println("Grace Period"+this.Grace_Period);
       }
       else{
          System.out.println("Your Details");
          super.display();
          System.out.println("Cvc Number" +this.Cvc_Number );
       }
   }
}
