package com.softdesign.school.ui.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.softdesign.school.R;
import com.softdesign.school.ui.fragments.ContactsFragment;
import com.softdesign.school.ui.fragments.ProfileFragment;
import com.softdesign.school.ui.fragments.SettingFragment;
import com.softdesign.school.ui.fragments.TasksFragment;
import com.softdesign.school.ui.fragments.TeamFragment;
import com.softdesign.school.utils.Lg;


public class MainActivity extends AppCompatActivity {


    private Toolbar mToolBar;
    private ActionBar mActionBar;

    private NavigationView mNavigationView;
    private DrawerLayout mNavigationDrawer;

    private Fragment mFragment;

    public AppBarLayout mAppBar;
    public CollapsingToolbarLayout mCollapsingToolbar;
    public AppBarLayout.LayoutParams params = null;

    private FloatingActionButton mFloatingActionButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setTitle("School custom bars");
        Lg.e(this.getLocalClassName(), "========================\non Create");

        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        mNavigationDrawer = (DrawerLayout) findViewById(R.id.navigation_drawer);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mAppBar = (AppBarLayout) findViewById(R.id.appbar_layout);
        mCollapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.fab);






        //для обращения к элементам NavigationView
        View mHeaderLayout = mNavigationView.getHeaderView(0);

        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //getWindow().setStatusBarColor(Color.BLACK);
        }*/




        fabClick();
        getNewToolbar();
        setupToolbar();
        setupDrawer();

        //задаем отступ в NavigationDrawer для того, чтобы элементы не уходили под StatuBar
        //и не делаем отступ в версии андроида < 5.0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mHeaderLayout.setPadding(0, getStatusBarHeight(), 0, 0);
        }


        //первый запуск
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_frame_container, new ProfileFragment())
                    .commit();
        }
    }

    private void fabClick() {
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                collapseAppBar(false);
            }
        });
    }

    /**
     * Метод для инициализации своего кастомного ToolBar
     */
/*    public void setupToolbar() {
        setSupportActionBar(mToolBar);
        ActionBar actionBar = getSupportActionBar();
        params = (AppBarLayout.LayoutParams) mCollapsingToolbar.getLayoutParams();

        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }*/
    public void getNewToolbar() {
        setSupportActionBar(mToolBar);
        mActionBar = getSupportActionBar();
        params = (AppBarLayout.LayoutParams) mCollapsingToolbar.getLayoutParams();
    }


    /**
     * Метод настраивающий кастомный ToolBar
     * добавляет кнопку меню, и задает картинку
     */
    private void setupToolbar() {
        if (mActionBar != null) {
            mActionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);  // задает иконку
            mActionBar.setDisplayHomeAsUpEnabled(true); //картинка с меню (обычно 3 полоски)
        }
    }

    /**
     * Метод определяющий высоту StatusBar
     *
     * @return возвращает значние int
     */
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            mNavigationDrawer.openDrawer(GravityCompat.START);
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
        /*outState.putInt(STATUS_BAR_COLOR, mStatusBarColor);
        outState.putInt(TOOL_BAR_COLOR, mToolBarColor);*/
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Lg.e(this.getLocalClassName(), "data was restored");
        //если есть информация в бандле, достаем и вызываем метод меняющий цвета баров
        if (savedInstanceState != null) {
           /* mStatusBarColor = savedInstanceState.getInt(STATUS_BAR_COLOR);
            mToolBarColor = savedInstanceState.getInt(TOOL_BAR_COLOR);
            setThemeColor(mStatusBarColor, mToolBarColor);*/
        }
    }


    /**
     * Метод меняющий цвета Statusbar и Toolbar, на входе поулчает цвета:
     *
     * @param colorStatusBar цвет статусбара
     * @param colorToolBar   цвет тулбара
     */
    /*private void setThemeColor(int colorStatusBar, int colorToolBar) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(colorStatusBar);
        }
        mActionBar.setBackgroundDrawable(new ColorDrawable(colorToolBar));
    }*/


    /**
     * Инициализация NavigationDrawer
     */
    private void setupDrawer() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.drawer_profile:
                        mFragment = new ProfileFragment();
                        break;
                    case R.id.drawer_contacts:
                        mFragment = new ContactsFragment();
                        break;
                    case R.id.drawer_team:
                        mFragment = new TeamFragment();
                        break;
                    case R.id.drawer_tasks:
                        mFragment = new TasksFragment();
                        break;
                    case R.id.drawer_settings:
                       mFragment = new SettingFragment();
                        break;
                }
                if (mFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_container, mFragment).addToBackStack(mFragment.getClass().getName()).commit();
                }
                mNavigationDrawer.closeDrawers();
                return false;
            }
        });

    }


    /**
     * Метод отмечающий элемент в меню
     *
     * @param id
     */
    public void checkMenu(int id) {
        mNavigationView.getMenu().findItem(id).setChecked(true);
    }

    /**
     * Сворачивает ToolBar
     *
     * @param collapse true - свернуть / false -  развернуть
     */
    public void collapseAppBar(boolean collapse) {
        if (collapse) {
            AppBarLayout.OnOffsetChangedListener mListener = new AppBarLayout.OnOffsetChangedListener() {
                @Override
                public void onOffsetChanged(AppBarLayout mAppBar, int verticalOffset) {
                    if (mCollapsingToolbar.getHeight() + verticalOffset <= ViewCompat.getMinimumHeight(mCollapsingToolbar) + getStatusBarHeight()) {
                        mAppBar.removeOnOffsetChangedListener(this);
                        LockToolBar();
                    }
                }
            };
            mAppBar.addOnOffsetChangedListener(mListener);
            mAppBar.setExpanded(false);
        } else {
            UnLockToolBar();
            mAppBar.setExpanded(true);
        }
    }

    /**
     * Снимает блокировку с ToolBar выставляя scrollFlag
     */
    private void LockToolBar() {
        params.setScrollFlags(0);
        mCollapsingToolbar.setLayoutParams(params);
    }

    /**
     * Блокирует ToolBar выставляя scrollFlag
     */
    private void UnLockToolBar() {
        params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED);
        mCollapsingToolbar.setLayoutParams(params);
    }
}

