package com.ecovacs.test;

import com.ecovacs.test.common.Common;
import io.appium.java_client.ios.IOSDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by ecosqa on 17/2/7.
 * test translate of intl app
 */
public class TestIntlTranslate_debug {
    private IOSDriver driver = null;

    @BeforeClass
    public void setUp(){
        driver = Common.getInstance().getDriver();
        if(driver == null){
            return;
        }
        HandleIntl.getInstance().init(driver);
        HandleIntl.getInstance().translate_init("English");
        HandleIntl.getInstance().translateErrorReport_init();
    }

    @AfterClass
    public void tearDown(){
        //HandleDM80i.getInstance().changeLanguage(PropertyData.getProperty("French"));
        //driver.quit();
    }

    @Test(priority = 1)
    public void translateMain(){
        Assert.assertTrue(HandleIntl.getInstance().translateMain());
    }

    @Test(priority = 2)
    public void translateSwitchWLAN(){
        Assert.assertTrue(HandleIntl.getInstance().translateSwitchWLAN());
    }

    @Test(enabled = false, priority = 3)
    public void translateFailNetworkSetting(){
        Assert.assertTrue(HandleIntl.getInstance().translateFailNetworkSetting());
    }


}
