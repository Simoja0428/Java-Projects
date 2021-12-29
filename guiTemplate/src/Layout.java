import javax.swing.*;
import java.awt.*;

public class Layout 
{
    public static void main(String[] args) 
    {
        JFrame window = new JFrame("Template Window");
        JPanel mainHolder = new JPanel(new GridLayout(1,1));

        window.add(mainHolder);
        window.setSize(300, 300); 
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        window.setLocation(200, 200); 
        window.setVisible(true);
    }
}
