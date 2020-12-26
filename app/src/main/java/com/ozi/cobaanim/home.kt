package com.ozi.cobaanim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ozi.cobaanim.camera.scanbarcode
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_mainn.*

class home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        barcodee.setOnClickListener {
            val p = Intent(this,mainn::class.java)
            startActivity(p)
        }
        grafik.setOnClickListener {
            val p = Intent(this,detail::class.java)
            startActivity(p)
        }
        camera.setOnClickListener {
            val o = Intent (this,scanbarcode::class.java)
            startActivity(o)
        }
    }
}