package ex17.test;

public class CC extends AA {

    public void cc() {
        System.out.println("cc함수");
    }
}

// 1 1 2 3 4
// 1 2 3 4 4
// 3 4 5 6 6
// 1 2 3 4 6
// for(int i = 0; i < 2; i++) {
//   int num = dice[i];
//   for(int j = i + 1; j < i + 4; j++) {
//      if(num + 1 != dice[j]) break;
//      num++;
//
// 1 1 1 1 6 => 10 - 6 = 4
//              10 - 1 = 9
// 다더하고 앞 뒤 뺀다음 더 큰 것을
// 4 5 5 5 5 => 24 - 4 = 20
//              24 - 5 = 19
//