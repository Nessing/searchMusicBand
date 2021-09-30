CREATE TABLE users (
    id          bigserial primary key,
    email       varchar(255) not null,
    password    varchar(255) not null,
    name        varchar(255) not null,
    city        varchar(50),
    type        varchar(50),
    searching   varchar(50),
    genre       varchar(255),
    description       varchar(255)
);

INSERT INTO users (email, password, name, city, type, searching, genre, description)
VALUES
       ('techno42@mail.com', 'itkrhjfd', 'Hank', 'Владивосток', 'piano', 'band', 'поп-рок', 'Закончил музыкальную школу по классу фортепиано. Ищу группу');