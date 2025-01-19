
import java.util.Scanner;

public class Application {
    public static void askQuestion(){
        Scanner sc = new Scanner(System.in);
        boolean run = true;

        while(run){
            try{
                System.out.println("덧셈할 문자를 입력해주세요");
                String inputString = sc.nextLine();
                if((!inputString.contains(","))&&(!inputString.contains(":"))){
                    customCalculate(inputString);
                }
                calculate(inputString);
            }catch(IllegalArgumentException e){
                System.out.println("잘못된 값을 입력하셨습니다.");
                run = false;
            }/*catch (Exception e){
                System.out.println("예기지 못하게 종료되었습니다");
                run = false;
            }*/
        }
    }
    //기본 구분자 처리 메소드
    public static void calculate(String inputString){
        int count = 0;
        String[] parts = inputString.split(",|:");
        for(String s : parts){
            if(s.trim().isEmpty()){
                continue;
            }
            count += Integer.parseInt(s) ;
        }
        System.out.println("결과 값 : " +  count);
    }
    //커스텀 구분자 처리 메소드
    public static void customCalculate(String inputString){
        int startIndex=inputString.indexOf("//");
        int endIndex= inputString.indexOf("\n");


        int count = 0;


        String splitElement = inputString.substring(startIndex, endIndex);
        System.out.println(splitElement);
        String modifiedStr = inputString.substring(endIndex +1);
        System.out.println(modifiedStr);
        String[] parts = modifiedStr.split(splitElement);
        System.out.println(parts);

        for(String s : parts){
            if(s.trim().isEmpty()){
                continue;
            }
            count += Integer.parseInt(s) ;
        }
        System.out.println("결과 값 : " +  count);

    }

    public static void main(String[] args) {

        askQuestion();
    }
}
