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
  picture     BLOB,
  video       TEXT,
  FOREIGN KEY (id_author) REFERENCES users (id),
  FOREIGN KEY (id_category) REFERENCES categories (id)
);

CREATE TABLE IF NOT EXISTS comments
(
  id         INTEGER PRIMARY KEY AUTOINCREMENT,
  author     TEXT,
  id_project INTEGER,
  text    TEXT,
  created    DATE,
  FOREIGN KEY (id_project) REFERENCES projects (id)
);

CREATE TABLE IF NOT EXISTS blogs
(
  id         INTEGER PRIMARY KEY AUTOINCREMENT,
  author     TEXT,
  id_project INTEGER,
  text    TEXT,
  created    DATE,
  FOREIGN KEY (id_project) REFERENCES projects (id)
);

CREATE TABLE IF NOT EXISTS users
(
  id      INTEGER PRIMARY KEY AUTOINCREMENT,
  name    TEXT,
  password   TEXT,
  email   TEXT,
  active  INTEGER
);

CREATE TABLE IF NOT EXISTS persistent_logins (
    username VARCHAR(64) NOT NULL,
    series VARCHAR(64) NOT NULL,
    token VARCHAR(64) NOT NULL,
    last_used TIMESTAMP NOT NULL,
    PRIMARY KEY (series)
);

CREATE TABLE IF NOT EXISTS pictures
(
  id          INTEGER PRIMARY KEY AUTOINCREMENT,
  id_project  INTEGER,
  picture     BLOB,
  FOREIGN KEY (id_project) REFERENCES projects (id)
);
