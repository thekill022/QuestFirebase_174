package com.example.intro_firebase.viewmodel

import com.example.intro_firebase.modeldata.Siswa

sealed class StatusUIDetail {
    data class Success(val satuSiswa : Siswa?) : StatusUIDetail
    object Error : StatusUIDetail
    object Loading : StatusUIDetail
}