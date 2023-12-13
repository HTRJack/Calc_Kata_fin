package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String input;

        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();

        try {
            System.out.println(calc(input));
        } catch (Exception e) {
            System.out.println("OOOPS!");
            System.exit(0);
        }


    }

    public static String calc(String input) throws Exception {
        String result;

        char sign;
        Number num1;
        Number num2;

        int intResult;

        sign = parseMathSign(input);
        if (sign == '0') throw new Exception();
        num1 = new Number(input, sign, 1);
        num2 = new Number(input, sign, 2);


        if (num1.numValue > 10 | num1.numValue < 1) {
            throw new Exception();
        }

        if (num2.numValue > 10 | num2.numValue < 1) {
            throw new Exception();
        }

        if (!num1.numSystem.equals(num2.numSystem)) {
            throw new Exception();
        }
        if (sign == '+') {
            intResult = num1.numValue + num2.numValue;
        } else if (sign == '-') {
            intResult = num1.numValue - num2.numValue;
        } else if (sign == '/') {
            intResult = num1.numValue / num2.numValue;
        } else {
            intResult = num1.numValue * num2.numValue;
        }
        if (num1.numSystem.equals("arabic")) {
            result = Integer.toString(intResult);
        } else if (num1.numSystem.equals("roman")) {
            result = arabicToRoman(intResult);
        } else {
            throw new Exception();
        }
        return result;
    }


    static char parseMathSign(String inputText) {
        int positionOfSymbol;
        char mathSign = '0';
        ArrayList<Character> validMathSigns = new ArrayList<>();
        validMathSigns.add('/');
        validMathSigns.add('+');
        validMathSigns.add('-');
        validMathSigns.add('*');

        for (Character sign : validMathSigns
        ) {
            if (inputText.indexOf(sign) != -1) {
                positionOfSymbol = inputText.indexOf(sign);
                mathSign = inputText.charAt(positionOfSymbol);
                break;
            }
        }

        return mathSign;
    }

    static String arabicToRoman(int num) {
        return List.of("", "M", "MM", "MMM").get(num / 1000) +
                List.of("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM").get(num / 100 % 10) +
                List.of("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC").get(num / 10 % 10) +
                List.of("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX").get(num % 10);
    }

}