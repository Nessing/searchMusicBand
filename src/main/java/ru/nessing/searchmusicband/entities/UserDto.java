package ru.nessing.searchmusicband.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private long id;
    private String email;
    private String password;
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
        this.name = user.getName();
        this.city = user.getCity();
        this.type = user.getType();
        this.searching = user.getSearching();
        this.genre = user.getGenre();
        this.description = user.getDescription();
        this.state = user.getState();
    }

    public UserDto(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public static UserDtoBuilder builder(String email, String password, String name) {
        return new UserDtoBuilder(email, password, name);
    }

    public static class UserDtoBuilder {
        private final UserDto userDto;

        private UserDtoBuilder(String email, String password, String name) {
            userDto = new UserDto(email, password, name);
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
