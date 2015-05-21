INSERT INTO categories (id, name, description) VALUES (1, 'Music', 'desc Music');
INSERT INTO categories (id, name, description) VALUES (2, 'Medicine', 'desc Medicine');
INSERT INTO categories (id, name, description) VALUES (45, 'Tech', 'test description');
INSERT INTO categories (id, name, description) VALUES (46, 'Food', 'food desc');


INSERT INTO projects (id, name, id_category, id_author, description, video) VALUES (1, 'project 1', 1, 1, 'bla-bla-bla-bla-bla-bla-bla-bla-bla-bla-bla-bla-bla-', 'https://www.youtube.com/embed/J4L4UQnbjGc');
INSERT INTO projects (id, name, id_category, id_author, description) VALUES (22, 'testproject 2', 1, 1, 'test description');

INSERT INTO blogs (id, author, id_project, text, created) VALUES (1, '1', 1, 'blablabla_blog', '1430946000000');

INSERT INTO users (id, name, password, email, active) VALUES (1, 'test', 'c8837b23ff8aaa8a2dde915473ce0991', 'test@test.mail', 1);