package com.revature.assignoop;

public class Classes extends Phylum{
    private boolean liveBirth;
    private boolean isInsect;
    private boolean isPlant;

    public boolean isLiveBirth() {
        return liveBirth;
    }

    public void setLiveBirth(boolean liveBirth) {
        this.liveBirth = liveBirth;
    }

    public boolean isInsect() {
        return isInsect;
    }

    public void setInsect(boolean insect) {
        isInsect = insect;
    }

    public boolean isPlant() {
        return isPlant;
    }

    public void setPlant(boolean plant) {
        isPlant = plant;
    }
}
