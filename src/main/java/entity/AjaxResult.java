package entity;

import java.io.Serializable;

public class AjaxResult implements Serializable {

	private static final long serialVersionUID = -6442403699084074901L;
	
	private Boolean success;
	
	private String message;
	

	public AjaxResult(Boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}

	public AjaxResult() {
		super();
		success = true;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

}
