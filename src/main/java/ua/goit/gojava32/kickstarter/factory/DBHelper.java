package ua.goit.gojava32.kickstarter.factory;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;


public class DBHelper {
  public static final String CREATE_TABLES_FILENAME = "/sql/createTables.sql";
  public static final String DROP_TABLES_FILENAME = "/sql/dropTables.sql";
  public static final String INSERT_DATA_FILENAME = "/sql/insertData.sql";

  Connection connection;

  public static void main(String[] args) {
    DBHelper dbHelper = new DBHelper();
    dbHelper.initDatabase();
  }

  public void initDatabase() {

    final String CONNECTION_STRING = "jdbc:sqlite:kickstarter.db";
    try {
      connection = DriverManager.getConnection(CONNECTION_STRING);
      executeQueryFromFile(DROP_TABLES_FILENAME);
      executeQueryFromFile(CREATE_TABLES_FILENAME);
      executeQueryFromFile(INSERT_DATA_FILENAME);
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }

  private void executeQueryFromFile(String filename) {
    InputStream input = this.getClass().getResourceAsStream(filename);
    if (input == null) {
      throw new RuntimeException("Cannot read file: " + filename);
    }
    String query = getStringFromInputStream(input);
    executeUpdate(query);
    Logger logger = Logger.getLogger(this.getClass());
    logger.info("query:"+ query);

    try {
      input.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  private static String getStringFromInputStream(InputStream is) {

    BufferedReader br = null;
    StringBuilder sb = new StringBuilder();

    String line;
    try {

      br = new BufferedReader(new InputStreamReader(is));
      while ((line = br.readLine()) != null) {
        sb.append(line);
      }

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

    return sb.toString();

  }

  public ResultSet executeQuery(String query) {


    ResultSet rs;
    try {
      Statement statement = connection.createStatement();
      rs = statement.executeQuery(query);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return rs;
  }

  public int executeUpdate(String query) {
   int rs;
    try {
      Statement statement = connection.createStatement();
      rs = statement.executeUpdate(query);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return rs;
  }

}
