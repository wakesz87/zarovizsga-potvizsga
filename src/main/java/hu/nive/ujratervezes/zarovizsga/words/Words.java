package hu.nive.ujratervezes.zarovizsga.words;

public class Words {

    public boolean hasMoreDigits(String s) {
        if (s == null || s.isBlank()) {
            return false;
        }
        int digits = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                digits++;
            }
        }
        return digits > (s.length() - digits);
    }
}
