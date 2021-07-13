package g.gitops.poc.infrastructure.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class JsonUtil {
    public static <T> T mapToObject(Map<String,Object> map,Class<T> clazz){
        ObjectMapper mapper = new ObjectMapper();
        T obj = mapper.convertValue(map,clazz);
        return obj;
    }

    public static Map<String,Object> objectToMap(Object obj){
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(obj,Map.class);
    }

    public static String toMessage(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibilityChecker(mapper.getVisibilityChecker().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
        //mapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        return mapper.writeValueAsString(obj);
    }

    public static Map<String,Object> toMap(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> obj = mapper.readValue(json,Map.class);
        return obj;
    }
}
