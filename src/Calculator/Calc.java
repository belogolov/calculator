package Calculator;

class Calc {
    private int a;
    private int b;
    private String operation;
    private String resultStr;

    Calc(int a, int b, String operation) {
        this.a = a;
        this.b = b;
        this.operation = operation;
        resultStr = "";
    }


    private void calculate() {
        switch (operation) {
            case "+":
                plus();
                break;
            case "-":
                minus();
                break;
            case "*":
                multiply();
                break;
            case "/":
                div();
                break;
            default:
                System.out.println("Операция не определена");
                break;
        }
    }

    String getResult() {
        calculate();
        return resultStr;
    }

    private void plus() {
        //int result = a + b;
        //System.out.println(result);
        resultStr = Integer.toString(a + b);
    }

    private void minus() {
//        int result = a - b;
//        System.out.println(result);
        resultStr = Integer.toString(a - b);
    }

    private void multiply() {
//        int result = a * b;
//        System.out.println(result);
        resultStr = Integer.toString(a * b);
    }

    private void div() {
        //double result = (double) a / (double) b;
//        if (b == 0) {
//            System.out.println("Деление на 0");
//        }
        //System.out.println(result);
        resultStr = Double.toString((double) a / (double) b);
    }
}
