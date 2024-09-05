package ex_240903;

import ex_240903.member.Member;
import ex_240903.member.MemberRepository;
import ex_240903.todo.TodoRepository;

import java.util.Scanner;

public class TodoMain {

    private MemberRepository memberRepository = new MemberRepository();
    private TodoRepository todoRepository = new TodoRepository();

    private String info = """
                0. login
                
                1. select()
                2. insert()
                3. update()
                4. delete()
                
                5. todo select() -> user 사용자
                6. todo insert() -> user 정보...
                7. todo update()
                8. todo delete()
                """;

    public static Member MEMBER;

    TodoMain() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(info);
            int ra = scanner.nextInt();
            if(ra == 0) {
                System.out.println("어떤 사용자 할래? 몇번");
                int member_idx = scanner.nextInt();
                MEMBER = memberRepository.findByIdx(member_idx);
                if (MEMBER == null) {
                    System.out.println("로그인 실패");
                } else {
                    System.out.println("로그인 성공");
                }
                System.out.println(MEMBER);
            }
            else if (ra == 1) {
                memberRepository.select();
            } else if (ra == 2) {
                memberRepository.insert();
            } else if (ra == 6) {
                todoRepository.insert();
            } else {
                System.out.println("종료됩니다.");
                break;
            }
        }
    }

    public static void main(String[] args) {
        new TodoMain();
    }
}