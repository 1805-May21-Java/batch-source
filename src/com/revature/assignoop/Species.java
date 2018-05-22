package com.revature.assignoop;

public class Species extends Genus{
    private String nickname;
    private String sName = "UNSET";
    private String sSubName = "UNSET";
    private String sound = "Silence";
    private String trinomial;
    private boolean noise;
    private boolean speed;

    //Default Constructor.
    public Species(){

    }

    //Params constructor for creating your very own Species.
    public Species(String nickname, String sName, String sound, boolean noise, boolean speed) {
        this.nickname = nickname;
        this.sName = sName;
        this.sound = sound;
        this.noise = noise;
        this.speed = speed;
    }

    //Since we inherit from Family we're going to take the family name to create the trinomial.
    public String getTrinomial() {
        this.trinomial = this.sSubName+" "+this.sName+" "+getfName();
        return trinomial;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public boolean isNoise() {
        return noise;
    }

    public void setNoise(boolean noise) {
        this.noise = noise;
    }

    public boolean isSpeed() {
        return speed;
    }

    public void setSpeed(boolean speed) {
        this.speed = speed;
    }

    public String getsSubName() {
        return sSubName;
    }

    public void setsSubName(String sSubName) {
        this.sSubName = sSubName;
    }
}
