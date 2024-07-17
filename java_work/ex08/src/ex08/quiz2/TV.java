package ex08.quiz2;

public class TV {
    private final String companyName;
    private final int createdYear;
    private final int size;

    public TV(String companyName, int createdYear, int size) {
        this.companyName = companyName;
        this.createdYear = createdYear;
        this.size = size;
    }

    public void show() {
        System.out.println(companyName + "에서 만든 " + createdYear + "년 " + size + "인치");
    }
}
