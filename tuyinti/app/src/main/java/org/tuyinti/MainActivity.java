package org.tuyinti;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import org.tuyinti.dummy.DummyContent;

public class MainActivity extends AppCompatActivity {


    private Fragment mFragment,cFragment,clFragment,msFragment,sFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
           // hideAllFragment(transaction);
            Boolean flag = false;
            Fragment fragment;
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_message:
                         fragment = MessageFragment.newInstance(10);
                        transaction.replace(R.id.content,fragment).commit();
                    break;
                case R.id.navigation_contact:
                         fragment =ContactFragment.newInstance(10);
                         transaction.replace(R.id.content,fragment).commit();
                    break;
                case R.id.navigation_coloring:
                         fragment = new ColoringFragment();
                         transaction.replace(R.id.content,fragment).commit();
                    break;
                case R.id.navigation_music:
                    fragment = new MusicFragment();
                         transaction.replace(R.id.content,fragment).commit();
                    break;
                case R.id.navigation_sports:
                    fragment = new SprotsFragment();
                         transaction.replace(R.id.content,fragment).commit();
                    break;
            }
            return true;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
    }

    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(mFragment != null)fragmentTransaction.hide(mFragment);
        if(cFragment != null)fragmentTransaction.hide(cFragment);
        if(clFragment != null)fragmentTransaction.hide(clFragment);
        if(msFragment != null)fragmentTransaction.hide(msFragment);
        if(sFragment != null)fragmentTransaction.hide(sFragment);
    }

}
