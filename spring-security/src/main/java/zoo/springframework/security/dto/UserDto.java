package zoo.springframework.security.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private String userId;
    private String password;


    private UserDto() {
    }

    @Builder(access = AccessLevel.PRIVATE)
    private UserDto(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public static UserDto byIdAndPassword(final String userId, final String password) {
        return UserDto.builder()
                .userId(userId)
                .password(password)
                .build();
    }

}