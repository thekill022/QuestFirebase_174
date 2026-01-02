package com.example.intro_firebase.view.route

import com.example.intro_firebase.R

object DestinasiEdit : DestinasiNavigasi {
    override val route: String = "item_edit"
    override val titleRes: Int = R.string.edit_siswa
    const val itemIdArg = "idSiswa"
    val routeWithArgs = "$route/${itemIdArg}"
}