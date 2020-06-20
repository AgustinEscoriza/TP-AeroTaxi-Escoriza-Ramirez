package Persistencia;


import com.google.gson.*;

import java.lang.reflect.Type;

import static java.lang.Class.forName;

public class JsonDeserializerAvion<T> implements com.google.gson.JsonDeserializer {
    @Override
    public Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonPrimitive classNamePrimitive = (JsonPrimitive) jsonObject.get("type");

        String nombreDeClase = classNamePrimitive.getAsString();

        Class<?> clazz;
        try{
            clazz = Class.forName(nombreDeClase);
        } catch(ClassNotFoundException e){
            throw new JsonParseException(e.getMessage());
        }
        return jsonDeserializationContext.deserialize(jsonObject, clazz);
    }
}
