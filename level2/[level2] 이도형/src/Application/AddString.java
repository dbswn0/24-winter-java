package Application;

public class AddString {
    public AddString(String[] splitedParts){
        addSplitedString(splitedParts);
    }


    public void addSplitedString(String[] splitedParts){
        int count =0;

        for(String s : splitedParts){
            if(s.trim().isEmpty()){
                continue;
            }
            count += Integer.parseInt(s) ;
        }
        System.out.println("결과 값 : " +  count);
    }
}
