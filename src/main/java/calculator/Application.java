package calculator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner sc = new Scanner(System.in);

        // get string
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = sc.nextLine();
        if (input.contains("//") && input.contains("\\n")){
            int idx = input.indexOf("//");
            Character custom = input.charAt(idx+2);
//            System.out.println("custom: "+custom);

            String regex_custom = "[0-9:,"+custom+"]";
//            System.out.println("regex_custom: "+regex_custom);
            String regex_cond = "^"+regex_custom+"*(//.\\\\n)?"+regex_custom+"*$";
//            System.out.println("regex_cond: "+regex_cond);
            if (!input.matches(regex_cond)) {
                System.out.println("input: "+input);
                throw new IllegalArgumentException();
            }
        } else {
            String regex_cond = "^[0-9:,]*$";
            if (!input.matches(regex_cond)) throw new IllegalArgumentException();
        }

        String regex_ = ",|:";
        if (input.contains("//") && input.contains("\\n") && input.indexOf("\\n") == input.indexOf("//")+3){
            int idx = input.indexOf("//");
            Character custom = input.charAt(idx+2);
//            System.out.println("custom: "+custom);
            String escapedCustom = Pattern.quote(String.valueOf(custom));
            regex_ += "|"+escapedCustom;
            input = input.replace("\\n", "").replace("//","");
        }
//        System.out.println("input: "+input);
//        System.out.println("split regex: " + regex_);

        String tokens[] = input.split(regex_);
        int sum = 0;
        for (String token : tokens) {
//            System.out.println("token: " + token);
            if (!token.isEmpty() && Character.isDigit(token.charAt(0))) sum += Character.getNumericValue(token.charAt(0));
        }
        System.out.println("결과 : " + sum);
    }
}
