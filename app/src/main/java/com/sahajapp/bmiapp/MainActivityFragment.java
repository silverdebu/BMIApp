package com.sahajapp.bmiapp;

import android.app.Fragment;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;

import static com.sahajapp.bmiapp.CommonUtil.showToastMessage;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private EditText feet = null;
    private EditText inchs = null;
    private EditText weight = null;
    private EditText age = null;

    private Switch heightUnit = null;
    private Switch sex = null;
    private Switch weightUnit = null;

    public static MainActivityFragment newInstance() {
        MainActivityFragment fragment = new MainActivityFragment();
        fragment.setRetainInstance(true);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    /*public void showToastMessage(String msg) {
        Context context = this.getActivity().getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, msg, duration);
        toast.show();
    }*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showToastMessage("FRAG CREATE", this.getActivity());
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        feet = (EditText) view.findViewById(R.id.feet);
        inchs = (EditText) view.findViewById(R.id.inchs);
        weight = (EditText) view.findViewById(R.id.weight);
        age = (EditText) view.findViewById(R.id.years);

        heightUnit = (Switch) view.findViewById(R.id.heightUnit);
        weightUnit = (Switch) view.findViewById(R.id.weightUnit);
        sex = (Switch) view.findViewById(R.id.sex);

        setSwitchListners();


    }

    /**
     *
     */
    private void setSwitchListners() {

        heightUnit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    showToastMessage("CHECKED", buttonView.getContext());
                    feet.getText().clear();
                    inchs.getText().clear();
                    inchs.setVisibility(View.GONE);
                    feet.setLayoutParams(new LinearLayout.LayoutParams(0,
                            (int) getResources().getDimension(R.dimen.inputTextHeight), 3f));
                    feet.setHint("cm");
                    feet.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
                    feet.requestFocus();
                } else {
                    showToastMessage("NOT CHECKED", buttonView.getContext());
                    feet.getText().clear();
                    inchs.getText().clear();
                    inchs.setVisibility(View.VISIBLE);
                    feet.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
                    feet.setLayoutParams(new LinearLayout.LayoutParams(0,
                            (int) getResources().getDimension(R.dimen.inputTextHeight), 1.5f));
//                    inchs.setLayoutParams(new LinearLayout.LayoutParams(0,
//                            (int) getResources().getDimension(R.dimen.inputTextHeight), 1.5f));
                    feet.setHint("feet");
                    feet.requestFocus();

                }
            }
        });

        weightUnit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                weight.getText().clear();
                weight.requestFocus();
            }
        });

        sex.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                   if (isChecked) {
                       showToastMessage("Female", buttonView.getContext());
                   } else {
                       showToastMessage("Male", buttonView.getContext());
                   }
               }
           }
        );
    }
}
