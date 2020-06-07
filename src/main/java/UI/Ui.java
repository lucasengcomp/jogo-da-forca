package UI;

import java.util.Scanner;

public class Ui {

    public static void print(Object object) {
        System.out.println(object);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static char readChar(String text) {
        System.out.println(text + "Digite uma letra");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        if (line.trim().isEmpty()) {
            //TODO: verifica se inseriu somente palavras vazias
        }
        if (line.length() > 1) {
            //TODO: isso é erro
        }

        char c = line.charAt(0);
        if (!Character.isLetter(c)) {
            //TODO: valida se é letra
        }
        //retornou caracter válido
        return c;
    }
}
