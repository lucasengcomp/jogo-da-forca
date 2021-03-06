package core;

import java.util.HashSet;
import java.util.Set;

public class Word {

    private static final char SECRET_CHAR = '_';

    private String originalWord;
    private Set<Character> foundChars = new HashSet<>();
    private Set<Character> wordChars = new HashSet<>();

    public Word(String originalWord) {
        this.originalWord = originalWord.toUpperCase();

        char[] chars = this.originalWord.toCharArray();
        for (char c : chars) {
            wordChars.add(c);
        }
    }

    public int size() {
        return originalWord.length();
    }

    public boolean hasChar(char c) {
        //int pos = originalWord.indexOf(c);
        c = Character.toUpperCase(c);
        if (originalWord.indexOf(c) > -1) {
            foundChars.add(c);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        char[] charArray = originalWord.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];


            if (foundChars.contains(c)) {
                stringBuilder.append(c);
            } else {
                stringBuilder.append(SECRET_CHAR);
            }
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    public boolean discovered() {
        return foundChars.equals(wordChars);
    }

    public String getOriginalWord() {
        return originalWord;
    }


}
