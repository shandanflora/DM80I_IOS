package com.ecovacs.test.activity;

import com.ecovacs.test.common.TranslateErrorReport;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

/**
 * Created by ecosqa on 17/3/7.
 *
 */
public class ConsumableActivity {
    private static ConsumableActivity consumableActivity = null;

    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]")
    private MobileElement title = null;
    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]")
    private MobileElement back = null;
    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")
    private MobileElement btnSide = null;
    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[2]")
    private MobileElement btnMain = null;
    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[3]")
    private MobileElement btnFilter = null;
    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAStaticText[1]")
    private MobileElement textRemain = null;
    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAStaticText[6]")
    private MobileElement textViewNote = null;
    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[4]")
    private MobileElement btnReset = null;

    private ConsumableActivity(){

    }

    public static ConsumableActivity getInstance(){
        if (consumableActivity == null){
            consumableActivity = new ConsumableActivity();
        }
        return consumableActivity;
    }

    public void init(IOSDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickBack(){
        back.click();
    }

    private boolean staticUI(Map<String, String> tranMap){
        String strLanguage = tranMap.get("language");
        boolean btitle = title.getText().equalsIgnoreCase(tranMap.get("random_deebot_consumable"));
        if (!btitle){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Consumable", title.getText(),
                    tranMap.get("random_deebot_consumable"), "fail");
        }
        boolean bbtnSide = btnSide.getText().equalsIgnoreCase(tranMap.get("random_deebot_Side_brush_consumables"));
        if (!bbtnSide){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Consumable", btnSide.getText(),
                    tranMap.get("random_deebot_Side_brush_consumables"), "fail");
        }
        boolean bbtnMain = btnMain.getText().equalsIgnoreCase(tranMap.get("random_deebot_ROLLER_consumables"));
        if (!bbtnMain){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Consumable", btnMain.getText(),
                    tranMap.get("random_deebot_ROLLER_consumables"), "fail");
        }
        boolean bbtnFilter = btnFilter.getText().equalsIgnoreCase(tranMap.get("random_deebot_filter"));
        if (!bbtnFilter){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Consumable", btnFilter.getText(),
                    tranMap.get("random_deebot_filter"), "fail");
        }
        boolean btextRemain = textRemain.getText().equalsIgnoreCase(tranMap.get("random_deebot_consumable_remain"));
        if (!btextRemain){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Consumable", textRemain.getText(),
                    tranMap.get("random_deebot_consumable_remain"), "fail");
        }
        boolean btextViewNote = textViewNote.getText().equalsIgnoreCase(tranMap.get("random_deebot_consumable_remain_hint"));
        if (!btextViewNote){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Consumable", textViewNote.getText(),
                    tranMap.get("random_deebot_consumable_remain_hint"), "fail");
        }
        boolean bbtnReset = btnReset.getText().equalsIgnoreCase(tranMap.get("random_deebot_consumable_reset"));
        if (!bbtnReset){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Consumable", btnReset.getText(),
                    tranMap.get("random_deebot_consumable_reset"), "fail");
        }
        return btitle && bbtnSide && bbtnMain &&
                bbtnFilter && btextRemain && btextViewNote &&
                bbtnReset;
    }

    public boolean translate(Map<String, String> tranMap){
        return staticUI(tranMap);
    }
}
