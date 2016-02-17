package com.softdesign.school.ui.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.activeandroid.query.Select;
import com.softdesign.school.R;
import com.softdesign.school.data.storage.models.User;
import com.softdesign.school.utils.Lg;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TeamActivity extends AppCompatActivity {


    @Bind(R.id.btn_add_team)
    Button mBtnAddTeam;
    @Bind(R.id.btn_add_user)
    Button mBtnAddUser;

    private DialogFragment mDialogFragment;
    List<User> mUsers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        ButterKnife.bind(this);
        setTitle("Контакты");
        setListener();
    }


    private void setListener() {
        Button.OnClickListener dialogButtons = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title;
                switch (v.getId()) {
                    case R.id.btn_add_team:
                        Lg.e("btn", "team");
                        title = "Добавить Команду?";
                        configDialog(title, R.layout.fragment_add_team);
                        break;
                    case R.id.btn_add_user:
                        Lg.e("btn", "user");
                        title = "Добавить Пользователя?";
                        configDialog(title, R.layout.fragment_add_user);
                        break;
                }

            }


        };
        mBtnAddTeam.setOnClickListener(dialogButtons);
        mBtnAddUser.setOnClickListener(dialogButtons);
    }

    private void configDialog(String titleText, int layout) {
        TextView title = new TextView(this);
        //кастомный заголовок
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
