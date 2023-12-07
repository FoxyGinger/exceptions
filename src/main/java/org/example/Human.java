package org.example;

import java.util.Arrays;

public class Human {
    public static class BirtDayFormatException extends RuntimeException {
        public BirtDayFormatException() {
            super("Некорректный формат даты рождения. Корректный формат: %s".formatted(Human.BirtDayFormat));
        }
    }
    public static class GenderException extends RuntimeException {
        public GenderException() {
            super("Некорректный пол. Корректный пол: %s".formatted(String.join(", ", Human.Genders)));
        }
    }
    public static class PhoneNumberException extends RuntimeException {
        public PhoneNumberException() {
            super("Некорректный формат телефона. Разрешенные символы: %s".formatted(String.join(", ", Human.PhoneNumberPossibleChars)));
        }
    }
    String firstName;
    String middleName;
    String lastName;
    String birthDay;
    String gender;
    String phoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    static int BirtDayLength = 10;
    static String BirtDayFormat = "dd.mm.yyyy";
    static String[] Genders = {"f", "m"};
    static String[] PhoneNumberPossibleChars = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "-", "+", "(", ")"};

    public Human(String lastName, String firstName, String middleName, String birthDay, String gender, String phoneNumber) {
        checkBirthdayDate(birthDay);
        checkGender(gender);
        checkPhoneNumber(phoneNumber);
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "<%s><%s><%s><%s><%s><%s>".formatted(lastName, firstName, middleName, birthDay, phoneNumber, gender);
    }

    private void checkBirthdayDate(String birthDay) throws BirtDayFormatException {
        if (birthDay.length() != BirtDayLength) throw new BirtDayFormatException();
        for (int i = 0; i < birthDay.length(); i++) {
            if (i == 2 || i == 5) {
                if (birthDay.charAt(i) != '.') throw new BirtDayFormatException();
            }
            else {
                if (!Character.isDigit(birthDay.charAt(i))) throw new BirtDayFormatException();
            }
        }
    }

    private void checkGender(String gender) throws GenderException {
        if (!Arrays.asList(Genders).contains(gender)) throw new GenderException();
    }

    private void checkPhoneNumber(String phoneNumber) throws PhoneNumberException {
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (!Arrays.asList(PhoneNumberPossibleChars).contains(Character.toString(phoneNumber.charAt(i)))) throw new PhoneNumberException();
        }
    }
}
