import java.util.ArrayList;
public class TestExceptions {
    public static void main(String[] args) {
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("Hello World");
        myList.add("48");
        myList.add("Goodbye World");

        // loop through the list and try to assign each item to an int variable
        try{
            for (int i = 0; i < myList.size(); i ++){
                Integer castedValue = (Integer) myList.get(i);
            }
        } catch(ClassCastException e){
            System.out.println("error: " + e);
        }
    }
}
