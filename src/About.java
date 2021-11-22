import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class About extends JFrame
{

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    About frame = new About();
                    frame.setVisible(true);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public About()
    {
        setTitle("About");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 683, 598);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        JTextArea txtrHelloItsMe = new JTextArea();
        txtrHelloItsMe.setWrapStyleWord(true);
        txtrHelloItsMe.setEditable(false);
        txtrHelloItsMe.setFont(new Font("SansSerif", Font.PLAIN, 14));
        txtrHelloItsMe.setText("Hello!\r\nIt's me, the creator of this programme!\r\n\r\nThis programme has been created to automatise a very redundant task of planting carrots in a video game without connecting to the game process itself. To do so, first fill in the boxes asking how many items (carrots) you want to make, save the position X and Y of your synthesis button (aka. the plot where you plant carrots) then the button on your keyboard that plants and gathers the carrots - in game called 'macro button' (default button  '1' or '2'). Click 'CRAFT' button. The programme will now plant and collect the carrots automatically until it is finished. If you want to interrupt the process, simply press EMERGENCY EXIT. The time delays are based on the animations in-game and the additional random delay that a human normally planting the carrots would have. Thus the estimated time to finish the gathering is only more or less accurate because the human input lag is random. It's best to just run the programme and leave your PC for the time being and come back around the time you are told it will have finished. If you mouseover the boxes or sentences you will be shown tooltips with extra help or explainations.\r\n\r\nCreated by: Łukasz Jurkowski lukijurkowski@gmail.com");
        txtrHelloItsMe.setLineWrap(true);
        txtrHelloItsMe.setCaretPosition(0);
        scrollPane.setViewportView(txtrHelloItsMe);
    }

}
