package zoo.service.bookstore.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import static lombok.AccessLevel.PROTECTED;


@Getter
@NoArgsConstructor(access = PROTECTED)
public class User {

    @Builder
    public User(long userSeq, String userName, String userId, String userPw) {
        this.userSeq = userSeq;
        this.userName = userName;
        this.userId = userId;
        this.userPw = userPw;
    }

    private long userSeq;
    private String userName;
    private String userId;
    private String userPw;

}