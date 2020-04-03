package Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalcApp {
    public static void main(String[] args) throws IOException {
        System.out.println("Калькулятор выполняет операции вида a + b, a - b, a * b, a / b с арабскими или римскими целыми числами из интервала [1; 10].");


        while (true) {
            String s = getString();
            int indexOfOperation = getIndexOfOperation(s);

            System.out.print("Output: ");
            if (indexOfOperation == -1) {
                System.out.println("Действие не определено");
                break;
            } else {
                String aStr = s.substring(0, indexOfOperation);
                String bStr = s.substring(indexOfOperation + 1);
                String opStr = s.substring(indexOfOperation, indexOfOperation + 1);
                Number aNum = new Number(aStr);
                Number bNum = new Number(bStr);

                if (isCorrect(aNum, bNum)) {
                    Calc calc = new Calc(aNum.getValue(), bNum.getValue(), opStr);
                    String result = calc.getResult();
                    if (aNum.getType() == Number.TypeOfNumber.ARAB) {
                        System.out.println(result);
                    } else {
                        //Number resNum = new Number(Integer.parseInt(result), aNum.getType());
                        Number resNum = new Number((int) Double.parseDouble(result), aNum.getType());
                        System.out.println(resNum.toString() + " (" + result + ")");
                    }

                } else {
                    break;
                }
            }
        }

    }

    private static boolean isCorrect(Number a, Number b) {
        if (a.isNumber() && b.isNumber()) {
            if (a.getType() == b.getType()) {
                if (a.getValue() < 1 || a.getValue() > 10 || b.getValue() < 1 || b.getValue() > 10) {
                    System.out.println("Введены неподходящие числа. Введите целые числа от 1 до 10.");
                    return false;
                }
            } else {
                System.out.println("Введены неподходящие числа. Следует вводить одновременно арабские или римские числа.");
                return false;
            }
        } else {
            System.out.println("Введены неподходящие числа. Следует вводить либо арабские, либо римские числа.");
            return false;
        }
        return true;
    }

    private static int getIndexOfOperation(String str) {
        int index = -1;
        index = str.indexOf("+");
        if (index == -1) {
            index = str.indexOf("-");
            if (index == -1) {
                index = str.indexOf("*");
                if (index == -1) {
                    index = str.indexOf("/");
                }
            }
        }
        return index;
    }

    private static String getString() throws IOException {
        System.out.print("Input: ");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }
}
