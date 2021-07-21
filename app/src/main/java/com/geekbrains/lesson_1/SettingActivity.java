package com.geekbrains.lesson_1;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SettingActivity extends AppCompatActivity {

    public static final String SETTINGS = "SETTINGS";
    public static final String APP_THEME = "APP_THEME";
    public static final int AppFunnyTheme = 1;
    public static final int AppDarkTheme = 2;
    public static final int Theme_Lesson_1 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int currentThemeCode = getCodeStyle();
        int currentThemeResId = codeStyleToStaleId(currentThemeCode);
        setAppTheme(currentThemeResId);
        setContentView(R.layout.activity_setting);
        initRadioButtons();
    }

    private  int getCodeStyle (){

        SharedPreferences sharedPreferences = getSharedPreferences(SETTINGS, MODE_PRIVATE);
        return sharedPreferences.getInt(APP_THEME,Theme_Lesson_1);
    }

    private void setAppTheme(int codeStyle){

        SharedPreferences sharedPreferences = getSharedPreferences(SETTINGS, MODE_PRIVATE);
        sharedPreferences.edit()
                .putInt(APP_THEME, codeStyle)
                .apply();
    }

    private int codeStyleToStaleId (int codeStyle) {
        switch (codeStyle) {
            case AppFunnyTheme:
                return R.style.FunnyStyle;
            case AppDarkTheme:
                return R.style.DarkStyle;
            case Theme_Lesson_1:
            default:
                return R.style.Theme_Lesson_1;

        }
    }

    public void initRadioButtons(){
        findViewById(R.id.radioButtonLesson1).setOnClickListener(v -> {
            setAppTheme(Theme_Lesson_1);
            recreate();
        });

        findViewById(R.id.radioButtonDark).setOnClickListener(v -> {
            setAppTheme(AppDarkTheme);
            recreate();
        });

        findViewById(R.id.radioButtonFunny).setOnClickListener(v -> {
            setAppTheme(AppFunnyTheme);
            recreate();
        });

    }

}