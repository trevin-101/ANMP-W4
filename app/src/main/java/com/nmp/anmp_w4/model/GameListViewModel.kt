package com.nmp.anmp_w4.model

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GameListViewModel(application: Application): AndroidViewModel(application) {
    val gameID = MutableLiveData<ArrayList<Student>>()
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun refresh() {
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.2.2/Games/games.json"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                Log.d("showvoley", it)
            },
            {
                Log.d("showvoley", it.toString())
            }
        )

    }
    fun fetch() {
        val sType = object : TypeToken<List<Student>>() { }.type
        val result = Gson().fromJson<List<Student>>(it, sType)
        gameID.value = result as ArrayList<Student>?

        Log.d("showvoley", result.toString())
    }


}