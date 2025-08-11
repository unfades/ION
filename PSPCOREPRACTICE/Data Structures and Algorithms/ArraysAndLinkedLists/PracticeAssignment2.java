import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;
import java.time.LocalDate;


class OrderUp{
    int itemID;
    String itemName;
    float price;
    int quanity;
    List<Object[]> menu = new ArrayList<>();
    List<Object[]> menuOrders = new LinkedList<>();
    static int orderID = 0;
    public void addFoodItem(int itemID, String itemName, float price, int quanity){
        Object[] foodItem = new Object[4];
        foodItem[0] = itemID;
        foodItem[1] = itemName;
        foodItem[2] = price;
        foodItem[3] = quanity;
        menu.add(foodItem);
    }
    
    public void makeOrder(int itemID){
        for(Object[] i : menu){
            if((int)i[3]>0){
                System.out.println("You order is available");
                
                System.out.println("How many " + i[1] + " do you want?" + " There's only " + i[3] +" left");
                Scanner sc = new Scanner(System.in);
                int want = sc.nextInt();
                if(want>(int)i[3] || want<=0){
                    System.out.println("That's not a valid amount");
                    sc.close();
                    return;
                }
                if(want>=0 && want<=(int)i[3]){
                    System.out.println("You ordered " + want + i[1]+"s");
                    System.out.println("What's your name?");
                    String name = String.valueOf(sc.next());
                    //here initiated add to LL
                    Object[] arr = new Object[5];
                    arr[0] = orderID++; //orderID unique for each person
                    arr[1] = name; //String
                    arr[2] = i[0]; //itemID
                    arr[3] = want; //qty
                    LocalDate localDate = LocalDate.now();
                    arr[4] = localDate; //local Date via java.util.LocalDate... 
                    menuOrders.add(arr);
                    /*
                    Each order should contain:
                    o Order ID (Integer)
                    o Customer Name (String)
                    o Item ID (Integer)
                    o Quantity (Integer)
                    o Order Date (String)
                     */
                }
            }
        }
    }

    public void cancelOrder(int orderID){
        for(Object[] arr: menuOrders){
            if((int)arr[0] == orderID){
                menuOrders.remove(arr);
            }
        }
    }

    public String displayAllOrders(){
        StringBuilder sb = new StringBuilder();
        for(Object[] i: menuOrders){
            sb.append(i[0] + " " + i[1] + " " + i[2] + " " + i[3] + "\n");
        }
        sb.append("\n");
        return sb.toString();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Object[] i: menu){
            sb.append(i[0] + " " + i[1] + " " + i[2] + " " + i[3] + "\n");
        }
        sb.append("\n");
        return sb.toString();
    }

    public String displayMenu(){
        System.out.println("Here's the menu: ");
        return toString();
    }
}


public class PracticeAssignment2 {
    public static void main(String[] args) {
        OrderUp order = new OrderUp();
        //stocking up
        order.addFoodItem(0, "Burger", 25.0f, 10);
        order.addFoodItem(1, "Pizza", 25.0f, 10);
        order.addFoodItem(2, "Froyo", 25.0f, 10);
        order.addFoodItem(3, "Lemonade", 25.0f, 10);

        System.out.println(order.displayMenu());
        
        //making orders via LLs for customers
        order.displayAllOrders();
        order.makeOrder(0);
        System.out.println(order.displayAllOrders());
        order.cancelOrder(2);
        System.out.println(order.displayAllOrders());
        //successful
    }   
}

/*
Manage a restaurant's stuff like -
USING ARRAYS:
Adding new food items
    - each food item has:
    1.nameID
    2.itemName
    3.Price(float)
    4.QuantityAvailable(int)
Search for food items by nameID
Update the quantity of food items left
Display all available food items left
--------------------------------------
USING LL:
Place an Order
Each order should contain:
o Order ID (Integer)
o Customer Name (String)
o Item ID (Integer)
o Quantity (Integer)
o Order Date (String)
o Display All Orders
o Cancel an Order
*/