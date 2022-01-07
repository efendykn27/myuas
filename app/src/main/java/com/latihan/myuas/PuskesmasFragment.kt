package com.latihan.myuas

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.latihan.myUAS.Adapter.PostAdapter
import com.latihan.myuas.model.PostResponse
import com.latihan.myUAS.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PuskesmasFragment : Fragment() {
    private val api by lazy { RetrofitClient().endpoint}
    private lateinit var postAdapter: PostAdapter
    private lateinit var listTamu : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_puskesmas, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        listTamu = view.findViewById(R.id.rvPost)
        setupList()
    }


    private fun setupList() {
//        listTamu = findViewById(R.id.rvPost)
        postAdapter = PostAdapter(arrayListOf())
        listTamu.adapter = postAdapter
    }

    override fun onStart(){
        super.onStart()
        getPuskesmas()
    }
    private fun getPuskesmas(){

        api.data().enqueue(object : Callback<PostResponse> {
            override fun onResponse(call: Call<PostResponse>, response: Response<PostResponse>) {
                if (response.isSuccessful){
                    val listData = response.body()!!.puskesmas
                    postAdapter.setData(listData)

                }else{
                    Toast.makeText(
                        activity,
                        "gagal get data",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                Log.e("reportActivity", t.toString())
            }

        })
    }
}