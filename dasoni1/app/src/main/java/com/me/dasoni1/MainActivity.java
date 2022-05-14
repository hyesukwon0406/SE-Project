package com.me.dasoni1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.me.dasoni1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new CoupleMainFragment()); //this starts the app with coupleMain fragment.

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch(item.getItemId()){

                case R.id.couplemainnav:
                    replaceFragment(new CoupleMainFragment());
                    break;
                case R.id.chatnav:
                    replaceFragment(new ChatFragment());
                    break;
                case R.id.gallerynav:
                    replaceFragment(new GalleryFragment());
                    break;
                case R.id.memonav:
                    replaceFragment(new MemoBoardFragment());
                    break;
            }

            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();

    }
}