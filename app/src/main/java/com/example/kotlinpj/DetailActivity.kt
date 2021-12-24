package com.example.kotlinpj

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    val TAG = DetailActivity::class.java.toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        initView()
    }

    fun initView(){
        val tv_detail = findViewById<TextView>(R.id.tv_detail)
        val btn_Exit = findViewById<Button>(R.id.btn_exit)

        btn_Exit.setOnClickListener {
            backToFinish()
        }

        //var name = intent.getStringExtra("name")
        var user = intent.getSerializableExtra("user")
        tv_detail.setText(user.toString())

        Log.d(TAG, user.toString())
    }
    fun backToFinish(){
        val intent = Intent()
        intent.putExtra("result", "Thanks a lot")
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}