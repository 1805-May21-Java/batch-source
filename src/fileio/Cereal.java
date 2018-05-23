package fileio;

import java.io.Serializable;
import java.util.Objects;

public class Cereal implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * POJO ( Plain Old Java Object )
     *
     * - private instance fields.
     * - public getters and setters.
     * - no args constructor.
     * - override equals();
     * - override hashCode();
     * - override toStringMethod();
     */

    private boolean hasMilk;
    private transient int calories;
    private boolean isWholeWheat;
    private String brand;

    public Cereal(){
        super();
    }

    public Cereal(boolean hasMilk, int calories, boolean isWholeWheat, String brand) {
        this.hasMilk = hasMilk;
        this.calories = calories;
        this.isWholeWheat = isWholeWheat;
        this.brand = brand;
    }

    public boolean isHasMilk() {
        return hasMilk;
    }

    public void setHasMilk(boolean hasMilk) {
        this.hasMilk = hasMilk;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public boolean isWholeWheat() {
        return isWholeWheat;
    }

    public void setWholeWheat(boolean wholeWheat) {
        isWholeWheat = wholeWheat;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cereal{");
        sb.append("hasMilk=").append(hasMilk);
        sb.append(", calories=").append(calories);
        sb.append(", isWholeWheat=").append(isWholeWheat);
        sb.append(", brand='").append(brand).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cereal cereal = (Cereal) o;
        return hasMilk == cereal.hasMilk &&
                calories == cereal.calories &&
                isWholeWheat == cereal.isWholeWheat &&
                Objects.equals(brand, cereal.brand);
    }

    @Override
    public int hashCode() {

        return Objects.hash(hasMilk, calories, isWholeWheat, brand);
    }
}
