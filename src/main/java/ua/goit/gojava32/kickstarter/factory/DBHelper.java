package ua.goit.gojava32.kickstarter.factory;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import ua.goit.gojava32.kickstarter.dao.ImageDAOImpl;
import ua.goit.gojava32.kickstarter.dao.ProjectDAOImpl;
import ua.goit.gojava32.kickstarter.model.Image;
import ua.goit.gojava32.kickstarter.model.Project;
import ua.goit.gojava32.kickstarter.service.ImageService;
import ua.goit.gojava32.kickstarter.service.ProjectService;

import java.io.*;
import java.sql.*;

public class DBHelper {
  public static final String CREATE_TABLES_FILENAME = "/sql/createTables.sql";
  public static final String DROP_TABLES_FILENAME = "/sql/dropTables.sql";
  public static final String INSERT_DATA_FILENAME = "/sql/insertData.sql";
  public static final String TEST_IMAGE_FILENAME = "/images/medicine1.sql";

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
      //saveImageToDatabase(TEST_IMAGE_FILENAME);
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

  /*private void saveImageToDatabase(String filename) {
    File file = new File(filename);
    Project project = new ProjectDAOImpl().get(1);
    byte[] bFile = new byte[(int) file.length()];
    try (FileInputStream fis = new FileInputStream(filename)) {
      fis.read(bFile);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    Image image = FactoryModel.createImage(1, project, bFile);
    new ImageDAOImpl().add(image);
  }*/

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
