package RATES;

import org.json.JSONObject;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;


public class EvaluationPanel extends JPanel implements ActionListener {


    String userContent;
    String profilePhotoPath;
    JSONObject userData;
    JLabel userIcon;
    String theAttachmentPath;
    String submittedBy;


    EvaluationPanel(String TopicCode, String theUser, String subjectName, String theBodyString, String theRating, String theDateTime, String theEvalOption, boolean anon, String attachmentPath, HistoryPanel parent) {

        theAttachmentPath = attachmentPath;

        setLayout(new FlowLayout(FlowLayout.CENTER,0,8));
        setBorder(BorderFactory.createLineBorder(Color.black,2));
        setPreferredSize(new Dimension(700,220));

        JSplitPane evalSP = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        evalSP.setDividerSize(1);
        evalSP.setBorder(null);
        evalSP.setPreferredSize(new Dimension(670,200));
        add(evalSP);


        //LEFT EVALUATION
        JPanel evalLeft = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
        evalLeft.setPreferredSize(new Dimension(150,200));
        evalLeft.setMaximumSize(new Dimension(150,200));
        evalLeft.setMinimumSize(new Dimension(150,200));
        evalSP.add(evalLeft, JSplitPane.LEFT);


        submittedBy = anon ? "Anonymous" : theUser;
        JLabel submittedByLabel = new JLabel(submittedBy);
        evalLeft.add(submittedByLabel);

        JSeparator sep = new JSeparator(SwingConstants.HORIZONTAL);
        sep.setPreferredSize(new Dimension(130,1));
        sep.setForeground(Color.black);
        evalLeft.add(sep);

        userIcon = new JLabel("");
        userIcon.setPreferredSize(new Dimension(65,65));


        //User Image
        profilePhotoPath = "Images/ProfileImages/default.png";
        String userJsonPath = "JSON/user.json";
        try {
            userContent = new String((Files.readAllBytes(Paths.get(userJsonPath))));
            userData = new JSONObject(userContent);
            if(anon){
                profilePhotoPath = "Images/ProfileImages/default.png";
            }
            else{
                profilePhotoPath = userData.getJSONObject("userDetails").get("profileImagePath").toString();
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(profilePhotoPath));
            Image dimg = img.getScaledInstance(55, 55, Image.SCALE_SMOOTH);
            ImageIcon profileImage = new ImageIcon(dimg);
            userIcon.setIcon(profileImage);
        } catch (Exception e) {
            e.printStackTrace();
        }

        userIcon.setPreferredSize(new Dimension(55,55));
        evalLeft.add(userIcon);

        JLabel dateLabel = new JLabel(theDateTime);
        dateLabel.setFont(new Font(dateLabel.getFont().getFontName(), Font.PLAIN, 10));
        evalLeft.add(dateLabel);

        JLabel ratingLabel = new JLabel(theRating);
        switch(theRating){
            case "Positive":
                ratingLabel.setForeground(new Color(65, 150, 0));
                break;
            case "Neutral":
                ratingLabel.setForeground(new Color(199, 119, 0));
                break;
            case "Negative":
                ratingLabel.setForeground(Color.RED);
                break;
        }
        ratingLabel.setFont(new Font(dateLabel.getFont().getFontName(), Font.PLAIN, 15));
        evalLeft.add(ratingLabel);

        if(!theAttachmentPath.equals("")){
            JButton openAttachment = new JButton("Open Attachment");
            openAttachment.setBackground(Color.white);
            openAttachment.addActionListener(this);
            evalLeft.add(openAttachment);

            JLabel attachmentLabel = new JLabel(theAttachmentPath.substring(theAttachmentPath.lastIndexOf('/')+1));
            evalLeft.add(attachmentLabel);
        }


        //RIGHT EVALUATION
        JPanel evalRight = new JPanel(new FlowLayout(FlowLayout.LEFT,30,15));
        evalRight.setPreferredSize(new Dimension(520,200));
        evalRight.setMaximumSize(new Dimension(520,200));
        evalRight.setMinimumSize(new Dimension(520,200));
        evalSP.add(evalRight, JSplitPane.RIGHT);

        JLabel evalTitle = new JLabel(subjectName+" - "+theEvalOption);
        evalTitle.setFont(new Font(dateLabel.getFont().getFontName(), Font.PLAIN, 18));
        evalRight.add(evalTitle);

        JTextArea evaluationBodyText = new JTextArea();
        evaluationBodyText.setLineWrap(true);
        evaluationBodyText.setWrapStyleWord(true);
        evaluationBodyText.setEditable(false);
        evaluationBodyText.setMargin(new Insets(4,4,4,4));
        evaluationBodyText.setPreferredSize(new Dimension(450,120));
        evaluationBodyText.setText(theBodyString);
        evalRight.add(evaluationBodyText);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            Desktop.getDesktop().open(new File(theAttachmentPath));
        }
        catch(Exception ex){
            System.out.println(ex.toString());
        }

    }
}