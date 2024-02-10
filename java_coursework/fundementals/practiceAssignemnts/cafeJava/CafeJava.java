public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        Double mochaPrice = 3.5;
        Double coffiePrice=2.5;
        Integer lattePrice= 9;
        Double cappucinoPrice=4.5;
        Integer orderTotal=0;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2="Sam";
        String customer3="Jimmy";
        String customer4="Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = false;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	//** Your customer interaction print statements will go here ** 
        if (isReadyOrder1 == false){
            System.out.println(customer1 + pendingMessage );
        }
        else if (isReadyOrder1 == true) {
            System.out.println(customer1 + readyMessage);
        }
        // switch(isReadyOrder1){
        //     case true:
        //         System.out.println(customer1 + readyMessage);
        //         break;
        //     case false:
        //         System.out.println(customer1 + pendingMessage );
        //         break;
        // }
        //^^^^^^^^^^^^ got error for setting cases to boolean value. might only be bale to do it for int data types or something^^^^^^^^^^
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ part 1^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^  
    if (isReadyOrder4==true){
        System.out.println("hello " + customer4 + readyMessage + displayTotalMessage + cappucinoPrice);
    }
    else 
        System.out.println("hello " + customer4 + pendingMessage);
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^part 2^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

    System.out.println("Hello "+ customer2 +" "+ displayTotalMessage + orderTotal.sum(lattePrice,lattePrice));
    if (isReadyOrder2==true){
        System.out.println("Hello "+ customer2 + readyMessage);
    }
    else
        System.out.println("Hello "+ customer2 + pendingMessage);

//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^part 3^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
Double priceCorrection = coffiePrice - lattePrice;
    System.out.println("Hello "+ customer3 + " You're new total is $" + priceCorrection ) ; // <- Could also just remove price correction var and do "latteCost-coffieCost" to find the differance 
// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^part4^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
}
}
