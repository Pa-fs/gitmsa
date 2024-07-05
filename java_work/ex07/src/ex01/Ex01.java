package ex01;
/**
 * shift + f10 현재 설정된 파일 실행
 * ctrl + shift + f10 열려진 파일 시행
 * shift + delete 한줄 삭제
 * alt + insert 파일 생성
 * ctrl + e 최근 파일 찾기
 * shift + shift 파일 찾기
 * alt + 1 왼쪽 메뉴 선택으로 이동 => esc 소스로 다시 이동
 */
public class Ex01 {

    public static void main(String[] args) {
//        int sum = 0;
//        for (int i = 1; i <= 10; i++) {
//            for (int j = 0; j < i; j++) {
//                sum = sum + j + 1;
//            }
//        }
//        System.out.println(sum);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
