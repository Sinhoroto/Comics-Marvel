CREATE TABLE comic_author (
author_id int not null,
comic_id int not null,

FOREIGN KEY (author_id) REFERENCES Author(id),
FOREIGN KEY (comic_id) REFERENCES Comic(id)
);
