package core;

import game.GameException;
import jdk.nashorn.internal.runtime.WithObject;
import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dictionary {

    private static final String FILE_NAME = "dicionario.txt";

    private List<String> words = new ArrayList<>();

    private void load() {

        try (Scanner scanner = new Scanner(getClass().getResourceAsStream("/" + FILE_NAME))) {
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().trim();
                words.add(word);
            }
            if (words.size() == 0) {
                throw new GameException("A lista de palavras não pode ser vazia!");
            }
        }
    }

    public Word nextWord() {
        int pos = RandomUtils.newRandomNumber(0, words.size());
        return new Word(words.get(pos));
    }
}
