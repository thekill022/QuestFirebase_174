package com.example.intro_firebase.viewmodel

import com.example.intro_firebase.modeldata.Siswa

sealed interface StatusUiSiswa {
    data class Success(val siswa: List<Siswa> = listOf()) : StatusUiSiswa
    object Error : StatusUiSiswa
    object Loading : StatusUiSiswa
}