package domain;

public class Musician {
    String name;
    String instrument; //VOCALS, GUITAR, BASS, DRUMS
    double talent;     //1-9
    double creativity; //1-9
    int salary;     //10-500
    MusicianTrait trait1;
    MusicianTrait trait2;

    public Musician(String name, String instrument, double talent, double creativity, int salary, MusicianTrait trait1, MusicianTrait trait2) {
        this.name = name;
        this.instrument = instrument;
        this.talent = talent;
        this.creativity = creativity;
        this.salary = salary;
        this.trait1 = trait1;
        this.trait2 = trait2;
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

    public void setTalent(double talent) {
        this.talent = talent;
    }

    public void setCreativity(double creativity) {
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
