package com.cjlu.warehouse_manage;


import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;


@SpringBootTest
class WarehouseManageApplicationTests {



    @Test
    public void contextLoads(){
        String userDir = System.getProperties().getProperty("user.dir");
        String fileSeparator = File.separator;
        System.out.println(fileSeparator);
        System.out.println(userDir);
    }

}
