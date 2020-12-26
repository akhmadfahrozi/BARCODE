package com.ozi.cobaanim

import android.graphics.Bitmap
import android.graphics.Color
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import kotlinx.android.synthetic.main.activity_mainn.*
import org.jetbrains.anko.editText

class mainn : AppCompatActivity() {

    private val TAG = "mainn"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainn)


        button.setOnClickListener {
            val text = et_bar.text.toString()

            if (text.isNotBlank()) {
                val bitmap = generateQRCode(text)
                barcode.setImageBitmap(bitmap)
            }
        }
    }

    private fun generateQRCode(text: String): Bitmap {
        val width = 500
        val height = 500
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val codeWriter = MultiFormatWriter()
        try {
            val bitMatrix = codeWriter.encode(text, BarcodeFormat.QR_CODE, width, height)
            for (x in 0 until width) {
                for (y in 0 until height) {
                    bitmap.setPixel(x, y, if (bitMatrix[x, y]) Color.BLACK else Color.WHITE)
                }
            }
        } catch (e: WriterException) {
            Log.d(TAG , "generateQRCode: ${e.message}")
        }
        return bitmap
    }
}

