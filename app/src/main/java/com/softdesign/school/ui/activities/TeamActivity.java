package com.softdesign.school.ui.activities;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.activeandroid.query.Select;
import com.softdesign.school.R;
import com.softdesign.school.data.storage.models.User;
import com.softdesign.school.ui.adapters.UserAdapter;
import com.softdesign.school.ui.fragments.UserFragmentAdd;
import com.softdesign.school.utils.Lg;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TeamActivity extends AppCompatActivity {

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
    @Bind(R.id.btn_add_team)
    Button mBtnAddTeam;
    @Bind(R.id.btn_add_user)
    Button mBtnAddUser;

    public AppBarLayout.LayoutParams params = null;
    private Fragment mFragment;
    private ActionBar mActionBar;
    private DialogFragment mDialogFragment;
    List<User> mUsers;
    UserAdapter userAdapter;
    String[] data = {"one", "two", "three", "four", "five"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        ButterKnife.bind(this);
        setTitle("Контакты");
        setListener();

        userAdapter = new UserAdapter(this);

        //первый запуск
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_frame_container, new UserFragmentAdd())
                    .commit();
        }

        getNewToolbar();
        setupToolbar();

        View mHeaderLayout = mNavigationView.getHeaderView(0);
        //задаем отступ в NavigationDrawer для того, чтобы элементы не уходили под StatuBar
        //и не делаем отступ в версии андроида < 5.0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mHeaderLayout.setPadding(0, getStatusBarHeight(), 0, 0);
        }



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


    // методы переопределяющий событе по клику назад, чтобы закрыть Navigation View, если он открыт
    @Override
    public void onBackPressed() {
        if (isNavDrawerOpen()) {
            closeNavDrawer();
        } else {
            super.onBackPressed();
        }
    }


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

    protected boolean isNavDrawerOpen() {
        return mNavigationDrawer != null && mNavigationDrawer.isDrawerOpen(GravityCompat.START);
    }

    protected void closeNavDrawer() {
        if (mNavigationDrawer != null) {
            mNavigationDrawer.closeDrawer(GravityCompat.START);
        }
    }

    //вешаем Listener на кнопки добавления команды/контакта
    private void setListener() {
        Button.OnClickListener dialogButtons = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title;
                switch (v.getId()) {
                    case R.id.btn_add_team:
                        Lg.e("btn", "team");
                        title = "Добавить Команду?";
                        configDialog(title, R.layout.dialog_add_team);
                        break;
                    case R.id.btn_add_user:
                        Lg.e("btn", "user");
                        title = "Добавить Пользователя?";
                        configDialog(title, R.layout.dialog_add_user);
                        break;
                }

            }


        };
        mBtnAddTeam.setOnClickListener(dialogButtons);
        mBtnAddUser.setOnClickListener(dialogButtons);
    }

    private void configDialog(String titleText, int layout) {
        //кастомный заголовок
        TextView title = new TextView(this);
        title.setText(titleText);
        title.setPadding(10, 10, 10, 10);
        title.setGravity(Gravity.CENTER);


        AlertDialog.Builder builder = new AlertDialog.Builder(TeamActivity.this);
        builder.setCustomTitle(title)
                .setCancelable(false)
                .setPositiveButton("Готово",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                .setNegativeButton("Отмена",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                .setView(layout);
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void loadData() {
        mUsers = getDataListUsers();
    }

    public List<User> getDataListUsers() {
        return new Select()
                .from(User.class)
                .execute();
    }

}
