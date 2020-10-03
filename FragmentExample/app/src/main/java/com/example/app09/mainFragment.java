package com.example.app09;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link mainFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class mainFragment extends Fragment {
    MainActivity activity;
    private static Toast toast;
    EditText editname;
    EditText editage;
    EditText editbirth;
    Button mybutton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mybutton = rootView.findViewById(R.id.savebutton);
        editage = rootView.findViewById(R.id.age);
        editname = rootView.findViewById(R.id.name);
        editbirth = rootView.findViewById(R.id.birth);

        mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast = Toast.makeText(getActivity(), "이름: "+ editname.getText() + " 나이: "+ editage.getText() + " 생일: "+ editbirth.getText(), Toast.LENGTH_SHORT);
                toast.show();
                editage.setText("");
                editname.setText("");
                editbirth.setText("");
                editname.requestFocus();
            }
        });
        editbirth.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && keyCode == KeyEvent.KEYCODE_ENTER){
                    mybutton.performClick();
                }

                return false;
            }
        });
        return rootView;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (MainActivity)getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activity = null;
    }
}