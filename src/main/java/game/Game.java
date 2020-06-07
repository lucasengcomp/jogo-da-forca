package game;

import core.Dictionary;
import core.Word;

public class Game {

    public void start() {

        Dictionary dictionary = Dictionary.getInstance();

        Word word = dictionary.nextWord();

        System.out.println(word.getOriginalWord());
    }
}
