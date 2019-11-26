package ugm.fznzz.findmycoffee.DataClass;

public class User {
    private String Name;
    private String Pass;

    public User() {
    }

    public User(String name, String pass) {
        Name = name;
        Pass = pass;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPass() {
        return Pass;
    }

    public void setPassword(String pass) {
        Pass = pass;
    }
}
