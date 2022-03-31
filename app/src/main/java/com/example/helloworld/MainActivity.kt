package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.helloworld.databinding.ActivityMainBinding
import java.lang.ArithmeticException
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding   // viewBinding 을 사용하기 위해 클래스를 저장
    override fun onCreate(savedInstanceState: Bundle?) {
        var num1:Double
        var num2:Double
        var result:Double
        super.onCreate(savedInstanceState)
        binding =
            ActivityMainBinding.inflate(layoutInflater) // xml에 있는 레이아웃정보들을 받아올 수 있게 inflate 함수실행
        setContentView(binding.root)  // viewBinding을 위해서 수정

        binding.add.setOnClickListener {
            try {
                num1 = binding.num1.text.toString().toDouble()
                num2 = binding.num2.text.toString().toDouble()
                result = num1 + num2
                binding.result.text = getString(R.string.result, result.toString())
            } catch (e: NumberFormatException) {
                Toast.makeText(applicationContext,"숫자를 입력하시오",Toast.LENGTH_SHORT).show()
            } catch (e:StackOverflowError){
                Toast.makeText(applicationContext,"너무 큰 숫자입니다.줄이십쇼",Toast.LENGTH_SHORT).show()
            }
        }
        binding.sub.setOnClickListener {
            try {
                num1 = binding.num1.text.toString().toDouble()
                num2 = binding.num2.text.toString().toDouble()
                result = num1 - num2
                binding.result.text = getString(R.string.result, result.toString())
            } catch (e: NumberFormatException) {
                Toast.makeText(applicationContext,"숫자를 입력하시오",Toast.LENGTH_SHORT).show()
            }catch (e:StackOverflowError){
                Toast.makeText(applicationContext,"너무 큰 숫자입니다.줄이십쇼",Toast.LENGTH_SHORT).show()
            }
        }
        binding.mul.setOnClickListener {
            try {
                num1 = binding.num1.text.toString().toDouble()
                num2 = binding.num2.text.toString().toDouble()
                result = num1 * num2
                binding.result.text = getString(R.string.result, result.toString())
            } catch (e: NumberFormatException) {
                Toast.makeText(applicationContext,"숫자를 입력하시오",Toast.LENGTH_SHORT).show()
            }catch (e:StackOverflowError){
                Toast.makeText(applicationContext,"너무 큰 숫자입니다.줄이십쇼",Toast.LENGTH_SHORT).show()
            }
        }

        binding.div.setOnClickListener {
            try {
                num1 = binding.num1.text.toString().toDouble()
                num2 = binding.num2.text.toString().toDouble()
                result = num1 / num2
                binding.result.text = getString(R.string.result, result.toString())
            } catch (e: NumberFormatException) {
                Toast.makeText(applicationContext,"숫자를 입력하시오",Toast.LENGTH_SHORT).show()
            } catch (e: ArithmeticException) {
                Toast.makeText(applicationContext,"나누는 수는 0이될 수 없습니다 다시입력하시오",Toast.LENGTH_SHORT).show()
            }catch (e:StackOverflowError){
                Toast.makeText(applicationContext,"너무 큰 숫자입니다.줄이십쇼",Toast.LENGTH_SHORT).show()
            }
        }
    }
}

