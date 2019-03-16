package app;
// for capturing and storing data sent via HTML form
// consider creating a unique one for each form in our application
// these classes MUST CONTAIN ACCESSOR AND MUTATOR METHODS in order to capture form info
public class FormCapture {
    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
