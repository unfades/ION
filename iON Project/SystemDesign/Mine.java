package SystemDesign;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.math.BigDecimal;

abstract class Transaction{

    protected BigDecimal amount;
    protected String date;
    protected String category;

    public Transaction(BigDecimal amount, String date, String category){
        this.amount = amount;
        this.date = date;
        this.category = category;
    }
    //overridden in Income/Expense
    public abstract void apply(Account account);
}

class Income extends Transaction{
    BigDecimal income;
    public Income(BigDecimal amount, String date, String category){
        super(amount,date,category);
    }

    @Override
    public void apply(Account account){
        this.amount = this.amount.abs();
        account.setBalance(this.amount);
    }
}

class Expense extends Transaction{
    BigDecimal expense;
    public Expense(BigDecimal amount, String date, String category){
        super(amount,date,category);
    }
    
    @Override
    public void apply(Account account){
    	//the negate method in BigDecimal makes positives negative and vice versa
        this.amount = this.amount.abs().negate();
        account.setBalance(this.amount);
    }
}

class Account{
    private BigDecimal balance;
    private List<Transaction> transactionsList;

    public Account(){
        this.balance = new BigDecimal("0.0");
        this.transactionsList = new ArrayList<>();
    }

    public void addTransaction(Transaction t){
        t.apply(this);
        transactionsList.add(t);
    }

    public BigDecimal getBalance(){
        return this.balance;
    }

    public void setBalance(BigDecimal amount){
        this.balance = this.balance.add(amount);
    }

    public List<Transaction> getTransactions(){
        return transactionsList;
    }
}

class ReportGenerator{

    public void generateReport(Account account){
        BigDecimal income = new BigDecimal("0.0");
        BigDecimal expenses = new BigDecimal("0.0");
        
        System.out.println("Transaction History:");
        for(Transaction t : account.getTransactions()){
        	//instanceof to check if the object is of Income or Expense
            if(t instanceof Income){
            	System.out.println("Amount: $" + t.amount + " | Category: " + t.category + " | Date: " + t.date + " | Type: Income");
                income = income.add(t.amount);
            }else if(t instanceof Expense){
            	System.out.println("Amount: $" + t.amount.abs() + " | Category: " + t.category + " | Date: " + t.date + " | Type: Expense");
                expenses = expenses.add(t.amount);
            }
        }
        
        System.out.println();
        System.out.println("Account Summary:");
        System.out.println("Total Income $" + income);
        System.out.println("Total Expense $" + expenses.abs());
        System.out.println("Net Savings $" + account.getBalance());
    }
}


public class Mine{
    public static void displayMenu() {
        System.out.println("\nPersonal Finance Tracker");
        System.out.println("1. Add Income");
        System.out.println("2. Add Expense");
        System.out.println("3. View Report");
        System.out.println("4. Exit");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = 0;
        Account myAccount = new Account();
        while(input!=4){
            displayMenu();
            input = Integer.valueOf(sc.nextLine()); //avoiding that NumberFormatException eating up the buffer on the nextLine
            String category;
            Date date;
            Transaction t;
            BigDecimal amt;
            switch(input){
                case 1:
                    System.out.println("How much income did you earn?:");
                    amt = new BigDecimal(String.valueOf(sc.nextLine()));
                    System.out.println("And how did you earn this income?:");
                    category = String.valueOf(sc.nextLine());
                    date = new Date();
                    t = new Income(amt,date.toString(),category);
                    myAccount.addTransaction(t);
                    break;
                case 2:
                    System.out.println("How much expenses did you incur?:");
                    amt = new BigDecimal(String.valueOf(sc.nextLine()));
                    System.out.println("And how did you incur this expense?:");
                    category = String.valueOf(sc.nextLine());
                    date = new Date();
                    t = new Expense(amt,date.toString(),category);
                    myAccount.addTransaction(t);
                    break;
                case 3:
                    ReportGenerator rg = new ReportGenerator();
                    rg.generateReport(myAccount);
                    break;
                case 4:
                    input = 4; break;
                default:
                    input = 0; break;
            }
        }
         sc.close();
    }
}