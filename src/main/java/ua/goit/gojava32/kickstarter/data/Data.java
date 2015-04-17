package ua.goit.gojava32.kickstarter.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;

public class Data {
 
  public static Map<Category, List<Project>> projects = new HashMap<Category, List<Project>>() {
      private static final long serialVersionUID = 4630444610336634592L;

      {
        List<Project> listMusic = new ArrayList<>();
        Collections.addAll(listMusic, new Project(1,"guitar"),new Project(2,"baraban"));
        put(new Category(1, "music"),listMusic);

        List<Project> listMedicine = new ArrayList<>();
        Collections.addAll(listMedicine, new Project(3,"heart"),new Project(4,"knee"),new Project(5,"head"),new Project(6,"arm"),new Project(7,"leg"));
        put(new Category(2, "medicine"),listMedicine);
      }
    };
    
}
