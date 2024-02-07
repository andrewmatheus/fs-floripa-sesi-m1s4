package M1S04EX5;

import java.util.ArrayList;

public class Course {
    private String name;
    private String description;
    private ArrayList<String> teachers;
    private int workload;

    public Course(String name, String description, int workload) {
        this.name = name;
        this.description = description;
        this.teachers = new ArrayList<>();
        this.workload = workload;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getTeachers() {
        return teachers;
    }

    public int getWorkload() {
        return workload;
    }

    public void addTeachers(String teacher) {
        teachers.add(teacher);
    }

    public void printProgress() {
        System.out.println("Progresso do curso " + name + ": 50%");
    }

    public void printNotes() {
        System.out.println("Notas do curso " + name + ": 10,0");
    }

    public void printParticipation() {
        System.out.println("Participação no curso " + name + ": 80%");
    }

}
