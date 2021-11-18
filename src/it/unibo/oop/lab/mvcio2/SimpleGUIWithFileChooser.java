package it.unibo.oop.lab.mvcio2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import it.unibo.oop.lab.mvcio.*;
/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    /*
     * TODO: Starting from the application in mvcio:
     */ 
    /*
     *  create frame
     */
    private static JFrame frame = new JFrame("EX mvcio2");
    public SimpleGUIWithFileChooser(final Controller controller) {
        /*
        * set screen dimension
        */
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 2, sh / 2);
        frame.setLocationByPlatform(true);
        /*
         * added panel
         */
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
         * added textField
         */
        final JTextArea textArea = new JTextArea();
        /*
         * added button
         */
        final JButton saveButton = new JButton("Save");
        /*
         * added two component in the panel
         */
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(saveButton, BorderLayout.SOUTH);
        frame.setContentPane(panel);
        /*
         * action when the button is pressed
         */
        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    controller.setCurrentFile();
                    controller.saveFile(textArea.getText());
                } catch (IOException e1) {
                    System.out.println(e1.toString());
                }
            }
        }); 
    /* 1) Add a JTextField and a button "Browse..." on the upper part of the
     * graphical interface.
     * Suggestion: use a second JPanel with a second BorderLayout, put the panel
     * in the North of the main panel, put the text field in the center of the
     * new panel and put the button in the line_end of the new panel.
     */
        /*
         * added new panel
         */
        final JPanel panel2 = new JPanel();
        panel.add(panel2, BorderLayout.NORTH);
        /*
         * added new textField witch display the current file 
         */
        controller.setCurrentFile();
        final JTextField txtField = new JTextField(controller.getFile().getName(), 15);
        panel2.add(txtField, BorderLayout.CENTER);
        /*
         * added new button
         */
        final JButton browseButton = new JButton("browse...");
        panel2.add(browseButton, BorderLayout.LINE_END);
    }
    /* 2) The JTextField should be non modifiable. And, should display the
     * current selected file.
     * 
     * 3) On press, the button should open a JFileChooser. The program should
     * use the method showSaveDialog() to display the file chooser, and if the
     * result is equal to JFileChooser.APPROVE_OPTION the program should set as
     * new file in the Controller the file chosen. If CANCEL_OPTION is returned,
     * then the program should do nothing. Otherwise, a message dialog should be
     * shown telling the user that an error has occurred (use
     * JOptionPane.showMessageDialog()).
     * 
     * 4) When in the controller a new File is set, also the graphical interface
     * must reflect such change. Suggestion: do not force the controller to
     * update the UI: in this example the UI knows when should be updated, so
     * try to keep things separated.
     */
    private void display() {
        frame.setVisible(true);
    }
    public static void main(final String... args) {
        final SimpleGUIWithFileChooser simpleGui = new SimpleGUIWithFileChooser(new Controller());
        simpleGui.display();
    }
}
