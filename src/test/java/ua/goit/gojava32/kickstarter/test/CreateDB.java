package ua.goit.gojava32.kickstarter.test;

import ua.goit.gojava32.kickstarter.factory.DBHelper;

public class CreateDB {
  public static void main(String[] args) {
      DBHelper dbHelper = new DBHelper();
      dbHelper.initDatabase();
  }
}
