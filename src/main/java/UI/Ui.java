package UI;

import java.util.InvalidPropertiesFormatException;
import java.util.Scanner;

public class Ui {

    public static void print(Object object) {
        System.out.println(object);
    }

    public static void printNewLine() {
        System.out.println();
    }

    @SuppressWarnings("resource")
    public static char readChar(String text) throws InvalidPropertiesFormatException {
        System.out.println(text + "Digite uma letra");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        if (line.trim().isEmpty()) {
            throw new InvalidPropertiesFormatException("Não foi digitada nenhuma letra!");
        }
        if (line.length() > 1) {
            throw new InvalidPropertiesFormatException("Digite apenas 1 letra por vez!");
        }

        char c = line.charAt(0);
        if (!Character.isLetter(c)) {
            throw new InvalidPropertiesFormatException("Você informou número! :-| Digite apenas letra!");
        }
        //retornou caracter válido
        return c;
    }
}
