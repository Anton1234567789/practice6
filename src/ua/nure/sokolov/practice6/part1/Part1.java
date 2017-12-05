package ua.nure.sokolov.practice6.part1;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

public class Part1 {

    public static void main(String[] args) {
            WordContainer wordContainer = new WordContainer();
            String input = System.lineSeparator();
            input = "asd asdf asd asdf asdf 43 asdsf 43 43 434 wer wer";
            byte[] bytes = input.getBytes();
            InputStream is = new ByteArrayInputStream(bytes);
            System.setIn(is);
            wordContainer.main(null);
    }
}

class WordContainer{

    public List<Word> wordList = new ArrayList<>();

    public List<Word> getWordList() {
        return wordList;
    }

    public void add(Word word) {
        for (Word w : wordList) {
            if (w.getContent().equals(word.getContent())) {
                w.setFrequency(w.getFrequency() + 1);
                return;
            }
        }
        wordList.add(word);
    }

    public static void main(String[] args) {
        WordContainer container = new WordContainer();
        StringBuffer sb = new StringBuffer();
        Scanner sc = new Scanner(System.in);
        String s;
        while (sc.hasNext()) {
            s = sc.next();
            if ("stop".equals(s)) {
                break;
            }
            sb.append(s).append(" ");
        }
        sc.close();
        String[] strings = sb.toString().split("\\s+");
        for (int i = 0; i < strings.length; i++) {
            container.add(new Word(strings[i]));
        }

        Collections.sort(container.getWordList(), (o1, o2) -> {
            int res =-(o1.getFrequency() - o2.getFrequency());
            if (res != 0) {
                return res;
            }
            return o1.getContent().compareTo(o2.getContent());
        });

        StringBuilder stringBuilder = new StringBuilder();
        for (Iterator<Word> iterator = container.getWordList().iterator();
             iterator.hasNext(); ) {
            Word word = iterator.next();
            stringBuilder.append(word.getContent() + ": " + word.getFrequency() + System.lineSeparator());
        }
        System.out.println(stringBuilder.toString());

    }

}

class Word{
    private String content;

    private int frequency;

    public Word(String word) {
        this.content = word;
        frequency = 1;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return frequency == word.frequency &&
                Objects.equals(content, word.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, frequency);
    }


}
