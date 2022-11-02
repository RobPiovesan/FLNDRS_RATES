package RATES;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginPanel extends JPanel implements ActionListener{

    JPanel cards;
    JPanel loginCard;
    JPanel mainCard;

    JButton loginButton;
    LoginPanel(){
        setBackground(Color.white);
        cards = new JPanel(new CardLayout());
        cards.setBackground(Color.white);
        cards.setMaximumSize(new Dimension(1200,650));
        add(cards);

        loginCard = new JPanel();
        loginCard.setLayout(new GridLayout(2,1));
        loginCard.setBackground(Color.white);
        loginCard.setMaximumSize(new Dimension(1200,650));

        mainCard = new JPanel();
        mainCard.setBackground(Color.white);
        cards.add(loginCard, "Login");
        cards.add(mainCard, "mainCard");


        JPanel homeLogos = new JPanel(new FlowLayout(FlowLayout.CENTER,0,110));
        homeLogos.setBackground(Color.white);
        homeLogos.setPreferredSize(new Dimension(1200, 200));

        JPanel logoInner = new JPanel();
        logoInner.setBackground(Color.white);
        logoInner.setPreferredSize(new Dimension(1200, 200));

        JLabel ratesLogo = new JLabel("RATES");
        ratesLogo.setFont(new Font(ratesLogo.getFont().getFontName(), Font.BOLD, 80));
        ratesLogo.setBorder(new EmptyBorder(0,400,5,400));
        logoInner.add(ratesLogo);

        JLabel ratesSubtitle = new JLabel("Real-time Activity and Teaching Evaluation System");
        ratesSubtitle.setFont(new Font(ratesLogo.getFont().getFontName(), Font.ITALIC, 22));
        logoInner.add(ratesSubtitle);


        homeLogos.add(logoInner);
        loginCard.add(homeLogos);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setPreferredSize(new Dimension(1200,240));
        bottomPanel.setBackground(Color.white);

        JPanel loginPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        loginPanel.setPreferredSize(new Dimension(170,180));
        loginPanel.setBackground(Color.white);


        JLabel usernameLabel = new JLabel("Username");
        loginPanel.add(usernameLabel);
        JTextField userName = new JTextField();
        userName.setColumns(15);
        loginPanel.add(userName);

        JLabel passwordLabel = new JLabel("Password");
        loginPanel.add(passwordLabel);
        JPasswordField password = new JPasswordField();
        password.setColumns(15);
        loginPanel.add(password);

        bottomPanel.add(loginPanel);


        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        loginPanel.add(loginButton);
        bottomPanel.add(loginPanel);
        loginCard.add(bottomPanel);


        mainCard.add(new MainPanel(this));
    }

    public void logout(){
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, "Login");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if(source.equals(loginButton)){
            CardLayout cl = (CardLayout)(cards.getLayout());
            cl.show(cards, "mainCard");
        }
    }
}