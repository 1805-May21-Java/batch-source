package com.revature.accessfl;

public class FloatDriver {
    private float f = 10.0f;
    private float f2 = 121.001f;

    public FloatDriver(){
        super();
    }

    public FloatDriver(float f) {
        this.f = f;
    }

    public static void main(String args[]){

    }

    public float getF() {
        return f;
    }

    public void setF(float f) {
        this.f = f;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FloatDriver{");
        sb.append("f=").append(f);
        sb.append('}');
        return sb.toString();
    }

    public float getF2() {
        return f2;
    }

    public void setF2(float f2) {
        this.f2 = f2;
    }
}
