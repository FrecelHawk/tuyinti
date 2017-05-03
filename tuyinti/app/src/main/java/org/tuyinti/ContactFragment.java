package org.tuyinti;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.tuyinti.adapter.ContactsAdapter;
import org.tuyinti.bean.DataFactory;
import org.tuyinti.bean.User;
import org.tuyinti.bean.Word;
import org.tuyinti.page.CnAddFriend;
import org.tuyinti.page.CnGroup;
import org.tuyinti.page.CnInstitution;
import org.tuyinti.page.CnMy;
import org.tuyinti.page.CnScanCode;
import org.tuyinti.page.CnSendGroup;
import org.tuyinti.page.MsgFilterActivity;
import org.tuyinti.page.MsgGroupActvitiy;
import org.tuyinti.page.MsgInstitutionActivity;
import org.tuyinti.page.MsgNewGroupActivity;
import org.tuyinti.page.MsgPeople;
import org.tuyinti.page.MsgPublishActivity;
import org.tuyinti.utils.ActivityStartUtil;
import org.tuyinti.view.IndexView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class ContactFragment extends BaseFragment implements View.OnClickListener{


    private static final String TAG = "ContactsFragment";

    private RecyclerView recyclerView;
    private IndexView indexView;
    private TextView tvWord;
    private List<User>listFriends;
    private ContactsAdapter adapter;
    private LinearLayoutManager layoutManager;
    private Word words[] = new Word[26]; //26个字母表



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contacts, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        tvWord = (TextView)view.findViewById(R.id.tv_word);
        indexView = (IndexView)view.findViewById(R.id.index_view);
        indexView.addOnIndexListener(new IndexView.OnIndexListener() {
            @Override
            public void onSelectedIndex(int index, String word) {
                tvWord.setText(word);
                if(index-1 >=0 && index-1 <26) {
                    int dex = words[index - 1].index;
                    layoutManager.scrollToPositionWithOffset(dex, 0);
                }
            }

            @Override
            public void onStart(int index, String word) {
                tvWord.setVisibility(View.VISIBLE);
                tvWord.setText(word);
            }

            @Override
            public void onEnd() {
                tvWord.setVisibility(View.GONE);
            }
        });
        //机构
        ((TextView)view.findViewById(R.id.textView1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityStartUtil.start(getActivity(), CnInstitution.class);
            }
        });
        //群组
        ((TextView)view.findViewById(R.id.textView2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityStartUtil.start(getActivity(), CnGroup.class);
            }
        });
        //我
        ((TextView) view.findViewById(R.id.textView3)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityStartUtil.start(getActivity(), CnMy.class);
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initToolbar(R.id.toolbar,R.string.title_home);
        initData();
    }

    private void initData() {
        listFriends = DataFactory.createFriends(80);
        Collections.sort(listFriends, new Comparator<User>() {
            @Override
            public int compare(User user, User t1) {
                return user.name.compareTo(t1.name);
            }
        });
        initWord();
        adapter = new ContactsAdapter(getContext());
        adapter.setDatas(listFriends);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new ContactsDividerItemDecoration(getContext(), words));
    }

    //初始化字母表
    private void initWord() {
        int in = 0;
        int k = 0;
        String word = "";
        for(int i=0; i<listFriends.size(); i++){
            String w1 = listFriends.get(i).name.substring(0,1);
            if(word.equals(w1)){
                continue;
            }
            word = w1;
            in = i;
            for(; k<words.length; k++){
                String w2 = IndexView.INDEX_KEY[k + 1];
                if(word.compareTo(w2) < 0)
                    break;
                words[k] = new Word();
                words[k].title = IndexView.INDEX_KEY[k + 1];
                words[k].index = in;
            }
        }
        for(; k<26; k++){
            words[k] = new Word();
            words[k].title = IndexView.INDEX_KEY[k+1];
            words[k].index = in;
        }
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean onActivityBackPress() {
        return false;
    }


    //处理菜单
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.contact_toolbar_menu, menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case  R.id.send_group:
                ActivityStartUtil.start(getActivity(), CnSendGroup.class);
                break;
            case  R.id.add_friend:
                ActivityStartUtil.start(getActivity(), CnAddFriend.class);
                break;
            case  R.id.scan_code:
                ActivityStartUtil.start(getActivity(), CnScanCode.class);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
