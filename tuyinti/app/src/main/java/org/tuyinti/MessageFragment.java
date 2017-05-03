package org.tuyinti;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.tuyinti.dummy.DummyContent;
import org.tuyinti.dummy.DummyContent.DummyItem;
import org.tuyinti.page.MsgFilterActivity;
import org.tuyinti.page.MsgGroupActvitiy;
import org.tuyinti.page.MsgInstitutionActivity;
import org.tuyinti.page.MsgNewGroupActivity;
import org.tuyinti.page.MsgPeople;
import org.tuyinti.page.MsgPublishActivity;
import org.tuyinti.utils.ActivityStartUtil;
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
        //机构
        ((TextView)view.findViewById(R.id.textView1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityStartUtil.start(getActivity(), MsgInstitutionActivity.class);
            }
        });
        //人
        ((TextView)view.findViewById(R.id.textView2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               ActivityStartUtil.start(getActivity(), MsgPeople.class);
            }
        });
        //群组
        ((TextView) view.findViewById(R.id.textView3)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityStartUtil.start(getActivity(), MsgNewGroupActivity.class);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initToolbar(R.id.toolbar,R.string.title_home);
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


    //处理菜单
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.msg_toolbar_menu, menu);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case  R.id.publish:
                ActivityStartUtil.start(getActivity(), MsgPublishActivity.class);
                break;
            case  R.id.filter:
                ActivityStartUtil.start(getActivity(), MsgFilterActivity.class);
                break;
            case  R.id.create_group:
                ActivityStartUtil.start(getActivity(), MsgGroupActvitiy.class);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
