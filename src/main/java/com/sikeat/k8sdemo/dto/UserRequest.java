package com.sikeat.k8sdemo.dto;

import com.sikeat.k8sdemo.entity.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserRequest {
    private String userName;
    private String description;

    public User toEntity()
    {
        return new User(
                null,
                this.userName,
                this.description
        );
    }
}
