package Calculator;

class Number {

    private enum TypeOfNumber {
        NOT_NUMBER, ARAB, ROMAN
    }

    private TypeOfNumber type;
    private String inputString;
    private int value;

    Number(String inputString) {
        this.inputString = inputString.replaceAll(" ", "");
        type = TypeOfNumber.NOT_NUMBER;
        value = 0;
        getValueFromString();
    }

    boolean isNumber() {
        return type != TypeOfNumber.NOT_NUMBER;
    }

    TypeOfNumber getType() {
        return type;
    }

    int getValue() {
        return value;
    }


    private void getValueFromString() {
        if (!convertToArabNumber()) {
            convertToRomanNumber();
        }
    }

    private boolean convertToArabNumber()  {
        boolean isArab = false;
        try {
            value = Integer.parseInt(inputString);
            type = TypeOfNumber.ARAB;
            isArab = true;
        } catch (NumberFormatException e) {
            //e.printStackTrace();
        }
        return isArab;
    }

    private boolean convertToRomanNumber()  {
        boolean isRoman = false;
        String str = inputString.toUpperCase();

        if (str.matches("M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})")) {
            type = TypeOfNumber.ROMAN;
            int p = 0;
            int romanValue = 0;
            for (int i = str.length() - 1; i >= 0; i--) {
                romanValue = romanNumeral(str.charAt(i));
                if (romanValue >= p) {
                    value += romanValue;
                } else {
                    value -= romanValue;
                }
                p = romanValue;
            }
            isRoman = true;
        }

        return isRoman;
    }

    private int romanNumeral(char roman){
        switch(roman){
            case'M':
                return 1000;
            case'D':
                return 500;
            case'C':
                return 100;
            case'L':
                return 50;
            case 'X':
                return 10;
            case'V':
                return 5;
            case'I':
                return 1;
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        return inputString;
    }
}
