package com.kelin.mvvmlight.zhihu.newsdetail;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by kelin on 16-4-29.
 */
public interface NewsDetailCssService {
    @GET
    Observable<String> getNewsDetailCss(@Url String url);
}
