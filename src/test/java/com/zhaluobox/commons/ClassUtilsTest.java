package com.zhaluobox.commons;

import com.zhaluobox.designMode.factorymode2.Human;
import org.junit.Test;

import java.util.List;

public class ClassUtilsTest {

    @Test
    public void getAllClassByInterface() {

        List<Class> allClassByInterface = ClassUtils.getAllClassByInterface(Human.class);
//        List<Class> allClassByInterface = ClassUtils.getAllClassByInterface(Map.class);
        allClassByInterface.forEach(t->{
            System.out.println(t.getName());
        });

    }

    @Test
    public void testPackageName(){

    }
}