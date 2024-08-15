package mypreprocessor;
import javax.swing.JFileChooser;
/**
 * @author Francisco Garcia
 * PID# 5767275
 * Programming Assignment 4
 * Professor Joslyn Smith
 */

public class MyPreprocessor {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            String inputFilename = fileChooser.getSelectedFile().getPath();
            Preprocessor p = new Preprocessor(inputFilename);
            p.process();
        }
    }
}

