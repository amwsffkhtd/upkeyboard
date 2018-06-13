package per.yue.android.blog.upkeyboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class ActivityKeyboardActivity extends AppCompatActivity {

    private EditText et_1;
    private EditText et_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_keyboard);
        et_1=(EditText)findViewById(R.id.et_1);
        et_2=(EditText)findViewById(R.id.et_2);

        Button btn_show_keyboard = (Button)findViewById(R.id.btn_show_keyboard);
        Button btn_hide_keyboard = (Button)findViewById(R.id.btn_hide_keyboard);
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
}
