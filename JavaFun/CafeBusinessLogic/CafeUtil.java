import java.util.ArrayList;


public class CafeUtil {
    public void militaryHoursTest() {
        // print all the numbers from 0 to 23
        for (int hour = 0; hour < 24; hour++){
            System.out.println(hour);
        } 
    }
    
    public void coffeeNotification() {
        // print notification every hour
        for (int hour = 0; hour < 24; hour++) {
            System.out.println(String.format("It's %d:00 hours, do you need a coffee break?", hour));
        }
    }

    public void specialsAlert() {
        for (int hour = 6; hour < 16; hour++){
            if (hour % 2 == 0){
                System.out.println("Buy one get one free for the next 15 minutes!");
            } else{
                System.out.println("Stay tuned for deals announced throughout the day.");
            }
        }
    }

    public int leadsAtDay10() {
        // sum all numbers from 1 to 10
        int sum = 0;
        for (int i = 1; i < 11; i++){
            sum += i;
        }
        return sum;
    }

    public void displayMenu(String nameArray[]) {
        for (int i = 0; i < nameArray.length; i++){
            System.out.println(nameArray[i]);
        }
    }

    public double getOrderTotal(double priceArray[]) {
        // return total price of the given array
        double totalPrice = 0.0;
        for (int i = 0; i < priceArray.length; i++){
            totalPrice += priceArray[i];
        }
        return totalPrice;
    }

    public double getHighestPrice(double priceArray[]) {
        // return the highest price
        double maxPrice = priceArray[0];
        for (int i = 1; i < priceArray.length; i++){
            maxPrice = Math.max(maxPrice, priceArray[i]);
        }
        return maxPrice;
    }

    public ArrayList<String> raffleWinners(String customers[]){
        // return winner's array
        ArrayList<String> winners = new ArrayList<String>();
        for (int i = 0; i < customers.length; i++){
            if ((i + 1) % 4 == 0){
                winners.add(customers[i]);
            }
        }
        return winners;
    }
}
