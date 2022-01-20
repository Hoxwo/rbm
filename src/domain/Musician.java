package domain;

import java.util.Random;

public class Musician {
    String name;
    String instrument; //VOCALS, GUITAR, BASS, DRUMS
    int talent;     //1-9
    int creativity; //1-9
    int salary;     //10-500
    MusicianTrait trait1;
    MusicianTrait trait2;
    static Random ran = new Random();

    public Musician(String name, String instrument, int talent, int creativity, int salary, MusicianTrait trait1, MusicianTrait trait2) {
        this.name = name;
        this.instrument = instrument;
        this.talent = talent + getZeroOneOrTwoAsDouble();
        this.creativity = creativity + getZeroOneOrTwoAsDouble();
        this.salary = salary;
        this.trait1 = trait1;
        this.trait2 = trait2;
    }

    public String toString() {
        String musicianSummary = "" + this.name + " (" + this.talent + ", " + this.creativity + ")" + " <> " + this.instrument + " <> " + this.salary + "K <>";
        if (trait1 != null) {
            musicianSummary = musicianSummary + "" + trait1.getName();
            if(trait2 != null) {
                musicianSummary = musicianSummary + ", " + trait2.getName();
            }
        }

        return musicianSummary;
    }

    public String multilineSummary() {
        String musicianSummary = "" + this.name + " <> " + this.instrument + " <> " + this.salary + "K \n" +
                                 "Talent: " + this.talent + "\n" +
                                 "Creativity: " + this.creativity + "\n" +
                                 "Traits: ";
        if (trait1 != null) {
            musicianSummary = musicianSummary + "" + trait1.getName();
            if(trait2 != null) {
                musicianSummary = musicianSummary + ", " + trait2.getName();
            }
        }

        return musicianSummary;
    }

    private static int getZeroOneOrTwoAsDouble() {
        return ran.nextInt(3); // [0-2] range
    }

    public void addToTalent(double add) {
        this.talent += add;
    }

    public void addToCreativity(double add) {
        this.creativity += add;
    }

    public void addToSalary(int raise) {
        this.salary += raise;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public String getInstrument() {
        return instrument;
    }

    public double getTalent() {
        return talent;
    }

    public double getCreativity() {
        return creativity;
    }

    public int getSalary() {
        return salary;
    }

    public MusicianTrait getTrait1() {
        return trait1;
    }

    public MusicianTrait getTrait2() {
        return trait2;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public void setTalent(int talent) {
        this.talent = talent;
    }

    public void setCreativity(int creativity) {
        this.creativity = creativity;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setTrait1(MusicianTrait trait1) {
        this.trait1 = trait1;
    }

    public void setTrait2(MusicianTrait trait2) {
        this.trait2 = trait2;
    }
}
