import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        return String.format("Hello %s", name +" Welcome to Wayne Manner");
    }
    
    public String dateAnnouncement() {
        Date date=new Date();
        return "todays date is "+ date;
    }
    
    public String respondBeforeAlexis(String conversation) {
        if (conversation.indexOf("Alexis") >-1 )
            return "Try again, Alexis is not here";
        else if (conversation.indexOf("Alfred") != -1)
            return "At your service. As you wish, naturally.";
        else
            return"Right. And with that I shall retire.";
    }
    
	// NINJA BONUS
	// See the specs to overload the guestGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}

