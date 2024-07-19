package org.problem_test;


// 한 턴에 주사위 총 3번 돌린다
// 첫번쨰는 주사위 5개를 굴리는데
// keep은 자유롭게 가능
// 만약 keep 1 3 5
// 원하는 주사위는 1 2 3 4 5
// 다음 두번쨰는 2 4
// ...
/*
    recursive
    탈출조건 user 가 keep 더이상 안한다거나 (keep == 0) total == 0 모두 굴리면
    (깊이-lev 가 0개(총 횟수를 모두 사용))
    1. 5개를 모두 던진 뒤 개수를 보고 판단함
    2. 킵할 주사위를 체크 후 남은 개수를 다시 던짐
    사용자 그만 == true {
        return;
    }
    if(total == 0) {
        return;
    }
 */
/*
    recursive


    반복 가지 수 주사위 5개 5가지

    1. doDice 함수호출할때마다 킵할건지 입력받기
    2. 킵할꺼면 해당 번째 주사위 keep_arr[5] 배열에 저장
    3. keep - 1
 */
public class Dice {

    public static void main(String[] args) {

        // 오름차순으로 등차가 1인 수열찾기
        //        int[] dice = {1,1,3,4,6};
        // 0, 1번째 같아도 다시 시작할 수 있음
        // true인지 찾기만 하면됨
        int[] dice = {2,3,4,5,6};
        boolean isFound = false;
//        for(int i = 0; i < 2; i++) {
//            int cnt = 0;
//            int num = dice[i];
//            for (int j = i + 1; j < i + 4; j++) {
//                if (num + 1 != dice[j]) {
//                    isFound = false;
//                    break;
//                } else {
//                    cnt++;
//                }
//                num++;
//            }
//            if(cnt == 3) {
//                isFound = true;
//            }
//            if(isFound) break;
//        }

        int max = Integer.MIN_VALUE;
        int cnt = 0;
        for (int i = 0; i < dice.length; i++) {
            if(dice[i] - max == 1) {
                cnt++;
            } else {
                cnt = 0;
            }

            if(cnt == 3) {
                isFound = true;
                break;
            }

            if(max <= dice[i]) {
                max = dice[i];
            }
        }

        System.out.println(isFound);
    }
}
