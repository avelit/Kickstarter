INSERT INTO categories (id, name, description) VALUES (1, 'Music', 'desc Music');
INSERT INTO categories (id, name, description) VALUES (2, 'Medicine', 'desc Medicine');
INSERT INTO categories (id, name, description) VALUES (45, 'Tech', 'test description');
INSERT INTO categories (id, name, description) VALUES (46, 'Food', 'food desc');


INSERT INTO projects (id, name, id_category, id_author, description) VALUES (1, 'project 1', 1, 1, 'bla-bla-bla-bla-bla-bla-bla-bla-bla-bla-bla-bla-bla-');
INSERT INTO projects (id, name, id_category, id_author, description) VALUES (22, 'testproject 2', 1, 1, 'test description');

INSERT INTO blogs (id, author, id_project, text, created) VALUES (1, '1', 1, 'blablabla_blog', '1430946000000');