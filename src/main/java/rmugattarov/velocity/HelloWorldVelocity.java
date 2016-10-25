package rmugattarov.velocity;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.StringWriter;

/**
 * Created by rmugattarov on 25.10.2016.
 */
public class HelloWorldVelocity {
    public static void main(String[] args) {
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());

        velocityEngine.init();
        Template template = velocityEngine.getTemplate("hello-world.vm");
        VelocityContext velocityContext = new VelocityContext();

        velocityContext.put("msg", "FU");

        StringWriter stringWriter = new StringWriter();
        template.merge(velocityContext, stringWriter);
        System.out.println(stringWriter.toString());
    }
}
