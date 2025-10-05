import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class CreateBannerButton implements ActionListener{ 

   JLabel jLab; 

    CreateBannerButton(){
        JFrame frame2 = new JFrame("Votes or Nah");

        frame2.setSize(400, 500) ;     
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setLayout(new FlowLayout());  
        JLabel FirstLabel = new JLabel("Are you legal to vote or nah?!");
        FirstLabel.setBounds(100, 50, 240, 80);       
        frame2.add(FirstLabel);
        JButton FirstButton = new JButton("YES");
        JButton SecondButton = new JButton("NO");
        FirstButton.addActionListener(this);
        SecondButton.addActionListener(this);
        frame2.setLayout(null);
        FirstButton.setBounds(80, 200 ,80, 80);
        SecondButton.setBounds(160, 200, 80, 80);
        jLab = new JLabel("Press a button..");
        jLab.setBounds(120,10, 240,80);
        frame2.add(FirstButton);
        frame2.add(SecondButton);
        frame2.add(jLab);
        frame2.setVisible(true);
    }

    public static void main(String args[]) { 

        SwingUtilities.invokeLater(new Runnable() { 

            public void run() { 

                new CreateBannerButton();
                
            }

        }); 

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("YES")) {
            jLab.setText("You pressed YES.");
        } else {
            jLab.setText("You pressed NO.");
        }
    }
}                         