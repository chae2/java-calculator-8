package calculator;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner sc = new Scanner(System.in);

        // get string
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = sc.nextLine();

        String regex_ = ",|:";
        if (input.contains("//") && input.contains("\\n") && input.indexOf("\\n") == input.indexOf("//")+3){
            int idx = input.indexOf("//");
            Character custom = input.charAt(idx+2);
            regex_ += "|"+custom;
            input = input.replace("\\n", "").replace("//","");
        }

        String tokens[] = input.split(regex_);
        int sum = 0;
        for (String token : tokens) {
//            System.out.println("token: " + token);
            if (!token.isEmpty() && Character.isDigit(token.charAt(0))) sum += Character.getNumericValue(token.charAt(0));
        }
        System.out.println("결과 : " + sum);
    }
}
