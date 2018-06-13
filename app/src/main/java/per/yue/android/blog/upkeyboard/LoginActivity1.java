package per.yue.android.blog.upkeyboard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by matth on 2018/6/12.
 */

public class LoginActivity1 extends AppCompatActivity {

    private int screenHeight;
    private View layout_content;
    private View layout_bottom;
    private int bottomHeight;
    private KeyBoardHelper boardHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        layout_content = findViewById(R.id.layout_content);
        layout_bottom = findViewById(R.id.layout_bottom);
        boardHelper = new KeyBoardHelper(this);
        boardHelper.onCreate();
//        boardHelper.setOnKeyBoardStatusChangeListener(onKeyBoardStatusChangeListener);
        layout_bottom.post(new Runnable() {
            @Override
            public void run() {
                bottomHeight = layout_bottom.getHeight();
                Log.i("vlog","=================bottomHeight:"+bottomHeight);
            }
        });
    }
    private KeyBoardHelper.OnKeyBoardStatusChangeListener onKeyBoardStatusChangeListener = new KeyBoardHelper.OnKeyBoardStatusChangeListener() {
        @Override
        public void OnKeyBoardPop(int keyBoardheight) {
            final int height = keyBoardheight;
            if (bottomHeight > height) {
                layout_bottom.setVisibility(View.GONE);
            } else {
                int offset = bottomHeight - height;
                final ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) layout_content
                        .getLayoutParams();
                lp.topMargin = offset;
                layout_content.setLayoutParams(lp);
            }
        }
        @Override
        public void OnKeyBoardClose(int oldKeyBoardheight) {
            if (View.VISIBLE != layout_bottom.getVisibility()) {
                layout_bottom.setVisibility(View.VISIBLE);
            }
            final ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) layout_content
                    .getLayoutParams();
            if (lp.topMargin != 0) {
                lp.topMargin = 0;
                layout_content.setLayoutParams(lp);
            }
        }
    };
    @Override
    protected void onDestroy() {
        super.onDestroy();
        boardHelper.onDestory();
    }
}
