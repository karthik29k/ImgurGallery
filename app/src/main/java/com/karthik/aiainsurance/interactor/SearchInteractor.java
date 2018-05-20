package com.karthik.aiainsurance.interactor;

import android.support.annotation.NonNull;

import java.util.List;

import com.karthik.aiainsurance.domain.Item;
import com.karthik.aiainsurance.repository.RestServiceBuilder;
import com.karthik.aiainsurance.repository.SearchApi.SearchApiDao;
import com.karthik.aiainsurance.repository.SearchApi.SearchResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchInteractor {

    private List<Item> responceItemsData;
    private SearchApiDao searchApiDao;

    public SearchInteractor() {
        searchApiDao = RestServiceBuilder.create().create(SearchApiDao.class);
    }

    @NonNull
    public List<Item> getData(String query){
        try {
            Call<SearchResponse> result = searchApiDao.getResult(query);

            result.enqueue(new Callback<SearchResponse>() {
                @Override
                public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                    if (response.body() != null) {
                        responceItemsData = response.body().getData().getItems();
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

        return responceItemsData;
    }
}

