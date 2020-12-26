package com.ozi.cobaanim

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ozi.cobaanim.api.apiservice
import com.ozi.cobaanim.api2.apinet2
import com.ozi.cobaanim.api3.apin3
import com.ozi.cobaanim.model.Responsekaltim
import com.ozi.cobaanim.model2.ResponseIndo
import com.ozi.cobaanim.model3.Responsetambah
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getWindow().setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN)

        setdataaa()
//        setdataa2()

        st.setOnClickListener {
            val pp = Intent(this@MainActivity, detail::class.java)
            startActivity(pp)
        }
        val button_simpan = findViewById<Button>(R.id.simpan)
        button_simpan.setOnClickListener {
            simpan(
                nama.text.toString(), positif.text.toString(),
                meninggal.text.toString(), sembuh.text.toString()
            )
        }
    }

    private fun simpan(//di samakan di ------------Data item Murid
        nama: String?,
        positif: String?,
        meninggal: String?,
        sembuh: String?
    ) {
        apin3.net()?.tambahmurid(
            nama, positif, meninggal, sembuh
        )?.enqueue(object : Callback<Responsetambah> {
            override fun onFailure(call: Call<Responsetambah>, t: Throwable) {


            }

            override fun onResponse(
                call: Call<Responsetambah>,
                response: Response<Responsetambah>
            ) {
                if (response.isSuccessful) {
                    var data = response.body()?.message
                    toast(data.toString())
                } else {

                }
            }

        })
    }


    private fun setdata(responn: List<Responsekaltim>) {

        val respone = responn[0]
        sembuh.setText("${respone.sembuh}")
        positif.setText("${respone.positif}")
        meninggal.setText(("${respone.meninggal}"))

    }

    private fun setdata2(responn: List<ResponseIndo>) {

        val respone = responn[0]
        sembuh2.setText("${respone.sembuh}")
        positif2.setText("${respone.getpositif()}")
        meninggal2.setText(("${respone.meninggal}"))
    }

//    private fun setdataa2() {
//
//        apinet2.service()?.getindo()
//            ?.enqueue(object : Callback<List<ResponseIndo>> {
//                override fun onFailure(call: Call<List<ResponseIndo>>?, t: Throwable?) {
//                    Toast.makeText(this@MainActivity, "ERROR HOST ", Toast.LENGTH_LONG).show()
//
//                }
//
//                override fun onResponse(
//                    call: Call<List<ResponseIndo>>,
//                    response: Response<List<ResponseIndo>>
//                ) {
//                    if (response?.isSuccessful!!) {
//
//                        val main: List<ResponseIndo> = response.body()!!
//                        setdata2(main)
//
//
//                    } else {
//                        Toast.makeText(this@MainActivity, "Hasil data", Toast.LENGTH_LONG)
//                            .show()
//
//                    }
//                }
//
//            })
//    }

    private fun setdataaa() {

        apiservice.getService()?.getData()
            ?.enqueue(object : Callback<List<Responsekaltim>> {
                override fun onFailure(call: Call<List<Responsekaltim>>?, t: Throwable?) {
                    Toast.makeText(this@MainActivity, "ERROR HOST ", Toast.LENGTH_LONG).show()

                }

                override fun onResponse(
                    call: Call<List<Responsekaltim>>,
                    response: Response<List<Responsekaltim>>
                ) {
                    if (response?.isSuccessful!!) {

                        val main: List<Responsekaltim> = response.body()!!
                        setdata(main)


                    } else {
                        Toast.makeText(this@MainActivity, "Hasil data", Toast.LENGTH_LONG)
                            .show()

                    }
                }

            })
    }


}
