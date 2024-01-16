package api.response.exceptions;

public enum ErrorCode {
    OK(2000,"OK"),
    SERVER_ERROR(5000,"BAD_REQUEST");

    private Integer code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
