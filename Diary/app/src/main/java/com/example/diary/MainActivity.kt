package com.example.diary

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import java.io.IOException
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: SimplediaryBinding
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        binding=SimpledairyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var cal=Calendar.getInstance()
        var cYear=cal.get(Calendar.YEAR)
        var cMonth=cal.get(Calendar.MONTH)
        var cDay=cal.get(Calendar.DAY_OF_MONTH)
//        lateinit var fNmae=String
        var fName="${cYear}_${cMonth+1}+${cDay}.txt"
        binding.datePicker.init(cYear,cMonth,cDay){ view,year,month,day ->
            Log.d("TAG",fName)
            var str=readDiary(fName)
            binding.editText.setText(str)
        }
        binding.btnSmt.setOnClickListener{
            openFileOutput(fNmae, Context.MODE_PRIVATE).use {
                it.write(binding.editText.text.toString().toByteArray())
                Toast.makeText(applicationContext,"$fName 저장",Toast.LENGTH_SHORT).show()
            }
        }
        fun readDiary(fName:String):String?{
            var diaryStr:String?=null
            try{
                openFileInput(fName).bufferedReader().forEachLine {
                    if(diaryStr==null){diaryStr=it}
                    else{diaryStr+="\n"+it}
                    Log.d("TAG",diaryStr!!!)
                    binding.btnSmt.text="수정하기"
                    }
            } catch (e:IOException){
                binding.editText.hint="일기없음"
                binding.btnSmt.text="새로저장"
            }
            return diaryStr
        }
    }
}