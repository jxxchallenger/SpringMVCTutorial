package io.jxxchallenger.spring.resource;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
/**
 * <a herf="https://blog.csdn.net/jxchallenger/article/details/103107512">深扒XmlWebApplicatioContext是如何解析contextConfigLocation中包含通配符(Ant-style)配置文件</a>
 * @author Chen
 *
 */
public class AntStyleResourceResolverTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AntStyleResourceResolverTest.class);
    
    @Test
    public void test() {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            Resource[] resources = resolver.getResources("classpath:com/hkbea/spring/ApplicationContext-*.xml");
            LOGGER.info("size: " + resources.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
