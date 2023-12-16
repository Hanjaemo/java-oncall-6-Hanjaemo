package oncall.exception;

import java.util.function.Supplier;
import oncall.view.OutputView;

public class ExceptionHandler {

    private ExceptionHandler() {
    }

    public static <T> T handleSupplier(Supplier<T> reader) {
        try {
            return reader.get();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return handleSupplier(reader);
        }
    }
}
