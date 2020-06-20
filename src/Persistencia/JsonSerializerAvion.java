package Persistencia;

import Modelo.Avion;
import Modelo.Bronze;
import Modelo.Gold;
import Modelo.Silver;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class JsonSerializerAvion implements JsonSerializer<ArrayList<Avion>> {

    private static Map<String,Class> map = new TreeMap<String,Class>();

    static {
        map.put("Gold", Gold.class);
        map.put("Silver", Silver.class);
        map.put("Bronze", Bronze.class);
    }
    @Override
    public JsonElement serialize(ArrayList<Avion> avions, Type type, JsonSerializationContext jsonSerializationContext) {
        if(avions == null){
            return null;
        }
        else{
            JsonArray jsonArray = new JsonArray();
            for(Avion avion: avions){
                Class c = map.get(avion.getTypeName());
                if(c == null){
                    throw new RuntimeException("Unknown class: " + avion.getTypeName());
                }
                jsonArray.add(jsonSerializationContext.serialize(avion,c));
            }
            return jsonArray;
        }
    }
}
