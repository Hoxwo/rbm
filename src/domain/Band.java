package domain;

import java.util.ArrayList;
import java.util.List;

public class Band {
    String name;
    double talent;     //1-9
    double creativity; //1-9
    int income;     //10-500
    int fans;       //in thousands, 1 - 999
    List<Musician> members = new ArrayList<Musician>();
    BandTrait trait1;
    BandTrait trait2;

    public Band(String name, double talent, double creativity, int income, BandTrait trait1, BandTrait trait2, int fans) {
        this.name = name;
        this.talent = talent;
        this.creativity = creativity;
        this.income = income;
        this.trait1 = trait1;
        this.trait2 = trait2;
        this.members = new ArrayList<Musician>();
        this.fans = fans;
    }

    public double calculateAverageTalent() {
        double runningTotal = 0.0;
        for(Musician oneMember : members) {
            runningTotal += oneMember.getTalent();
        }

        return (runningTotal / members.size());
    }

    public double calculateAverageCreativity() {
        double runningTotal = 0.0;
        for(Musician oneMember : members) {
            runningTotal += oneMember.getCreativity();
        }

        return (runningTotal / members.size());
    }

    public void addToTalent(double add) {
        this.talent += add;
    }

    public void addToCreativity(double add) {
        this.creativity += add;
    }

    public void addToIncome(int raise) {
        this.income += raise;
    }

    public void addMember(Musician member) {
        this.members.add(member);
    }

    public void removeMember(Musician member) {
        this.members.remove(member);
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public double getTalent() {
        return talent;
    }

    public double getCreativity() {
        return creativity;
    }

    public int getIncome() {
        return income;
    }

    public BandTrait getTrait1() {
        return trait1;
    }

    public BandTrait getTrait2() {
        return trait2;
    }

    public List<Musician> getMembers() {
        return members;
    }

    public int getFans() {
        return fans;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTalent(double talent) {
        this.talent = talent;
    }

    public void setCreativity(double creativity) {
        this.creativity = creativity;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public void setTrait1(BandTrait trait1) {
        this.trait1 = trait1;
    }

    public void setTrait2(BandTrait trait2) {
        this.trait2 = trait2;
    }

    public void setMembers(List<Musician> members) {
        this.members = members;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }
}
