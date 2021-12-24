package com.example.kotlinpj

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.kotlinpj.model.User

class MainActivity : AppCompatActivity() {

    val TAG = MainActivity::class.java.toString()
    lateinit var tv_home : TextView
    val LAUNCH_DETAIL = 1001


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == LAUNCH_DETAIL){
            if(resultCode == Activity.RESULT_OK){
                var result = data?.getStringExtra("result")
                Log.d(TAG, result!!)
                tv_home.setText(result)
            }
        }
    }

    fun initViews(){
        tv_home = findViewById(R.id.tv_home)
        val b_detail = findViewById<Button>(R.id.btn_open_detail)

        b_detail.setOnClickListener {
            var user = User(1, "Maqsud")
            openDetailActivity(user)
        }
    }

    fun openDetailActivity(user : User){
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("user", user)
        //startActivity(intent)

        startActivityForResult(intent, LAUNCH_DETAIL)
    }
}