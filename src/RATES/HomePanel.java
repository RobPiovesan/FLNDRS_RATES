package RATES;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;


public class HomePanel extends JPanel implements ActionListener {

    JLabel ratesLogo;
    JLabel ratesSubtitle;

    JPanel cards;
    JPanel homeCard;
    JPanel profileCard;
    JPanel historyCard;

    JButton profileButton;
    JButton historyButton;
    JButton logoutButton;


    HistoryPanel historyPanel;
    String profileIconPath;
    LoginPanel loginPanel;

    HomePanel(LoginPanel parentPanel){
        loginPanel = parentPanel;
        cards = new JPanel(new CardLayout());

        add(cards);

        homeCard = new JPanel();
        profileCard = new JPanel();
        historyCard = new JPanel();
        cards.add(homeCard, "Home");
        cards.add(profileCard, "Profile");
        cards.add(historyCard, "History");

        //###############################################
        //------------------homeCard---------------------
        //###############################################
        cards.setBackground(Color.white);
        homeCard.setBackground(Color.white);
        setBackground(Color.white);
        JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        sp.setPreferredSize(new Dimension(1200,550));
        sp.setBorder(null);
        sp.setEnabled(false);
        sp.setDividerSize(0);
        sp.setBackground(Color.white);
        homeCard.add(sp);

        //TOP SPLIT PANE
        JSplitPane topSp = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        topSp.setPreferredSize(new Dimension(1200,250));
        topSp.setEnabled(false);
        topSp.setBorder(null);
        topSp.setDividerSize(0);
        topSp.setBackground(Color.white);
        homeCard.add(topSp);

        //LOGO section
        JPanel homeLogos = new JPanel(new FlowLayout(FlowLayout.CENTER,0,90));
        homeLogos.setBackground(Color.white);
        homeLogos.setPreferredSize(new Dimension(1200, 250));

        JPanel logoInner = new JPanel();
        logoInner.setBackground(Color.white);
        logoInner.setPreferredSize(new Dimension(1100, 240));

        ratesLogo = new JLabel("RATES");
        ratesLogo.setFont(new Font(ratesLogo.getFont().getFontName(), Font.BOLD, 80));
        ratesLogo.setBorder(new EmptyBorder(0,400,5,400));
        logoInner.add(ratesLogo);

        ratesSubtitle = new JLabel("Real-time Activity and Teaching Evaluation System");
        ratesSubtitle.setFont(new Font(ratesLogo.getFont().getFontName(), Font.ITALIC, 22));
        logoInner.add(ratesSubtitle);

        homeLogos.add(logoInner);

        topSp.add(homeLogos,JSplitPane.BOTTOM);

        sp.add(topSp);

        //BOTTOM HALF
        JPanel homeBottom = new JPanel(new FlowLayout(FlowLayout.CENTER,100,0));
        homeBottom.setBackground(Color.white);
        homeBottom.setPreferredSize(new Dimension(1200, 250));
        sp.add(homeBottom,JSplitPane.BOTTOM);


        //Profile Button
        profileIconPath = "Images/ButtonIcons/ProfileButtonIcon.png";
        profileButton = new JButton();
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(profileIconPath));
            Image dimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon profileImage = new ImageIcon(dimg);
            profileButton.setIcon(profileImage);
            profileButton.setBackground(null);
            profileButton.setBorder(null);
        } catch (Exception e) {
            e.printStackTrace();
            profileButton.setText("Profile");
        }
        profileButton.setFocusPainted(false);
        profileButton.addActionListener(this);

        String historyIconPath = "Images/ButtonIcons/HistoryButtonIcon.png";
        historyButton = new JButton();
        BufferedImage img2 = null;
        try {
            img2 = ImageIO.read(new File(historyIconPath));
            Image dimg = img2.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
            ImageIcon profileImage = new ImageIcon(dimg);
            historyButton.setIcon(profileImage);
            historyButton.setBackground(null);
            historyButton.setBorder(null);
        } catch (Exception e) {
            e.printStackTrace();
            historyButton.setText("History");
        }
        historyButton.addActionListener(this);


        String logoutIconPath = "Images/ButtonIcons/LogoutButtonIcon.png";
        logoutButton = new JButton();
        BufferedImage img3 = null;
        try {
            img3 = ImageIO.read(new File(logoutIconPath));
            Image dimg = img3.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
            ImageIcon profileImage = new ImageIcon(dimg);
            logoutButton.setIcon(profileImage);
            logoutButton.setBackground(null);
            logoutButton.setBorder(null);
        } catch (Exception e) {
            e.printStackTrace();
            logoutButton.setText("Logout");
        }
        logoutButton.addActionListener(this);


        homeBottom.add(profileButton);
        homeBottom.add(historyButton);
        homeBottom.add(logoutButton);


        //###############################################
        //-----------------profileCard-------------------
        //###############################################
        ProfilePanel profilePanel = new ProfilePanel(cards);
        profileCard.add(profilePanel);
        profileCard.setBackground(Color.white);

        //###############################################
        //-----------------profileCard-------------------
        //###############################################
        historyPanel = new HistoryPanel(cards);
        historyCard.add(historyPanel);
        historyCard.setBackground(Color.white);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();

        if(source.equals(profileButton)){
            CardLayout cl = (CardLayout)(cards.getLayout());
            cl.show(cards, "Profile");
        }
        if(source.equals(historyButton)){
            historyPanel.loadBody();
            CardLayout cl = (CardLayout)(cards.getLayout());
            cl.show(cards, "History");
        }
        if(source.equals(logoutButton)){
            loginPanel.logout();

        }

    }
}
