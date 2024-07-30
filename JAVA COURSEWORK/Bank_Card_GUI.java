import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup; 
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 * Write a description of class Bank_GUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bank_Card_GUI implements ActionListener
{
        private JButton BWithdraw1, BDis1,BClear1,BGO1,BAddDC1;
        private JPanel JPan1;
        private JLabel JLab1,LCard1,LIssue1,LBal1,LClient1,LBankAcc1,LPIN1,LWithdrawAmt1,LDateOfWith1;
        private JComboBox JCB_Day1,JCB_M1,JCB_Y1;
        private JTextField TextCard1,TextIssue1,TBalance1,TClient1,TBankAcc1,TPIN1,TWithAmt1;
        private JFrame JFra1;
        //Credit Card
        private JButton BAddC,BCrCan,BSetCrL,BClear,BDisplay;
        private JLabel JLCC,LCard,LIssue,LBal,LClient,LBankAcc,LCVC,LIntRate,LDateOfExp,LCrLimit,LGP;
        private JTextField TextCard,TextIssue,TBalance,TClient,TBankAcc,TCVC,TIRate,TCrLimit,TGP;
        private JComboBox JCB_Day,JCB_M,JCB_Y;
        private JFrame JFram;
        private JPanel JPan;
        ArrayList<BankCard> Arr_List = new ArrayList<BankCard>();
        
     public void actionPerformed(ActionEvent e)
     {
      if(e.getSource() == BWithdraw1) {
    // Get the values entered by the user in the GUI
    int withdrawAmount = Integer.valueOf(TWithAmt1.getText()); // Amount to withdraw
    int cardId = Integer.valueOf(TextCard1.getText()); // Card ID
    int pinNumber = Integer.valueOf(TPIN1.getText()); // PIN number
    String dayValue = JCB_Day1.getSelectedItem().toString(); // Day of withdrawal
    String monthValue = JCB_M1.getSelectedItem().toString(); // Month of withdrawal
    String yearValue = JCB_Y1.getSelectedItem().toString(); // Year of withdrawal
    String withdrawalDateValue = dayValue + "/" + monthValue + "/" + yearValue; // Date of withdrawal

    // Display success message
    JOptionPane.showMessageDialog(JPan1,"Successfully Withdrawn");

    // Search for the card in the ArrayList
    for (BankCard bankCard : Arr_List) {
        if (bankCard instanceof DebitCard) { // Check if the card is a DebitCard
            // Downcast the bankCard object to a DebitCard object
            DebitCard debitCard = (DebitCard) bankCard;
            // Check if the card ID matches the one entered by the user
            if (debitCard.getCID() == cardId) {
                // Display information about the withdrawal
                JOptionPane.showMessageDialog(JPan1, "The card ID is: " + cardId + "\n" +
                        "The withdrawal amount is: " + withdrawAmount + "\n" +
                        "The PIN number is: " + pinNumber + "\n");
                // Check if the PIN entered by the user matches the PIN of the DebitCard
                if (pinNumber == debitCard.getPIN_number()) {
                    // Check if the withdrawal amount is less than or equal to the balance on the DebitCard
                    if (withdrawAmount <= debitCard.getBA()) {
                        // Withdraw the specified amount from the DebitCard
                        debitCard.withdraw(withdrawAmount, withdrawalDateValue, pinNumber);
                    } else {
                        JOptionPane.showMessageDialog(JPan1, "Sorry, insufficient amount!");
                    }
                } else {
                    JOptionPane.showMessageDialog(JPan1, "Sorry, the PIN number is incorrect.");
                }
            } else {
                JOptionPane.showMessageDialog(JPan1, "Sorry, the Card ID doesn't match.");
            }
        }
    }
   }

       else if(e.getSource() == BDis1) {
       // Display the details of a debit card
      for(BankCard arr: Arr_List)
             {
                if (arr instanceof DebitCard)
                {
                    DebitCard obj = (DebitCard) arr;
                    obj.display();
                }
                System.out.println("The Card id is: "+ TextCard1);
             }
            }
    
        else if(e.getSource() == BClear) {
        // Clear the input fields
        TextCard1.setText("");
        TextIssue1.setText("");
        TBalance1.setText("");
        TClient1.setText("");
        TBankAcc1.setText("");
        TPIN1.setText("");
        TWithAmt1.setText("");
         }

        else if(e.getSource() == BGO1)
        {
           mC();
           JFram.dispose();
        }
        else if(e.getSource() == BAddDC1) // if the "Add Debit Card" button is clicked
  {
    // get the values entered in the text fields
    int Card_id = Integer.valueOf(TextCard1.getText()); // card ID
    String IssuerBankk= TextIssue1.getText(); // issuer bank
    int Balance_Amt= Integer.valueOf(TBalance1.getText()); // balance amount
    String Client_Name= TClient1.getText(); // client name
    String Bank_Amount = TBankAcc1.getText(); // bank account number
    int PIN_Number= Integer.valueOf(TPIN1.getText()); // PIN number
    
    boolean B1 = true; // initialize a boolean variable to true
    
    // loop through the array list of bank cards to check if the card ID entered already exists
    for(BankCard BankC1:Arr_List)
    {
        if (BankC1 instanceof DebitCard) // check if the current bank card is an instance of DebitCard
        {
            DebitCard DEBC = (DebitCard) BankC1; // if so, cast it as a DebitCard object
            if (DEBC.getCID() == Card_id) // if the card ID matches the one entered
            {
                B1=false; // set the boolean variable to false
                break; // break out of the loop
            }
        }
    }
    
    if (B1==true) // if the boolean variable is still true (i.e. the card ID was not found in the array list)
    {
        // create a new DebitCard object with the values entered in the text fields
        DebitCard obj_Deb = new DebitCard (Balance_Amt,Card_id,Bank_Amount, IssuerBankk, Client_Name,  PIN_Number);
        Arr_List.add(obj_Deb); // add the new DebitCard object to the array list
        JOptionPane.showMessageDialog(JPan1, "Successfully added!"); // show a success message
    }
    else // if the boolean variable is false (i.e. the card ID was found in the array list)
    {
        JOptionPane.showMessageDialog(JPan1, "Already Added"); // show an error message
    }
  }
   // Credit Card
   else if (e.getSource() == BAddC)
        {
            try 
            {
                // taking input from fields and storing them in their respecitve variables
                int credit_id_value = Integer.parseInt(TextCard.getText());
                String credit_bank_value = TextIssue.getText();
                int credit_bal_value = Integer.parseInt(TBalance.getText()); 
                String credit_client_value = TClient.getText();
                String credit_acc_value = TBankAcc.getText();
                int credit_cvc_value = Integer.parseInt(TCVC.getText());
                double credit_int_rate_value = Double.parseDouble(TIRate.getText());
                String day_value = JCB_Day.getSelectedItem().toString();
                String month_value = JCB_M.getSelectedItem().toString();
                String year_value = JCB_Y.getSelectedItem().toString();
                String credit_date_value = day_value+"/"+month_value+"/"+year_value;
                boolean flag = true;
            
            
                for (BankCard item_element: Arr_List)
                {   
                    // checking if the element is instance of creditcard class
                    if (item_element instanceof CreditCard)
                    {
                        // downcasting item_element from bankCard class to creditCard class
                        CreditCard newObject = (CreditCard) item_element;
                        
                        if (newObject.getCID() == credit_id_value)
                        {
                            // sets flag to false if the card id value is repeated as card id is unique
                            flag = false;
                            JOptionPane.showMessageDialog(JPan, "Error adding item");
                        }
                    }
                }
                    
                if (flag == true)
                {
                    // this creates an object debitObject using constructor DebitCard with parameters credit_id_value, credit_bal_value, credit_acc_value, credit_bank_value,  credit_client_value, credit_cvc_value, credit_int_rate_value, credit_date_value
                    CreditCard creditObject = new CreditCard(credit_id_value, credit_bal_value, credit_acc_value, credit_bank_value,  credit_client_value, credit_cvc_value, credit_int_rate_value, credit_date_value);
                    // prints success dialogue box
                    JOptionPane.showMessageDialog(JPan, "Success, your credentials have been added.");
                    JOptionPane.showMessageDialog(JPan, "Displaying Account Credentials" + "\nCard ID: " + credit_id_value + "\nIssuer Bank: " + credit_bank_value + "\nAccount Balance: " + credit_bal_value + "\nClient Name: " +credit_client_value + "\nAccount Number: " + credit_acc_value + "\nCVC Number: " + credit_cvc_value + "\nInterest Rate: " + credit_int_rate_value + "\nExpiration Date: " + credit_date_value);
                    // adding the object to the arraylist
                    Arr_List.add(creditObject);
                }
            }
            catch (NumberFormatException err)
            {
                JOptionPane.showMessageDialog(JPan, "Error: Fields have invalid input in them. ");
            }
}
if (e.getSource() == BAddC) {
    System.out.println("Add Credit Card button clicked");
    // Get the values entered by the user in the GUI
    int card = Integer.valueOf(TextCard.getText()); // Card number
    System.out.println("Card number: " + card);
    String issue = TextIssue.getText(); // Date of issue
    System.out.println("Date of issue: " + issue);
    int balance = Integer.valueOf(TBalance.getText()); // Balance on the card
    System.out.println("Balance on the card: " + balance);
    String client = TClient.getText(); // Name of the card holder
    System.out.println("Name of the card holder: " + client);
    String bankAcc = TBankAcc.getText(); // Bank account number
    System.out.println("Bank account number: " + bankAcc);
    String gp = TGP.getText(); // Card's grace period
    System.out.println("Card's grace period: " + gp);
    int crLimit = Integer.valueOf(TCrLimit.getText()); // Credit limit
    System.out.println("Credit limit: " + crLimit);
    int cvc = Integer.valueOf(TCVC.getText()); // Card Verification Code
    System.out.println("Card Verification Code: " + cvc);
    double intRate = Integer.valueOf(TIRate.getText()); // Interest rate
    System.out.println("Interest rate: " + intRate);
    String day_value1 = JCB_Day.getSelectedItem().toString();
    String month_value1 = JCB_M.getSelectedItem().toString();
    String year_value1 = JCB_Y.getSelectedItem().toString();
    String expiration_Date = day_value1 + "/" + month_value1 + "/" + year_value1;
    System.out.println("Expiration date: " + expiration_Date);
    // Check if the card has already been added to the ArrayList
    boolean isCardAdded = false;
    for (BankCard bankCard : Arr_List) {
        if (bankCard instanceof CreditCard) {
            CreditCard creditCard = (CreditCard) bankCard;
            if (creditCard.getCID() == card) {
                isCardAdded = true;
                break;
            }
        }
    }
    System.out.println("Is card already added? " + isCardAdded);
    // If the card hasn't been added, create a new CreditCard object and add it to the ArrayList
    if (!isCardAdded) {
        CreditCard obj_Cr = new CreditCard(balance, card, bankAcc, issue, client, cvc, intRate, expiration_Date);
        Arr_List.add(obj_Cr);
        JOptionPane.showMessageDialog(JPan, "Successfully added!");
        System.out.println("Credit card added successfully!");
    } 
    // If the card has already been added, display an error message
    else {
        JOptionPane.showMessageDialog(JPan, "Card already added.");
        System.out.println("Error: Credit card already added!");
    }
    }

        else if(e.getSource() == BCrCan)
               {
                  {
                    try
                       {
                        int Card_Id = Integer.valueOf(TextCard.getText());
        
                        boolean id = false;
                        for(BankCard B_Card : Arr_List)
                        {
                            if(B_Card instanceof CreditCard )
                            {
                            if(B_Card.getCID() == Card_Id)
                            {
                                id = true;
                                CreditCard C_Card = (CreditCard) B_Card;
        
                                C_Card.CancelCreditCard();
        
                                JOptionPane.showMessageDialog(null, "Your Credit Card has been cancelled successfully.","Successfully cancelled.", JOptionPane.PLAIN_MESSAGE);
                            }
                         }
                        }
                        if(id == false)
                        {
                         JOptionPane.showMessageDialog(null, "Card Id doesn't exist\n" + "Please enter correct Card Id","Incorrect Card Id", JOptionPane.WARNING_MESSAGE);
                        }
                       }
                   catch(Exception E)
                 {
                    JOptionPane.showMessageDialog(null, "Your Credit Card details are invalid!!!", "Invalid Credit Card details!!", JOptionPane.ERROR_MESSAGE);
                 }
             }
          }
          else if(e.getSource() == BSetCrL)
             {
              double CR_Limit =Double.valueOf(TCrLimit.getText());
              int Card_Id = Integer.valueOf(TextCard.getText());
              int CVC_Number = Integer.valueOf(TCVC.getText());
              int Grace_Period = Integer.valueOf(TGP.getText());
              String day_value = JCB_Day.getSelectedItem().toString();
              String month_value = JCB_M.getSelectedItem().toString();
              String year_value = JCB_Y.getSelectedItem().toString();
              String Cr_date_value = day_value + "/" + month_value + "/" + year_value;
              JOptionPane.showMessageDialog(JPan,"Successfully Withdrawn");
              for (BankCard UD : Arr_List)
              {
                 if (UD instanceof CreditCard)
                 {
                    //Down castin
                    CreditCard Cr_obj = (CreditCard) UD;
                    //comparison if the value of Debit Card are same or not
                
                     if(Cr_obj.getCID()== Card_Id)
                     {
                        JOptionPane.showMessageDialog(JPan , "The card id is:  " + Card_Id + "/n"+ "The Credit Limit is : " + CR_Limit + "/n"+"The CVC number is: " + CVC_Number + "/n");
                        if (CR_Limit == Cr_obj.getCredit_Limit( )){
                            //check if the witdraw amt is smaller than balanv=ce amount
                            if(CR_Limit <= 2.5*Cr_obj.getBA())
                            {
                               
                              Cr_obj.setCredit_Limit(CR_Limit , Grace_Period);
                              JOptionPane.showMessageDialog(JPan, "Successfully updated credit limit!");
                            }
                             else{
                                 JOptionPane.showMessageDialog(JPan,"Sorry , Insufficient Amount!!!!!!");
                             }
                        }else{
                            JOptionPane.showMessageDialog(JPan,"Sorry , The Pin number is incorrect.");
                        }
                    }else{
                        JOptionPane.showMessageDialog(JPan,"Sorry , The Card Id doesnt match.");
                    }
                 }
              }
       }
      else if(e.getSource() == BClear)
            {
            TextCard.setText("");
            TextIssue.setText("");
            TBalance.setText("");
            TClient.setText("");
            TBankAcc.setText("");
            TCVC.setText("");
            TCrLimit.setText("");
            TGP.setText("");
            TIRate.setText("");
            JCB_Day.setSelectedIndex(2023);
            JCB_M.setSelectedIndex(0);
            JCB_Y.setSelectedIndex(1);
            
            }
         else if(e.getSource() == BDisplay)
            {
               for(BankCard arr: Arr_List)
                 {
                    if (arr instanceof CreditCard)
                    {
                        CreditCard obj = (CreditCard) arr;
                        obj.Display_All_Information();
                    }
                 }
            }
             
     }
    
         public void m1D()
        {
          JFra1 = new JFrame("Coursework");
          JFra1.setBounds(250, 5 , 1000 , 800);
          JFra1.setLayout(null);
          
          JPan1 = new JPanel();
          JPan1.setBounds(0,0,1000,800);
          JPan1.setBackground(Color.lightGray);
          JPan1.setLayout(null);
          
          JLab1 = new JLabel("Debit Card");
          JLab1.setBounds(400,20 , 200 , 60);
          JLab1.setFont(new Font("Arial" , Font.BOLD,30));
          
          LCard1 = new JLabel("Card ID"); 
          LCard1.setBounds(80, 80 , 80 , 50);
          LCard1.setFont(new Font("Arial" , Font.PLAIN,20));
          TextCard1 = new JTextField();
          TextCard1.setBounds(160, 90 , 100 , 30);
          
          LIssue1 = new JLabel("Issuer Bank");
          LIssue1.setBounds(600, 80 , 140 , 50);
          LIssue1.setFont(new Font("Arial" , Font.PLAIN,20));
          TextIssue1 = new JTextField();
          TextIssue1.setBounds(725, 90 , 100 , 30);
          
          LBal1 = new JLabel("Balance amount");
          LBal1.setBounds(80 , 150 , 200 , 30);
          LBal1.setFont(new Font("Arial" , Font.PLAIN,20));
          TBalance1 = new JTextField();
          TBalance1.setBounds(240, 150 , 100 , 30);
          
          LClient1 = new JLabel("Client Name");
          LClient1.setBounds(600 , 150 , 150 , 30);
          LClient1.setFont(new Font("Arial" , Font.PLAIN,20));
          TClient1 = new JTextField();
          TClient1.setBounds(725, 150 , 100 , 30);
          
          LBankAcc1 = new JLabel("Bank Account");
          LBankAcc1.setBounds(80, 220 , 200 , 30);
          LBankAcc1.setFont(new Font("Arial" , Font.PLAIN,20));
          TBankAcc1 = new JTextField();
          TBankAcc1.setBounds(220, 220 , 120 , 30);
          
          LPIN1 = new JLabel("Pin Number");
          LPIN1.setBounds(600 , 220 , 150 , 30);
          LPIN1.setFont(new Font("Arial" , Font.PLAIN,20));
          TPIN1 = new JTextField();
          TPIN1.setBounds(725, 220 , 100 , 30);
          
          BAddDC1 = new JButton ("Add Debit Card");
          BAddDC1.setBounds(350 , 300, 190, 30);
          BAddDC1.setFont(new Font("Arial" , Font.PLAIN,20));
          
          BGO1 = new JButton ("Go Back");
          BGO1.setBounds(650 , 350, 150, 30);
          BGO1.setFont(new Font("Arial" , Font.PLAIN,20));
          
          LWithdrawAmt1 = new JLabel("Withdraw Amount");
          LWithdrawAmt1.setBounds(80, 425 , 200 , 30);
          LWithdrawAmt1.setFont(new Font("Arial" , Font.PLAIN,20));
          TWithAmt1 = new JTextField();
          TWithAmt1.setBounds(260, 425, 100 , 30);
          
          LDateOfWith1= new JLabel("Date of Withdrawal");
          LDateOfWith1.setBounds(80 , 550 , 200 , 30);
          LDateOfWith1.setFont(new Font("Arial" , Font.PLAIN,20));
          JCB_Day1 = new JComboBox();
          JCB_Day1.setBounds(280 , 555 , 50 , 20);
          for(int i = 1 ; i<=30 ; i++){
                Integer str = (Integer) i;
                JCB_Day1.addItem(str);
          }
          
          String[] months = {"January","Febuary","March","April","May","June","July","August","September","October","November","December"};
          JCB_M1 = new JComboBox(months);
          JCB_M1.setBounds(350, 555 , 80 , 20);
            
          JCB_Y1 = new JComboBox();
          JCB_Y1.setBounds(480 , 555 , 60 , 20);
          for(int a = 1900 ; a<=2023 ; a++){
                Integer str = (Integer) a ;
                JCB_Y1.addItem(str);
          } 
            
          BWithdraw1 = new JButton ("Withdraw");
          BWithdraw1.setBounds(250 , 655 , 150 , 30);
          BWithdraw1.setFont(new Font("Arial" , Font.PLAIN,20));
          
          JButton BDis1 = new JButton ("Display");
          BDis1.setBounds(450, 655 , 100 , 30);
          BDis1.setFont(new Font("Arial" , Font.PLAIN,20));
          
          BClear1 = new JButton ("Clear");
          BClear1.setBounds(620 , 655 , 100 , 30);
          BClear1.setFont(new Font("Arial" , Font.PLAIN,20));
          
          BClear1.addActionListener(this);
          BDis1.addActionListener(this);
          BWithdraw1.addActionListener(this);
          BGO1.addActionListener(this);
          BAddDC1.addActionListener(this);
          
          
          JPan1.add(JCB_Y1);    
          JPan1.add(JCB_M1);  
          JPan1.add(JCB_Day1); 
          JPan1.add(LDateOfWith1);
          JPan1.add(TWithAmt1);
          JPan1.add(LWithdrawAmt1);
          JPan1.add(BWithdraw1);
          JPan1.add(BDis1);
          JPan1.add(BClear1);
          JPan1.add(BGO1);
          JPan1.add(BAddDC1);
          JPan1.add(LPIN1);
          JPan1.add(TPIN1);
          JPan1.add(TBankAcc1);
          JPan1.add(LBankAcc1);
          JPan1.add(TClient1);
          JPan1.add(LClient1);
          JPan1.add(TBalance1);
          JPan1.add(LBal1);
          JPan1.add(TextIssue1);
          JPan1.add(LIssue1);
          JPan1.add(TextCard1);
          JPan1.add(LCard1);
          JPan1.add(JLab1);
          JFra1.add(JPan1);
          JFra1.setVisible(true);
     } 
       public void mC()
      {
          JFram = new JFrame("Coursework");
          JFram.setBounds(250, 5 , 1000 , 800);
          JFram.setLayout(null);
          
          JPan = new JPanel();
          JPan.setBounds(0,0,1000,800);
          JPan.setBackground(Color.LIGHT_GRAY);
          JPan.setLayout(null);
          
          JLCC = new JLabel("Credit Card");
          JLCC.setBounds(400,20 , 200 , 60);
          JLCC.setFont(new Font("Arial" , Font.BOLD,30));
          
          LCard = new JLabel("Card ID"); 
          LCard.setBounds(80, 80 , 80 , 50);
          LCard.setFont(new Font("Arial" , Font.PLAIN,20));
          TextCard = new JTextField();
          TextCard.setBounds(160, 90 , 100 , 30);
          
          LIssue = new JLabel("Issuer Bank");
          LIssue.setBounds(600, 80 , 140 , 50);
          LIssue.setFont(new Font("Arial" , Font.PLAIN,20));
          TextIssue = new JTextField();
          TextIssue.setBounds(725, 90 , 100 , 30);
          
          JLabel LBal = new JLabel("Balance amount");
          LBal.setBounds(80 , 150 , 200 , 30);
          LBal.setFont(new Font("Arial" , Font.PLAIN,20));
          JTextField TBalance = new JTextField();
          TBalance.setBounds(240, 150 , 100 , 30);
          
          JLabel LClient = new JLabel("Client Name");
          LClient.setBounds(600 , 150 , 150 , 30);
          LClient.setFont(new Font("Arial" , Font.PLAIN,20));
          JTextField TClient = new JTextField();
          TClient.setBounds(725, 150 , 100 , 30);
          
          JLabel LBankAcc = new JLabel("Bank Account");
          LBankAcc.setBounds(80, 220 , 200 , 30);
          LBankAcc.setFont(new Font("Arial" , Font.PLAIN,20));
          JTextField TBankAcc = new JTextField();
          TBankAcc.setBounds(220, 220 , 120 , 30);
          
          JLabel LCVC = new JLabel("CVC Number");
          LCVC.setBounds(600 , 220 , 150 , 30);
          LCVC.setFont(new Font("Arial" , Font.PLAIN,20));
          JTextField TCVC = new JTextField();
          TCVC.setBounds(725, 220 , 100 , 30);
          
          JButton BAddC = new JButton ("Add Credit Card");
          BAddC.setBounds(350 , 300, 190, 30);
          BAddC.setFont(new Font("Arial" , Font.PLAIN,20));
          
          JButton BCrCan = new JButton ("Cancel Credit");
          BCrCan.setBounds(650 , 300, 160, 30);
          BCrCan.setFont(new Font("Arial" , Font.PLAIN,20));
          
          JLabel LIntRate = new JLabel("Interest Rate");
          LIntRate.setBounds(80 , 350 , 150 , 30);
          LIntRate.setFont(new Font("Arial" , Font.PLAIN,20));
          JTextField TIRate = new JTextField();
          TIRate.setBounds(220 , 350 , 150 , 30);
          
          
          
          JLabel LDateOfExp = new JLabel("Expiration Date");
          LDateOfExp.setBounds(80 , 425 , 200 , 30);
          LDateOfExp.setFont(new Font("Arial" , Font.PLAIN,20));
          JComboBox JCB_Day = new JComboBox();
          JCB_Day.setBounds(280 , 430 , 50 , 20);
          for(int i = 1 ; i<=30 ; i++){
                Integer str = (Integer) i;
                JCB_Day.addItem(str);
          }
          
          String[] months = {"January","Febuary","March","April","May","June","July","August","September","October","November","December"};
          JComboBox JCB_M = new JComboBox(months);
          JCB_M.setBounds(350, 430 , 80 , 20);
            
          JComboBox JCB_Y = new JComboBox();
          JCB_Y.setBounds(480 , 430 , 60 , 20);
          for(int a = 1900 ; a<=2023 ; a++){
                Integer str = (Integer) a ;
                JCB_Y.addItem(str);
          }  
          
          JLabel LCrLimit = new JLabel("Credit Limit");
          LCrLimit.setBounds(80 , 505 , 150 , 30);
          LCrLimit.setFont(new Font("Arial", Font.PLAIN,20));
          JTextField TCrLimit = new JTextField();
          TCrLimit.setBounds(250 , 505 , 150 , 30);
          
          JLabel LGP = new JLabel("Grace Period");
          LGP.setBounds(80 , 580 , 150 , 30);
          LGP.setFont(new Font("Arial", Font.PLAIN,20));
          JTextField TGP = new JTextField();
          TGP.setBounds(250 , 580 , 150 , 30);
          
          JButton BSetCrL = new JButton ("Set Credit Limit");
          BSetCrL.setBounds(230 , 655 , 180 , 30);
          BSetCrL.setFont(new Font("Arial" , Font.PLAIN,20));
          
          JButton BDis = new JButton ("Display");
          BDis.setBounds(450, 655 , 100 , 30);
          BDis.setFont(new Font("Arial" , Font.PLAIN,20));
          
          JButton BClear = new JButton ("Clear");
          BClear.setBounds(620 , 655 , 120 , 30);
          BClear.setFont(new Font("Arial" , Font.PLAIN,20));
          
    
          BClear.addActionListener(this);
          BDis.addActionListener(this);
          BSetCrL.addActionListener(this);
          BAddC.addActionListener(this);
          BCrCan.addActionListener(this);
          
          
          JPan.add(TCrLimit);
          JPan.add(LCrLimit);
          JPan.add(TGP);
          JPan.add(LGP);
          JPan.add(TIRate);
          JPan.add(LIntRate);
          JPan.add(BSetCrL);
          JPan.add(BDis);
          JPan.add(BClear);
          JPan.add(JCB_Y);    
          JPan.add(JCB_M);  
          JPan.add(JCB_Day);  
          JPan.add(LDateOfExp);
          JPan.add(BCrCan);
          JPan.add(BAddC);
          JPan.add(LCVC);
          JPan.add(TCVC);
          JPan.add(TBankAcc);
          JPan.add(LBankAcc);
          JPan.add(TClient);
          JPan.add(LClient);
          JPan.add(TBalance);
          JPan.add(LBal);
          JPan.add(TextIssue);
          JPan.add(LIssue);
          JPan.add(TextCard);
          JPan.add(LCard);
          JPan.add(JLCC);
          JFram.add(JPan);
          JFram.setVisible(true);
     }
           
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }   

