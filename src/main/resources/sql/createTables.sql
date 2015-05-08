CREATE TABLE IF NOT EXISTS categories
(
  id          INTEGER PRIMARY KEY AUTOINCREMENT,
  name        TEXT,
  description TEXT
);

CREATE TABLE IF NOT EXISTS projects
(
  id          INTEGER PRIMARY KEY AUTOINCREMENT,
  name        TEXT,
  id_category INTEGER,
  id_author   INTEGER,
  description TEXT,
  moneyNeed   INTEGER,
  moneyHas    INTEGER,
  video       TEXT,
  FOREIGN KEY (id_author) REFERENCES users (id),
  FOREIGN KEY (id_category) REFERENCES categories (id)
);

CREATE TABLE IF NOT EXISTS comments
(
  id         INTEGER PRIMARY KEY AUTOINCREMENT,
  author     TEXT,
  id_project INTEGER,
  comment    TEXT,
  created    DATE,
  FOREIGN KEY (id_project) REFERENCES projects (id)
);

CREATE TABLE IF NOT EXISTS blogs
(
  id         INTEGER PRIMARY KEY AUTOINCREMENT,
  author     TEXT,
  id_project INTEGER,
  comment    TEXT,
  created    DATE,
  FOREIGN KEY (id_project) REFERENCES projects (id)
);

CREATE TABLE IF NOT EXISTS users
(
  id      INTEGER PRIMARY KEY AUTOINCREMENT,
  name    TEXT,
  token   TEXT,
  email   TEXT,
  comment TEXT,
  active  INTEGER
);
