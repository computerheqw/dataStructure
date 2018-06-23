package com.hqw.stack;

import java.util.StringTokenizer;

/**
 * @author hqw521@qq.com
 * @date 2018/6/5 10:35
 */
public class TestStack {
    private Stack<Character> stack = new LinkedListStack<>();
    public void test() {
        Stack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 8; i++) {
            stack.push(i);
        }
        System.out.println(stack.toString());

        TestStack test = new TestStack();
        System.out.println(test.isValid("(([]{})"));
        System.out.println(test.infixToSuffix("9 + (3 - 1) * 3 + 10 / 2"));
    }
    // 括号匹配验证
    public boolean isValid(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                if (topChar == '(' && c != ')') {
                    return false;
                }
                if (topChar == '[' && c != ']') {
                    return false;
                }
                if (topChar == '{' && c != '}') {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * 中缀转后缀规则：
     * 从左到右遍历中缀表达式，若是数字就输出，即成为后缀表达式的一部分；
     * 如果是左括号，就压入栈，
     * 如果是右括号，则栈中元素依次出栈，直到栈中左括号出栈，
     * 如果是+、-运算符，栈中元素依次出栈，直到栈为空或遇到左括号，而后再将运算符压入栈，
     * 如果是*、/运算符，若栈不为空，且栈顶元素为*或/，则栈顶元素依次出栈，而后运算符入栈。
     * @param infixExpression
     * @return
     */
    public String infixToSuffix(String infixExpression) {
        StringTokenizer token = new StringTokenizer(infixExpression, " ()+-*/", true);
        Stack<String> operationStack = new LinkedListStack<>();
        String suffixExpression = "";
        while(token.hasMoreElements()) {
            String c = token.nextToken().trim();
            if (c.equals("+") || c.equals("-")) {
                while (!operationStack.isEmpty() && !operationStack.peek().equals("(")) {
                    suffixExpression += operationStack.pop();
                }
                operationStack.push(c);
            } else if (c.equals("*") || c.equals("/")) {
                while (!operationStack.isEmpty() && (operationStack.peek().equals("*") || operationStack.peek().equals("/"))) {
                    suffixExpression += operationStack.pop();
                }
                operationStack.push(c);
            } else if (c.equals(")")) {
                while (!operationStack.isEmpty() && !operationStack.peek().equals("(")) {
                    suffixExpression += operationStack.pop();
                }
                operationStack.pop();
            } else if (c.equals("(")) {
                operationStack.push(c);
            } else {
                suffixExpression += c;
            }
        }
        while (!operationStack.isEmpty()) {
            suffixExpression += operationStack.pop();
        }
        System.out.println(suffixExpression);
        return suffixExpression;
    }

    // 后缀表达式计算
    public void expressionCalculation(String suffixExpression) {
        StringTokenizer token = new StringTokenizer(suffixExpression);
        java.util.Stack<Double> numStack = new java.util.Stack<>();
        while(token.hasMoreElements()) {
            String c = token.nextToken().trim();
            if (c.equals("/") || c.equals("+") || c.equals("-") || c.equals("*")) {
                numStack.push(calculation(numStack.pop(), numStack.pop(), c));
            } else {
                numStack.push(Double.valueOf(c));
            }
        }
        System.out.println(numStack.peek());
    }

    private double calculation(double num1, double num2, String operator) {
        double result = 0.0;
        switch (operator) {
            case "+":
              result =  num2 + num1;
              break;
            case "-":
                result =  num2 - num1;
                break;
            case "*":
                result =  num2 * num1;
                break;
            case "/":
                result =  num2 / num1;
                break;
        }
        return result;
    }

    public double evaluateExpression(String expression) {
        Stack<Double> operandStack = new LinkedListStack<>();
        Stack<Character> operatorStack = new LinkedListStack<>();
        StringTokenizer tokens = new StringTokenizer(expression, "()+-*/", true);
        while (tokens.hasMoreTokens()) {
            String token = tokens.nextToken().trim();
            if (token.length() == 0) {
                continue;
            }
            else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    operandStack.push(calculation(operandStack.pop(), operandStack.pop(), String.valueOf(operatorStack.pop())));
                }
                operatorStack.push(token.charAt(0));
            } else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
                while (!operatorStack.isEmpty() && (operatorStack.peek() == '*' || operatorStack.peek() == '/')) {
                    operandStack.push(calculation(operandStack.pop(), operandStack.pop(), String.valueOf(operatorStack.pop())));
                }
                operatorStack.push(token.charAt(0));
            } else if (token.trim().charAt(0) == '(') {
                operatorStack.push('(');
            } else if (token.trim().charAt(0) == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() !='(') {
                    operandStack.push(calculation(operandStack.pop(), operandStack.pop(), String.valueOf(operatorStack.pop())));
                }
                operatorStack.pop();
            } else {
                operandStack.push(new Double(token));
            }
        }
        while(!operatorStack.isEmpty()) {
            operandStack.push(calculation(operandStack.pop(), operandStack.pop(), String.valueOf(operatorStack.pop())));
        }
        return operandStack.peek();
    }
}
