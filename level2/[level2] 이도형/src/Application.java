
import java.util.Scanner;

public class Application {
    public static void askQuestion(){
        Scanner sc = new Scanner(System.in);


        while(true){
            try{
                System.out.println("덧셈할 문자를 입력해주세요");
                String inputString = sc.nextLine();
                if((!inputString.contains(","))&&(!inputString.contains(":"))){ // 구분자로 ,나 :가 없을 시 커스텀구분자 메소드실행
                    customCalculate(inputString);
                }
                calculate(inputString);
            }catch(IllegalArgumentException e){
                System.out.println("잘못된 값을 입력하셨습니다.");
                break;
            }
        }
    }
    //기본 구분자 처리 메소드
    public static void calculate(String inputString){
        int count = 0;
        String[] parts = inputString.split(",|:");  //String 배열에 ,와 :로 분리한 문자열 저장
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
        int startIndex=inputString.indexOf("//"); // "//"를 찾아서 처음 발견한 인덱스 반환
        int endIndex= inputString.indexOf("\n"); // \n의 인덱스 반환
        int count = 0;


        String splitElement = inputString.substring(startIndex, endIndex); // 커스텀 구분자 선언 및 저장
        String modifiedStr = inputString.substring(endIndex +1); // 구분할 문자열 생성
        String[] parts = modifiedStr.split(splitElement); // 분할


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
