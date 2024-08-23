package ex_240822;

interface Viewable {
    @Deprecated
    public void showIt(String str);
}

class Viewer implements Viewable {
    @Override
    public void showIt(String str) {
        System.out.println("str = " + str);
    }
}

public class Ex07 {

    public static void main(String[] args) {
        Viewer viewer = new Viewer();

        viewer.showIt("ABCDE");
    }
}
