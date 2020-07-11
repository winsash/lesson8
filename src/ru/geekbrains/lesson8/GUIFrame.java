package ru.geekbrains.lesson8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIFrame extends JFrame {
    public GUIFrame() {
        setTitle("Java GUI Calc");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        setBackground(new Color(202, 114, 14));


        JTextField textField = new JTextField();
        textField.setBackground(new Color(0xA2E44C));
        add(textField);

        GridLayout gridLayout = new GridLayout(3, 3);
        setLayout(gridLayout);

        ButtonListener buttonListener = new ButtonListener(textField);

        for (int i = 1; i <= 9; i++) {
            JButton jButton = new JButton(String.valueOf(i));
            jButton.addActionListener(buttonListener);
            add(jButton);
        }

        JButton plusButton = new JButton("+");
        plusButton.setBackground(Color.GRAY);
        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                if (!text.isEmpty()) {
                    char lastChar = text.charAt(text.length() - 1);
                    if (checkLastChar(lastChar)) {
                        text = text + "+";
                        textField.setText(text);
                    }
                }
            }
        });
        add(plusButton);

        JButton minusButton = new JButton("-");
        minusButton.setBackground(Color.GRAY);
        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                if (!text.isEmpty()) {
                    char lastChar = text.charAt(text.length() - 1);
                    if (checkLastChar(lastChar)) {
                        text = text + "-";
                        textField.setText(text);
                    }
                }
            }
        });
        add(minusButton);

        JButton multiplicationButton = new JButton("*");
        multiplicationButton.setBackground(Color.GRAY);
        multiplicationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                if (!text.isEmpty()) {
                    char lastChar = text.charAt(text.length() - 1);
                    if (checkLastChar(lastChar)) {
                        text = text + "*";
                        textField.setText(text);
                    }
                }
            }
        });
        add(multiplicationButton);

        JButton segmentationButton = new JButton("/");
        segmentationButton.setBackground(Color.GRAY);
        segmentationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                if (!text.isEmpty()) {
                    char lastChar = text.charAt(text.length() - 1);
                    if (checkLastChar(lastChar)) {
                        text = text + "/";
                        textField.setText(text);
                    }
                }
            }
        });
        add(segmentationButton);

        JButton backButton = new JButton("Backspace");
        backButton.setBackground(Color.ORANGE);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                if (!text.isEmpty()) {
                    text = text.substring(0, text.length() - 1);
                    textField.setText(text);
                }
            }
        });
        add(backButton);

        JButton clearButton = new JButton("Clear");
        clearButton.setBackground(Color.RED);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                text = "";
                textField.setText(text);
            }
        });
        add(clearButton);

        JButton summaryButton = new JButton("=");
        summaryButton.setBackground(Color.GREEN);
        summaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
                String expression = textField.getText();
                try{
                    float result = Float.valueOf(engine.eval(expression).toString());
                    textField.setText(String.valueOf(result));
                } catch (ScriptException exception){};
            }
        });
        add(summaryButton);


        setVisible(true);
    }

    private boolean checkLastChar(char symbol) {
        if (symbol != '+' && symbol != '-' && symbol != '*' && symbol != '/') {
            return true;
        } else {
            return false;
        }
    }
}
