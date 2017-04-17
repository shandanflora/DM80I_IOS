package com.ecovacs.test.activity;

import com.ecovacs.test.common.TranslateErrorReport;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

/**
 * Created by ecosqa on 17/2/17.
 * work log activity
 */
public class WorkLogActivity {
    private static WorkLogActivity workLogActivity = null;

    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]")
    private MobileElement title = null;
    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]")
    private MobileElement back = null;
    /*@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]")
    private MobileElement timeTotal = null;*/
    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]")
    private MobileElement timeTips = null;
    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[1]/UIAStaticText[1]")
    private MobileElement cleanHistory = null;

    private WorkLogActivity(){

    }

    public static WorkLogActivity getInstance(){
        if(workLogActivity == null){
            workLogActivity = new WorkLogActivity();
        }
        return workLogActivity;
    }

    public void init(IOSDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickBack(){
        back.click();
    }

    private boolean staticUITranslation(Map<String, String> tranMap){
        String strLanguage = tranMap.get("language");
        boolean btitle = title.getText().equalsIgnoreCase(tranMap.get("random_deebot_work_log"));
        if (!btitle){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Work log", title.getText(),
                    tranMap.get("random_deebot_work_log"), "fail");
        }
        boolean btimeTips = timeTips.getText().equalsIgnoreCase(tranMap.get("random_deebot_time_all"));
        if (!btimeTips){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Work log", timeTips.getText(),
                    tranMap.get("random_deebot_time_all"), "fail");
        }
        boolean bcleanHistory = cleanHistory.getText().equalsIgnoreCase(tranMap.get("random_deebot_work_log1"));
        if (!bcleanHistory){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Work log", cleanHistory.getText(),
                    tranMap.get("random_deebot_work_log1"), "fail");
        }
        return btitle && btimeTips && bcleanHistory;
    }

    public boolean translate(Map<String, String> tranMap){
        return staticUITranslation(tranMap);
    }

}
