package db_240814;


import java.util.Scanner;

public class DBMain {

    DBMain() {
        Scanner scanner = new Scanner(System.in);
        DBRepository dbRepository = new DBRepository();

        while (true) {
            System.out.println("""
                    뭐할래?
                    1. 입력
                    2. 조회
                    3. 수정
                    4. 삭제
                    5. 종료
                    """);

            int cho = scanner.nextInt();

            // insert 문 실행
            if (cho == 1) {
                dbRepository.insert();
            }
            // select 문 실행
            else if(cho == 2){
                dbRepository.select();
            }
            else if(cho == 3) {
                dbRepository.update();
            }
            // delete 문 실행
            else if(cho == 4) {
                dbRepository.delete();
            }
            else {
                System.out.println("종료합니다");
                break;
            }
        }
    }
    public static void main(String[] args) {
        new DBMain();
    }
}
