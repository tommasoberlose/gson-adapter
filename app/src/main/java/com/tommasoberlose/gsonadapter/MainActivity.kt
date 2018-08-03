package com.tommasoberlose.gsonadapter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.toast
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    NetworkAdapter().apiService.test()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            { status ->
              toast(status.name + if (status.present) " è presente." else " non è presente.")
            }, { e ->
          e.printStackTrace()
        })
  }
}
