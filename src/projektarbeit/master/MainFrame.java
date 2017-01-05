package projektarbeit.master;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javafx.concurrent.Worker;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;


public class MainFrame extends JFrame
{
    
    //private Worker worker = new Worker();
    private final JLabel cityHeader = new JLabel();
    private JComboBox chooseCity = new JComboBox();
    private final JLabel stationHeader = new JLabel();
    private JComboBox chooseStation = new JComboBox();
    private final JLabel dateHeader = new JLabel();
    private JComboBox chooseDate = new JComboBox();
    
    //private JToggleButton toggleButton = new JToggleButton("Drück mich", true);
    
    
    String checkBoxStation = "Alle";
    
    
    public MainFrame()
    {
        JFrame f = new JFrame("Projektarbeit");
        
        //Festlegen der Frame-Layouts
        BorderLayout topBorder = new BorderLayout(5,5);
        BorderLayout westBorder = new BorderLayout(5,5);
        BorderLayout eastBorder = new BorderLayout (5,5);
        
        javax.swing.border.Border blackline = BorderFactory.createLineBorder(Color.black);
        
        JPanel top = new JPanel(topBorder);
        JPanel subEast  = new JPanel(eastBorder);
        JPanel subWest = new JPanel(westBorder);
        JPanel innerWNorth = new JPanel();
        JPanel innerWSouth = new JPanel();
        JPanel innerENorth = new JPanel();
        JPanel innerESouth = new JPanel();
        
        //Erzeugung des Time-Chart
        
        LineChartSample linechart = new LineChartSample();
        
        
        //Hier Texte der Header setzten
        cityHeader.setText("Auswahl der Stadt");
        stationHeader.setText("Auswahl der Haltestelle");
        dateHeader.setText("Auswahl des zu überprüfenden Tages");
        chooseCity.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Frankfurt" }));
        chooseCity.setEnabled(false);
        chooseStation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "STATIONEN EINSETZEN" }));
        chooseStation.setEnabled(true);
        chooseDate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DATUM" }));
        chooseDate.setEnabled(false);
    
        
        
        //Action-Listener einfügen
            chooseStation.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed( ActionEvent e ) 
                {
                    int a=1+2;
                    //checkBoxStation = (String) //Stadt auswählen
                    // Chart mit Daten der entsprechenden Station updaten
                }
            });
            
            
            
            
         
                    
                
        top.add(subEast, BorderLayout.EAST);
        top.add(subWest, BorderLayout.WEST);
        
        f.add(top);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setSize(new Dimension(1100, 680));
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        //f.setIconImage(img.getImage());
        f.setVisible(true);
        
    }



public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                new MainFrame();
            }
        });
    }
    
    
    
}
