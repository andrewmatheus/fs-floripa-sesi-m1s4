package M1S04EX1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> listCourse = new ArrayList<>();
        ArrayList<String> listTeacher = new ArrayList<>();

        Scanner scan = new Scanner(System.in);

        int optionSelected;

        System.out.println("****************************");
        System.out.println("*      SEJA BEM VINDO      *");
        System.out.println("****************************\n");

        do {
            System.out.println("+--------------------------+");
            System.out.println("+           MENU           +");
            System.out.println("+--------------------------+");
            System.out.println("| 1 - Adicionar curso      |");
            System.out.println("| 2 - Adicionar professor  |");
            System.out.println("+--------------------------+");
            System.out.println("| 0 - Sair                 |");
            System.out.println("+--------------------------+");
            System.out.print  ("Selecione uma opção: "     );

            optionSelected = scan.nextInt();
            scan.nextLine(); // Limpar o buffer do scanner

            switch (optionSelected) {
                case 1:
                    addCourse(listCourse, scan);
                    break;
                case 2:
                    addTeacher(listTeacher, scan);
                    break;
                case 0:
                    listOfCourseAndTeacher(listCourse, listTeacher);
                    break;
                default:
                    System.out.println("Opção selecionada não é válida. Informe uma opção do menu e tente novamente!");
            }
        } while (optionSelected != 0);

        scan.close();
    }

    public static void addCourse(ArrayList<String> listCourse, Scanner scan) {
        System.out.println("Digite o nome do curso:");
        String course = scan.nextLine();
        listCourse.add(course);
        System.out.println("Curso adicionado com sucesso!");
    }

    public static void addTeacher(ArrayList<String> listTeacher, Scanner scan) {
        System.out.println("Digite o nome do professor:");
        String teacher = scan.nextLine();
        listTeacher.add(teacher);
        System.out.println("Professor adicionado com sucesso!");
    }

    private static void listOfCourseAndTeacher(ArrayList<String> listCourse, ArrayList<String> listTeacher) {
        System.out.println("Lista de cursos inseridos:");
        for (String course : listCourse) {
            System.out.println(course);
        }

        System.out.println("\nLista de professores inseridos:");
        for (String teacher : listTeacher) {
            System.out.println(teacher);
        }
    }
}
