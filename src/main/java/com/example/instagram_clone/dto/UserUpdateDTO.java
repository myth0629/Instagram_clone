package com.example.instagram_clone.dto;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class UserUpdateDTO {
    private long id;
    private String password;
    private String name;
    private String phone;
    private String title;
    private String website;
    private String profileImageUrl;
}
