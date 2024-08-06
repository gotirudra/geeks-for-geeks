class Solution {
    public boolean isValid(String str) {
        String[] parts = str.split("\\.");

        if (parts.length != 4) return false;

        for (String part : parts) {
           
            if (part.isEmpty() || !isNumeric(part)) return false;

            int num = Integer.parseInt(part);
            if (num < 0 || num > 255) return false;

            if (part.length() > 1 && part.charAt(0) == '0') return false;
        }

        return true;
    }

    private boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}
