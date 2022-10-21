import java.util.Scanner;

class MakingReservation {
    String []sSeat = new String[10];
    String []aSeat = new String[10];
    String []bSeat = new String[10];
    
    MakingReservation() {
        for (int i = 0; i < 10; i++) {
            sSeat[i] = "---";
            aSeat[i] = "---";
            bSeat[i] = "---";
        }    
    }
    public void reservation() {
        Scanner sc = new Scanner(System.in);
        System.out.print("좌석구분 S(1), A(2), B(3)>>");

        int seat = sc.nextInt();
        switch(seat) {
        case 1 :
            System.out.print("S>>");
            for (String e : sSeat) {
                System.out.print(" " + e);
            }
            System.out.print("\n이름>>");
            String sName = sc.next();
            System.out.print("번호>>");
            int sNumber = sc.nextInt();
            if (sSeat[sNumber - 1] == "---") {
                sSeat[sNumber - 1] = sName;
            }
            else {
                System.out.println("이미 예약된 좌석입니다!");
            }
            break ;
        case 2 :
            System.out.print("A>>");
            for (String e : aSeat) {
                System.out.print(" " + e);
            }
            System.out.print("\n이름>>");
            String aName = sc.next();
            System.out.print("번호>>");
            int aNumber = sc.nextInt();
            if (aSeat[aNumber - 1] == "---") {
                aSeat[aNumber - 1] = aName;
            }
            else {
                System.out.println("이미 예약된 좌석입니다!");
            }
            break ;
        case 3 :
            System.out.print("B>>");
            for (String e : bSeat) {
                System.out.print(" " + e);
            }
            System.out.print("\n이름>>");
            String bName = sc.next();
            System.out.print("번호>>");
            int bNumber = sc.nextInt();
            if (bSeat[bNumber - 1] == "---") {
                bSeat[bNumber - 1] = bName;
            }
            else {
                System.out.println("이미 예약된 좌석입니다!");
            }
            break ;
        }
    }

    public void lookUp() {
        System.out.print("S>>");
        for (String e : sSeat) {
            System.out.print(" " + e);  
        }
        System.out.println("");
        System.out.print("A>>");
        for (String e : aSeat) {
            System.out.print(" " + e);  
        }
        System.out.println("");
        System.out.print("B>>");
        for (String e : bSeat) {
            System.out.print(" " + e);  
        }
        System.out.println("\n<<<조회를 완료하였습니다.>>>");
    }

    public void cancle() {
        Scanner sc = new Scanner(System.in);
        System.out.print("좌석 S:1, A:2, B:3>>");

        int seatCancle = sc.nextInt();
        switch(seatCancle) {
        case 1 :
            int i;
            System.out.print("S>>");
            for (String e : sSeat) {
                System.out.print(" " + e);
            }
            System.out.print("\n이름>>");
            String sName = sc.next();
            for (i = 0; i < 10; i++) {
                if (sName.equals(sSeat[i])) {
                    break ;
                }
            }
            if (i < 10) {
                sSeat[i] = "---";
            }
            else {
                System.out.println("예약된 분이 존재하지 않습니다!");
            }
            break ;
        case 2 :
            System.out.print("A>>");
            for (String e : aSeat) {
                System.out.print(" " + e);
            }
            System.out.print("\n이름>>");
            String aName = sc.next();
            for (i = 0; i < 10; i++) {
                if (aName.equals(aSeat[i])) {
                    break ;
                }
            }
            if (i < 10) {
                aSeat[i] = "---";
            }
            else {
                System.out.println("예약된 분이 존재하지 않습니다!");
            }
            break ;
        case 3 :
            System.out.print("B>>");
            for (String e : bSeat) {
                System.out.print(" " + e);
            }
            System.out.print("\n이름>>");
            String bName = sc.next();
            for (i = 0; i < 10; i++) {
                if (bName.equals(bSeat[i])) {
                    break ;
                }
            }
            if (i < 10) {
                bSeat[i] = "---";
            }
            else {
                System.out.println("예약된 분이 존재하지 않습니다!");
            }
            break ;
        }
    }

    public boolean endReservation() {
        return false;
    }

    public boolean chooseSelect() {
        boolean checking = true;
        Scanner sc = new Scanner(System.in);

        System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4>>");
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
            checking = endReservation();
            break ;
        }

        return checking;
    }
}

public class Hw2_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean checker = true;
        System.out.println("명품콘서트홀 예약 시스템입니다.");
        MakingReservation mr = new MakingReservation();

        while (checker) {
            checker = mr.chooseSelect();
        }
        sc.close();
    }    
}
