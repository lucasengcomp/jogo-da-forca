package game;

import core.Word;

public class Game {

    public void start() {

        Word word = new Word("casa");
        word.hasChar('c');
        word.hasChar('s');
        word.hasChar('a');

        System.out.println(word.discovered());
        System.out.println(word);
    }
}
