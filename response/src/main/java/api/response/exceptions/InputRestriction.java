package api.response.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InputRestriction {
    private int maxGrade;

    public InputRestriction(int maxGrade) {
        this.maxGrade = maxGrade;
    }
}
