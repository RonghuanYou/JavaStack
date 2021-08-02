public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = "your order will be ready shortly.";
        String readyMessage = "your order is ready.";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        int dripCoffee = 4;
        double latte = 5.5;
        double cappucino = 4.5;
        
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";

        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = true;

        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        
        // Example1: customer1 ordered one mocha
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
        System.out.println(pendingMessage);
        if (isReadyOrder1 == true){
            System.out.println(readyMessage);
        } else{
            System.out.println("Your order is not ready");
        }
        System.out.println(displayTotalMessage + String.valueOf(mochaPrice));
        // add a new line
        System.out.print(System.lineSeparator());

        // Example2: customer4 ordered one cappucino
        System.out.println(generalGreeting + customer4); // Displays "Welcome to Cafe Java, Noah"
        System.out.println(pendingMessage);
        if (isReadyOrder4 == true) {
            System.out.println(readyMessage);
        } else {
            System.out.println("Your order is not ready");
        }        
        System.out.println(displayTotalMessage + String.valueOf(cappucino));
        System.out.print(System.lineSeparator());

        // Example3: customer2 ordered 2 lattes
        System.out.println(generalGreeting + customer2); // Displays "Welcome to Cafe Java, Sam"
        System.out.println(pendingMessage);
        if (isReadyOrder2 == true) {
            System.out.println(readyMessage);
        } else {
            System.out.println("Your order is not ready");
        }
        System.out.println(displayTotalMessage + String.valueOf(2 * latte));
        System.out.print(System.lineSeparator());

        // Example4: Jimmy just realized he was charged for a coffee but had ordered a
        // latte. Tell him his new total (what he owes) to make up the difference.
        System.out.println(generalGreeting + customer3); // Displays "Welcome to Cafe Java, Jimmy"
        System.out.println("The difference you need to pay is " + String.valueOf(latte - dripCoffee));
    }
}
