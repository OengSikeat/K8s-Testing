package com.sikeat.k8sdemo.entity;


import com.sikeat.k8sdemo.dto.UserResponse;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name")
    private String username;


    private String description;

    public UserResponse toResponse() {
        return UserResponse.builder()
                .id(this.id)
                .userName(this.username)
                .description(this.description)
                .build();
    }
}
