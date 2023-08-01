package com.example.ch7_layout

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.ch7_layout.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //바인딩 객체 획득
        val binding = ActivityMainBinding.inflate(layoutInflater)
        //액티비티 화면 출력
        setContentView(binding.root)

        //뷰 객체 이용
        binding.one.setOnClickListener {
            if (binding.tvNumbers.text=="전화번호 입력"){
                binding.tvNumbers.text = "${binding.one.text}"
            }else{
                binding.tvNumbers.text = "${binding.tvNumbers.text}${binding.one.text}"
            }
        }
        //반복 객체 변수에 대입해서 길이 줄이기!!
        val tv_num = binding.tvNumbers
        binding.two.setOnClickListener {
            if (tv_num.text=="전화번호 입력"){
                tv_num.text = "${binding.two.text}"
            }else{
                tv_num.text = "${tv_num.text}${binding.two.text}"
            }
        }
        binding.three.setOnClickListener {
            if (tv_num.text=="전화번호 입력"){
                tv_num.text = "${binding.three.text}"
            }else{
                tv_num.text = "${tv_num.text}${binding.three.text}"
            }
        }
        binding.four.setOnClickListener {
            if (tv_num.text=="전화번호 입력"){
                tv_num.text = "${binding.four.text}"
            }else{
                tv_num.text = "${tv_num.text}${binding.four.text}"
            }
        }
        binding.five.setOnClickListener {
            if (tv_num.text=="전화번호 입력"){
                tv_num.text = "${binding.five.text}"
            }else{
                tv_num.text = "${tv_num.text}${binding.five.text}"
            }
        }
        binding.six.setOnClickListener {
            if (tv_num.text=="전화번호 입력"){
                tv_num.text = "${binding.six.text}"
            }else{
                tv_num.text = "${tv_num.text}${binding.six.text}"
            }
        }
        binding.seven.setOnClickListener {
            if (tv_num.text=="전화번호 입력"){
                tv_num.text = "${binding.seven.text}"
            }else{
                tv_num.text = "${tv_num.text}${binding.seven.text}"
            }
        }
        binding.eight.setOnClickListener {
            if (tv_num.text=="전화번호 입력"){
                tv_num.text = "${binding.eight.text}"
            }else{
                tv_num.text = "${tv_num.text}${binding.eight.text}"
            }
        }
        binding.nine.setOnClickListener {
            if (tv_num.text=="전화번호 입력"){
                tv_num.text = "${binding.nine.text}"
            }else{
                tv_num.text = "${tv_num.text}${binding.nine.text}"
            }
        }
        binding.zero.setOnClickListener {
            if (tv_num.text=="전화번호 입력"){
                tv_num.text = "${binding.zero.text}"
            }else{
                tv_num.text = "${tv_num.text}${binding.zero.text}"
            }
        }
        binding.star.setOnClickListener {
            if (tv_num.text=="전화번호 입력"){
                tv_num.text = "${binding.star.text}"
            }else{
                tv_num.text = "${tv_num.text}${binding.star.text}"
            }
        }
        binding.sharp.setOnClickListener {
            if (tv_num.text=="전화번호 입력"){
                tv_num.text = "${binding.sharp.text}"
            }else{
                tv_num.text = "${tv_num.text}${binding.sharp.text}"
            }
        }
        binding.iconBack.setOnClickListener {
            if (!tv_num.text.isEmpty()) {
                tv_num.text = tv_num.text
                    .substring(0, tv_num.text.length - 1)
            }
        }
    }
}
