package RATES;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;



public class ContentPanel extends JPanel implements ActionListener {

    String iconPath;
    JLabel contentIcon;

    JButton openButton;
    JButton submitEvalButton;

    SubjectPanel parent;
    String contentName;
    String link;

    ContentPanel(String contentName, String type, String date, String link, SubjectPanel theParent){
        this.contentName = contentName;
        this.link = link;
        parent = theParent;
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        setBorder(BorderFactory.createLineBorder(Color.black,2));
        setPreferredSize(new Dimension(630,80));

        contentIcon = new JLabel("");
        contentIcon.setBorder(new EmptyBorder(0,20,0,20));
        contentIcon.setPreferredSize(new Dimension(35,35));

        if(type.equals("Video")){
            iconPath = "Images/ContentIcons/videoIcon.png";
        }
        if(type.equals("Document")){
            iconPath = "Images/ContentIcons/docIcon.png";
        }
        if(type.equals("Activity")){
            iconPath = "Images/ContentIcons/activityIcon.png";
        }

        BufferedImage img;
        if(!iconPath.equals("")){
            try {
                img = ImageIO.read(new File(iconPath));
                Image dimg = img.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
                ImageIcon profileImage = new ImageIcon(dimg);
                contentIcon.setIcon(profileImage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        add(contentIcon);

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,7));
        titlePanel.setPreferredSize(new Dimension(140,60));
        titlePanel.setMaximumSize(new Dimension(140,60));
        titlePanel.setMinimumSize(new Dimension(140,60));
        add(titlePanel);

        JLabel contentLabel = new JLabel(contentName);
        contentLabel.setFont(new Font(contentLabel.getFont().getFontName(), Font.BOLD, 18));
        contentLabel.setBorder(new EmptyBorder(0,0,0,0));
        titlePanel.add(contentLabel);

        JLabel dateLabel = new JLabel(date);
        dateLabel.setFont(new Font(contentLabel.getFont().getFontName(), Font.PLAIN, 11));
        dateLabel.setBorder(new EmptyBorder(0,0,0,0));
        titlePanel.add(dateLabel);

        JPanel sepPanel = new JPanel();
        sepPanel.setPreferredSize(new Dimension(1,50));
        sepPanel.setMaximumSize(new Dimension(1,50));
        sepPanel.setMinimumSize(new Dimension(1,50));
        sepPanel.setBackground(Color.BLACK);
        sepPanel.setBorder(new EmptyBorder(0,20,0,0));
        add(sepPanel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,0));
        buttonPanel.setPreferredSize(new Dimension(400,26));
        buttonPanel.setMaximumSize(new Dimension(400,26));
        buttonPanel.setMinimumSize(new Dimension(400,26));
        add(buttonPanel);

        openButton = new JButton("Open Content");
        openButton.setFocusPainted(false);
        openButton.setBackground(Color.WHITE);
        openButton.addActionListener(this);
        buttonPanel.add(openButton);

        submitEvalButton = new JButton("Submit Evaluation");
        submitEvalButton.setBackground(Color.WHITE);
        submitEvalButton.addActionListener(this);
        buttonPanel.add(submitEvalButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton source = (JButton) e.getSource();

        if(source.equals(openButton)){
            try{
                Desktop.getDesktop().open(new File(link));
                System.out.println("yes");
            }
            catch(Exception ex){
                System.out.println("nope");
            }
        }
        if(source.equals(submitEvalButton)){
            parent.changeComboBox(contentName);
        }

    }
}