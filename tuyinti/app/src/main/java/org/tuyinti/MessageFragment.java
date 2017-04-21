package org.tuyinti;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.tuyinti.dummy.DummyContent;
import org.tuyinti.dummy.DummyContent.DummyItem;
import org.tuyinti.utils.ResourceUtils;
import org.tuyinti.view.SlideView;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class MessageFragment extends BaseFragment implements View.OnClickListener, SlideView.OnSlideListener {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    private RecyclerView mRecyclerView;
    private SlideView mLastSlideViewWithStatusOn;

    private List<Integer> datas;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MessageFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static MessageFragment newInstance(int columnCount) {
        MessageFragment fragment = new MessageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_message, container, false);

        mRecyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);

        datas = new ArrayList<Integer>();
       /* for (int i = 0; i < 20; i++) {
            datas.add("测试数据--" + i);
        }*/

        datas.add(R.drawable.msg_item1);
        datas.add(R.drawable.msg_item2);
        datas.add(R.drawable.msg_item3);
        LinearLayoutManager layout = new LinearLayoutManager(getContext());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layout);
        mRecyclerView.setAdapter(new RecyclerView.Adapter<MyViewHolder>() {

            @Override
            public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                //方式一
                // SlideView slideView = (SlideView) getLayoutInflater().inflate(R.layout.item_main_custom, null);
                //方式二
                View myview = inflater.inflate(R.layout.item_main, null);
                SlideView slideView = new SlideView(MessageFragment.this.getContext());
                slideView.setContentView(myview);

                slideView.setOnSlideListener(MessageFragment.this);
                return new MyViewHolder(slideView);
            }

            @Override
            public void onBindViewHolder(MyViewHolder holder, int position) {
                // holder.mName.setText(datas.get(position));
//                holder.mDelete.setOnClickListener(MainActivity.this);
                holder.image.setImageDrawable(ResourceUtils.getDrawable(datas.get(position)));
            }

            @Override
            public int getItemCount() {
                return datas.size();
            }
        });

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public boolean onActivityBackPress() {
        return false;
    }

    @Override
    public void onListFragmentInteraction(DummyItem item) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.delete:
                Toast.makeText(MessageFragment.this.getContext(), "delete", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onSlide(View view, int status) {
        if (mLastSlideViewWithStatusOn != null && mLastSlideViewWithStatusOn != view) {
            mLastSlideViewWithStatusOn.shrink();
        }

        if (status == SLIDE_STATUS_ON) {
            mLastSlideViewWithStatusOn = (SlideView) view;
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.name);

        }
    }
}
