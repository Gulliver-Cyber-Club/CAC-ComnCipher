import java.awt.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.*;
public class MyGUIB extends JFrame
 
{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button;

    public MyGUIB() {
        super("My GUI");

        JPanel panel = new JPanel();
        GridLayout gridLayout = new GridLayout(4,1);
        panel.setLayout( gridLayout);

        JLabel label1 = new JLabel("password:");
        panel.add(label1);

        textField1 = new JTextField();
        panel.add(textField1);

        JLabel label2 = new JLabel("salt:");
        panel.add(label2);

        textField2 = new JTextField();
        panel.add(textField2);

        JLabel label3 = new JLabel("ciphertext:");
        panel.add(label3);

        textField3 = new JTextField();
        panel.add(textField3);

        button = new JButton("send");
        panel.add(button);

        button.addActionListener(e -> {
            String string1 = textField1.getText();
            String string2 = textField2.getText();
            String string3 = textField3.getText();

            // Call the method using the three strings
            
            Encrypt enc = new Encrypt();
            try {
                enc.decrypt(string1, string2, string3);
            } catch (InvalidKeyException | InvalidKeySpecException | NoSuchAlgorithmException | NoSuchPaddingException
                    | InvalidAlgorithmParameterException | BadPaddingException | IllegalBlockSizeException e1) {
                
                e1.printStackTrace();
            }
        });

        add(panel);
        setSize(400, 200);
        setVisible(true);
    }
public static void main(String[] args) {
    new MyGUI();
}
   
    
}