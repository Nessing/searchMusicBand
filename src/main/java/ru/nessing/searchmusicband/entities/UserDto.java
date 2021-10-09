package ru.nessing.searchmusicband.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private long id;
    private String email;
    private String password;
    private String nickname;
    private String name;
    private String city;
    private String type;
    private String searching;
    private String genre;
    private String description;
    private String state;

    public UserDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.nickname = user.getNickname();
        this.name = user.getName();
        this.city = user.getCity();
        this.type = user.getType();
        this.searching = user.getSearching();
        this.genre = user.getGenre();
        this.description = user.getDescription();
        this.state = user.getState();
    }

    public UserDto(String email, String password, String nickname, String name) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.name = name;
    }

    public static UserDtoBuilder builder(String email, String password, String nickname, String name) {
        return new UserDtoBuilder(email, password, nickname, name);
    }

    public static UserDtoBuilder builder() {
        return new UserDtoBuilder();
    }

    public static class UserDtoBuilder {
        private final UserDto userDto;

        public UserDtoBuilder() {
            userDto = new UserDto();
        }

        private UserDtoBuilder(String email, String password, String nickname, String name) {
            userDto = new UserDto(email, password, nickname, name);
        }

        public UserDtoBuilder withId(long id) {
            userDto.id = id;
            return this;
        }

        public UserDtoBuilder withEmail(String email) {
            userDto.email = email;
            return this;
        }

        public UserDtoBuilder withPassword(String password) {
            userDto.password = password;
            return this;
        }

        public UserDtoBuilder withNickname(String nickname) {
            userDto.nickname = nickname;
            return this;
        }

        public UserDtoBuilder withName(String name) {
            userDto.name = name;
            return this;
        }

        public UserDtoBuilder withCity(String city) {
            userDto.city = city;
            return this;
        }

        public UserDtoBuilder withType(String type) {
            userDto.type = type;
            return this;
        }

        public UserDtoBuilder withSearching(String searching) {
            userDto.searching = searching;
            return this;
        }

        public UserDtoBuilder withGenre(String genre) {
            userDto.genre = genre;
            return this;
        }

        public UserDtoBuilder withDescription(String description) {
            userDto.description = description;
            return this;
        }

        public UserDtoBuilder withState(String state) {
            userDto.state = state;
            return this;
        }

        public UserDto build() {
            return userDto;
        }
    }
}
