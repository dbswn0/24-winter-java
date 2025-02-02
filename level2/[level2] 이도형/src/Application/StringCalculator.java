package Application;

import java.util.Scanner;

public class StringCalculator {
    Scanner sc = new Scanner(System.in);


    public StringCalculator(){
        runScanner();
    }

    public void runScanner(){
        try{
            while(true){
                System.out.println("덧셈할 문자를 입력해주세요");
                String inputStr = sc.nextLine();
                Spliter spliter = new Spliter(inputStr);
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            sc.close();
        }catch (Exception e){
            System.out.println("잘못된 값을 입력하셨습니다.");
            sc.close();
        }
    }


}
