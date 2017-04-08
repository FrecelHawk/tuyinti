package org.tuyinti;


/**
 * Created by visitor on 2017/4/8.
 */
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import org.xutils.x;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

    }
}
