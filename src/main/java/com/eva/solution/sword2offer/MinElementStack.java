package com.eva.solution.sword2offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author EvaJohnson
 * @Date 2019-08-01
 * @Email g863821569@gmail.com
 */
public class MinElementStack {
    private Stack<Integer> minStack = new Stack<>();

    private Stack<Integer> stack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        List<Integer> list = new ArrayList<>();
        while (!minStack.isEmpty() && top() < node) {
            list.add(minStack.pop());
        }
        minStack.push(node);
        for (int i = list.size() - 1; i >= 0; i--) {
            minStack.push(list.get(i));
        }
    }

    public int pop() {
        Integer pop = stack.pop();
        List<Integer> list = new ArrayList<>();
        while (!minStack.isEmpty() && top() != pop) {
            list.add(minStack.pop());
        }
        minStack.pop();
        for (int i = list.size() - 1; i >= 0; i--) {
            minStack.push(list.get(i));
        }
        return pop;
    }

    public int top() {
        return minStack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    // ["PSH3","MIN","PSH4","MIN","PSH2","MIN","PSH3","MIN","POP","MIN","POP","MIN","POP","MIN","PSH0","MIN"]
    public static void main(String[] args) {
        MinElementStack stack = new MinElementStack();
        stack.push(3);
        System.out.println(stack.min());
        stack.push(4);
        System.out.println(stack.min());
        stack.push(2);
        System.out.println(stack.min());
        stack.push(3);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.push(0);
        System.out.println(stack.min());
    }
}
