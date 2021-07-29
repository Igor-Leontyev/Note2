package com.crybz.notes2;

import android.content.SharedPreferences;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readSettings();
        initView();
    }

    private void readSettings() {
        SharedPreferences preferences = getSharedPreferences(SettingsFragment.SETINGS_SAVE,MODE_PRIVATE);
        SettingsFragment.isUseBS = preferences.getBoolean(SettingsFragment.IS_USE_BS,false);
        SettingsFragment.isAdd = preferences.getBoolean(SettingsFragment.IS_ADD,false);
    }

    private void initView() {
        findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SettingsFragment.isUseBS) {
                    Fragment fragment = null;

                    List<Fragment> fragmentList = getSupportFragmentManager().getFragments();
                    for (int i = 0; i < fragmentList.size(); i++) {
                        if (fragmentList.get(i).isVisible()) {
                            fragment = fragmentList.get(i);
                        }
                    }
                    if (fragment != null) {
                        getSupportFragmentManager()
                                .beginTransaction()
                                .remove(fragment)
                                .commit();
                    }
                } else {
                    getSupportFragmentManager().popBackStack();
                }

            }
        });
    }
}
