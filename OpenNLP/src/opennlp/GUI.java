
package opennlp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class GUI extends JFrame{
    //declaring all components(labels,textfields,buttons,tables etc)
    private final JLabel[] labels;
    private final JTextField[] textBoxes;
    private final JButton[] buttons;
    private  JTable table;
    private final JComboBox[] comboBoxes; 
    private final JRadioButton[] radioButtons;
    
    //constructor
    public GUI( int textboxsize,int tblsize,int combobox,ArrayList<String> lblNames,ArrayList<String> btnNames, ArrayList<String> radiobtnNames ) {
        //title of frame
        super("NLP based GUI");
        //name of table's columns
        String[] columns={"Title1","Title2","Title3","Title4"};
        //data for table,which will remain empty
        String[][] data={};
        //default java look and feel
        try {
            //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.setLookAndFeel(NimbusLookAndFeel.class.getName());
        } catch (Exception ex)
        {
            System.out.println(ex);
        }
        //size of frame,layout and visibilty
        setSize(600, 480);
        setVisible(true);
        setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        //center location
        setLocationRelativeTo(null);
        //alwasy on top
        //setAlwaysOnTop(true);
        //initlizing lables and textboxes
        labels = new JLabel[lblNames.size()];
        textBoxes = new JTextField[textboxsize];
        //loop for generating lables and textbxes according to the requiremnet
        for (int i = 0; i < labels.length; i++) {
                //getting lable name and converting into upper case
                labels[i] = new JLabel(lblNames.get(i).toUpperCase());
                //setting foreground color of label
                Color clr=new Color (0,96,100);
                labels[i].setForeground(clr);
                //setting size of textbox(10)
                textBoxes[i] = new JTextField(10);
                //adding to frame
                add(labels[i]);
                add(textBoxes[i]);               
        }
        //initlizing buttons
        buttons = new JButton[btnNames.size()];
        //loop for generating buttons according to the requirement
        for (int i = 0; i < buttons.length; i++) {
                //getting button name and converting into upper case
                buttons[i] = new JButton(btnNames.get(i).toUpperCase());
                //setting foreground color of button
                buttons[i].setForeground(Color.WHITE);
                //setting background color of button
                Color clr=new Color (30,136,229);
                buttons[i].setBackground(clr);
                //setting font 
                buttons[i].setFont(new Font("Times New Roman", Font.BOLD, 14));
                //adding to frame
                add(buttons[i]);
        }
        //if tabel size(there is a array for table) is not null
        if(tblsize!=0){
        //setting columns and data to tabel
        table=new JTable(data,columns);
        //dimension according to frame
        table.setPreferredScrollableViewportSize(new Dimension(570,100));
        //enable better view of table
        table.setFillsViewportHeight(true);
        //scrollable table 
        JScrollPane jsp=new JScrollPane(table);
        //border with title
        jsp.setBorder(BorderFactory.createTitledBorder ("Table"));
        //adding to frame
        add(jsp);
        }
        //initlizing buttons
        radioButtons=new JRadioButton[radiobtnNames.size()];
        //loop for generating radio buttons according to the requirement
        for (int i = 0; i <radioButtons.length; i++) {
             //getting button name and converting into upper case
            radioButtons[i]=new JRadioButton(radiobtnNames.get(i).toUpperCase());
            //adding to frame
            add(radioButtons[i]);

        }
        //initlizing comboBoxes
        comboBoxes=new JComboBox[combobox];
        //loop for generating comboBoxes according to the requirement
        for (int i = 0; i < comboBoxes.length; i++) {
            //generating combo boxes
            comboBoxes[i]=new JComboBox();
            //size (height,width)
            comboBoxes[i].setPreferredSize(new Dimension(200,50));
            //adding to frame
            add(comboBoxes[i]);
        }
    }
}
