package com.example.seekbary_x3

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val  img1HorizontalSeekbar = findViewById<SeekBar>(R.id.img1Horizontal)
        val density = applicationContext.resources.displayMetrics.density
        val  img2HorizontalSeekbar = findViewById<SeekBar>(R.id.img2Horizontal)
        val  img3HorizontalSeekbar = findViewById<SeekBar>(R.id.img3Horizontal)
        val img1VerticalSeekbar = findViewById<SeekBar>(R.id.img1Vertical)
        val img2VerticalSeekbar = findViewById<SeekBar>(R.id.img2Vertical)
        val img3VerticalSeekbar = findViewById<SeekBar>(R.id.img3Vertical)
        val img1 = findViewById<ImageView>(R.id.imageView)
        val img2 = findViewById<ImageView>(R.id.imageView2)
        val img3 = findViewById<ImageView>(R.id.imageView3)
        val progresText1 = findViewById<TextView>(R.id.progressText1)
        val progresText2 = findViewById<TextView>(R.id.progressText2)
        val resetButton = findViewById<Button>(R.id.reset_button)
        val list = listOf<SeekBar>(img1HorizontalSeekbar, img2HorizontalSeekbar, img3HorizontalSeekbar, img1VerticalSeekbar, img2VerticalSeekbar, img3VerticalSeekbar)
        for(i in list){
            i.progress = 150
        }
        val progressBarHoriz = findViewById<ProgressBar>(R.id.progressBar)
        val progressBarVert = findViewById<ProgressBar>(R.id.progressBar2)
        fun updateProgress(progressBar: ProgressBar, dir:Int){
            if(dir==1){
                var progressTotal = (img1HorizontalSeekbar.progress + img2HorizontalSeekbar.progress + img3HorizontalSeekbar.progress)/4.5
                progressBarHoriz.setProgress(progressTotal.toInt())
                progresText1.text = progressTotal.toString() + "%"

            }
            else if(dir==2){
                var progressTotal = (img1VerticalSeekbar.progress + img2VerticalSeekbar.progress + img3VerticalSeekbar.progress)/4.5
                progressBarVert.setProgress(progressTotal.toInt())
                progresText2.text = progressTotal.toString() + "%"
            }
        }
        updateProgress(progressBarHoriz, 1)
        updateProgress(progressBarVert,2)

        fun a(seekBar: SeekBar, img: ImageView, dir: Int){
            if(dir == 1){
                seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
                    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                        img.layoutParams.width = (seekBar.progress*density).toInt() + 1
                        img.requestLayout()
                        updateProgress(progressBarHoriz, 1)
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
                        img.layoutParams.height = (seekBar.progress*density).toInt() + 1
                        img.requestLayout()
                        updateProgress(progressBarVert,2)
                    }

                    override fun onStartTrackingTouch(p0: SeekBar?) {

                    }

                    override fun onStopTrackingTouch(p0: SeekBar?) {

                    }
                })
            }
        }
        resetButton.setOnClickListener {
            for(i in list){
                i.progress =150
                updateProgress(progressBarHoriz, 1)
                updateProgress(progressBarVert,2)
            }
        }

        a(img1HorizontalSeekbar,img1,1)
        a(img1VerticalSeekbar,img1,2)
        a(img2HorizontalSeekbar,img2,1)
        a(img2VerticalSeekbar,img2,2)
        a(img3HorizontalSeekbar,img3,1)
        a(img3VerticalSeekbar,img3,2)
    }
}