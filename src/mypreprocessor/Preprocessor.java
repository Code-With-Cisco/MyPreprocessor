package mypreprocessor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
/**
 * @author Francisco Garcia
 * PID# 5767275
 * Programming Assignment 4
 * Professor Joslyn Smith
 */

public class Preprocessor {
    private String filename;
    
    public Preprocessor(String filename) {
        this.filename = filename;
 }       
        public void process() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                if (isValid(line)) {
                    System.out.println(line + " : Valid");
                } else {
                    System.out.println(line + " : Invalid");
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
    
    private boolean isValid(String line) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        return stack.isEmpty();
    }
}
