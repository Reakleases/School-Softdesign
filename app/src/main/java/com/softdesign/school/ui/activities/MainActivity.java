package com.softdesign.school.ui.activities;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.softdesign.school.R;
import com.softdesign.school.utils.Lg;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    public static final String TOOL_BAR_COLOR = "Tool Bar Color";
    public static final String STATUS_BAR_COLOR = "Status Bar Color";
    public static final String VISIBLE_KEY = "visible";

    private int mStatusBarColor;
    private int mToolBarColor;

    private EditText mEditText;
    private CheckBox mCheckBox;
    private Button mButtonBlue;
    private Button mButtonRed;
    private Button mButtonGreen;
    private Toolbar mToolBar;
    private ActionBar mActionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("School custom bars");
        Lg.e(this.getLocalClassName(), "========================\non Create");


        mEditText = (EditText) findViewById(R.id.editText2);

        mCheckBox = (CheckBox) findViewById(R.id.checkBox);
        mCheckBox.setOnClickListener(this);

        mButtonBlue = (Button) findViewById(R.id.btn_blue);
        mButtonBlue.setOnClickListener(this);

        mButtonRed = (Button) findViewById(R.id.btn_red);
        mButtonRed.setOnClickListener(this);

        mButtonGreen = (Button) findViewById(R.id.btn_green);
        mButtonGreen.setOnClickListener(this);

        mToolBar = (Toolbar) findViewById(R.id.toolbar);


        getNewToolBar();
        setupToolBar();


    }

    /**
     * Метод для инициализации своего кастомного тулбара
     */
    private void getNewToolBar() {
        setSupportActionBar(mToolBar);
        mActionBar = getSupportActionBar();
    }


    /**
     * Метод настраивающий кастомный тулбар
     * добавляет кнопку меню, и задает картинку
     */
    private void setupToolBar() {
        if (mActionBar != null) {
            mActionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);  // задает иконку
            mActionBar.setDisplayHomeAsUpEnabled(true); //картинка с меню (обычно 3 полоски)
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Toast.makeText(this, "Click!", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Lg.e(this.getLocalClassName(), "on Start");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Lg.e(this.getLocalClassName(), "on Resume");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Lg.e(this.getLocalClassName(), "on Stop");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Lg.e(this.getLocalClassName(), "on Restart");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Lg.e(this.getLocalClassName(), "on Destroy");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Lg.e(this.getLocalClassName(), "data was saved");
        outState.putInt(STATUS_BAR_COLOR, mStatusBarColor);
        outState.putInt(TOOL_BAR_COLOR, mToolBarColor);
        outState.putBoolean(VISIBLE_KEY, mEditText.getVisibility() == View.VISIBLE);

    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Lg.e(this.getLocalClassName(), "data was restored");
        //если есть информация в бандле, достаем и вызываем метод меняющий цвета баров
        if (savedInstanceState != null) {
            mStatusBarColor = savedInstanceState.getInt(STATUS_BAR_COLOR);
            mToolBarColor = savedInstanceState.getInt(TOOL_BAR_COLOR);
            setThemeColor(mStatusBarColor, mToolBarColor);
            int visibleState = savedInstanceState.getBoolean(VISIBLE_KEY) ? View.VISIBLE : View.INVISIBLE;
            mEditText.setVisibility(visibleState);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.checkBox:
                Toast.makeText(this, "Click!", Toast.LENGTH_SHORT).show();
                if (mCheckBox.isChecked()) {
                    mEditText.setVisibility(View.INVISIBLE);
                } else {
                    mEditText.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.btn_blue:
                mStatusBarColor = ContextCompat.getColor(this, R.color.color_status_bar_blue);
                mToolBarColor = ContextCompat.getColor(this, R.color.color_tool_bar_blue);
                setThemeColor(mStatusBarColor, mToolBarColor);
                break;
            case R.id.btn_red:
                mStatusBarColor = ContextCompat.getColor(this, R.color.color_status_bar_red);
                mToolBarColor = ContextCompat.getColor(this, R.color.color_tool_bar_red);
                setThemeColor(mStatusBarColor, mToolBarColor);
                break;
            case R.id.btn_green:
                mStatusBarColor = ContextCompat.getColor(this, R.color.color_status_bar_green);
                mToolBarColor = ContextCompat.getColor(this, R.color.color_tool_bar_green);
                setThemeColor(mStatusBarColor, mToolBarColor);
                break;
        }
    }

    /**
     * Метод меняющий цвета Statusbar и Toolbar, на входе поулчает цвета:
     *
     * @param colorStatusBar цвет статусбара
     * @param colorToolBar   цвет тулбара
     */
    private void setThemeColor(int colorStatusBar, int colorToolBar) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(colorStatusBar);
        }
        mActionBar.setBackgroundDrawable(new ColorDrawable(colorToolBar));
    }
}

