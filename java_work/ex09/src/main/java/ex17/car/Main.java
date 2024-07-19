package ex17.car;

public class Main {

    public static void main(String[] args) {

        SamsungCar samsungCar = new SamsungCar();

        KiaCar kiaCar = new KiaCar();

        samsungCar.show();
        samsungCar.name = "ㅇㅁㄴㄻㄴㅇㄹ";
        samsungCar.company = "DSFsdf";
        samsungCar.desc = "dasfsadfa";

        samsungCar.show();
        kiaCar.show();

        System.out.println(samsungCar);
        System.out.println(kiaCar);
    }
}
