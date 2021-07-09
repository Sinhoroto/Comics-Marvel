CREATE TABLE user_comic (
user_id bigint not null,
comic_id int not null,

FOREIGN KEY (user_id) REFERENCES user(id),
FOREIGN KEY (comic_id) REFERENCES Comic(id)
);
