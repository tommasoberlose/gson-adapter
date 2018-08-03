package com.tommasoberlose.gsonadapter

import retrofit2.http.*
import rx.Observable


/**
 * Created by tommaso on 23/08/17.
 */

interface APIService {
  @Headers("Content-Type: application/json", "Accept: application/json")
  @GET("status")
  fun test(): Observable<StatusObject>
}
