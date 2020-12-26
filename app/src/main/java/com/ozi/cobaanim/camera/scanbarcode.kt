package com.ozi.cobaanim.camera

import android.Manifest.permission.CAMERA
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Size
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import com.google.common.util.concurrent.ListenableFuture
import com.google.zxing.Result
import com.ozi.cobaanim.R
import kotlinx.android.synthetic.main.activity_scanbarcode.*
import me.dm7.barcodescanner.zxing.ZXingScannerView
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.jar.Manifest


class scanbarcode : AppCompatActivity() ,
    ZXingScannerView.ResultHandler, View.OnClickListener{

        private lateinit var mScannerView: ZXingScannerView
        private var isCaptured = false

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_scanbarcode)
            initScannerView()
            initDefaultView()
            button_reset.setOnClickListener(this)
        }

        private fun initScannerView() {
            mScannerView = ZXingScannerView(this)
            mScannerView.setAutoFocus(true)
            mScannerView.setResultHandler(this)
            frame_layout_camera.addView(mScannerView)
        }

        override fun onStart() {
            mScannerView.startCamera()
            doRequestPermission()
            super.onStart()
        }

        private fun doRequestPermission() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkSelfPermission(android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(arrayOf(android.Manifest.permission.CAMERA), 100)
                }
            }
        }

        override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
            when (requestCode) {
                100 -> {
                    initScannerView()
                }
                else -> {
                    /* nothing to do in here */
                }
            }
        }

        override fun onPause() {
            mScannerView.stopCamera()
            super.onPause()
        }

        private fun initDefaultView() {
            text_view_qr_code_value.text = "QR Code Value"
            button_reset.visibility = View.GONE
        }

        override fun handleResult(rawResult: Result?) {
            text_view_qr_code_value.text = rawResult?.text
            button_reset.visibility = View.VISIBLE
        }

        override fun onClick(view: View?) {
            when (view?.id) {
                R.id.button_reset -> {
                    mScannerView.resumeCameraPreview(this)
                    initDefaultView()
                }
                else -> {
                    /* nothing to do in here */
                }
            }
        }

    }
