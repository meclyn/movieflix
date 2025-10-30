package br.com.movieflix.mapper;

import br.com.movieflix.controller.request.UserRequest;
import br.com.movieflix.controller.response.UserResponse;
import br.com.movieflix.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static User toUser(UserRequest userRequest) {
        return User.builder()
                .name(userRequest.name())
                .email(userRequest.email())
                .password(userRequest.password())
                .build();
    }

    public static UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .name(user.getName())
                .email(user.getEmail())
                .id(user.getId())
                .build();
    }
}
