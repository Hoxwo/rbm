package main;

import domain.BandTrait;
import domain.Musician;
import domain.MusicianTrait;
import javax.swing.*;
import java.util.*;

public class RockBandManager {
    static Map<String, MusicianTrait> musicianTraits = new HashMap<>();
    static Map<String, BandTrait> bandTraits = new HashMap<>();
    static List<Musician> theScene =  new ArrayList<>();
    static String speedState; //SLOW, NORMAL, FAST
    static String gameState; //START, RECORD, TOUR, RESULT, HIREANDFIRE, END
    static Random ran = new Random();

    public static void main(String[] args) {
        //initial data and state setup
        initMusicianTraits();
        initBandTraits();
        initScene();
        speedState = "NORMAL";
        gameState = "START";

        while(!gameState.equals("END")) {
            JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Hello world");

            if (gameState.equals("START")) {

            } else if (gameState.equals("RECORD")) {

            } else if (gameState.equals("TOUR")) {

            } else if (gameState.equals("RESULT")) {

            } else if (gameState.equals("HIREANDFIRE")) {

            } else if (gameState.equals("END")) {

            }

            try {
                Thread.sleep(60000);
            } catch (Throwable t) {
                //nothing
            } finally {
                gameState = "END";
            }
        }
        JFrame f = new JFrame();
        JOptionPane.showMessageDialog(f, "Ending");
        System.exit(1);
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
        Musician smus1 = new Musician("Johnny Paige", "GUITAR", 9.0, 5.0, 10, null ,null);
        setTraitsSTier(smus1, musicianTraits.get("Shredder"), musicianTraits.get("Long-Winded"));
        theScene.add(smus1);

        Musician smus2 = new Musician("Jim Pat Jone", "BASS", 9.0, 5.0, 10, null ,null);
        setTraitsSTier(smus2, musicianTraits.get("Songwriter"), musicianTraits.get("Long-Winded"));
        theScene.add(smus2);

        Musician smus3 = new Musician("Roberto Plane", "VOCALS", 9.0, 5.0, 10, null ,null);
        setTraitsSTier(smus3, musicianTraits.get("Songwriter"), musicianTraits.get("Long-Winded"));
        theScene.add(smus3);

        Musician smus4 = new Musician("Jorge Bondham", "DRUMS", 9.0, 5.0, 10, null ,null);
        setTraitsSTier(smus4, musicianTraits.get("Shredder"), musicianTraits.get("Long-Winded"));
        theScene.add(smus4);

        //A tier, 12 pts max, 6-8 salary, 25% chance of 1 trait
        Musician amus1 = new Musician("Dave Mac", "GUITAR", 9.0, 5.0, 10, null ,null);
        setTraitsATier(amus1, musicianTraits.get("Shredder"));
        theScene.add(amus1);

        Musician amus2 = new Musician("Gabe Shogun", "DRUMS", 9.0, 5.0, 10, null ,null);
        setTraitsATier(amus2, musicianTraits.get("Songwriter"));
        theScene.add(amus2);

        //B tier, 10 pts max, 4-6 salary, 10% chance of 1 trait
        Musician bmus1 = new Musician("Alex Bea", "BASS", 9.0, 5.0, 10, null ,null);
        setTraitsBTier(bmus1, musicianTraits.get("Songwriter"));
        theScene.add(bmus1);

        Musician bmus2 = new Musician("Jerry Gordita", "GUITAR", 9.0, 5.0, 10, null ,null);
        setTraitsBTier(bmus2, musicianTraits.get("Long-Winded"));
        theScene.add(bmus2);
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
}
