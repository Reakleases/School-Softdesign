package com.softdesign.school.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.softdesign.school.R;
import com.softdesign.school.data.storage.preferences.UserPreferences;
import com.softdesign.school.ui.activities.MainActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ProfileFragment extends Fragment {


    private static final ButterKnife.Action<View> INVISIBLE = new ButterKnife.Action<View>() {
        @Override
        public void apply(View view, int index) {
            view.setVisibility(View.GONE);
        }
    };
    private static final ButterKnife.Action<View> VISIBLE = new ButterKnife.Action<View>() {
        @Override
        public void apply(View view, int index) {
            view.setVisibility(View.VISIBLE);
        }
    };


    @Bind({R.id.txt_phone_value, R.id.txt_email_value, R.id.txt_vk_value, R.id.txt_git_value, R.id.txt_bio_value})
    List<TextView> txtViewsValues;
    @Bind({R.id.txt_phone_label, R.id.txt_email_label, R.id.txt_vk_label, R.id.txt_git_label, R.id.txt_bio_label})
    List<TextView> txtViewsLabels;
    @Bind({R.id.et_phone_wrapper, R.id.et_email_wrapper, R.id.et_vk_wrapper, R.id.et_git_wrapper, R.id.et_bio_wrapper})
    List<TextInputLayout> etViewsWrappers;
    @Bind({R.id.et_phone_value, R.id.et_email_value, R.id.et_vk_value, R.id.et_git_value, R.id.et_bio_value})
    List<EditText> etViewsValue;
    private static final String FUNCTIONALITY_PROFILE_VIEW = "profile_view";
    private static final String FUNCTIONALITY_PROFILE_EDIT = "profile_edit";
    private static String mCurrentFunctionality;
    UserPreferences userFields;
    private List<String> mUserProfileData;
    private View mainView = null;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        userFields = new UserPreferences();
        mUserProfileData = userFields.loadUserProfileData(); // получаем данные из локальной модели.
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mainView == null) {
            // Если представления нет, создаем его*/
            mainView = inflater.inflate(R.layout.fragment_profile, container, false);
            ButterKnife.bind(this, mainView);
        }
        setFieldsData(txtViewsValues, mUserProfileData); //заполняем View элементы данными
        setFieldsData(etViewsValue, mUserProfileData);
        setupFunctionality(FUNCTIONALITY_PROFILE_VIEW);


        return mainView;
    }

    private void setFieldsData(List<? extends TextView> viewList, List<String> userFields) {
        for (int i = 0; i < viewList.size(); ++i) {
            viewList.get(i).setText(userFields.get(i));
        }
    }

    private List<String> getFieldsData(List<? extends TextView> viewList) {
        List<String> userFields = new ArrayList<String>();
        for (TextView viewField : viewList) {
            userFields.add(viewField.getText().toString());
        }
        return userFields;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().setTitle(getResources().getString(R.string.drawer_profile));
        ((MainActivity) getActivity()).checkMenu(R.id.drawer_profile);
        ((MainActivity) getActivity()).collapseAppBar(false);

        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab); //инициализируем fab из активити
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) fab.getLayoutParams(); // получаем параметры Layout fab приведенные к родителю

        params.setAnchorId(R.id.appbar_layout); //выставляем привязку якоря к appBarLayout
        params.anchorGravity = Gravity.BOTTOM | Gravity.END; //выставляем anchorGravity
        fab.setLayoutParams(params);
        fab.setImageResource(R.drawable.ic_create_24dp); // меняем иконку fab
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentFunctionality.equals(FUNCTIONALITY_PROFILE_VIEW)) {
                    setupFunctionality(FUNCTIONALITY_PROFILE_EDIT);
                } else {
                    setupFunctionality(FUNCTIONALITY_PROFILE_VIEW);
                }
            }
        });
    }


    public void setupFunctionality(String functionality) {

        mCurrentFunctionality = functionality; // выставляем текущую функциональность в зависимости от переданного аргумента

        switch (functionality) {
            case FUNCTIONALITY_PROFILE_VIEW: //режим просмотра
                List<String> ScreenData = getFieldsData(etViewsValue);
                if (!mUserProfileData.equals(ScreenData)) {  // если данные в EditView не совпадают с данными из модели UserPreferenses
                    userFields.saveUserProfileData(ScreenData); //то сохранить новые данные в модели
                    mUserProfileData = ScreenData; // заменить текущие данные в фрагменте
                    setFieldsData(txtViewsValues, mUserProfileData); // заполнить поля TextView
                }
                ButterKnife.apply(etViewsWrappers, INVISIBLE); //скрыть EditText
                ButterKnife.apply(txtViewsValues, VISIBLE); // показать TextView
                ButterKnife.apply(txtViewsLabels, VISIBLE);

                break;
            case FUNCTIONALITY_PROFILE_EDIT: //режим редактирования
                ButterKnife.apply(etViewsWrappers, VISIBLE); //показать EditText
                ButterKnife.apply(txtViewsValues, INVISIBLE); //скрыть TextView
                ButterKnife.apply(txtViewsLabels, INVISIBLE);
                break;

            default:
                mCurrentFunctionality = FUNCTIONALITY_PROFILE_VIEW;
                ButterKnife.apply(etViewsWrappers, INVISIBLE);
                ButterKnife.apply(txtViewsValues, VISIBLE);
                ButterKnife.apply(txtViewsLabels, VISIBLE);
                break;
        }











    }

}
