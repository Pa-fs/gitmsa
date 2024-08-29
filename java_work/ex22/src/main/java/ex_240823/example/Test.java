package ex_240823.example;

public class Test {

    public static void main(String[] args) {
        for(int i = 1; i<7; i++){

            for(int k=0; k<i; k++){

                System.out.print("*");
            }

            for (int j = 6; j>i; j--){

                System.out.print(" ");

            }
            for(int l=6; l>i; l--){
                System.out.print(" ");

            }
            for(int u=1; u<i*2; u++){

                System.out.print("*");
            }
            System.out.println();
        }

    }
}
