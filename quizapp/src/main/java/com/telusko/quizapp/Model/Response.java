package com.telusko.quizapp.Model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Response {
    
    private int id;
    private String response;
}
