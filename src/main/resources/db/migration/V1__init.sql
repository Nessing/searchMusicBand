CREATE TABLE search (
   id              bigserial primary key,
   searching       varchar(20)
);

INSERT INTO search (searching) VALUES ('band'), ('musician');

CREATE TABLE states (
    id              bigserial primary key,
    state           varchar(20)
);

INSERT INTO states (state) VALUES ('public'), ('private');

CREATE TABLE users (
    id              bigserial primary key,
    email           varchar(255) not null,
    password        varchar(255) not null,
    nickname        varchar(100) not null,
    name            varchar(255) not null,
    city            varchar(50),
    type            varchar(100),
    searching       int REFERENCES search(id),
    genre           varchar(255),
    description     varchar(255),
    state           int REFERENCES states(id)
);

INSERT INTO users (email, password, nickname, name, city, type, searching, genre, description, state)
VALUES
       ('techno42@mail.com', 'itkrhjfd', 'tehnar', 'Hank', 'Владивосток', 'piano', 1, 'поп-рок', 'Закончил музыкальную школу по классу фортепиано. Ищу группу', 1),
       ('bandEffect@mail.com', '45712', 'Effect_group', 'Effect', 'Североморск', 'vocal', 2, 'альтернативный рок', 'Мы группа Effect. Ищем вокалиста, владеющего техникой расщипления', 1),
       ('metaller@mail.com', 'jth324', 'metalRock97', 'John', 'Мурманск', 'guitar', 1, 'метал-рок', 'Самостоятельно изучал гитару. Ищу метал группу', 2);
