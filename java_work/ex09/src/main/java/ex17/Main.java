package ex17;

import ex17.phone.MobilePhone;
import ex17.phone.SmartPhone;

public class Main {

    public static void main(String[] args) {
        SmartPhone smartPhone = new SmartPhone("5.0", 1231241);
        smartPhone.show();

        MobilePhone mobilePhone = new MobilePhone(12345);
        mobilePhone.show();


        MobilePhone mobilePhone2 = new SmartPhone("5.0", 12345);
        mobilePhone2.show();
    }
}
