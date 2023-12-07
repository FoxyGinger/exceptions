package org.example;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class HumanMain {
    public static class HumanFieldsException extends RuntimeException {
        public HumanFieldsException() {
            super("Введено не верное количество аргументов. Аргументов должно быть 6.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8).useDelimiter("\n");
        System.out.print("Введите последовательно через пробел: ФИО, дата рождения, пол и номер телефона: ");
        String[] fields = scanner.next().split(" ");
        if (fields.length != 6) throw new HumanFieldsException();
        Human human = new Human(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5]);
        HumanFile.Write(human);
    }
}
