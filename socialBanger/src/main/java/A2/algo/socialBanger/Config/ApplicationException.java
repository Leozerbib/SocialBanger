package A2.algo.socialBanger.Config;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ApplicationException extends RuntimeException  {

    private HttpStatus httpStatus;
    private List<String> errors;
    private Object data;


    public ApplicationException(String message) {
        this(HttpStatus.BAD_REQUEST, message);
    }

    public ApplicationException(HttpStatus httpStatus, String message) {
        this(httpStatus, message, Collections.singletonList(message), null);
    }

    public ApplicationException(HttpStatus httpStatus, String message, Object data) {
        this(httpStatus, message, Collections.singletonList(message),  data);
    }


    public ApplicationException(HttpStatus httpStatus, String message, List<String> errors, Object data) {
        super(message);
        this.httpStatus = httpStatus;
        this.errors = errors;
        this.data = data;
    }

    
    public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public List<String> getErrors() {
		return errors;
	}

	public Object getData() {
		return data;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
