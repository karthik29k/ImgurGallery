package com.karthik.aiainsurance.repository;

import com.google.gson.annotations.SerializedName;

import com.karthik.aiainsurance.domain.Data;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public class SearchApi {

    private SearchApi() {
        // no instantiation
    }

    public interface SearchApiDao {
        @Headers("Authorization: Client-ID 6046ae1df183471")
        @GET("{searchText}/week/1")
        Call<SearchResponse> getResult(@Path("searchText") String word);
    }

    public class SearchResponse {
        @SerializedName("data")
        private Data data;
        public Data getData() {
            return data;
        }
    }
}