import java.util.Scanner;

class MakingReservation {
    public void reservation() {

    }

    public void lookUp() {

    }

    public void cancle() {

    }

    public void endReservation() {

    }

    public void chooseSelect() {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        switch(num) {
        case 1 :
            reservation();
            break ;
        case 2 :
            lookUp();
            break ;
        case 3 :
            cancle();
            break ;
        case 4 :
            endReservation();
            break ;
        }

        sc.close();
    }
}

public class Hw2_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("명품콘서트홀 예약 시스템입니다.");
        MakingReservation mr = new MakingReservation();

        mr.cancle();
        mr.chooseSelect();
        mr.endReservation();
        sc.close();
    }    
}
