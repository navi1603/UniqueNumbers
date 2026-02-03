package by.warlock;

import by.warlock.interfaces.Reader;
import by.warlock.interfaces.Writer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class UniqNumbers {
    private Reader reader;
    private Writer writer;
    private HashSet<Integer> uniqNumbers;
    private int uniqNumbersCounter;
    private BufferedReader br;

    public UniqNumbers() {
        uniqNumbers = new HashSet<>();
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public UniqNumbers(Reader reader, Writer writer) {
        this();
        this.reader = reader;
        this.writer = writer;
    }

    public void start() throws IOException {
        System.out.println("Введите построчно целые числа.\n" +
                "Для завершения введите пустую строку. ");
        while (true) {
            String line = br.readLine().strip();
            if(line.matches("^\\d+$")) {
                System.out.println("Вы ввели: " + line);
                //break;
            } else {
                System.out.println("Неверный формат!\n" +
                        " Введите целое число.");
            }
        }
    }
}
