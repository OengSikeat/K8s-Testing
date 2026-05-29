package com.sikeat.k8sdemo.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserResponse {
    private Long id;
    private String userName;
    private String description;
}
