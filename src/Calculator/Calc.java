package Calculator;

public class Calc {
    private int a;
    private int b;
    private String operation;

    public Calc(int a, int b, String operation) {
        this.a = a;
        this.b = b;
        this.operation = operation;
    }


    public void calculate() {

        if (operation.equals("+")) {
            plus();
        } else if (operation.equals("-")) {
            minus();
        } else if (operation.equals("*")) {
            multiply();
        } else if (operation.equals("/")) {
            div();
        } else {
            System.out.println("Операция не определена");
        }
    }

    private void plus() {
        int result = a + b;
        System.out.println(result);
    }

    private void minus() {
        int result = a - b;
        System.out.println(result);
    }

    private void multiply() {
        int result = a * b;
        System.out.println(result);
    }

    private void div() {
        double result = (double) a / (double) b;
//        if (b == 0) {
//            System.out.println("Деление на 0");
//        }
        System.out.println(result);
    }
}
