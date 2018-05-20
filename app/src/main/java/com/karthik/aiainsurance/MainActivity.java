package com.karthik.aiainsurance;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.View;

import com.karthik.aiainsurance.adapters.CustomRecyclerViewAdapter;
import com.karthik.aiainsurance.domain.Item;
import com.karthik.aiainsurance.repository.RestServiceBuilder;
import com.karthik.aiainsurance.repository.SearchApi.SearchApiDao;
import com.karthik.aiainsurance.repository.SearchApi.SearchResponse;

import java.util.List;

import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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
//        mAdapter = new CustomRecyclerViewAdapter(itemList);
//        mRecyclerView.setAdapter(mAdapter);
    }

    private void performSearch(SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                getData(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });
    }

    private void getData(String data){
        try {
            SearchApiDao searchApiDao = RestServiceBuilder.create().create(SearchApiDao.class);
            Call<SearchResponse> call = searchApiDao.getResult(data);
            call.enqueue(new Callback<SearchResponse>() {
                @Override
                public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                    if (response.body() != null) {
                        itemList = response.body().getData().getItems();
                        mAdapter = new CustomRecyclerViewAdapter(itemList);
                        mRecyclerView.setAdapter(mAdapter);
                    }
                }

                @Override
                public void onFailure(Call<SearchResponse> call, Throwable t) {
                    call.cancel();
                }
            });
        }catch (Throwable ex){
            ex.printStackTrace();
        }
    }
}
