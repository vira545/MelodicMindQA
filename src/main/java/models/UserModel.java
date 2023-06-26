package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class UserModel {
    private String userName;
    private String email;
    private String password;
    private String country;
    private String city;
}
