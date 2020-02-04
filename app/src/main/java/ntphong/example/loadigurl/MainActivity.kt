package ntphong.example.loadigurl

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URL
import java.net.URLConnection

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadimage().execute("https://howdoigo.asia/hanoi-to-ninh-binh-train-bus-or-taxi/")
    }
    inner class loadimage : AsyncTask<String,Void,Bitmap>(){
        override fun doInBackground(vararg params: String?): Bitmap {
            val url  = URL(params[0])
            val inputStream=url.openConnection().getInputStream()
            val bitmap:Bitmap=BitmapFactory.decodeStream(inputStream)
            return bitmap
        }

        override fun onPostExecute(result: Bitmap?) {
            super.onPostExecute(result)
            imgURL.setImageBitmap(result)
        }

    }
}
