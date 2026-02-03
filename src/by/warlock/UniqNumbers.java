package by.warlock;

import by.warlock.interfaces.Reader;
import by.warlock.interfaces.Writer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqNumbers {
    private Reader reader;
    private Writer writer;

    private List<Integer> inputNumbers;
    private Set<Integer> setNumbers;
    private List<Integer> dublicateNumbers;

    private int uniqNumbersSum;
    private BufferedReader br;

    public UniqNumbers() {
        inputNumbers = new ArrayList<>();
        setNumbers = new HashSet<>();
        dublicateNumbers = new ArrayList<>();
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public UniqNumbers(Reader reader, Writer writer) {
        this();
        this.reader = reader;
        this.writer = writer;
    }

    public void start() throws IOException {
        System.out.println("""
                Введите построчно целые числа.
                Для завершения ввода оставьте строку пустой
                и нажмите Enter.""");

        while (true) {
            String line = br.readLine().strip();
            if (!line.isEmpty()) {
                if (line.matches("^\\d+$")) {
                    Integer number = Integer.parseInt(line);
                    inputNumbers.add(number);
                    System.out.println("Вы ввели: " + line);
                } else {
                    System.out.println("Неверный формат!\n" +
                            " Введите целое число.");
                }
            } else {
                checkDuplicate();
                System.out.println("Сумма уникальных чисел: " + uniqNumbersSum);
                System.out.println("Повторяющиеся числа: " + dublicateNumbers + "\n");
                break;
            }
        }
    }

    private void checkDuplicate() {
        for (Integer number : inputNumbers) {
            if(!setNumbers.add(number)) {
                dublicateNumbers.add(number);
            } else {
                uniqNumbersSum += number;
            }
        }
    }
}
