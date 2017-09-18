package com.kbop;

import com.kbop.config.DataConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by WallaceTang on 2017/5/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataConfig.class})
//@ActiveProfiles("dev")
public class BaseTest {
//    @Autowired
//    Environment environment;
//    @Autowired
//    DataSource dataSource;


//    @Test
//    public void envtest() {
//        String s = Arrays.toString(environment.getActiveProfiles());
//        System.out.println(s);
//
//        try {
//            System.out.println(dataSource.getConnection().getMetaData().getURL());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//
//        }
//    }

}
