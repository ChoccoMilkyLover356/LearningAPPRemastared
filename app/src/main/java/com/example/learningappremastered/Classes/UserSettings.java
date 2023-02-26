package com.example.learningappremastered.Classes;

import android.app.Application;

public class UserSettings extends Application
{
    public static final String PREFERENCES_C = "preferences";
    public static final String PREFERENCES_M = "preferences";
    public static final String PREFERENCES_D = "preferences";
    public static final String CUSTOM_VISIBILITY_C = "customVisibilityC";
    public static final String VISIBILITY_TRUE_C = "visibilityTrueC";
    public static final String VISIBILITY_FALSE_C = "visibilityFalseC";
    public static final String CUSTOM_VISIBILITY_M = "customVisibilityM";
    public static final String VISIBILITY_TRUE_M = "visibilityTrueM";
    public static final String VISIBILITY_FALSE_M = "visibilityFalseM";
    public static final String CUSTOM_VISIBILITY_D = "customVisibilityD";
    public static final String VISIBILITY_TRUE_D = "visibilityTrueD";
    public static final String VISIBILITY_FALSE_D = "visibilityFalseD";

    private String customVisibilityC;
    private String customVisibilityM;
    private String customVisibilityD;

    public String getCustomVisibilityM() {
        return customVisibilityM;
    }

    public void setCustomVisibilityM(String customVisibilityM) {
        this.customVisibilityM = customVisibilityM;
    }

    public String getCustomVisibilityD() {
        return customVisibilityD;
    }

    public void setCustomVisibilityD(String customVisibilityD) {
        this.customVisibilityD = customVisibilityD;
    }

    public String getCustomVisibilityC() {
        return customVisibilityC;
    }

    public void setCustomVisibilityC(String customVisibility) {
        this.customVisibilityC = customVisibility;
    }

}
