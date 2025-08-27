package com.example.Dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Getter
@Setter
public class ChatRequest {
    private String question;
    private String username;

}
