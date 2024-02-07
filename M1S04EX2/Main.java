package M1S04EX2;

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
            System.out.println("+     MENU - PRINCIPAL     +");
            System.out.println("+--------------------------+");
            System.out.println("| (1) - Listar             |");
            System.out.println("| (2) - Adicionar          |");
            System.out.println("+--------------------------+");
            System.out.println("| (0) - Sair               |");
            System.out.println("+--------------------------+");
            System.out.print  ("Selecione uma opção: "     );

            optionSelected = scan.nextInt();
            scan.nextLine(); // Limpar o buffer do scanner

            switch (optionSelected) {
                case 1:
                    listOfCourseAndTeacher(listCourse, listTeacher);
                    break;
                case 2:
                    addMenu(listTeacher, listCourse, scan);
                    break;
                case 0:
                    System.out.println("Obrigado volte sempre. Aplicação finalizada com sucesso!");
                    break;
                default:
                    System.out.println("Opção selecionada não é válida. Informe uma opção do menu e tente novamente!");
            }
        } while (optionSelected != 0);

        scan.close();
    }

    public static void addMenu(ArrayList<String> listTeacher, ArrayList<String> listCourse, Scanner scan) {
        System.out.println("+--------------------------------+");
        System.out.println("+        MENU - ADICIONAR        +");
        System.out.println("+--------------------------------+");
        System.out.println("| (1) - Adicionar curso          |");
        System.out.println("| (2) - Adicionar professor(a)   |");
        System.out.println("+--------------------------------+");
        System.out.println("| (0) - Voltar ao menu principal |");
        System.out.println("+--------------------------------+");
        System.out.print  ("Selecione uma opção: "     );

        int optionSelected = scan.nextInt();
        scan.nextLine();

        switch (optionSelected) {
            case 1:
                addCourse(listCourse, scan);
                break;
            case 2:
                addTeacher(listTeacher, scan);
                break;
            case 0:
                System.out.println("Voltando ao menu principal...");
                break;
            default:
                System.out.println("Opção selecionada não é válida. Voltando ao menu principal...");
        }
    }

    public static void addCourse(ArrayList<String> listCourse, Scanner scan) {
        System.out.println("Digite o nome do curso:");
        String course = scan.nextLine();
        listCourse.add(course);
        System.out.println("Curso adicionado com sucesso!");
    }

    public static void addTeacher(ArrayList<String> listTeacher, Scanner scan) {
        System.out.println("Digite o nome do(a) professor(a):");
        String teacher = scan.nextLine();
        listTeacher.add(teacher);
        System.out.println("Professor(a) adicionado(a) com sucesso!");
    }

    private static void listOfCourseAndTeacher(ArrayList<String> listCourse, ArrayList<String> listTeacher) {

        if (listCourse.isEmpty()) {
            System.out.println("Nenhum curso adicionado!");
        } else {
            System.out.println("Lista de cursos adicionados:");

            for (int indexCourse = 0; indexCourse < listCourse.size(); indexCourse++) {
                System.out.println(indexCourse + " - " + listCourse.get(indexCourse));
            }
        }

        if (listTeacher.isEmpty()) {
            System.out.println("Nenhum(a) professor(a) adicionado(a)!");
            System.out.println("\n");
        } else {
            System.out.println("\nLista de professores adicionados:");
            for (int indexTeacher = 0; indexTeacher < listTeacher.size(); indexTeacher++) {
                System.out.println(indexTeacher + " - " + listTeacher.get(indexTeacher));
            }
            System.out.println("\n");
        }

    }
}