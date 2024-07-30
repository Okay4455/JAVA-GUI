
   
/**
 * Write a description of class BankCard here.
 * This method Java class named "BankCard" that represents a bank card object.
 * @author (Sonam Dhendup Gurung)
 * @version (2022)
 */
public class BankCard
{
   private int card_id;
   private int balance_amount;
   private String client_name;
   private String issuer_bank;
   private String bank_account;
   public BankCard(int Card , int Balance , String Bank , String Issuer){
       this.card_id=  Card;
       this.balance_amount=Balance;
       this.client_name="";
       this.issuer_bank=Issuer;
       this.bank_account=Bank;
   }
   /*getters method----instance variable card_id*/
   public int getCID(){
       return this.card_id;
   }
   /*getters method----instance variable balance_amount*/
   public int getBA(){
       return this.balance_amount;
   }
   /*getters method----instance variable client_name*/
   public String getCN(){
       return this.client_name;
   }
     /*getters method----instance variable issuer_bank*/
   public String getIB(){
       return this.issuer_bank;
   }
     /*getters method----instance variable bank_account*/
   public String getBAcc(){
       return this.bank_account;
   }
   /*setters method----instance variable client_name*/
   public void setCLI1(String client){
       this.client_name=client;
   }
   /*setters method----instance variable balance_amount*/
   public void setbalance_amount(int Balance){
       this.balance_amount=Balance;
   }
   /*display method for bank_card*/
   public void display(){
       System.out.println("The card id is " + this.card_id);
       System.out.println("The balance amount is " +this.balance_amount);
       System.out.println("The issuer bank is " +this.issuer_bank);
       System.out.println("The bank account is " + this.bank_account);
       
   /*display method condition missing*/
   if(this.client_name== ""){
       System.out.println("The client name is empty. Please set appropriate value"); 
   }
   else
   {System.out.println("The client name is " + this.client_name);}
}
}


