package com.genxmultiplexer.collapsingtoolbar


import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.palette.graphics.Palette
import com.google.android.material.appbar.CollapsingToolbarLayout


class MainActivity2 : AppCompatActivity() {
    lateinit var toolbar:androidx.appcompat.widget.Toolbar
    lateinit var collapsingToolbarLayout: CollapsingToolbarLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        toolbar=findViewById(R.id.toolbarId)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        collapsingToolbarLayout=findViewById(R.id.collapsingLayoutId)
        collapsingToolbarLayout.title="Page title Here"

        val bitmap:Bitmap=BitmapFactory.decodeResource(resources,R.drawable.road)
        createPaletteAsync(bitmap)
    }

    private fun createPaletteAsync(bitmap: Bitmap) {
        Palette.from(bitmap).generate {
            if (it != null) {
                collapsingToolbarLayout.setContentScrimColor(it.getMutedColor(R.attr.colorPrimary))
            }
        }
    }
}