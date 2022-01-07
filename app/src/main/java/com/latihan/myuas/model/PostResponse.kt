package com.latihan.myuas.model

data class PostResponse (
    val puskesmas: List<Data>
    ){
    data class Data(
        val id : String?,
        val nama_pus : String?,
        val alamat : String?,
        val jenis : String?
    )

}
