package com.hyesuhandh.dasoni.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.hyesuhandh.dasoni.R;
import com.hyesuhandh.dasoni.databinding.FragmentCoupleMainBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CoupleMainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CoupleMainFragment extends Fragment {
    private FragmentCoupleMainBinding binding;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    int a = 1;

    public CoupleMainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CoupleMainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CoupleMainFragment newInstance(String param1, String param2) {
        CoupleMainFragment fragment = new CoupleMainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCoupleMainBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.user1feeling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.facechange.setVisibility(view.VISIBLE);
            }
        });
        binding.face1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a=1;
                changImage();
                binding.facechange.setVisibility(view.INVISIBLE);
            }
        });
        binding.face2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a=2;
                changImage();
                binding.facechange.setVisibility(view.INVISIBLE);
            }
        });
        binding.face3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a=3;
                changImage();
                binding.facechange.setVisibility(view.INVISIBLE);
            }
        });
        binding.face4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a=4;
                changImage();
                binding.facechange.setVisibility(view.INVISIBLE);
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    public void changImage(){
        switch (a){
            case 1:
                binding.user1feeling.setImageResource(R.drawable.face);
                break;
            case 2:
                binding.user1feeling.setImageResource(R.drawable.loveface);
                break;
            case 3:
                binding.user1feeling.setImageResource(R.drawable.sadface);
                break;
            case 4:
                binding.user1feeling.setImageResource(R.drawable.angryface);
                break;
        }

    }

}

