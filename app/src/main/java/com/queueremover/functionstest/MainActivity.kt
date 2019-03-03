package com.queueremover.functionstest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject


class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        button.setOnClickListener {
            getResponse(inputTextView.text.toString())
        }
    }

    private fun getResponse(userInput: String) {
        AndroidNetworking.get("https://us-central1-functionstest-35e54.cloudfunctions.net/tstFuncOne")
            .addQueryParameter("textData", userInput)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {
                    textView.text = response!!.getString("input")
                }

                override fun onError(anError: ANError?) {
                }
            })
    }
}
