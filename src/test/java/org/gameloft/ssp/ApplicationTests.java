package org.gameloft.ssp;

import config.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by apple on 16/9/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SspApplicationTestConfig.class)
public class ApplicationTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }
}
