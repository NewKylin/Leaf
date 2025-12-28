package com.sankuai.inf.leaf.snowflake;

import com.sankuai.inf.leaf.IDGen;
import com.sankuai.inf.leaf.common.PropertyFactory;
import com.sankuai.inf.leaf.common.Result;
import org.junit.Test;

import java.util.Properties;

public class SnowflakeIDGenImplTest {
    @Test
    public void testGetId() throws Exception {
        Properties properties = PropertyFactory.getProperties();

        IDGen idGen = new SnowflakeIDGenImpl(properties.getProperty("leaf.zk.list"), 8080);
        long start = System.currentTimeMillis();
        for (int i = 1; i < 100; ++i) {
            Result r = idGen.get("a");
            Thread.sleep(2);
            System.out.println(r);
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start));
    }
}
