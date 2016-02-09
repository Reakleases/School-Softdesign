package com.softdesign.school.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school.R;
import com.softdesign.school.ui.activities.MainActivity;


public class ProfileFragment extends Fragment {


    private static final String FUNCTIONALITY_PROFILE_VIEW = "profile_view";
    private static final String FUNCTIONALITY_PROFILE_EDIT = "profile_edit";
    private static String sCurrentFunctionality = FUNCTIONALITY_PROFILE_VIEW;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View convertView = inflater.inflate(R.layout.fragment_profile, null);
        getActivity().setTitle(R.string.fragment_profile_title);
        ((MainActivity) getActivity()).checkMenu(R.id.drawer_profile);
        ((MainActivity) getActivity()).collapseAppBar(false);


        return convertView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab); //инициализируем fab из активити
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) fab.getLayoutParams(); // получаем параметры Layout fab приведенные к родителю
        params.setAnchorId(R.id.appbar_layout); //выставляем привязку якоря к appBarLayout
        params.anchorGravity = Gravity.BOTTOM | Gravity.END; //выставляем anchorGravity
        fab.setLayoutParams(params);
        fab.setImageResource(R.drawable.ic_create_24dp); // меняем иконку fab
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                     //создаем и вешаем новый обработчик на fab
                if (sCurrentFunctionality.equals(FUNCTIONALITY_PROFILE_VIEW)) {  //выбираем действие для fab в зависимости от текущего режима
                    setupFuncionality(FUNCTIONALITY_PROFILE_EDIT);
                } else {
                    setupFuncionality(FUNCTIONALITY_PROFILE_VIEW);
                }
            }
        });
    }




    private void setupFuncionality(String Funcionality) {

    }
}
