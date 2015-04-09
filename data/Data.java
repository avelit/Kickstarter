package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Data {
 
  private Map<String, List<String>> projects = new HashMap<String,List<String>>() {
      private static final long serialVersionUID = 4630444610336634592L;

      {
        List<String> listMusic = new ArrayList<>();
        Collections.addAll(listMusic, "guitar","baraban");
        put("music",listMusic);

        List<String> listMedicine = new ArrayList<>();
        Collections.addAll(listMedicine, "heart","knee","head");
        put("medicine",listMedicine);
      }

    };
    
    public List<String> getListByCategory(String category){
      return projects.get(category);
    }

    public Set<String> getListOfCategories() {
      return projects.keySet();
    }
}
