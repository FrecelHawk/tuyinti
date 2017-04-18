package org.tuyinti;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.tuyinti.utils.ActivityStartUtil;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by Administrator on 2017/4/8.
 */
@ContentView(R.layout.sign_up_activity)
public class SignUpActivity extends BaseActivity {

    @ViewInject(R.id.button2)
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityStartUtil.start(SignUpActivity.this,LoginActivity.class);
            }
        });
    }
}
