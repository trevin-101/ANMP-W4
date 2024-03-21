package com.nmp.anmp_w4.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel: ViewModel() {
    val studentsID = MutableLiveData<ArrayList<Student>>()
    val studentLoadErrorID = MutableLiveData<Boolean>()
    val loadingID = MutableLiveData<Boolean>()

    fun refresh() {
        studentsID.value = arrayListOf(
            Student("16055","Nonie","1998/03/28","5718444778","http://dummyimage.com/75x100" +
                    ".jpg/cc0000/ffffff"),
            Student("13312","Rich","1994/12/14","3925444073","http://dummyimage.com/75x100" +
                    ".jpg/5fa2dd/ffffff"),
            Student("11204","Dinny","1994/10/07","6827808747",
                "http://dummyimage.com/75x100.jpg/5fa2dd/ffffff1")
        )

        studentLoadErrorID.value = false
        loadingID.value = false
    }

    fun updateData() {
        studentsID.value?.clear()
        loadingID.value = true

        refresh()
    }

}
