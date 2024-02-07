package M1S04EX5;

public class Teacher {
    private String name;
    private String specialty;

    public Teacher(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void goToTeach() {
        System.out.println(name + " está ensinando...");
    }
}
