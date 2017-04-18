package org.tuyinti;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.tuyinti.utils.ActivityStartUtil;
import org.tuyinti.utils.ToastUtil;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by visitor on 2017/4/8.
 */


@ContentView(R.layout.login_activity)
public class LoginActivity extends BaseActivity {

    @ViewInject(R.id.button2)
    Button btn;
    @ViewInject(R.id.sing_up_btn)
    TextView singUp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityStartUtil.start(LoginActivity.this,MainActivity.class);
            }
        });

        singUp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                ActivityStartUtil.start(LoginActivity.this,SignUpActivity.class);
            }
        });

    }
}
