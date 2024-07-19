package ex17.car;

import lombok.ToString;

@ToString
public class KiaCar extends Car {

    public KiaCar() {
    }

    public KiaCar(String name, String desc, String company) {
        this.name = name;
        this.desc = desc;
        this.company = company;
    }
}
