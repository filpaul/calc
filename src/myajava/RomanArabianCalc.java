package myajava;

import java.util.Scanner;
public class RomanArabianCalc {
    public static Scanner scanner = new Scanner(System.in);
    public static int num1, num2;
    public static char operation;
    public static int result;
    public static boolean flag1 = false, flaq2 = false;
}
class TestCalc extends RomanArabianCalc {
    public static void main(String[] args) {
        System.out.println("Введите выражение, состоящее из двух целых чисе1 до 10:[2+2],\n"+
                " знака операции или два римских числа от I до X:[V+V] + Enter\n "+
                "Не допускается использовать арабские и римские цифры вместе:");
//      Считываем строку userInput которую ввёл пользователь
        String userInput = scanner.nextLine();
//      Создаём пустой символьный массив длиной 10 символов: line
        char[] line = new char[10];
//      Заполняем символьный массив символами строки которую ввел пользователь и ловим знак операции
        for (int i = 0; i < userInput.length(); i++) {
            line[i] = userInput.charAt(i);
            if (line[i] == '+') {
                operation = '+';
            }
            if (line[i] == '-') {
                operation = '-';
            }
            if (line[i] == '*') {
                operation = '*';
            }
            if (line[i] == '/') {
                operation = '/';
            }
        }
        String under_charString = String.valueOf(line);
        String[] blacks = under_charString.split("[+-/*]");
        String stable00 = blacks[0];
        String stable01 = blacks[1];
        String string03 = stable01.trim();

        String[] s1 = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for (int i = 0; i < s1.length; i++) {
            if (s1[i].equals(stable00)) {
                flag1 = true;
            }
        }
        for (int i = 0; i < s1.length; i++) {
            if (s1[i].equals(string03)) {
                flaq2 = true;
            }
        }
        if (flag1 && flaq2) {
            num1 = romanToNumber(stable00);
            num2 = romanToNumber(string03);
            if (num1 < 0 || num2 < 0) {
                throw new ArithmeticException();
            } else {
                result = calculate(num1, num2, operation);
                String resultRoman = convertArabToRoman(result);
                if (resultRoman.equals("O")) {
                    throw new ArithmeticException();
                }
                System.out.println("Output для римских цифр:");
                System.out.println(resultRoman);
            }

        } else {

            num1 = Integer.parseInt(stable00);
            num2 = Integer.parseInt(string03);
            if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
                throw new IllegalArgumentException();
            } else {
                result = calculate(num1, num2, operation);
                System.out.println("Output для арабских цифр:");
                System.out.println(result);
            }
        }
    }

    public static int calculate(int num1, int num2, char operation) {
        int result = 0;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArrayIndexOutOfBoundsException e){
                    break;}
            default:
                throw new IllegalArgumentException();
        }
        return result;
    }

    public static String convertArabToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        final String st = roman[numArabian];
        return st;
    }


    public static int romanToNumber(String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
        return -1;
    }
}
