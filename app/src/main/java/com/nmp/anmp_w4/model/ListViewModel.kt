package com.nmp.anmp_w4.model

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class ListViewModel(application: Application): AndroidViewModel(application) {
    val studentsID = MutableLiveData<ArrayList<Student>>()
    val studentLoadErrorID = MutableLiveData<Boolean>()
    val loadingID = MutableLiveData<Boolean>()
    val TAG = "volleyTag"
    private var queue:RequestQueue? = null


    fun refresh() {
//        studentsID.value = arrayListOf(
//            Student("16055","Nonie","1998/03/28","5718444778","http://dummyimage.com/75x100" +
//                    ".jpg/cc0000/ffffff"),
//            Student("13312","Rich","1994/12/14","3925444073","http://dummyimage.com/75x100" +
//                    ".jpg/5fa2dd/ffffff"),
//            Student("11204","Dinny","1994/10/07","6827808747",
//                "http://dummyimage.com/75x100.jpg/5fa2dd/ffffff1")
//        )
//
//        studentLoadErrorID.value = false
//        loadingID.value = false

        loadingID.value = true
        studentLoadErrorID.value = false

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://adv.jitusolution.com/student.php"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                loadingID.value = false
                Log.d("showvoley", it)
            },
            {
                Log.d("showvoley", it.toString())
                studentLoadErrorID.value = false
                loadingID.value = false
            }
        )


    }

    fun updateData() {
        studentsID.value?.clear()
        loadingID.value = true

        refresh()
    }

}
