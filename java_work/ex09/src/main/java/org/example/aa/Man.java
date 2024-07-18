package org.example.aa;

public class Man {

    protected String name;

    public Man() {
    }

    public Man(String name) {
        this.name = name;
    }

    public void tellInfo() {
        System.out.println("name = " + name);
    }
}
