package br.com.chat.chat.controller.exceptions;

public class StandartError {

    private Integer status;
    private Long timestamp;
    private String message;
    
    public StandartError(Integer status, Long timestamp, String message) {
        this.status = status;
        this.timestamp = timestamp;
        this.message = message;
    }
    
    public StandartError() {
        super();
    }
    
    public Integer getStatus() {
        return status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public Long getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
        
}
