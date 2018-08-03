package com.tommasoberlose.gsonadapter

import com.google.gson.annotations.Expose
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName

/**
 * Created by tommaso on 14/02/18.
 */

@JsonAdapter(CustomTypeArray::class)
class StatusObject {
  @SerializedName("name")
  @Expose
  var name = ""

  @SerializedName("status")
  @Expose
  var present = false
}