package me.angeloid.ttt;

import java.util.Stack;

/**
 * @author AngeloidYun
 * @date 2020/6/30
 */
public class SwordOffer09 {
    class CQueue {
        Stack<Integer> asc = new Stack<>();
        Stack<Integer> desc = new Stack<>();

        public CQueue() {
            size = 0;
        }

        int size;

        public void appendTail(int value) {

            asc.push(value);
            size++;
        }

        public int deleteHead() {
            if (size == 0) {
                return -1;
            }
            if (desc.isEmpty()) {
                while (!asc.isEmpty()) {
                    desc.push(asc.pop());
                }
            }
            size--;
            return desc.pop();
        }
    }

    class CQueue2 {
        private int[] stack1;
        private int[] stack2;
        private int top1,top2;
        int size ;
        public CQueue2() {
            stack1 = new int[10000];
            stack2 = new int[10000];
            top1 = -1;
            top2 = -1;
            size = 0;
        }

        public void appendTail(int value) {
            stack1[++top1] = value;
            size ++;
        }

        public int deleteHead() {
            if(size ==0){
                return -1;
            }
            if(top2 >= 0)
            {
                return stack2[top2--];
            }
            else
            {
                while(top1>=0)
                {
                    stack2[++top2] = stack1[top1--];
                }
            }
            size --;
            return stack2[top2--];
        }
    }
}
