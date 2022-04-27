package com.example.helloworld

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.helloworld.databinding.ActivityMain2Binding
import com.example.helloworld.databinding.ActivityMainBinding
import java.io.FileInputStream
import java.io.IOException
import java.nio.charset.Charset


class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnRead.setOnClicListener{
            try{
                var inFs: FileInputStream=openFileInput("file.txt")
                var txt=ByteArray(30)
                inFs.read(txt)
                var str=txt.toString(Charsets.UTF_8)
                Toast.makeText(applicationContext,str,Toast.LENGTH_SHORT).show()
                inFs.close()
            } catch(e:IOException){
                Toast.makeText(applicationContext,"파일없음",Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnWrite.setOnclickListener{
            var outFs : FileInputStream  =openFileOutput("file.txt", Context.MODE_PRIVATE)
            var str= "얄미운 나비"
            outFs.write (str.toByteArray())
            outFs.close()
            Toast.makeText(applicationContext,"file.txt생성",Toast.LENGTH_SHORT).show()
        }
    }
}