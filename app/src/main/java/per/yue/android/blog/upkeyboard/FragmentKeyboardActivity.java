package per.yue.android.blog.upkeyboard;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class FragmentKeyboardActivity extends AppCompatActivity {

    private static final String TAB1="TAB1";
    private static final String TAB2="TAB2";

    private Fragment fragment1;
    private Fragment fragment2;

    //代表当前在tab1,2代表当前在tab2
    private int intTab=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_keyboard);

        fragment1=new FragmentTab1();
        fragment2=new FragmentTab2();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.add(R.id.fl_context, fragment1,TAB1);
        fragmentTransaction.add(R.id.fl_context, fragment2,TAB2);
        fragmentTransaction.show(fragment1);
        fragmentTransaction.hide(fragment2);
        fragmentTransaction.commit();
        intTab=1;

        Button btn_tab1 = (Button)findViewById(R.id.btn_tab1);
        Button btn_tab2 = (Button)findViewById(R.id.btn_tab2);
        btn_tab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(intTab!=1){

                    fragment1 = getSupportFragmentManager().findFragmentByTag(TAB1);
                    if(fragment1==null){
                        fragment1=new FragmentTab1();
                    }
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.show(fragment1);
                    fragmentTransaction.hide(fragment2);
                    fragmentTransaction.commit();

                    ((FragmentTab1)fragment1).showKeyboard();
                }
                intTab=1;
            }
        });
        btn_tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(intTab!=2){
                    if(fragment1!=null){
                        ((FragmentTab1)fragment1).hideKeyboard();
                    }

                    fragment2 = getSupportFragmentManager().findFragmentByTag(TAB2);
                    if(fragment2==null){
                        fragment2=new FragmentTab2();
                    }
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.show(fragment2);
                    fragmentTransaction.hide(fragment1);
                    fragmentTransaction.commit();
                }
                intTab=2;
            }
        });

    }
}
