package ua.goit.gojava32.kickstarter.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;

public class Data {
 
  public static Map<Category, List<Project>> projects = new HashMap<Category, List<Project>>() {
      private static final long serialVersionUID = 4630444610336634592L;

      {
        Category categoryMusic = new Category(1, "music");
        List<Project> listMusic = new ArrayList<>();
        Collections.addAll(listMusic, new Project(1,"guitar",categoryMusic),new Project(2,"baraban",categoryMusic));
        categoryMusic.setProjects(listMusic);
        put(categoryMusic,listMusic);

        Category categoryMedicine = new Category(1, "medicine");
        List<Project> listMedicine = new ArrayList<>();
        Collections.addAll(listMedicine, new Project(3,"heart",categoryMedicine),new Project(4,"knee",categoryMedicine),new Project(5,"head",categoryMedicine),new Project(6,"arm",categoryMedicine),new Project(7,"leg",categoryMedicine));
        categoryMedicine.setProjects(listMedicine);
        put(categoryMedicine,listMedicine);
      }
    };
    
}
