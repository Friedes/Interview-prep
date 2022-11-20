package leetcode.java.string;

import java.util.Stack;

/*
 * Basic Calculator : Daily 20 Nov 2022
 */
public class Solution224 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int operand = 0;
        int result = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ')
                continue;
            if (ch - '0' >= 0 && ch - '0' <= 9) {
                operand = operand * 10 + (ch - '0'); 
            } else {
                if (ch == '+' || ch == '-') {
                    result = calculate(result, sign, operand);
                    sign = getsign(ch);
                } else {
                    if (ch == '(') {
                        stack.push(result); 
                        stack.push(sign);
                        result = 0;
                    } else {
                        result = calculate(result, sign, operand); 
                        int operator = stack.pop();
                        int prevResult = stack.pop();
                        result = calculate(prevResult, operator, result);                          
                    }
                    sign = 1; 
                }
                operand = 0; 
            }
        }
        if (operand != 0)
            result = calculate(result, sign, operand); 
                                                       
        return result;
    }

    private int calculate(int result, int sign, int number) {
        int ans = 0;
        if (sign == 1)
            ans = result + number;
        if (sign == -1)
            ans = result - number;
        return ans;
    }

    private int getsign(char ch) {
        if (ch == '+')
            return 1;
        else
            return -1;
    }
}
