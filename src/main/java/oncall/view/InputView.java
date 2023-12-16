package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    private static final Pattern MONTH_AND_DAY_OF_WEEK = Pattern.compile("^([0-9]+)(?:, ([가-힣]+))*$");

    private InputView() {
    }

    public static List<String> readMonthAndDayOfWeek() {
        System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
        String input = Console.readLine();
        if (!MONTH_AND_DAY_OF_WEEK.matcher(input).matches()) {
            throw new IllegalArgumentException("잘못된 입력입니다."); // TODO 예외처리
        }
        return Arrays.stream(input.split(","))
                .map(String::strip)
                .collect(Collectors.toList());
    }
}
