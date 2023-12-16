package oncall.exception;

public enum ErrorMessage {

    INVALID_INPUT_PATTERN("입력 형식이 유효하지 않습니다."),
    INVALID_EMPLOYEES_BY_SIZE("사원은 %d명 이상 %d명 이하만 가능합니다."),
    INVALID_EMPLOYEES_BY_DUPLICATED("사원 닉네임이 중복됩니다."),
    INVALID_EMPLOYEE_BY_NAME_LENGTH("사원 닉네임은 %d글자 이상 %d글자 이하만 가능합니다."),
    NOT_FOUNT_MONTH("존재하지 않는 월입니다."),
    NOT_FOUNT_DAY_OF_WEEK("존재하지 않는 요일입니다.");

    private static final String MESSAGE_FORMAT = "[ERROR] %s";
    private final String message;

    ErrorMessage(String message) {
        this.message = String.format(MESSAGE_FORMAT, message);
    }

    public String getMessage() {
        return message;
    }
}