package Application;

public class Spliter {
    String[] splitedString;
    public Spliter(String inputString){
        if((inputString.contains(",")) || (inputString.contains(":"))){
            this.splitedString = basicSpliter(inputString);
            AddString addStr = new AddString(this.splitedString);
        }else if((inputString.contains("//")) || (inputString.contains("\n"))) {
            this.splitedString = customSpliter(inputString);
            AddString addStr = new AddString(this.splitedString);
        }else{
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }


    public String[] basicSpliter(String inputString){
        String[] parts = inputString.split(",|:");
        return parts;
    }

    public String[] customSpliter(String inputString){
        int startIndex=inputString.indexOf("//") +2;
        int endIndex= inputString.indexOf("n");

        String splitElement = inputString.substring(startIndex, endIndex-1);
        String modifiedStr = inputString.substring(endIndex +1);
        String[] parts = modifiedStr.split(splitElement);

        return parts;
    }
}
