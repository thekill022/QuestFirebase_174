package com.example.intro_firebase.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.intro_firebase.modeldata.DetailSiswa
import com.example.intro_firebase.modeldata.UIStateSiswa
import com.example.intro_firebase.modeldata.toUiStateSiswa
import com.example.intro_firebase.repositori.RepositorySiswa
import com.example.intro_firebase.view.route.DestinasiDetail
import kotlinx.coroutines.launch

class EditViewModel (savedStateHandle: SavedStateHandle, private val repositorySiswa: RepositorySiswa) : ViewModel() {
    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set
    private val idSiswa : Long = savedStateHandle.get<String>(DestinasiDetail.itemIdArg)?.toLong() ?: error("idSiswa tidak ditemukan di SavedStateHandle")

    init {
        viewModelScope.launch {
            uiStateSiswa = repositorySiswa.getSatuSiswa(idSiswa)!!.toUiStateSiswa(true)
        }
    }

    fun updateUiState(detailSiswa: DetailSiswa) {
        uiStateSiswa = UIStateSiswa(detailSiswa = detailSiswa, isEntryValid = validasiInput(detailSiswa))
    }

    fun validasiInput(uiState : DetailSiswa = uiStateSiswa.detailSiswa) : Boolean {
        return with(uiState ) {
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }

}