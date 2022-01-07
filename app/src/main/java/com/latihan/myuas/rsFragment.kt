package com.latihan.myuas


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.latihan.myUAS.Adapter.PostAdapterRS
import com.latihan.myUAS.retrofit.PostResponseRS
import com.latihan.myUAS.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class rsFragment : Fragment() {
    private val api by lazy { RetrofitClient().endpoint}
    private lateinit var postAdapterRS: PostAdapterRS
    private lateinit var listRS : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_rs, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        listRS = view.findViewById(R.id.rvPostRS)
        setupList()
    }


    private fun setupList() {
//        listTamu = findViewById(R.id.rvPost)
        postAdapterRS = PostAdapterRS(arrayListOf())
        listRS.adapter = postAdapterRS
    }

    override fun onStart(){
        super.onStart()
        getPuskesmas()
    }
    private fun getPuskesmas(){

        api.dataRS().enqueue(object : Callback<PostResponseRS> {
            override fun onResponse(call: Call<PostResponseRS>, response: Response<PostResponseRS>) {
                if (response.isSuccessful){
                    val listData = response.body()!!.rumah_sakit
                    postAdapterRS.setData(listData)

                }else{
                    Toast.makeText(
                        activity,
                        "gagal get data",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onFailure(call: Call<PostResponseRS>, t: Throwable) {
                Log.e("reportActivity", t.toString())
            }

        })
    }

}