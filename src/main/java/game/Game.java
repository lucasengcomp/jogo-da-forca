package game;

import core.Dictionary;
import core.InvalidCharacterException;
import core.Word;
import ui.Ui;

import java.util.HashSet;
import java.util.Set;

public class Game {
    private static int MAX_ERRORS = 5;

    public void start() {

        Ui.print("Bem vindo ao jogo da forca");

        Dictionary dictionary = Dictionary.getInstance();
        Word word = dictionary.nextWord();

        Ui.print("A palavra sorteada tem " + word.size() + " letras!");

        Set<Character> usedChars = new HashSet<>();
        char c;
        int errorCount = 0;

        while (true) {
            Ui.print(word);
            Ui.printNewLine();

            try {
                c = Ui.readChar("Informe uma letra");

                if (usedChars.contains(c)) {
                    throw new InvalidCharacterException("Esta letra já foi informada anteriormente");
                }
                usedChars.add(c);

                if (word.hasChar(c)) {
                    Ui.print("Opa, tem a letra escolhida!");
                } else {
                    errorCount++;

                    if (errorCount < MAX_ERRORS) {
                        Ui.print("Eita, você ainda tem " + (MAX_ERRORS - errorCount) + " chances");
                    }
                }
                Ui.printNewLine();

                if (word.discovered()) {
                    Ui.print("Parabéns! Conseguiu acertar toda a palavra" + word.getOriginalWord());
                    Ui.print("Fim do jogo!");
                    break;
                }

                if (errorCount == MAX_ERRORS) {
                    Ui.print("Não deu. Você errou a palavra. A palavra era: " + word.getOriginalWord());
                    Ui.print("Fim do jogo!");
                    break;
                }

            } catch (InvalidCharacterException e) {
                Ui.print("Opa, deu erro. " + e.getMessage());
                Ui.printNewLine();
            }
        }
    }
}
