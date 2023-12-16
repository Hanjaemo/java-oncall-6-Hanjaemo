package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import oncall.exception.ErrorMessage;

public class InputView {

    private static final Pattern MONTH_AND_DAY_OF_WEEK_PATTERN = Pattern.compile("^([0-9]+)(?:,([가-힣]+))*$");
    private static final Pattern EMPLOYEES_PATTERN = Pattern.compile("^([가-힣]+)(?:,([가-힣]+))*$");

    private InputView() {
    }

    public static List<String> readMonthAndDayOfWeek() {
        System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
        String input = Console.readLine();
        validatePattern(MONTH_AND_DAY_OF_WEEK_PATTERN, input);
        return convertToList(input);
    }

    private static List<String> convertToList(String input) {
        return Arrays.stream(input.split(","))
                .map(String::strip)
                .collect(Collectors.toList());
    }

    public static List<String> readEmployees(String weekdayOrHoliday) {
        String format = "평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ";
        if (weekdayOrHoliday.equals("휴일")) {
            format = "휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ";
        }
        System.out.print(format);
        String input = Console.readLine();
        validatePattern(EMPLOYEES_PATTERN, input);
        return convertToList(input);
    }

    private static void validatePattern(Pattern pattern, String input) {
        if (!pattern.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_PATTERN.getMessage());
        }
    }
}
