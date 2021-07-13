package g.gitops.poc.infrastructure.common.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class JacksonToObject implements Text2ObjectInterface {
    @Override
    public Object toObject(String text, Class clz) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Object obj = mapper.readValue(text, clz);

        return obj;
    }
}
