package com.softdesign.school.ui.activities;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
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
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.softdesign.school.R;
import com.softdesign.school.data.storage.models.Team;
import com.softdesign.school.data.storage.models.User;
import com.softdesign.school.ui.fragments.UserFragmentAdd;
import com.softdesign.school.utils.Lg;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TeamActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolBar;
    @Bind(R.id.navigation_drawer)
    DrawerLayout mNavigationDrawer;
    @Bind(R.id.navigation_view)
    NavigationView mNavigationView;
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
    private Spinner mSpinner;
    private EditText mFirstName;
    private EditText mLastName;
    private EditText mTeam;


    String[] data = {"one", "two", "three", "four", "five"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        ButterKnife.bind(this);
        setTitle("Контакты");


        getNewToolbar();
        setupToolbar();


        View mHeaderLayout = mNavigationView.getHeaderView(0);
        //задаем отступ в NavigationDrawer для того, чтобы элементы не уходили под StatuBar
        //и не делаем отступ в версии андроида < 5.0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mHeaderLayout.setPadding(0, getStatusBarHeight(), 0, 0);
        }

        // mAppBar.setExpanded(false,false);
/*        BlockToolbar.setDrag(false,mAppBar);
        params.setScrollFlags(0);
        mCollapsingToolbar.setLayoutParams(params);*/


        //первый запуск
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_frame_container, new UserFragmentAdd())
                    .commit();
        }


        setListener();

    }


    /**
     * Метод для инициализации своего кастомного ToolBar
     */
    public void getNewToolbar() {
        setSupportActionBar(mToolBar);
        mActionBar = getSupportActionBar();
        //params = (AppBarLayout.LayoutParams) mCollapsingToolbar.getLayoutParams();
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
                LayoutInflater inflater = getLayoutInflater();
                String title;
                View view;
                switch (v.getId()) {
                    case R.id.btn_add_team:
                        Lg.e("btn", "team");
                        title = "Добавить Команду?";
                        view = inflater.inflate(R.layout.dialog_add_team, null);
                        configDialog(title, view, false);
                        break;
                    case R.id.btn_add_user:
                        Lg.e("btn", "user");
                        title = "Добавить Пользователя?";
                        view = inflater.inflate(R.layout.dialog_add_user, null);
                        configDialog(title, view, true);
                        break;
                }

            }


        };
        mBtnAddTeam.setOnClickListener(dialogButtons);
        mBtnAddUser.setOnClickListener(dialogButtons);

        //spinner

    }


    private void configDialog(String titleText, View layout, final boolean needSpinner) {
        //кастомный заголовок

        TextView title = new TextView(this);
        title.setText(titleText);
        title.setPadding(10, 10, 10, 10);
        title.setGravity(Gravity.CENTER);


        if (needSpinner){
            mSpinner = (Spinner) layout.findViewById(R.id.spinner);
            mFirstName = (EditText) layout.findViewById(R.id.et_add_firstname_value);
            mLastName = (EditText) layout.findViewById(R.id.et_add_lastname_value);
            Team.getAllNames();
            ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, Team.getAllNames());
            mSpinner.setAdapter(spinnerAdapter);
        } else {
            mTeam = (EditText) layout.findViewById(R.id.et_add_team_value);
        }



        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCustomTitle(title)
                .setCancelable(false)
                .setPositiveButton("Готово",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (needSpinner) {
                                    saveDataUser();
                                    Lg.e ("needSpinner","saveDataUser()");
                                } else {
                                    saveDataTeam();
                                    Lg.e ("not needSpinner","saveDataTeam()");
                                }

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

    public void saveDataUser() {
        Team team = Team.getTeamByName(mSpinner.getSelectedItem().toString());
        String firstName = mFirstName.getText().toString();
        String lastName = mLastName.getText().toString();
        User user = new User(firstName, lastName, team);
        user.save();

    }

    public void saveDataTeam() {
        String name = mTeam.getText().toString();
        Team team = new Team(name);
        team.save();

    }


}
