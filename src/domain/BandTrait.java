package domain;

public class BandTrait {
    String name;
    double talentBuff;
    double creativityBuff;

    public BandTrait(String name, double talentBuff, double creativityBuff) {
        this.name = name;
        this.talentBuff = talentBuff;
        this.creativityBuff = creativityBuff;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public double getTalentBuff() {
        return talentBuff;
    }

    public double getCreativityBuff() {
        return creativityBuff;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTalentBuff(double talentBuff) {
        this.talentBuff = talentBuff;
    }

    public void setCreativityBuff(double creativityBuff) {
        this.creativityBuff = creativityBuff;
    }
}
