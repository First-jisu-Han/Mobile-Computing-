package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.helloworld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding   // viewBinding 을 사용하기 위해 클래스를 저장
    override fun onCreate(savedInstanceState: Bundle?) {
        var num1:Int
        var num2:Int
        var result:Int
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater) // xml에 있는 레이아웃정보들을 받아올 수 있게 inflate 함수실행
        setContentView(binding.root)  // viewBinding을 위해서 수정

        binding.add.setOnClickListener{
            num1=binding.num1.ㅅtoString().toInt()
            num2=binding.num2.toString().toInt()
            result=num1+num2
            binding.result.text=getString(R.string.result,result.toString())
        }
        binding.sub.setOnClickListener{
            num1=binding.num1.toString().toInt()
            num2=binding.num2.toString().toInt()
            result=num1-num2
            binding.result.text=getString(R.string.result,result.toString())
        }
        binding.mul.setOnClickListener{
            num1=binding.num1.toString().toInt()
            num2=binding.num2.toString().toInt()
            result=num1*num2
            binding.result.text=getString(R.string.result,result.toString())
        }
        binding.div.setOnClickListener{
            num1=binding.num1.toString().toInt()
            num2=binding.num2.toString().toInt()
            result=num1/num2
            binding.result.text=getString(R.string.result,result.toString())
        }

        }
    }
