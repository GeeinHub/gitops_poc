package g.gitops.poc.infrastructure.common.event;

public interface Text2ObjectInterface {

    Object toObject(String text, Class clz) throws Exception;
}
