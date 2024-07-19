package ex17.box;

public class Main {

    public static void main(String[] args) {
        Box box = new Box();
        PaperBox paperBox = new PaperBox();
        GoldBox goldBox = new GoldBox();

        wrapBox(box);
        wrapBox(paperBox);
        wrapBox(goldBox);
    }

    private static void wrapBox(Box box) {

        if(box instanceof GoldBox) {
            ((GoldBox) box).goldBox();
        } else if(box instanceof PaperBox) {
            ((PaperBox) box).paperBox();
        } else {
            box.box();
        }

    }
}
