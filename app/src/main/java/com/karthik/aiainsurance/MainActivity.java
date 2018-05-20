package com.karthik.aiainsurance;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.View;

import java.util.List;

import com.karthik.aiainsurance.adapters.CustomRecyclerViewAdapter;
import butterknife.BindView;
import butterknife.OnClick;
import com.karthik.aiainsurance.domain.Item;
import com.karthik.aiainsurance.interactor.SearchInteractor;


public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private CustomRecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static boolean conditionEnabaled = false;

    private List<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        performSearch(searchView);
        return true;
    }

    @OnClick(R.id.condition)
    public void onToggleClicked(View v) {
        conditionEnabaled = !v.isEnabled();
        v.setEnabled(conditionEnabaled);
        mAdapter = new CustomRecyclerViewAdapter(itemList);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void performSearch(SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                itemList = new SearchInteractor().getData(query);
                mAdapter = new CustomRecyclerViewAdapter(itemList);
                mRecyclerView.setAdapter(mAdapter);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });
    }
}
