class ProjectTest {     
    public static void main(String[] args) {
        // INSTANCE
        Project project1 = new Project("Investing", "To detect real time investing data.");

        // CALL METHODS
        System.out.println(project1.elevatorPitch("Investing", "Design an App to detect real time investing data."));
        
        // TEST SETTER/GETTER
        project1.setName("FRESH FOOD");
        project1.setDescription("Distribute food to people in need");

        System.out.println(project1.getName());
        System.out.println(project1.getDescription());

        // 


    }
}



