package cpen221practice;

import java.util.ArrayList;
import java.util.List;

class LuhnValidator {

    boolean isValid(String candidate) {

        boolean check = true;
        candidate = candidate.replaceAll(" ","");

        for (int i = 0; i < candidate.length(); i++) {
            char Char = candidate.charAt(i);
            if(!Character.isDigit(Char)){
               check = false;
            }
        }

        int length = candidate.length();
        int[] values = new int[length];
        int sum = 0;

        if (length <= 1 || check == false) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            int number = Integer.parseInt(String.valueOf(candidate.charAt(i)));
            values[i] = number;
        }

        for (int i = values.length - 2; i >= 0; i -= 2) {
            int val = values[i];
            val = val * 2;

            if (val > 9) {
                val -= 9;
            }
            values[i] = val;
        }

        for (int i : values) {
            sum += i;
        }

        if (sum % 10 == 0) {

            return true;
        }

        else{
            return false;
        }

    }
}
