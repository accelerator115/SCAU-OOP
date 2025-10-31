package calculator.exp;

import java.util.Stack;

public class ArithmeticExpression {
    private String expr;

    public ArithmeticExpression(String expr) {
        this.expr = expr;
    }

    public int getResult() {
        return evaluatePostfix(toPostfix(expr));
    }

    private String[] toPostfix(String expr) {
        String[] tokens = expr.split(" ");
        Stack<String> operators = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (String token : tokens) {
            if (isNumeric(token)) {
                postfix.append(token).append(" ");
            } else if (token.equals("(")) {
                operators.push(token);
            } else if (token.equals(")")) {
                while (!operators.isEmpty() && !operators.peek().equals("(")) {
                    postfix.append(operators.pop()).append(" ");
                }
                operators.pop();
            } else {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(token)) {
                    postfix.append(operators.pop()).append(" ");
                }
                operators.push(token);
            }
        }

        while (!operators.isEmpty()) {
            postfix.append(operators.pop()).append(" ");
        }

        return postfix.toString().trim().split(" ");
    }

    private int evaluatePostfix(String[] postfix) {
        Stack<Integer> stack = new Stack<>();

        for (String token : postfix) {
            if (isNumeric(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                switch (token) {
                    case "+" -> stack.push(a + b);
                    case "-" -> stack.push(a - b);
                    case "*" -> stack.push(a * b);
                    case "/" -> stack.push(a / b);
                }
            }
        }

        return stack.pop();
    }

    private boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    private int precedence(String op) {
        return switch (op) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> -1;
        };
    }
}