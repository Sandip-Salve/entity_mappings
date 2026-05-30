package com.app.mappings.Utilities;

import java.time.LocalDateTime;

public class CustomApiResponse {

    private String apiResponse;
    private LocalDateTime localDateTime;

    public CustomApiResponse(String apiResponse){
        this.apiResponse = apiResponse;
        this.localDateTime = LocalDateTime.now();
    }

    public String getApiResponse() {
        return apiResponse;
    }

    public void setApiResponse(String apiResponse) {
        this.apiResponse = apiResponse;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "CustomApiResponse{" +
                "apiResponse='" + apiResponse + '\'' +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
