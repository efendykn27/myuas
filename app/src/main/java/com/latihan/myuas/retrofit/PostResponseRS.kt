package com.latihan.myUAS.retrofit

import com.google.gson.annotations.SerializedName

data class PostResponseRS (
    val rumah_sakit: List<DataRS>
    ){
    data class DataRS(
        val id : String?,
        val nama_rs : String?,
        val alamat : String?
    )

}
