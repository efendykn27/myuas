package com.latihan.myUAS.retrofit


import com.latihan.myuas.model.PostResponse
import retrofit2.Call
import retrofit2.http.*

interface API {
    @GET("puskesmas.php")
    fun data(): Call<PostResponse>

    @GET("rs.php")
    fun dataRS(): Call<PostResponseRS>




    @FormUrlEncoded
    @POST("login.php/")
    fun login(
        @Field("post_username") username : String?,
        @Field("post_password") password : String?
    ): Call<ResponseLogin>
}