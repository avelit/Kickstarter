package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {
    private Map<String, List<String>> projects = new HashMap<String,List<String>>() {
      {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "guitar","baraban");
        put("music",list);

        list.clear();
        Collections.addAll(list, "heart","knee","head");
        put("medicine",list);
      }
    };
    
    public Map<String, List<String>> getMap(){
      return projects;
    }
}
