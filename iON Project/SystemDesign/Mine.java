package SystemDesign;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

class Transaction{

    protected double amount;
    protected String date;
    protected String category;

    public Transaction(double amount, String date, String category){
        this.amount = amount;
        this.date = date;
        this.category = category;
    }
    //override in Income/Expense
    public void apply(Account account){

    }
}

class Income extends Transaction{
    double income;
    public Income(double amount, String date, String category){
        super(amount, date, category);
    }

    @Override
    public void apply(Account account){
        account.setBalance(this.amount);
    }
}

class Expense extends Transaction{
    double expense;
    public Expense(double amount, String date, String category){
        super(amount,date,category);
    }
    
    @Override
    public void apply(Account account){
        account.setBalance(-this.amount);
    }
}

class Account{
    private double balance;
    private List<Transaction> transactionsList;

    public Account(){
        this.balance = 0.0;
        this.transactionsList = new ArrayList<>();
    }

    public void addTransaction(Transaction t){
        t.apply(this);
        transactionsList.add(t);
    }

    public double getBalance(){
        return this.balance;
    }

    public void setBalance(double amount){
        this.balance = this.balance + amount;
    }

    public List<Transaction> getTransactions(){
        return transactionsList;
    }
}

class ReportGenerator{

    public void generateReport(Account account){
        double income = 0.0;
        double expenses = 0.0;
        for(Transaction t : account.getTransactions()){
            if(t instanceof Income){
                income+=t.amount;
            }else if(t instanceof Expense){
                expenses+=t.amount;
            }
        }
        System.out.println("Total Income ₹" + income);
        System.out.println("Total Expense ₹" + expenses);
        System.out.println("Net Savings ₹" + account.getBalance());
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
            Double amt;
            switch(input){
                case 1:
                    System.out.println("How much income did you earn?:");
                    amt = Double.valueOf(sc.nextLine());
                    System.out.println("And how did you earn this income?:");
                    category = String.valueOf(sc.nextLine());
                    date = new Date();
                    t = new Income(amt,date.toString(),category);
                    myAccount.addTransaction(t);
                    break;
                case 2:
                    System.out.println("How much expenses did you incur?:");
                    amt = Double.valueOf(sc.nextLine());
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