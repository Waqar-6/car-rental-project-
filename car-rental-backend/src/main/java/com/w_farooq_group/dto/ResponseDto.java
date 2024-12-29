package com.w_farooq_group.dto;

public class ResponseDto {
    private String responseStatus;
    private String responseMsg;

    public ResponseDto(String responseStatus, String responseMsg) {
        this.responseStatus = responseStatus;
        this.responseMsg = responseMsg;
    }

    public ResponseDto () {}

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }
}
