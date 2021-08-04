public class Project {
    //  ATTRIBUTES
    private String name;
    private String description;
    
    
    // OVERLOAD CONSTRUCTOR METHOD
    public Project(String name, String description) {
        // set the name and description attributes to the value from the parameter
        System.out.println("YOUR PROJECT IS INSTANTIATED.");
        this.name = name;
        this.description = description;
    }

    // CREATE AN INSTANCE METHOD CALLED elevatorPitch
    public String elevatorPitch(String nameParam, String descriptionParam) {
        return String.format("%s, %s", nameParam, descriptionParam);
    }

    // CREATE GETTER/SETTERS FOR EACH ATTRIBUTE
    public void setName(String name) {
        if (name.equals("")){
            System.out.println("Project name cannot be empty");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    








}
