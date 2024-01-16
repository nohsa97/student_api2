package api.response.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomException<T> {


    private ErrorCode errorCode;
    private String message;
    private InputRestriction data;

    public CustomException(ErrorCode errorCode, String message, InputRestriction data) {
        this.errorCode = errorCode;
        this.message = message;
        this.data = data;
    }


}
