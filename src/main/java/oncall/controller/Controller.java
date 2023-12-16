package oncall.controller;

import java.util.List;
import oncall.domain.MonthAndDayOfWeek;
import oncall.view.InputView;

public class Controller {

    public void run() {
        List<String> inputMonthAndDayOfWeek = InputView.readMonthAndDayOfWeek();
        MonthAndDayOfWeek monthAndDayOfWeek = new MonthAndDayOfWeek(
                Integer.parseInt(inputMonthAndDayOfWeek.get(0)),
                inputMonthAndDayOfWeek.get(1));
    }
}
