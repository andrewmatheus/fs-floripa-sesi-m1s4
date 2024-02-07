package M1S04EX5;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> listCourse = new ArrayList<>();
        ArrayList<String> listTeacher = new ArrayList<>();
        ArrayList<String> listCourseChecked = new ArrayList<>();

        Scanner scan = new Scanner(System.in);

        int optionSelected;

        System.out.println("*******************************");
        System.out.println("*        SEJA BEM VINDO       *");
        System.out.println("*******************************\n");

        do {
            System.out.println("+-----------------------------+");
            System.out.println("+       MENU - PRINCIPAL      +");
            System.out.println("+-----------------------------+");
            System.out.println("| (1) - Listar                |");
            System.out.println("| (2) - Adicionar             |");
            System.out.println("| (3) - Remover               |");
            System.out.println("| (4) - Marcar como concluído |");
            System.out.println("| (5) - Listar concluídos     |");
            System.out.println("+-----------------------------+");
            System.out.println("| (0) - Sair                  |");
            System.out.println("+-----------------------------+");
            System.out.print  ("Selecione uma opção: "     );

            optionSelected = scan.nextInt();
            scan.nextLine();

            switch (optionSelected) {
                case 1:
                    listOfCourseAndTeacher(listCourse, listTeacher);
                    break;
                case 2:
                    addMenu(listTeacher, listCourse, scan);
                    break;
                case 3:
                    removeMenu(listTeacher, listCourse, scan);
                    break;
                case 4:
                    markCheckedCourse(listCourse, listCourseChecked, scan);
                    break;
                case 5:
                    listOfCourseChecked(listCourseChecked);
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
        System.out.println("\n+--------------------------------+");
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

    public static void removeMenu(ArrayList<String> listTeacher, ArrayList<String> listCourse, Scanner scan) {
        System.out.println("+\n--------------------------------+");
        System.out.println("+        MENU - REMOVER          +");
        System.out.println("+--------------------------------+");
        System.out.println("| (1) - Remover curso            |");
        System.out.println("| (2) - Remover professor(a)     |");
        System.out.println("+--------------------------------+");
        System.out.println("| (0) - Voltar ao menu principal |");
        System.out.println("+--------------------------------+");
        System.out.print  ("Selecione uma opção: "     );

        int optionSelected = scan.nextInt();
        scan.nextLine();

        switch (optionSelected) {
            case 1:
                removeListCourse(listCourse, scan);
                break;
            case 2:
                removeListTeacher(listTeacher, scan);
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

    public static void removeListCourse(ArrayList<String> listCourse, Scanner scan) {
        System.out.println("+--------------------------------+");
        System.out.println("+        LISTA DE CURSOS         +");
        System.out.println("+--------------------------------+");

        if (listCourse.isEmpty()) {
            System.out.println("-----Nenhum curso adicionado!-----");
        } else {
            for (int indexCourse = 0; indexCourse < listCourse.size(); indexCourse++) {
                System.out.println(indexCourse + " - " + listCourse.get(indexCourse));
            }
        }

        System.out.println("+--------------------------------+");
        System.out.print("Informe o índice do curso que deseja remover:");
        int indexCourse = scan.nextInt();
        removeCourse(indexCourse, listCourse);
    }

    public static void markCheckedCourse(ArrayList<String> listCourse, ArrayList<String> listCheckedCourse, Scanner scan) {
        System.out.println("+--------------------------------+");
        System.out.println("+    LISTA DE CURSOS PENDENTES   +");
        System.out.println("+--------------------------------+");

        if (listCourse.isEmpty()) {
            System.out.println("-----Nenhum curso pendente!-----");
            System.out.println("Voltando ao menu ...");
        } else {
            for (int indexCourse = 0; indexCourse < listCourse.size(); indexCourse++) {
                System.out.println(indexCourse + " - " + listCourse.get(indexCourse));
            }

            System.out.println("+--------------------------------+");
            System.out.print("Informe o índice do curso que deseja marcar como concluído:");
            int indexCourse = scan.nextInt();
            listCheckedCourse.add(listCourse.get(indexCourse));
            System.out.println("Curso ("+ listCourse.get(indexCourse) + ") marcado como concluído!");
            System.out.println("Removendo curso da lista de disponível em 1, 2, 3 ...!");
            removeCourse(indexCourse, listCourse);
        }


    }

    public static void removeCourse(int indexCourse, ArrayList<String> listCourse) {
        if (indexCourse < 0) {
            System.out.println("Indice digitado:" + indexCourse + " não é válido!"  );
        } else if (listCourse.size() > indexCourse) {
            System.out.println("Curso: " + listCourse.get(indexCourse) + " removido com sucesso!");
            listCourse.remove(indexCourse);
            listOfCourse(listCourse);
        } else {
            System.out.println("Indice digitado:" + indexCourse + " não é válido!"  );
        }

    }

    public static void removeListTeacher(ArrayList<String> listTeacher, Scanner scan) {
        System.out.println("+--------------------------------+");
        System.out.println("+      LISTA DE PROFESSORES      +");
        System.out.println("+--------------------------------+");

        if (listTeacher.isEmpty()) {
            System.out.println("Nenhum professor(a) adicionado(a)!");
        } else {
            for (int indexTeacher = 0; indexTeacher < listTeacher.size(); indexTeacher++) {
                System.out.println(indexTeacher + " - " + listTeacher.get(indexTeacher));
            }
        }

        System.out.println("+--------------------------------+");
        System.out.print("Informe o índice do professor(a) que deseja remover:");
        int indexCourse = scan.nextInt();
        removeTeacher(indexCourse, listTeacher);
    }

    public static void removeTeacher(int indexTeacher, ArrayList<String> listTeacher) {

        if (indexTeacher < 0) {
            System.out.println("Indice digitado:" + indexTeacher + " não é válido!"  );
        } else if (listTeacher.size() > indexTeacher) {
            System.out.println("Professor(a): " + listTeacher.get(indexTeacher) + " removido(a) com sucesso!");
            listTeacher.remove(indexTeacher);
            listOfTeacher(listTeacher);
        } else {
            System.out.println("Indice digitado:" + indexTeacher + " não é válido!"  );
        }

    }

    public static void addTeacher(ArrayList<String> listTeacher, Scanner scan) {
        System.out.println("Digite o nome do(a) professor(a):");
        String teacher = scan.nextLine();
        listTeacher.add(teacher);
        System.out.println("Professor(a) adicionado(a) com sucesso!");
    }

    private static void listOfCourse(ArrayList<String> listCourse) {

        if (listCourse.isEmpty()) {
            System.out.println("Nenhum curso adicionado!");
        } else {
            System.out.println("Lista de cursos adicionados:");

            for (int indexCourse = 0; indexCourse < listCourse.size(); indexCourse++) {
                System.out.println(indexCourse + " - " + listCourse.get(indexCourse));
            }
        }

    }

    private static void listOfTeacher(ArrayList<String> listTeacher) {
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

    private static void listOfCourseChecked(ArrayList<String> listCourseChecked) {

        if (listCourseChecked.isEmpty()) {
            System.out.println("Nenhum curso concluído!");
        } else {
            System.out.println("Lista de cursos concluídos:");

            for (int indexCourseChecked = 0; indexCourseChecked < listCourseChecked.size(); indexCourseChecked++) {
                System.out.println(indexCourseChecked + " - " + listCourseChecked.get(indexCourseChecked));
            }
        }

    }
}