package per.yue.android.blog.upkeyboard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by matth on 2018/6/13.
 */

public class FragmentTab1 extends Fragment {
    private EditText et_1;
    private EditText et_2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab1, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        et_1=(EditText)getActivity().findViewById(R.id.et_1);
        et_2=(EditText)getActivity().findViewById(R.id.et_2);

        Button btn_show_keyboard = (Button)getActivity().findViewById(R.id.btn_show_keyboard);
        Button btn_hide_keyboard = (Button)getActivity().findViewById(R.id.btn_hide_keyboard);
        btn_show_keyboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtils.showKeyboard(et_1);
            }
        });
        btn_hide_keyboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtils.hideKeyboard(et_2);
            }
        });
    }

    public void hideKeyboard(){
        KeyboardUtils.hideKeyboard(et_2);
    }
    public void showKeyboard(){
        KeyboardUtils.showKeyboard(et_1);
    }
}
