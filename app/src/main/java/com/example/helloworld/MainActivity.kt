package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var name: Button  // 버튼 id로 버튼 변수 선언 - name
    lateinit var id: Button  //  버튼 id러 버튼 변수 선언  - id

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name = findViewById<Button>(R.id.name)
        id= findViewById<Button>(R.id.id)
        name.setOnClickListener{
            Toast.makeText(applicationContext,"JISU HAN",Toast.LENGTH_LONG).show()
        }
        id.setOnClickListener{
            Toast.makeText(applicationContext,"60172390",Toast.LENGTH_LONG).show()
        }


    }
}