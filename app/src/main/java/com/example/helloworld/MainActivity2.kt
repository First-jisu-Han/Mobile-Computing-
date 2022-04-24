package com.example.helloworld

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.Toast
import com.example.helloworld.databinding.ActivityMain2Binding
import java.lang.ArithmeticException
import java.lang.NumberFormatException

class MainActivity2 : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        var num1: Double
        var num2: Double
        var result: Double

        binding.B0.setOnClickListener(this)
        binding.B1.setOnClickListener(this)
        binding.B2.setOnClickListener(this)
        binding.B3.setOnClickListener(this)
        binding.B4.setOnClickListener(this)
        binding.B5.setOnClickListener(this)
        binding.B6.setOnClickListener(this)
        binding.B7.setOnClickListener(this)
        binding.B8.setOnClickListener(this)
        binding.B9.setOnClickListener(this)

        binding.add.setOnClickListener {
            try {
                num1 = binding.num1.text.toString().toDouble()
                num2 = binding.num2.text.toString().toDouble()
                result = num1 + num2
                binding.result.text = getString(R.string.result, result.toString())
            } catch (e: NumberFormatException) {
                Toast.makeText(applicationContext, "숫자를 입력하시오", Toast.LENGTH_SHORT).show()
            } catch (e: StackOverflowError) {
                Toast.makeText(applicationContext, "너무 큰 숫자입니다.줄이십쇼", Toast.LENGTH_SHORT).show()
            }
        }
        binding.sub.setOnClickListener {
            try {
                num1 = binding.num1.text.toString().toDouble()
                num2 = binding.num2.text.toString().toDouble()
                result = num1 - num2
                binding.result.text = getString(R.string.result, result.toString())
            } catch (e: NumberFormatException) {
                Toast.makeText(applicationContext, "숫자를 입력하시오", Toast.LENGTH_SHORT).show()
            } catch (e: StackOverflowError) {
                Toast.makeText(applicationContext, "너무 큰 숫자입니다.줄이십쇼", Toast.LENGTH_SHORT).show()
            }
        }
        binding.mul.setOnClickListener {
            try {
                num1 = binding.num1.text.toString().toDouble()
                num2 = binding.num2.text.toString().toDouble()
                result = num1 * num2
                binding.result.text = getString(R.string.result, result.toString())
            } catch (e: NumberFormatException) {
                Toast.makeText(applicationContext, "숫자를 입력하시오", Toast.LENGTH_SHORT).show()
            } catch (e: StackOverflowError) {
                Toast.makeText(applicationContext, "너무 큰 숫자입니다.줄이십쇼", Toast.LENGTH_SHORT).show()
            }
        }

        binding.div.setOnClickListener {
            try {
                num1 = binding.num1.text.toString().toDouble()
                num2 = binding.num2.text.toString().toDouble()
                result = num1 / num2
                if (result.isInfinite()) {
                    Toast.makeText(
                        applicationContext,
                        "나누는 수는 0이될 수 없습니다 다시입력하시오",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@setOnClickListener
                }
                binding.result.text = getString(R.string.result, result.toString())
            } catch (e: NumberFormatException) {
                Toast.makeText(applicationContext, "숫자를 입력하시오", Toast.LENGTH_SHORT).show()
            } catch (e: ArithmeticException) {
                Toast.makeText(applicationContext, "나누는 수는 0이될 수 없습니다 다시입력하시오", Toast.LENGTH_SHORT)
                    .show()
            } catch (e: StackOverflowError) {
                Toast.makeText(applicationContext, "너무 큰 숫자입니다.줄이십쇼", Toast.LENGTH_SHORT).show()
            }
        }
    }

        /* 포커스가 숫자에 없을때 자동으로 키보드를 사라지게 만드는 메서드 */
        override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
            if (currentFocus != null) {
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
            }
            return super.dispatchTouchEvent(ev)
        }

        // 버튼을 누르먄, 해당 포커스가 있는 숫자를 input 변수에 계속 추가 1 클릭 , 2 클릭 => 12
        // editText num1 부분과 num2 부분 둘 다 똑같이 작동 , 만약 다른곳을 클릭하면 메세지나오게끔
        override fun onClick(v: View?) {
            var input: String = (v as Button).text.toString() // v를 Button 으로 캐스팅
            if(binding.num1.isFocusable) {
                input = binding.num1.text.toString() + input
                binding.num1.setText(input)
            } else if (binding.num2.isFocused) {
                input = binding.num2.text.toString() + input
                binding.num2.setText(input)
            } else {
                Toast.makeText(applicationContext, "숫자 1 또는 2를 클릭해라", Toast.LENGTH_SHORT).show()
            }
        }
    }


