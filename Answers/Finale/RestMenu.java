import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class RestMenu implements ActionListener, ItemListener{

JCheckBox chicken;
JCheckBox salad;
JCheckBox salami;
JCheckBox pizza;
JCheckBox iceCream;
JCheckBox lasagna;
JCheckBox hotDog;
JCheckBox burger;
JCheckBox dumpling;
JCheckBox snowCone;

JTextField textField;

    int sum = 0;
    JLabel Prompt;
    JLabel Contents;
        RestMenu(){
        JFrame frame = new JFrame("The Menu of Food");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        textField = new JTextField(20);
        textField.setActionCommand("myCommand");
        JButton foodButton = new JButton("Confirm");
        foodButton.addActionListener(this);
        Prompt = new JLabel("Confirm order?: ");
        Contents = new JLabel("");
        chicken = new JCheckBox("$5 Chicken");
        chicken.addItemListener(this);
        salad = new JCheckBox("$10 Salad");
        salad.addItemListener(this);
        salami = new JCheckBox("$15 Salami");
        salami.addItemListener(this);
        pizza = new JCheckBox("$10 Pizza");
        pizza.addItemListener(this);
        iceCream = new JCheckBox("$15 IceCream");
        iceCream.addItemListener(this);
        lasagna = new JCheckBox("$10 Lasagna");
        lasagna.addItemListener(this);
        hotDog = new JCheckBox("$10 HotDog");
        hotDog.addItemListener(this);
        burger = new JCheckBox("$10 Burger");
        burger.addItemListener(this);
        dumpling = new JCheckBox("$5 Dumpling");
        dumpling.addItemListener(this);
        snowCone = new JCheckBox("$10 Snowcone");
        snowCone.addItemListener(this);

        frame.add(chicken);
        frame.add(salad);
        frame.add(salami);
        frame.add(pizza);
        frame.add(iceCream);
        frame.add(lasagna);
        frame.add(hotDog);
        frame.add(burger);
        frame.add(dumpling);
        frame.add(snowCone);
        frame.add(Prompt);
        frame.add(foodButton);
        frame.add(Contents);
        frame.setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e)
    {
        if (e.getSource() == chicken) {
            sum = e.getStateChange() == 1 ? sum+5: sum-5;    
        }
        if (e.getSource() == salad) {
            sum = e.getStateChange() == 1 ? sum+10: sum-10;    
        }
        if (e.getSource() == salami) {
            sum = e.getStateChange() == 1 ? sum+15: sum-15;    
        }
        if (e.getSource() == pizza) {
            sum = e.getStateChange() == 1 ? sum+10: sum-10;    
        }
        if (e.getSource() == iceCream) {
            sum = e.getStateChange() == 1 ? sum+15: sum-15;    
        }
        if (e.getSource() == lasagna) {
            sum = e.getStateChange() == 1 ? sum+10: sum-10;    
        }
        if (e.getSource() == hotDog) {
            sum = e.getStateChange() == 1 ? sum+10: sum-10;    
        }
        if (e.getSource() == burger) {
            sum = e.getStateChange() == 1 ? sum+10: sum-10;
        }
        if (e.getSource() == dumpling) {
            sum = e.getStateChange() == 1 ? sum+5: sum-5;    
        }
        if (e.getSource() == snowCone) {
            sum = e.getStateChange() == 1 ? sum+10: sum-10;
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("Confirm")){
            if(sum == 0) Contents.setText("Gonna order?");
            textField.setText(String.valueOf(sum));
            String price= textField.getText();
            if(sum>0) Contents.setText("You pressed Confirm. Your bill is:" + price);
        }
    }
    public static void main(String args[]) { 
        SwingUtilities.invokeLater(new Runnable() { 
            public void run() { 
                new RestMenu();
            }
        }); 

    }
}
