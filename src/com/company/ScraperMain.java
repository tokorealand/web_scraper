package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ScraperMain {
    private JTextField address;
    private JButton findPhoneNumbersButton;
    private JTextArea phoneNumbersTextArea;
    private JPanel Scraper;
    private PhoneNumberFinder finder = new PhoneNumberFinder();


   ScraperMain()
   {

        JFrame frame = new JFrame("Scapper");
        frame.setContentPane(Scraper);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

findPhoneNumbersButton.addActionListener(e -> {

    phoneNumbersTextArea.setText("Searching....");
    phoneNumbersTextArea.updateUI();

    SwingWorker myWorker= new SwingWorker<String, Void>() {
        @Override
        protected String doInBackground() throws Exception {
            //Execute your logic
            phoneNumbersTextArea.setText("Phone Number: " + finder.searchPageForNumber( address.getText()
            ) + "\n" +"Website: " + address.getText());
            return null;
        }
    };
    myWorker.execute();


});
   }








    }



