package com.revature.collections;

import java.util.Objects;

public class ChineseFood implements Comparable<ChineseFood>{

    private int calories;
    private String name;
    private boolean hasMSG;

    public ChineseFood() {
        super();
    }

    public ChineseFood(int calories, String name, boolean hasMSG) {
        this.calories = calories;
        this.name = name;
        this.hasMSG = hasMSG;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasMSG() {
        return hasMSG;
    }

    public void setHasMSG(boolean hasMSG) {
        this.hasMSG = hasMSG;
    }

    @Override
    public int compareTo(ChineseFood o) {
        return this.getCalories() - o.getCalories();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ChineseFood{");
        sb.append("calories=").append(calories);
        sb.append(", name='").append(name).append('\'');
        sb.append(", hasMSG=").append(hasMSG);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChineseFood that = (ChineseFood) o;
        return calories == that.calories &&
                hasMSG == that.hasMSG &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(calories, name, hasMSG);
    }
}
