package main;

import domain.Band;
import domain.BandTrait;
import domain.Musician;
import domain.MusicianTrait;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import java.util.regex.Pattern;

public class RockBandManager {
    static Map<String, MusicianTrait> musicianTraits = new HashMap<>();
    static Map<String, BandTrait> bandTraits = new HashMap<>();
    static List<Musician> theScene =  new ArrayList<>();
    static String speedState; //SLOW, NORMAL, FAST
    static String gameState; //START, RECORD, TOUR, RESULT, HIREANDFIRE, END
    static Random ran = new Random();
    static Band playerBand;

    public static void main(String[] args) {
        //initial data and state setup
        playerBand = initPlayerBand();
        initMusicianTraits();
        initBandTraits();
        initScene();
        speedState = "NORMAL";
        gameState = "START";

        //full panel
        JPanel mainPanel = new JPanel(new GridLayout(2,3));

        //band info panel
        JPanel bandPanel = new JPanel(new GridLayout(7,1));
        JLabel nameLabel = new JLabel(playerBand.getName());
        JLabel talentLabel = new JLabel("Talent: " + playerBand.getTalent());
        JLabel creativityLabel = new JLabel("Creativity: " + playerBand.getCreativity());
        JLabel incomeLabel = new JLabel("Income: " + playerBand.getIncome());
        JLabel currentMoneyLabel = new JLabel("Money: " + playerBand.getCurrentMoney());
        JLabel traitLabel = new JLabel("Traits: " + playerBand.getTrait1() + ", " + playerBand.getTrait2());
        JLabel fansLabel = new JLabel("Fans: " + playerBand.getFans());
        bandPanel.add(nameLabel);
        bandPanel.add(talentLabel);
        bandPanel.add(creativityLabel);
        bandPanel.add(incomeLabel);
        bandPanel.add(currentMoneyLabel);
        bandPanel.add(traitLabel);
        bandPanel.add(fansLabel);
        bandPanel.setSize(300, 200);
        bandPanel.setVisible(true);

        //member panel
        JPanel memberPanel = new JPanel(new GridLayout(3,1));
        JLabel memberLabel = new JLabel("Members");
        memberPanel.add(memberLabel);
        List<String> memberSummaries = getMusicianSummariesList(playerBand.getMembers());
        final JList<String> memberList = new JList<String>(memberSummaries.toArray(new String[0]));
        JScrollPane memberScrollPane = new JScrollPane();
        memberScrollPane.setViewportView(memberList);
        memberList.setLayoutOrientation(JList.VERTICAL);
        memberPanel.add(memberScrollPane);
        JButton btn = new JButton("Remove from band");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hirePlayerMusicianByName(memberList.getSelectedValue());
                List<String> memberSummariesUpdate = getMusicianSummariesList(playerBand.getMembers());
                memberList.setListData(memberSummariesUpdate.toArray(new String[0]));
                memberList.revalidate();
                memberList.repaint();
            }
        });
        btn.setEnabled(false);
        memberPanel.add(btn);
        memberPanel.setSize(300, 200);
        memberPanel.setVisible(true);

        //tour panel
        JPanel tourPanel = new JPanel();
        tourPanel.setSize(200, 200);
        JLabel tourLabel = new JLabel("Tour");
        tourPanel.add(tourLabel, BorderLayout.NORTH);

        //album panel
        JPanel albumPanel = new JPanel();
        albumPanel.setSize(200, 200);
        JLabel albumLabel = new JLabel("Album");
        albumPanel.add(albumLabel, BorderLayout.NORTH);

        //scene panel
        JPanel scenePanel = new JPanel(new GridLayout(3,1));
        JLabel sceneLabel = new JLabel("The Scene");
        scenePanel.add(sceneLabel);
        List<String> sceneSummaries = getMusicianSummariesList(theScene);
        final JList<String> sceneList = new JList<String>(sceneSummaries.toArray(new String[0]));
        JScrollPane sceneScrollPane = new JScrollPane();
        sceneScrollPane.setViewportView(sceneList);
        sceneList.setLayoutOrientation(JList.VERTICAL);
        scenePanel.add(sceneScrollPane);
        JButton addBtn = new JButton("Add to band");
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hirePlayerMusicianByName(sceneList.getSelectedValue());
                List<String> sceneSummariesUpdate = getMusicianSummariesList(theScene);
                sceneList.setListData(sceneSummariesUpdate.toArray(new String[0]));
                sceneList.revalidate();
                sceneList.repaint();

                List<String> memberSummariesUpdate = getMusicianSummariesList(playerBand.getMembers());
                memberList.setListData(memberSummariesUpdate.toArray(new String[0]));
                memberList.revalidate();
                memberList.repaint();

                playerBand.setTalent(playerBand.calculateAverageTalent());
                playerBand.setCreativity(playerBand.calculateAverageCreativity());
                talentLabel.setText("Talent: " + playerBand.getTalent());
                talentLabel.repaint();
                creativityLabel.setText("Creativity: " + playerBand.getCreativity());
                creativityLabel.repaint();
                bandPanel.revalidate();
                bandPanel.repaint();
            }
        });
        scenePanel.add(addBtn);

        //extra panel
        JPanel extraPanel = new JPanel();
        extraPanel.setSize(300, 200);
        JLabel extraLabel = new JLabel("Extra");
        extraPanel.add(extraLabel, BorderLayout.NORTH);

        //all together
        JFrame mainFrame = new JFrame("Rock Band Manager");
        mainPanel.add(bandPanel);
        mainPanel.add(tourPanel);
        mainPanel.add(scenePanel);
        mainPanel.add(memberPanel);
        mainPanel.add(albumPanel);
        mainFrame.add(mainPanel);
        mainFrame.setSize(1000, 400);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.pack();
        mainFrame.setVisible(true);

        while(true) {
            if (gameState.equals("START")) {

            } else if (gameState.equals("RECORD")) {

            } else if (gameState.equals("TOUR")) {

            } else if (gameState.equals("RESULT")) {

            } else if (gameState.equals("HIREANDFIRE")) {

            } else if (gameState.equals("END")) {

            }

            try {
                Thread.sleep(5000);
            } catch (Throwable t) {
                //nothing
            }
        }
    }

    private static Band initPlayerBand() {
        return new Band("The Band");
    }

    private static void initMusicianTraits() {
        musicianTraits.put("Indie", new MusicianTrait("Indie"));
        musicianTraits.put("Long-Winded", new MusicianTrait("Long-Winded"));
        musicianTraits.put("Pop", new MusicianTrait("Pop"));
        musicianTraits.put("Punk", new MusicianTrait("Punk"));
        musicianTraits.put("Shredder", new MusicianTrait("Shredder"));
        musicianTraits.put("Songwriter", new MusicianTrait("Songwriter"));
    }

    private static void initBandTraits() {
        bandTraits.put("Indie Band", new BandTrait("Indie Band", 0.0, 0.25));
        bandTraits.put("Jam Band", new BandTrait("Jam Band", 0.50, 0.0));
        bandTraits.put("Top 40 Band", new BandTrait("Top 40 Band", 0.25, 0.0));
        bandTraits.put("Punk Band", new BandTrait("Punk Band", 0.0, 0.25));
        bandTraits.put("Metal Band", new BandTrait("Metal Band", 0.25, 0.0));
        bandTraits.put("Prolific", new BandTrait("Prolific", 0.0, 0.50));
    }

    private static void initScene() {
        //S tier, 14 pts max, 8-10 salary, 25% chance 0 traits, 75% chance 1 trait, if trait 1 not empty 25% chance of 2nd trait
        Musician smus1 = new Musician("Johnny Paige", "Guitar", 7, 5, 10, null ,null);
        setTraitsSTier(smus1, musicianTraits.get("Shredder"), musicianTraits.get("Long-Winded"));
        theScene.add(smus1);

        Musician smus2 = new Musician("Jim Pat Jone", "Bass", 7, 5, 10, null ,null);
        setTraitsSTier(smus2, musicianTraits.get("Songwriter"), musicianTraits.get("Long-Winded"));
        theScene.add(smus2);

        Musician smus3 = new Musician("Roberto Plane", "Vocals", 7, 5, 10, null ,null);
        setTraitsSTier(smus3, musicianTraits.get("Songwriter"), musicianTraits.get("Long-Winded"));
        theScene.add(smus3);

        Musician smus4 = new Musician("Jorge Bondham", "Drums", 7, 5, 10, null ,null);
        setTraitsSTier(smus4, musicianTraits.get("Shredder"), musicianTraits.get("Long-Winded"));
        theScene.add(smus4);

        //A tier, 12 pts max, 6-8 salary, 25% chance of 1 trait
        Musician amus1 = new Musician("Dave Mac", "Guitar", 6, 4, 6, null ,null);
        setTraitsATier(amus1, musicianTraits.get("Shredder"));
        theScene.add(amus1);

        Musician amus2 = new Musician("Gabe Shogun", "Drums", 6, 4, 6, null ,null);
        setTraitsATier(amus2, musicianTraits.get("Songwriter"));
        theScene.add(amus2);

        //B tier, 10 pts max, 4-6 salary, 10% chance of 1 trait
        Musician bmus1 = new Musician("Alex Bea", "Bass", 5, 3, 4, null ,null);
        setTraitsBTier(bmus1, musicianTraits.get("Songwriter"));
        theScene.add(bmus1);

        Musician bmus2 = new Musician("Jerry Gordita", "Guitar", 5, 3, 5, null ,null);
        setTraitsBTier(bmus2, musicianTraits.get("Long-Winded"));
        theScene.add(bmus2);

        Musician bmus3 = new Musician("Jerry Gordita2", "Guitar", 5, 3, 5, null ,null);
        setTraitsBTier(bmus3, musicianTraits.get("Long-Winded"));
        theScene.add(bmus3);

        Musician bmus4 = new Musician("Jerry Gordita3", "Guitar", 5, 3, 5, null ,null);
        setTraitsBTier(bmus4, musicianTraits.get("Long-Winded"));
        theScene.add(bmus4);

        Musician bmus5 = new Musician("Jerry Gordita4", "Guitar", 5, 3, 5, null ,null);
        setTraitsBTier(bmus5, musicianTraits.get("Long-Winded"));
        theScene.add(bmus5);

        Musician bmus6 = new Musician("Jerry Gordita5", "Guitar", 5, 3, 5, null ,null);
        setTraitsBTier(bmus6, musicianTraits.get("Long-Winded"));
        theScene.add(bmus6);
    }

    private static int fourSidedRoll() {
        return ran.nextInt(4) + 1; // [0-3] + 1 = [1-4] range
    }

    private static int tenSidedRoll() {
        return ran.nextInt(10) + 1; // [0-9] + 1 = [1-10] range
    }

    private static void setTraitsSTier(Musician musician, MusicianTrait trait1, MusicianTrait trait2) {
        if(fourSidedRoll() != 1) {
            musician.setTrait1(trait1);
            if(fourSidedRoll() == 1) {
                musician.setTrait2(trait2);
            }
        }
    }

    private static void setTraitsATier(Musician musician, MusicianTrait trait1) {
        if(fourSidedRoll() == 1) {
            musician.setTrait1(trait1);
        }
    }

    private static void setTraitsBTier(Musician musician, MusicianTrait trait1) {
        if(tenSidedRoll() == 1) {
            musician.setTrait1(trait1);
        }
    }

    private static List<String> getMusicianSummariesList(List<Musician> musicians) {
        List<String> summariesList = new ArrayList<>(musicians.size());
        for (Musician musician : musicians) {
            summariesList.add(musician.toString());
        }

        return summariesList;
    }

    public static void hirePlayerMusicianByName(String musicianSummary) {
        Musician selectedMusician = null;
        String nameOnly  = musicianSummary.split(Pattern.quote("("))[0].stripTrailing();
        System.out.println("adding player with name: " + nameOnly);
        for(Musician musician : theScene) {
            if(nameOnly.equals(musician.getName())) {
                selectedMusician = musician;
                break;
            }
        }

        //remove musician from the scene and add him to the band
        if(selectedMusician != null) {
            theScene.remove(selectedMusician);
            playerBand.addMember(selectedMusician);
            int currentCash = playerBand.getCurrentMoney();
            playerBand.setCurrentMoney(currentCash - selectedMusician.getSalary());
        }
    }

    public static void firePlayerMusicianByName(String musicianSummary) {
        Musician selectedMusician = null;
        String nameOnly  = musicianSummary.split(Pattern.quote("("))[0].stripTrailing();
        System.out.println("adding player with name: " + nameOnly);
        for(Musician musician : playerBand.getMembers()) {
            if(nameOnly.equals(musician.getName())) {
                selectedMusician = musician;
                break;
            }
        }

        //remove musician from the scene and add him to the band
        if(selectedMusician != null) {
            playerBand.removeMember(selectedMusician);
            theScene.add(selectedMusician);
            int currentCash = playerBand.getCurrentMoney();
            playerBand.setCurrentMoney(currentCash + selectedMusician.getSalary());
        }
    }

    private void updateAllUI() {

    }
}