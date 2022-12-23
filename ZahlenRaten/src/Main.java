import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    static Integer myNumber = ThreadLocalRandom.current().nextInt(0, 100 + 1);
    static Integer tries = 0;

    static JLabel text = new JLabel("Gebe eine Zahl zwischen 0 und 100 ein!");

    static JTextField textField = new JTextField();

    static JLabel punktZahl = new JLabel("Versuche: " + tries);

    static JFrame frame = new JFrame("Rate die Zahl!");

    static JButton button = new JButton("Raten");


    public static void main(String[] args) {
        openUI();


    }



    public static void guess(Integer number) {
        if (number == myNumber) {
            System.out.println("RICHTIG!");

            System.out.println("Du hast " + tries + " Versuche gebraucht");
            text.setText("Du hast " + tries + " Versuche gebraucht");
            punktZahl.setVisible(false);
            textField.setVisible(false);
            button.setText("Beenden?");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false); //you can't see me!
                    frame.dispose(); //Destroy the JFrame object

                }
            });


        }else {

            System.out.println("FALSCH");
            text.setText("FALSCH!");


            if (number < myNumber) {
                System.out.println("Deine Zahl ist kleiner als die Richtige Zahl!");
                text.setText("Deine Zahl ist kleiner als die Richtige Zahl!");

            }else {
                System.out.println("Deine Zahl ist größer als die richtige Zahl");
                text.setText("Deine Zahl ist größer als die Richtige Zahl!");

            }
            textField.setText("");
        }
    }

    public static void openUI() {
        frame.setSize(340, 300);
        frame.setLocation(100, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultLookAndFeelDecorated(true);



        punktZahl.setBounds(100, 20, 250, 30);
        text.setBounds(50, 50, 250, 30);

        textField.setBounds(50, 100, 200, 30);

        button.setBounds(50, 150, 200, 30);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String textfromTextfield = textField.getText();
                    Integer number = Integer.parseInt(textfromTextfield);
                    guess(number);
                    tries++;
                    punktZahl.setText("Versuche: " + tries);
                }catch(Exception error){
                    text.setText("Bitte gebe eine Zahl ein");
                }
            }
        });


        frame.add(punktZahl);
        frame.add(button);
        frame.add(textField);
        frame.add(text);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

}