package com.karthik.aiainsurance.interactor;

import android.support.annotation.NonNull;

import com.karthik.aiainsurance.domain.Item;
import com.karthik.aiainsurance.repository.RestServiceBuilder;
import com.karthik.aiainsurance.repository.SearchApi.SearchApiDao;

import java.util.List;

import rx.Single;

public class SearchInteractor {

    private SearchApiDao searchApiDao;

    public SearchInteractor() {
        searchApiDao = RestServiceBuilder.create().create(SearchApiDao.class);
    }

    @NonNull
    public Single<List<Item>> getData(String query) {
        return null;
        //return searchApiDao.getResult(query).map(response -> response.getData().getItems());
    }
}

