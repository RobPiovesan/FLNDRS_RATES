package RATES;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainPanel extends JPanel implements ActionListener{

    JTabbedPane tabbedPane;
    SubjectPanel[] subjectPanels = new SubjectPanel[4];
    JLabel[] tabLabels = new JLabel[4];

    String[] subjectCodes = {"COMP3750", "COMP3771", "COMS1001", "ENGR2881"};
    String[] subjectNames = {"Interactive Computer Systems", "Advanced Database", "Academic Writing", "Computer Networks"};

    Color tabbedPaneBG = new Color(219, 219, 219);

    MainPanel(LoginPanel parentPanel){

        UIManager.put("TabbedPane.selected", Color.white);
        UIManager.put("TabbedPane.contentBorderInsets", new Insets(0, 0, 0, 0));

        setLayout(new BorderLayout());
        setBackground(Color.white);
        tabbedPane = new JTabbedPane();
        tabbedPane.setFocusable(false);

        tabbedPane.addTab("",new HomePanel(parentPanel));
        ImageIcon homeIcon = new ImageIcon("Images/homeIcon.png");

        JLabel homeLabel = new JLabel("",JLabel.CENTER);
        homeLabel.setIcon(homeIcon);
        homeLabel.setPreferredSize(new Dimension(30,30));

        tabbedPane.setTabComponentAt(0,homeLabel);
        tabbedPane.setBackground(tabbedPaneBG);

        for(int i = 0; i < subjectPanels.length; i++){
            subjectPanels[i] = new SubjectPanel(subjectCodes[i], subjectNames[i], i);
            tabbedPane.addTab("", subjectPanels[i]);
            tabbedPane.setBackground(tabbedPaneBG);
            tabbedPane.setForeground(Color.white);

            tabLabels[i] = new JLabel("<html><div style=\"font-size:8px\"'>"+subjectCodes[i]+"</div><div style=\"font-size:12px\">"+subjectNames[i]+"</div</html>");
            tabLabels[i].setPreferredSize(new Dimension(250, 50));
            tabbedPane.setTabComponentAt(i+1, tabLabels[i]);  // tab index, jLabel
        }

        add(tabbedPane);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
