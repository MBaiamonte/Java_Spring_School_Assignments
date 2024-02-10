import java.util.ArrayList;
public class CafeUtil{

public int getStreakGoal(int numOfWeeks){
int sum=0;
// int numOfWeeks= 10;  <- dont need just pass it in as parameter on the test side. works if you remove it as a parameter 
for (int i=0; i<numOfWeeks+1;i++)
    sum+=i;
    // System.out.println(sum);
    return sum;
} 
public double getOrderTotal(double[] lineItems){
double orderTotal=0;
for (int i=0; i<lineItems.length; i++)
    orderTotal+=lineItems[i];
    return orderTotal;
}

public void displayMenu(ArrayList<String> menuItems){
for (int i=0;i<menuItems.size();i++)
    System.out.println(menuItems.get(i));
}

// public void addCustomer(ArrayList<String>customer){
// System.out.println("Please enter your name");
// String userName = System.console().readLine();
// ArrayList<String> customerList= new ArrayList<String>();
// customerList.add(userName);
// System.out.println("hello "+ userName + " there is "+customerList.size()+"  person in front of you");
// // System.out.println("hello "+ userName + " there are   %o  in front of you",customerList.size());
// for (int i = 0; i<customerList.size();i++)
//     System.out.println(customerList.get(i));
// }
//^^^^^^^^^^^^^shouldnt need to create another array insted use the bottom version and use the supplied array custmers.
public void addCustomer(ArrayList<String>customer){
System.out.println("Please enter your name");
String userName = System.console().readLine();
customer.add(userName);
System.out.println("hello "+ userName + " there is "+customer.size()+"  person in front of you");
System.out.println(customer);
}

}
