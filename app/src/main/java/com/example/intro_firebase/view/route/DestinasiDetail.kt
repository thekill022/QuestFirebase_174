package com.example.intro_firebase.view.route

import com.example.intro_firebase.R

object DestinasiDetail : DestinasiNavigasi {
    override val route: String = "detail_siswa"
    override val titleRes: Int = R.string.detail_siswa
    const val itemIdArg = "idSiswa"
    val routeWithArgs = "$route/${itemIdArg}"
}