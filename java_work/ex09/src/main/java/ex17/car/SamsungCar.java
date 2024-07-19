package ex17.car;

import lombok.ToString;

@ToString
public class SamsungCar extends Car {

    public SamsungCar() {}

    public SamsungCar(String name, String desc, String company) {
        super.name = name;
        super.desc = desc;
        super.company = company;
    }
}
