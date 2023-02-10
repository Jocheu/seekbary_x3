package com.example.seekbary_x3

import android.opengl.Matrix
import android.os.Bundle
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Objects

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val  img1HorizontalSeekbar = findViewById<SeekBar>(R.id.img1Horizontal)
        val  img2HorizontalSeekbar = findViewById<SeekBar>(R.id.img2Horizontal)
        val  img3HorizontalSeekbar = findViewById<SeekBar>(R.id.img3Horizontal)
        val img1VerticalSeekbar = findViewById<SeekBar>(R.id.img1Vertical)
        val img2VerticalSeekbar = findViewById<SeekBar>(R.id.img2Vertical)
        val img3VerticalSeekbar = findViewById<SeekBar>(R.id.img3Vertical)
        val img1 = findViewById<ImageView>(R.id.imageView)
        val img2 = findViewById<ImageView>(R.id.imageView2)
        val img3 = findViewById<ImageView>(R.id.imageView5)
        val list = listOf<SeekBar>(img1HorizontalSeekbar, img2HorizontalSeekbar, img3HorizontalSeekbar, img1VerticalSeekbar, img2VerticalSeekbar, img3HorizontalSeekbar)
        for(i in list){
            i.progress = 100
        }


        fun a(seekBar: SeekBar, img: ImageView, dir: Int){
            if(dir == 1){
                seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
                    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                        img.layoutParams.width = seekBar.progress*4+1
                        img.requestLayout()
                    }

                    override fun onStartTrackingTouch(p0: SeekBar?) {

                    }

                    override fun onStopTrackingTouch(p0: SeekBar?) {

                    }
                })
            }
            else if(dir==2){
                seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
                    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                        img.layoutParams.height = seekBar.progress*4+1
                        img.requestLayout()
                    }

                    override fun onStartTrackingTouch(p0: SeekBar?) {

                    }

                    override fun onStopTrackingTouch(p0: SeekBar?) {

                    }
                })
            }
        }
        a(img2HorizontalSeekbar,img2,1)
    }
}