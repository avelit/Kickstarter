package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {
    private Map<String, List<String>> projects = new HashMap<String,List<String>>() {
      {
        List<String> listMusic = new ArrayList<>();
        Collections.addAll(listMusic, "guitar","baraban");
        put("music",listMusic);

        List<String> listMedicine = new ArrayList<>();
        Collections.addAll(listMedicine, "heart","knee","head");
        put("medicine",listMedicine);
      }
    };
    
    public Map<String, List<String>> getMap(){
      return projects;
    }
}
