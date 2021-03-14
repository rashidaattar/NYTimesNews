package com.demo.nytimesnews.remote.api

import com.demo.nytimesnews.remote.model.NewsList
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by Rashida on 4/9/19.
 */
interface NewsAPI {

    @GET("mostviewed/all-sections/7.json?api-key=ga8Aus47wGIx13sPZg8zrdutvVrzNJrv")
    fun getNews1(): Observable<NewsList>
}