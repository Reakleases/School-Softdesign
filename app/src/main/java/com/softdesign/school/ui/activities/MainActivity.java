package com.softdesign.school.ui.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
import com.softdesign.school.ui.fragments.ContactsFragmentAdd;
import com.softdesign.school.ui.fragments.ProfileFragment;
import com.softdesign.school.ui.fragments.SettingFragment;
import com.softdesign.school.ui.fragments.TasksFragment;
import com.softdesign.school.ui.fragments.TeamFragment;
import com.softdesign.school.ui.fragments.TeamFragmentAdd;
import com.softdesign.school.utils.BlockToolbar;
import com.softdesign.school.utils.ConstantManager;
import com.softdesign.school.utils.Lg;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolBar;
    @Bind(R.id.navigation_drawer)
    DrawerLayout mNavigationDrawer;
    @Bind(R.id.navigation_view)
    NavigationView mNavigationView;
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbar;
    @Bind(R.id.appbar_layout)
    AppBarLayout mAppBar;
    @Bind(R.id.fab)
    FloatingActionButton mFloatingActionButton;

    private FragmentManager mFragmentManager;
    private Fragment mFragment;
    private String mFragmentTag = null;
    private ActionBar mActionBar;
    public AppBarLayout.LayoutParams params = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Lg.e(this.getLocalClassName(), "========================\non Create");

        ButterKnife.bind(this);
        //для обращения к элементам NavigationView
        View mHeaderLayout = mNavigationView.getHeaderView(0);
        mFragmentManager = getSupportFragmentManager();


        fabClick();
        getNewToolbar();
        setupToolbar();
        setupDrawer();

        //задаем отступ в NavigationDrawer для того, чтобы элементы не уходили под StatuBar
        //и не делаем отступ в версии андроида < 5.0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mHeaderLayout.setPadding(0, getStatusBarHeight(), 0, 0);
        }


        if (savedInstanceState == null) {
            Lg.e ("MainActivity","savedInstanceState=null");
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                Lg.e ("MainActivity"," extras != null");
                String tag = extras.getString(ConstantManager.ACTIVITY_TAG);
                if (tag != null) {
                    Lg.e ("MainActivity","getting tag "+tag);
                    mFragmentTag = tag;
                } else {
                    Lg.e("MainActivity", " corrupted tag");
                    mFragmentTag = ConstantManager.FRAGMENT_TAG_PROFILE;
                }
            } else {
                Lg.e("MainActivity", " tag and extras = null");
                mFragmentTag = ConstantManager.FRAGMENT_TAG_PROFILE;
            }
            mFragment = fragmentInstanceByTag(mFragmentTag);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_frame_container, mFragment, mFragmentTag)
                    .commit();
        }
    }

    private void fabClick() {

        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
                LockToolBar();
            }
        });
    }


    /**
     * Метод для инициализации своего кастомного ToolBar
     */
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
            mActionBar.setHomeAsUpIndicator(R.drawable.ic_menu_24dp);  // задает иконку
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
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Lg.e(this.getLocalClassName(), "data was restored");
    }


    /**
    * Инициализация NavigationDrawer
    */
    private void setupDrawer() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.drawer_profile:
                        mFragmentTag = ConstantManager.FRAGMENT_TAG_PROFILE;
                        clickMenu(false, mFragmentTag);
                        break;
                    case R.id.drawer_contacts:
                        mFragmentTag = ConstantManager.FRAGMENT_TAG_CONTACTS_ADD;
                        clickMenu(true, mFragmentTag);
                        break;
                    case R.id.drawer_team:
                        mFragmentTag = ConstantManager.FRAGMENT_TAG_TEAM_ADD;
                        clickMenu(true, mFragmentTag);
                        break;
                    case R.id.drawer_tasks:
                        mFragmentTag = ConstantManager.FRAGMENT_TAG_TASKS;
                        clickMenu(false, mFragmentTag);

                        break;
                    case R.id.drawer_settings:
                        mFragmentTag = ConstantManager.FRAGMENT_TAG_SETTINGS;
                        clickMenu(false, mFragmentTag);

                        break;
                }
                mNavigationDrawer.closeDrawers();
                return false;
            }
        });

    }

    /**
     *
     * @param activity если true, запускаем другой активити
     * @param tag тэг по которому определиться фрагмент, или же если
     *            activity = false, то передадим тэг фрагменту другому активити
     */
    private void clickMenu (boolean activity, String tag) {

        if (activity) {
            Intent intent = new Intent(MainActivity.this, TeamActivity.class);
            intent.putExtra(ConstantManager.ACTIVITY_TAG,tag);
            startActivity(intent);
            finish();
        } else {
            mFragment = fragmentInstanceByTag(tag);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_frame_container, mFragment, tag)
                    .addToBackStack(tag)
                    .commit();
        }

    }

    /**
     * Создаем фрагмент по его тегу
     *
     * @param mFragmentTag - тег фрагмента
     * @return фрагмент
     */
    private Fragment fragmentInstanceByTag(String mFragmentTag) {

        Fragment newFragment;
        switch (mFragmentTag) {
            case ConstantManager.FRAGMENT_TAG_PROFILE:
                newFragment = mFragmentManager.findFragmentByTag(mFragmentTag);
                if (newFragment == null) {
                    newFragment = new ProfileFragment();
                }
                break;
            case ConstantManager.FRAGMENT_TAG_CONTACTS:
                newFragment = mFragmentManager.findFragmentByTag(mFragmentTag);
                if (newFragment == null) {
                    newFragment = new ContactsFragment();
                }
                break;
            case ConstantManager.FRAGMENT_TAG_TEAM:
                newFragment = mFragmentManager.findFragmentByTag(mFragmentTag);
                if (newFragment == null) {
                    newFragment = new TeamFragment();
                }
                break;
            case ConstantManager.FRAGMENT_TAG_SETTINGS:
                newFragment = mFragmentManager.findFragmentByTag(mFragmentTag);
                if (newFragment == null) {
                    newFragment = new SettingFragment();
                }
                break;
            case ConstantManager.FRAGMENT_TAG_TASKS:
                newFragment = mFragmentManager.findFragmentByTag(mFragmentTag);
                if (newFragment == null) {
                    newFragment = new TasksFragment();
                }
                break;
            case ConstantManager.FRAGMENT_TAG_CONTACTS_ADD:
                newFragment = mFragmentManager.findFragmentByTag(mFragmentTag);
                if (newFragment == null) {
                    newFragment = new ContactsFragmentAdd();
                }
                break;
            case ConstantManager.FRAGMENT_TAG_TEAM_ADD:
                newFragment = mFragmentManager.findFragmentByTag(mFragmentTag);
                if (newFragment == null) {
                    newFragment = new TeamFragmentAdd();
                }
                break;
            default:
                newFragment = new ProfileFragment();
                break;
        }
        return newFragment;
    }

    // методы переопределяющие события по клику назад, чтобы закрыть Navigation View, если он открыт
    @Override
    public void onBackPressed() {
        if (isNavDrawerOpen()) {
            closeNavDrawer();
        } else {
            super.onBackPressed();
        }
    }

    protected boolean isNavDrawerOpen() {
        return mNavigationDrawer != null && mNavigationDrawer.isDrawerOpen(GravityCompat.START);
    }

    protected void closeNavDrawer() {
        if (mNavigationDrawer != null) {
            mNavigationDrawer.closeDrawer(GravityCompat.START);
        }
    }


    /**
     * Метод отмечающий элемент в меню
     *
     * @param id идентификатор пукнта меню
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
        Lg.e ("collapseAppBar", "calling method");
        if (collapse) {
            UnLockToolBar();
            AppBarLayout.OnOffsetChangedListener mListener = new AppBarLayout.OnOffsetChangedListener() {
                @Override
                public void onOffsetChanged(AppBarLayout mAppBar, int verticalOffset) {
                    if (mCollapsingToolbar.getHeight() + verticalOffset <= ViewCompat.getMinimumHeight(mCollapsingToolbar) + getStatusBarHeight()) {
                        mAppBar.removeOnOffsetChangedListener(this);
                        LockToolBar();
                        BlockToolbar.setDrag(false, mAppBar);
                    }
                }
            };
            mAppBar.addOnOffsetChangedListener(mListener);
            mAppBar.setExpanded(false);
            BlockToolbar.setDrag(false, mAppBar);

        } else {
            UnLockToolBar();
            mAppBar.setExpanded(true);
            BlockToolbar.setDrag(true, mAppBar);
        }
    }

    /**
     * Снимает блокировку с ToolBar выставляя scrollFlag
     */
    private void LockToolBar() {
        Lg.e("lock", "got locked");
        params.setScrollFlags(0);
        mCollapsingToolbar.setLayoutParams(params);
    }

    /**
     * Блокирует ToolBar выставляя scrollFlag
     */
    private void UnLockToolBar() {
        params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL |
                AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED |
                AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP);
        mCollapsingToolbar.setLayoutParams(params);
    }
}

