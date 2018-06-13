package per.yue.android.blog.upkeyboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_to_edittexts = (Button)findViewById(R.id.btn_to_edittexts);
        Button btn_to_login = (Button)findViewById(R.id.btn_to_login);
        Button btn_to_activity_keyboard = (Button)findViewById(R.id.btn_to_activity_keyboard);
        Button btn_to_fragment_keyboards = (Button)findViewById(R.id.btn_to_fragment_keyboards);
        btn_to_edittexts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,EditTextsActivity.class);
                startActivity(intent);
            }
        });
        btn_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LoginActivity1.class);
                startActivity(intent);
            }
        });
        btn_to_activity_keyboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ActivityKeyboardActivity.class);
                startActivity(intent);
            }
        });
        btn_to_fragment_keyboards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FragmentKeyboardActivity.class);
                startActivity(intent);
            }
        });
    }
}
