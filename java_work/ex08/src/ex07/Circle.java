package ex07;

class Circle {
    // private 변수는 setter getter로 참조 가능하다
    private int rad;
    private String name;

    public Circle() {
    }

    public Circle(int rad) {
        this.rad = rad;
    }

    public Circle(String name) {
        this.name = name;
    }

    public Circle(int rad, String name) {
        this.rad = rad;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.equals("")) {
            this.name = "홍길동";
            return;
        }
        this.name = name;
    }

    public int getRad() {
        return rad;
    }

    public void setRad(int rad) {
        if (rad < 0) {
            this.rad = 0;
            return;
        }
        this.rad = rad;
    }

    public double getArea() {
        return rad * rad * 3.14;
    }
}
