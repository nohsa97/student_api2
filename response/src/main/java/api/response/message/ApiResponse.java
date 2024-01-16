package api.response.message;

import api.response.exceptions.ErrorCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ApiResponse<T> {
    private Status status;
    private Metadata metadata;
    private List<T> results;



    @Getter
    public static class Status {
        private Integer code;
        private String message;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Status(ErrorCode errorCode) {
            this.code = errorCode.getCode();
            this.message = errorCode.getMessage();
        }
    }


    @Getter
    public static class Metadata {
        private Long resultCount;

        public Metadata(Long resultCount) {
            this.resultCount = resultCount;
        }

        public Long getResultCount() {
            return resultCount;
        }

        public void setResultCount(Long resultCount) {
            this.resultCount = resultCount;
        }
    }


}
