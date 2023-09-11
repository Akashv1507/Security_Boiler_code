package com.akash.securityboilercode.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {

	public static ResponseEntity<Object> generateResponse(HttpStatus status, boolean error, String message, Object responseObj) {
        Map<String, Object> map = new HashMap<>();
        try {
            map.put("timestamp", LocalDateTime.now());
            map.put("status", status.value());
            map.put("isSuccess", error);
            map.put("message", message);
            map.put("data", responseObj);

            return new ResponseEntity<>(map,status);
        } catch (Exception e) {
            map.clear();
            map.put("timestamp", LocalDateTime.now());
            map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            map.put("isSuccess",false);
            map.put("message", e.getMessage());
            map.put("data", null);
            return new ResponseEntity<>(map,status);
        }
    }
}
