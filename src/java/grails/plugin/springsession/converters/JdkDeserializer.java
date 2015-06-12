package grails.plugin.springsession.converters;

import org.springframework.core.serializer.Deserializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

/**
 * Created by jitendra on 28/5/15.
 */
public class JdkDeserializer implements Deserializer<Object> {

    private ClassLoader classLoader;
    private Boolean instantiate;

    public JdkDeserializer(ClassLoader classLoader, Boolean instantiate) {
        this.classLoader = classLoader;
        this.instantiate = instantiate;
    }

    @Override
    public Object deserialize(InputStream inputStream) throws IOException {
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream) {
            @Override
            protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
                try {
                    return Class.forName(desc.getName(), instantiate, classLoader);
                } catch (ClassNotFoundException cnfex) {
                    try {
                        return super.resolveClass(desc);
                    } catch (ClassNotFoundException cnfex1) {
                        throw cnfex1;
                    }
                }
            }
        };
        try {
            return objectInputStream.readObject();
        } catch (ClassNotFoundException cnfex) {
            return null;
        }
    }
}