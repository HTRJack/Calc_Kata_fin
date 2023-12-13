package org.example;

import java.util.ArrayList;

class Number {

    Number(String inputText, char sign, int state) {
        if (state == 1) {
            stringValue = inputText.substring(0, inputText.indexOf(sign) - 1).trim();
            numSystem = checkSystem(stringValue);
            numValue = parseNum(stringValue, numSystem);
        }
        if (state == 2) {
            stringValue = inputText.substring(inputText.indexOf(sign)+1).trim();
            numSystem = checkSystem(stringValue);
            numValue = parseNum(stringValue, numSystem);
        }
    }


    String stringValue;
    int numValue;

    String numSystem;

    static String checkSystem(String input) {
        ArrayList<String> romanRow = new ArrayList<>();

        romanRow.add("I");
        romanRow.add("II");
        romanRow.add("III");
        romanRow.add("IV");
        romanRow.add("V");
        romanRow.add("VI");
        romanRow.add("VII");
        romanRow.add("VIII");
        romanRow.add("IX");
        romanRow.add("IX");

        for (String romanNumber : romanRow) {
            if (input.equals(romanNumber)) {
                return "roman";
            }
        }

        if (Integer.parseInt(input) > 0 & Integer.parseInt(input) < 11) {
            return "arabic";
        }
        return "error";
    }

    static int parseNum(String input, String system) {


        if (system.equals("arabic")) {

            return Integer.parseInt(input);
        } else if (system.equals("roman")) {
            return switch (input) {
                case "I" -> 1;
                case "II" -> 2;
                case "III" -> 3;
                case "IV" -> 4;
                case "V" -> 5;
                case "VI" -> 6;
                case "VII" -> 7;
                case "VIII" -> 8;
                case "IX" -> 9;
                case "X" -> 10;
                default -> 0;
            };
        } else return 0;

    }

}
