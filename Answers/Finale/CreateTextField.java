import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class CreateTextField implements ActionListener{ 

    JTextField textField;
    JLabel Prompt;
    JLabel Contents;
        CreateTextField(){
        JFrame frame3 = new JFrame("Welcome to Lab7b!");
        frame3.setSize(500,500);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setLayout(new FlowLayout());
        textField = new JTextField(15);
        textField.setActionCommand("myCommand");
        JButton textFieldButton = new JButton("REVERSE");
        textField.addActionListener(this);
        textFieldButton.addActionListener(this);
        Prompt = new JLabel("Enter text: ");
        Contents = new JLabel("");
        frame3.add(Prompt);
        frame3.add(textField);
        frame3.add(textFieldButton);
        frame3.add(Contents);
        frame3.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("REVERSE")){
            String initStr= textField.getText();
            char[] arr = initStr.toCharArray();
            for(int i = 0; i<initStr.length()/2; i++){
                char temp = arr[i];
                arr[i] = arr[arr.length-i-1];
                arr[arr.length-i-1] = temp;
            }
            initStr = new String(arr);
            String revved = initStr;
            Contents.setText("You pressed ENTER. Text is:" + revved);
        } else {
            Contents.setText("You pressed ENTER. Text is: " + textField.getText());
        }
    }

    public static void main(String args[]) { 

        SwingUtilities.invokeLater(new Runnable() { 

            public void run() { 

                new CreateTextField();

            }

        }); 

    }
}    