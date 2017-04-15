package org.tuyinti;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.arlib.floatingsearchview.FloatingSearchView;

import org.tuyinti.dummy.DummyContent;

/**
 * Created by Administrator on 2017/4/12.
 */

public abstract class BaseFragment extends Fragment implements OnListFragmentInteractionListener {


    private BaseFragmentCallBacks mCallbacks;

    public interface BaseFragmentCallBacks{

        void onAttachSearchViewToDrawer(FloatingSearchView searchView);
    }


    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    protected void attachSearchViewActivityDrawer(FloatingSearchView searchView){
        if(mCallbacks != null){
            mCallbacks.onAttachSearchViewToDrawer(searchView);
        }
    }

    public abstract boolean onActivityBackPress();
}
