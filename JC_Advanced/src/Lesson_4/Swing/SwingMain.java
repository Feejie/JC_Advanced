package Lesson_4.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingMain {
    public static void main(String[] args) {
        new GUI();
    }
}


class GUI extends JFrame {
    public GUI(){
        setTitle("New Form");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);
        createGUI();
        setVisible(true);
    }

    public void createGUI(){
        JButton runButton = new JButton("Run");

        JPanel btnPanel = new JPanel(new FlowLayout());

        btnPanel.setPreferredSize(new Dimension(50, 40));
        btnPanel.add(runButton);

        add(btnPanel, BorderLayout.SOUTH);

        // вывод нового окна
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame inputWindow = new JFrame("Input Form");
                inputWindow.setBounds(200, 300, 400, 400);
                inpGUI(inputWindow);
                inputWindow.setVisible(true);
            }

            // параметры окна
            void inpGUI(JFrame frame){
                String fnHint = "First Name";
                String lnHint = "Last Name";
                String nnHint = "Nickname";

                JTextField firstName = new JTextField(fnHint);
                JTextField lastName = new JTextField(lnHint);
                JTextField nickName = new JTextField(nnHint);

                JButton expButton = new JButton("Export");

                JPanel inpPanel = new JPanel(new GridLayout(3, 1));
                JPanel btnPanel = new JPanel(new FlowLayout());
                inpPanel.setPreferredSize(new Dimension(100, 90));
                btnPanel.setPreferredSize(new Dimension(50,50));
                inpPanel.add(firstName);
                inpPanel.add(lastName);
                inpPanel.add(nickName);
                btnPanel.add(expButton);

                frame.add(inpPanel, BorderLayout.NORTH);
                frame.add(btnPanel, BorderLayout.SOUTH);

                // вывод текста в первое окно
                expButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JTextArea firstNameArea = new JTextArea("");
                        JTextArea lastNameArea = new JTextArea("");
                        JTextArea nicknameArea = new JTextArea("");
                        firstNameArea.setEditable(false);
                        lastNameArea.setEditable(false);
                        nicknameArea.setEditable(false);

                        JPanel textPanel = new JPanel(new GridLayout(3, 1));
                        textPanel.setPreferredSize(new Dimension(10, 90));

                        textPanel.add(firstNameArea);
                        textPanel.add(lastNameArea);
                        textPanel.add(nicknameArea);

                        add(textPanel, BorderLayout.NORTH);

                        hintTextCheck(firstName, firstNameArea, fnHint);
                        hintTextCheck(lastName, lastNameArea, lnHint);
                        hintTextCheck(nickName, nicknameArea, nnHint);
                        firstName.setText("");
                        lastName.setText("");
                        nickName.setText("");
                        firstName.grabFocus();
                        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                    }
                });

                // параметры текста-подсказки
                Color hintColor1 = firstName.getCaretColor();
                Color hintColor2 = lastName.getCaretColor();
                Color hintColor3 = nickName.getCaretColor();

                firstName.setForeground(Color.LIGHT_GRAY);
                lastName.setForeground(Color.LIGHT_GRAY);
                nickName.setForeground(Color.LIGHT_GRAY);

                // вывести подсказку
                createHint(firstName, fnHint, hintColor1);
                createHint(lastName, lnHint, hintColor2);
                createHint(nickName, nnHint, hintColor3);

            }

            // задать подсказку
            void createHint(JTextField tf, String hint, Color color){
                tf.addFocusListener(new FocusAdapter() {
                    // field в фокусе
                    @Override
                    public void focusGained(FocusEvent e) {
                        super.focusGained(e);
                        tf.setForeground(color);
                        if(tf.getText().equals(hint)){
                            tf.setText("");
                        }
                    }

                    // field не в фокусе
                    @Override
                    public void focusLost(FocusEvent e){
                        if(tf.getText().isEmpty()){
                            tf.setForeground(Color.LIGHT_GRAY);
                            tf.setText(hint);
                        }
                    }
                });
            }

            // вывод подсказки в TextArea при нетронутом поле TextField
            void hintTextCheck(JTextField textField, JTextArea textArea, String hint){
                if(!textField.getText().equals(hint)) {
                    textArea.setText(textField.getText());
                } else {
                    textArea.setText(textField.getText());
                    textArea.setForeground(Color.LIGHT_GRAY);
                }
            }
        });

    }
}
