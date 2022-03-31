package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.helloworld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding   // viewBinding 사용
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater) // viewBinding 을 위해 추가해줘야됨
        setContentView(binding.root)  // viewBinding을 위해서 수정
        binding.name.setOnClickListener{ Toast.makeText(applicationContext,"JISU HAN",Toast.LENGTH_LONG).show() }
        binding.id.setOnClickListener{ Toast.makeText(applicationContext,"60172390",Toast.LENGTH_LONG).show() }
    }
}