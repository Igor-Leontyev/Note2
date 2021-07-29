package com.crybz.notes2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment {
    public static final String IS_USE_BS = "isUseBS";
    public static final String IS_ADD = "isAdd";
    public static boolean isReplace;
    public static boolean isAdd;
    public static boolean isUseBS;
    final static String SETINGS_SAVE = "SETTINGS";


    public SettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        RadioButton rbReplace = view.findViewById(R.id.rb_replace);
        RadioButton rbAdd = view.findViewById(R.id.rb_add);
        SwitchCompat swUseBackStack = view.findViewById(R.id.sw_backstack);

        rbAdd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isAdd = isChecked;
                writeSettings();

            }
        });
        swUseBackStack.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isUseBS = isChecked;
                writeSettings();
            }
        });
    }

    private void writeSettings() {
        requireActivity().getSharedPreferences(SETINGS_SAVE, Context.MODE_PRIVATE)
                .edit()
                .putBoolean(IS_ADD, isAdd)
                .putBoolean(IS_USE_BS, isUseBS)
                .apply();
    }
}
