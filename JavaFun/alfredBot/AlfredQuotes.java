import java.util.Date;

public class AlfredQuotes {
    public String basicGreeting() {
        return "Hello, lovely to see you. How are you?";
    }

    /*
    inputs: dayPeriod: morning, afternoon, evening
    return type: String
    example: "Good evening, Beth Kane. Lovely to see you"
    */
    public String guestGreeting(String name, String dayPeriod) {
        return String.format("Good %s, %s. Lovely to see you", dayPeriod, name);
    }

    /*
        Inputs: None Return Type: String Description: Returns a polite
        announcement of the current date.     
     */
    public String dateAnnouncement() {
        Date date = new Date();
        return String.format("Current data: %s", date);
    }

    public String respondBeforeAlexis(String conversation) {
        return conversation;
    }

}
