package GUI;

import javax.swing.*;

import Cards.Card;
import GameplayRules.SuperTrumpFunction;
import Players.HumanHandler;
import Players.Player;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import static java.awt.Color.WHITE;

/*

Mineral SuperTrumps Card Game by 13422239 (CARMELJEEVA JOHNJEYASEELAN);

 */

public class GameFunction extends JFrame {
    //Hand
    private int handSize;
    private JPanel playerHand = new JPanel();
    private JScrollPane handScroll = new JScrollPane(playerHand);
    //Other
    private JPanel gamePanel = new JPanel();
    private JLabel cCard = new JLabel();
    private JLabel cPlayer = new JLabel();
    private JLabel cCat = new JLabel();
    private JPanel catSelection = new JPanel();
    private JLabel majorStatus = new JLabel();
    private JLabel gameStatus = new JLabel();
    private JLabel catPrompt = new JLabel("Please Choose a Category: ");
    private JButton cleavage = new JButton("Cleavage");
    private JButton hardness = new JButton("Hardness");
    private JButton specGravity = new JButton("Specific Gravity");
    private JButton crustAbund = new JButton("Crustal Abundance");
    private  JButton ecoValue = new JButton("Economic Value");
    private JPanel winnersDisplayed = new JPanel();
    private JLabel handTitle = new JLabel("Current Hand");
    private JLabel cardTitle = new JLabel("Current Card:");
    public static GameFunction gameFunction;

    public GameFunction(int numPlay){
        GameFunction.gameFunction = this;
        // SETTING FONTS
        Font fontCat = new Font(Font.SANS_SERIF, 3, 30);
        Font fontPlay = new Font(Font.SANS_SERIF, 2, 20);
        cPlayer.setFont(fontPlay);
        cPlayer.setForeground(WHITE);
        cCat.setFont(fontCat);
        cardTitle.setFont(fontPlay);
        cCat.setForeground(WHITE);
        gameStatus.setForeground(WHITE);
        majorStatus.setForeground(WHITE);
        handTitle.setForeground(WHITE);
        cardTitle.setForeground(WHITE);


        setContentPane(gamePanel);


        //STYLING
        Color bg = new Color(73,73,73);
        gamePanel.setBackground(bg);
        gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.Y_AXIS));
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        //ADDING ELEMENTS
        gamePanel.add(cPlayer);
        gamePanel.add(cCat);
        gamePanel.add(majorStatus);
        gamePanel.add(gameStatus);
        gameStatus.setAlignmentX(Component.CENTER_ALIGNMENT);
        majorStatus.setAlignmentX(Component.CENTER_ALIGNMENT);
        gamePanel.add(Box.createRigidArea(new Dimension(0,20)));
        gamePanel.add(cardTitle);
        cardTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        gamePanel.add(cCard);
        catSelection.setVisible(false);
        catSelection.setLayout(new BoxLayout(catSelection, BoxLayout.X_AXIS));
        gamePanel.add(catSelection);
        catSelection.add(catPrompt);
        catSelection.add(cleavage);
        catSelection.add(hardness);
        catSelection.add(specGravity);
        catSelection.add(crustAbund);
        catSelection.add(ecoValue);
        //gamePanel.add(playerHand);
        //playerHand.setVisible(true);

        //Players Hand Components
        gamePanel.add(Box.createRigidArea(new Dimension(0,40)));
        gamePanel.add(handTitle);
        handTitle.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        handTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        handTitle.setFont(fontPlay);
        gamePanel.add(handScroll);


        //Final Screen Components
        winnersDisplayed.setVisible(false);
        gamePanel.add(winnersDisplayed);

        //FINAL BULD and DISPLAY
        setVisible(true);
        pack();
        setSize(2300, 975);
        validate();



        //ACTION LISTERNERS for CATEGORY SELECTORS
        cleavage.addActionListener(e ->{
            HumanHandler.humanHandler.categoryNotifier("Cleavage");

        });
        hardness.addActionListener(e ->{
            HumanHandler.humanHandler.categoryNotifier("Hardness");

        });
        specGravity.addActionListener(e ->{
            HumanHandler.humanHandler.categoryNotifier("Specific gravity");

        });
        crustAbund.addActionListener(e ->{
            HumanHandler.humanHandler.categoryNotifier("Crustal abundance");

        });
        ecoValue.addActionListener(e ->{
            HumanHandler.humanHandler.categoryNotifier("Economic value");

        });

        //running in background
        new Thread(() -> {
            new SuperTrumpFunction(numPlay, this);
        }).start();

    }

    public void displayCard(String fileName){
        cCard.setIcon(new ImageIcon(new ImageIcon("images/" + fileName).getImage().getScaledInstance((int)Math.floor(300 * 0.714), 300,  java.awt.Image.SCALE_SMOOTH)));
        cCard.setVisible(true);
        cCard.setAlignmentX(Component.CENTER_ALIGNMENT);
        invalidate();
        repaint();
    }
    public void displayPlayer(String playerName){
        cPlayer.setText("Current Player: Player " + playerName);
        cPlayer.setAlignmentX(Component.CENTER_ALIGNMENT);
        invalidate();
        repaint();
    }
    public void displayCat(String categoryName){
        cCat.setText("Current Category: " + categoryName);
        cCat.setAlignmentX(Component.CENTER_ALIGNMENT);
        invalidate();
        repaint();

    }
    public void displayCatChoice(){
        cardTitle.setVisible(false);
        handTitle.setVisible(false);
        catSelection.setVisible(true);
        gamePanel.setVisible(true);
    }
    public void hideCatChoice(){
        catSelection.setVisible(false);
        cardTitle.setVisible(true);
        handTitle.setVisible(true);
        invalidate();
        repaint();
    }
    public  void changeStatus(String status){
        gameStatus.setText(status);
        invalidate();
        repaint();
    }

    public void clearStatus(){
        gameStatus.setText("");
    }
    public  void changeMajorStatus(String status){
        gameStatus.setText(status);
        invalidate();
        repaint();
    }

    public void clearMajorStatus(){
        gameStatus.setText("");
    }

    public void handGUIGenerator(ArrayList<Card> hand){
        playerHand.removeAll();
        handSize = hand.size();
        for (int i=0; i < handSize ;i++) {
            JButton card = new JButton();
            card.setIcon(new ImageIcon(new ImageIcon("images/" + hand.get(i).fileName).getImage().getScaledInstance((int)Math.floor(250 * 0.714), 350,  java.awt.Image.SCALE_SMOOTH)));
            // playerHand.add(new JButton());
            playerHand.add(card);
            int finalI1 = i;
            card.addActionListener(e ->{
                System.out.println(finalI1);
                HumanHandler.humanHandler.cardNotifier(finalI1);
                playerHand.remove(card);
            });

            //Hover Effect
            card.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    card.setIcon(new ImageIcon(new ImageIcon("images/" + hand.get(finalI1).fileName).getImage().getScaledInstance((int)Math.floor(250 * 0.714), 350,  java.awt.Image.SCALE_SMOOTH)));
                }
            });
            card.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    card.setIcon(new ImageIcon(new ImageIcon("images/" + hand.get(finalI1).fileName).getImage().getScaledInstance((int)Math.floor(250 * 0.714), 350,  java.awt.Image.SCALE_SMOOTH)));

                }
            });
        }
        JButton skip = new JButton();
        skip.setIcon(new ImageIcon(new ImageIcon("images/Slide66.jpg").getImage().getScaledInstance((int)Math.floor(250 * 0.714), 350,  java.awt.Image.SCALE_SMOOTH)));
        playerHand.add(skip);
        skip.addActionListener(e -> {
            HumanHandler.humanHandler.cardNotifier(handSize);
            playerHand.removeAll();
        });

        if (hand.size() == 0){
            handTitle.setText("You Have No Cards Left, The others will continue to determine the other places");
            skip.setEnabled(false);
        }
        // Hover Effect
        skip.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                skip.setIcon(new ImageIcon(new ImageIcon("images/Slide66.jpg").getImage().getScaledInstance((int)Math.floor(250 * 0.714), 350,  java.awt.Image.SCALE_SMOOTH)));            }
        });
        skip.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                skip.setIcon(new ImageIcon(new ImageIcon("images/Slide66.jpg").getImage().getScaledInstance((int)Math.floor(250 * 0.714), 350,  java.awt.Image.SCALE_SMOOTH)));
            }
        });
        playerHand.setVisible(true);
        invalidate();
        repaint();
        validate();
    }

    // Handlers for the Ending of a Game
    public void buildWinners(ArrayList<Player> winnerList){
        for (int i=0; i < winnerList.size(); i++){
            int place = i +1;
            JLabel winner = new JLabel("            " + place +"st Place is Player: " + winnerList.get(i).position);
            winnersDisplayed.add(winner);
        }
        winnersDisplayed.setSize(1500, 500);
        winnersDisplayed.setVisible(true);
        invalidate();
        repaint();
        validate();

    }
    public void gameClear(){
        gamePanel.setVisible(false);
    }

}
