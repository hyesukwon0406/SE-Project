package com.hyesuhandh.dasoni.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.hyesuhandh.dasoni.Fragment.ChatFragment;
import com.hyesuhandh.dasoni.Fragment.CoupleMainFragment;
import com.hyesuhandh.dasoni.Fragment.GalleryFragment;
import com.hyesuhandh.dasoni.Fragment.MemoBoardFragment;
import com.hyesuhandh.dasoni.R;
import com.hyesuhandh.dasoni.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity { ;
    String UserUid;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new CoupleMainFragment());

//        replaceFragment(new CoupleMainFragment()); //this starts the app with coupleMain fragment.

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
        Bundle bundle = new Bundle();
        bundle.putString("UserUid", UserUid);
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();


    }
}