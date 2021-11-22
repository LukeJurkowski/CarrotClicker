import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeListener;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.ParseException;


        public class UIMain extends JFrame
{

//	Model model;

    /**
     *
     */
    private static final long serialVersionUID = 1L;
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
                    UIMain frame = new UIMain();
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

    JSpinner spinner = new JSpinner(); //quantity
    JSpinner spinner_1 = new JSpinner(); //time
    JLabel lblNewLabel_2 = new JLabel("X:0.0 Y:0.0"); //show cords
    JButton btnNewButton = new JButton("Save new XY"); //save XY listener/button
    JCheckBox chckbxNewCheckBox = new JCheckBox("SHIFT"); //shift1
    JCheckBox chckbxNewCheckBox_1 = new JCheckBox("CTRL"); //ctrl1
    JCheckBox chckbxNewCheckBox_2 = new JCheckBox("ALT"); //alt1
    JFormattedTextField formattedTextField = new JFormattedTextField(); //key1
    //JFormattedTextField formattedTextField = new JFormattedTextField(formatter); /(formatter2)
    JCheckBox chckbxNewCheckBox_3 = new JCheckBox("SHIFT"); //shift2
    JCheckBox chckbxNewCheckBox_1_1 = new JCheckBox("CTRL"); //CTRL2
    JCheckBox chckbxNewCheckBox_2_1 = new JCheckBox("ALT"); //alt2
    JFormattedTextField formattedTextField2 = new JFormattedTextField(); //key2
    JSpinner spinner_2 = new JSpinner(); // macro1 craft time
    JButton btnNewButton_1 = new JButton("CRAFT"); //craft button
    JLabel lblNewLabel_7 = new JLabel(""); //finish time
    JButton btnNewButton_2 = new JButton("Emergency EXIT!"); //emergency exit button
    JButton btnNewButton_3 = new JButton("About"); //about button
    JButton btnNewButton_4 = new JButton("Reset"); //Reset values showing button


    public UIMain()
    {
        setAlwaysOnTop(true);
        setTitle("CarrotClicker");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 505, 393);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));

        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1);
        panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNewLabel = new JLabel("How many items to make [1-999]:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_1.add(lblNewLabel);


        spinner.setFont(new Font("Tahoma", Font.PLAIN, 14));
        spinner.setModel(new SpinnerNumberModel(1, 1, 999, 1));
        panel_1.add(spinner);

        JPanel panel_4 = new JPanel();
        contentPane.add(panel_4);

        JLabel lblNewLabel_3 = new JLabel("Time required to finish whole macro (in seconds) [1-180]");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_3.setToolTipText("The time needed to craft one item.");
        panel_4.add(lblNewLabel_3);


        spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        spinner_1.setToolTipText("The time needed to craft one item.");
        spinner_1.setModel(new SpinnerNumberModel(2, 1, 180, 1));
        panel_4.add(spinner_1);

        JPanel panel_2 = new JPanel();
        contentPane.add(panel_2);


        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));

        panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNewLabel_1 = new JLabel("Your X and Y of synthesis button");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_2.add(lblNewLabel_1);

        JLabel label = new JLabel("");
        panel_2.add(label);

        JLabel label_1 = new JLabel("");
        panel_2.add(label_1);
        panel_2.add(btnNewButton);

        panel_2.add(lblNewLabel_2);

        JPanel panel = new JPanel();
        contentPane.add(panel);

        JLabel lblNewLabel_4 = new JLabel("First macro button shortcut: ");
        lblNewLabel_4.setToolTipText("Any letter or number from international keyboard [A-Z] [0-9]");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(lblNewLabel_4);


        chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(chckbxNewCheckBox);

        chckbxNewCheckBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(chckbxNewCheckBox_1);

        chckbxNewCheckBox_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(chckbxNewCheckBox_2);

        try
        {
            MaskFormatter formatter = new MaskFormatter("A");
//			formatter.setValidCharacters("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
            formattedTextField = new JFormattedTextField(formatter);
            formattedTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
            formattedTextField.setToolTipText(
                    "Any letter or number from international keyboard [A-Z] [0-9]");
            formattedTextField.setColumns(4);
            panel.add(formattedTextField);

            JPanel panel_5 = new JPanel();
            contentPane.add(panel_5);

            JLabel lblNewLabel_4_1 = new JLabel("Second macro button shortcut: ");
            lblNewLabel_4_1.setToolTipText("Any letter or number from international keyboard [A-Z] [0-9] | Leave blank if macro has only 1 button.");
            lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
            panel_5.add(lblNewLabel_4_1);
            chckbxNewCheckBox_3.setToolTipText("");


            chckbxNewCheckBox_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
            panel_5.add(chckbxNewCheckBox_3);
            chckbxNewCheckBox_1_1.setToolTipText("");


            chckbxNewCheckBox_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
            panel_5.add(chckbxNewCheckBox_1_1);
            chckbxNewCheckBox_2_1.setToolTipText("");


            chckbxNewCheckBox_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
            panel_5.add(chckbxNewCheckBox_2_1);

            MaskFormatter formatter2 = new MaskFormatter("A");
            //JFormattedTextField formattedTextField = new JFormattedTextField(formatter);
            formattedTextField2 = new JFormattedTextField(formatter2);
            formattedTextField2.setFont(new Font("Tahoma", Font.PLAIN, 14));
            formattedTextField2.setToolTipText(
                    "Any letter or number from international keyboard [A-Z] [0-9] | Leave blank if macro has only 1 button.");
            formattedTextField2.setColumns(4);
            panel_5.add(formattedTextField2);

            JPanel panel_9 = new JPanel();
            contentPane.add(panel_9);

            JLabel lblNewLabel_8 = new JLabel("Time required to finish 1st macro before 2nd macro starts:");
            lblNewLabel_8.setToolTipText("The time needed to finish first macro when the macro consists of two buttons.\r\nLeave 0 if macro uses only one button.");
            lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
            panel_9.add(lblNewLabel_8);
            spinner_2.setToolTipText("The time needed to finish first macro when the macro consists of two buttons.\r\nLeave 0 if macro uses only one button.");


            spinner_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
            spinner_2.setModel(new SpinnerNumberModel(0, 0, 42, 1));
            panel_9.add(spinner_2);

            JSeparator separator = new JSeparator();
            contentPane.add(separator);

            JPanel panel_8 = new JPanel();
            contentPane.add(panel_8);

            JLabel lblNewLabel_6 = new JLabel("!!! Remember to have the game window on top!!!");
            lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
            panel_8.add(lblNewLabel_6);

            JPanel panel_3 = new JPanel();
            contentPane.add(panel_3);

            JLabel lblNewLabel_5 = new JLabel("The craft finishes around: ");
            lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));

            // crafting

            lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
            btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
            panel_3.add(btnNewButton_1);

            // emergency exit

            btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
            panel_3.add(btnNewButton_2);

            JPanel panel_6 = new JPanel();
            contentPane.add(panel_6);

            panel_6.add(lblNewLabel_5);

            panel_6.add(lblNewLabel_7);

            JPanel panel_7 = new JPanel();
            panel_7.setAlignmentX(Component.LEFT_ALIGNMENT);
            contentPane.add(panel_7);
            btnNewButton_4.setFont(new Font("Tahoma", Font.ITALIC, 12));


            btnNewButton_4.setToolTipText("Resets values to default ones as long as nothing is happening.");
            panel_7.add(btnNewButton_4);

            btnNewButton_3.setFont(new Font("Tahoma", Font.ITALIC, 12));
            panel_7.add(btnNewButton_3);

        } catch (ParseException e1)
        {
            e1.printStackTrace();
        }

    }

    public void UIUpdate()
    {
        repaint();
    }

	/*
	JSpinner spinner = new JSpinner(); //quantity
	JSpinner spinner_1 = new JSpinner(); //time
	JLabel lblNewLabel_2 = new JLabel("X:0.0 Y:0.0"); //show cords
	JButton btnNewButton = new JButton("Save new XY"); //save XY listener/button
	JCheckBox chckbxNewCheckBox = new JCheckBox("SHIFT"); //shift1
	JCheckBox chckbxNewCheckBox_1 = new JCheckBox("CTRL"); //ctrl1
	JCheckBox chckbxNewCheckBox_2 = new JCheckBox("ALT"); //alt1
	JFormattedTextField formattedTextField = new JFormattedTextField(); //key1
	//JFormattedTextField formattedTextField = new JFormattedTextField(formatter); /(formatter2)
	JCheckBox chckbxNewCheckBox_3 = new JCheckBox("SHIFT"); //shift2
	JCheckBox chckbxNewCheckBox_1_1 = new JCheckBox("CTRL"); //CTRL2
	JCheckBox chckbxNewCheckBox_2_1 = new JCheckBox("ALT"); //alt2
	JFormattedTextField formattedTextField2 = new JFormattedTextField(); //key2
	JButton btnNewButton_1 = new JButton("CRAFT"); //craft button
	JLabel lblNewLabel_7 = new JLabel(""); //finish time
	JButton btnNewButton_2 = new JButton("Emergency EXIT!"); //emergency exit button
	JButton btnNewButton_3 = new JButton("About"); //about button

	 */

    public void spinnerQuantityAddCL(ChangeListener cl)
    {
        spinner.addChangeListener(cl);
    }

    public int spinnerGetQuantity()
    {
        return (Integer) spinner.getValue();
    }

    public void spinnerTimeAddCL(ChangeListener cl) {
        spinner_1.addChangeListener(cl);
    }

    public int spinnerGetTime() {
        return (int) spinner_1.getValue();
    }

    public void labelCordUpdate(int x, int y) {
        lblNewLabel_2.setText("X:" + x + " Y:" + y);
    }

    public void buttonSaveXYAddAL(ActionListener al) {
        btnNewButton.addActionListener(al);
    }

    public void buttonSaveXYChangeText(String s) {
        btnNewButton.setText(s);
    }

    public void checkBoxShift1AddAL(ActionListener al) {
        chckbxNewCheckBox.addActionListener(al);
    }

    public boolean checkGetShift1() {
        return chckbxNewCheckBox.isSelected();
    }

    public void checkBoxCtrl1AddAL(ActionListener al) {
        chckbxNewCheckBox_1.addActionListener(al);
    }

    public boolean checkGetCtrl1() {
        return chckbxNewCheckBox_1.isSelected();
    }

    public void checkBoxAlt1AddAL(ActionListener al) {
        chckbxNewCheckBox_2.addActionListener(al);
    }

    public boolean checkGetAlt1() {
        return chckbxNewCheckBox_2.isSelected();
    }
    public String textGetKey1() {
        return formattedTextField.getText().toUpperCase();
    }

    public void textSetKey1(String s) {
        formattedTextField.setValue(s);
    }

    public void checkBoxShift2AddAL(ActionListener al) {
        chckbxNewCheckBox_3.addActionListener(al);
    }

    public boolean checkGetShift2() {
        return chckbxNewCheckBox_3.isSelected();
    }

    public void checkBoxCtrl2AddAL(ActionListener al) {
        chckbxNewCheckBox_1_1.addActionListener(al);
    }

    public boolean checkGetCtrl2() {
        return chckbxNewCheckBox_1_1.isSelected();
    }

    public void checkBoxAlt2AddAL(ActionListener al) {
        chckbxNewCheckBox_2_1.addActionListener(al);
    }

    public boolean checkGetAlt2() {
        return chckbxNewCheckBox_2_1.isSelected();
    }

    public void spinnerMacro1AddCL(ChangeListener cl) {
        spinner_2.addChangeListener(cl);
    }

    public int spinnerGetMacro1Time() {
        return (Integer) spinner_2.getValue();
    }

    public void buttonCraftAddAL(ActionListener al) {
        btnNewButton_1.addActionListener(al);
    }

    public String textGetKey2() {
        return formattedTextField2.getText().toUpperCase();
    }

    public void textSetKey2(String s) {
        formattedTextField2.setValue(s);
    }

    public void labelSetFinishTime(String s) {
        lblNewLabel_7.setText(s);
        UIUpdate();
    }

    public void buttonEmergencyExitAddAL(ActionListener al) {
        btnNewButton_2.addActionListener(al);
    }

    public void buttonAboutAddAL(ActionListener al) {
        btnNewButton_3.addActionListener(al);
    }

    public void buttonResetAddAL(ActionListener al) {
        btnNewButton_4.addActionListener(al);
    }

}
