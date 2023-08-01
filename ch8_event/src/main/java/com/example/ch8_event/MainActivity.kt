package com.example.ch8_event

import android.os.Bundle
import android.os.SystemClock
import android.view.KeyEvent
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.ch8_event.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {
    // 뒤로가기 버튼 누른 시각을 저장하는 속성
    var initTime = 0L

    // 멈춘 시각 저장하는 속성
    var pauseTime = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startbutton.setOnClickListener {
            binding.chronometer.base = SystemClock.elapsedRealtime() + pauseTime
            binding.chronometer.start()
            // 버튼 표시 여부 조정
            binding.stopbutton.isEnabled = true
            binding.resetbutton.isEnabled = true
            binding.startbutton.isEnabled = false
        }

        binding.stopbutton.setOnClickListener {
            pauseTime = binding.chronometer.base - SystemClock.elapsedRealtime()
            binding.chronometer.stop()
            binding.stopbutton.isEnabled = false
            binding.resetbutton.isEnabled = true
            binding.startbutton.isEnabled = true
        }

        binding.resetbutton.setOnClickListener {
            pauseTime = 0L
            binding.chronometer.base = SystemClock.elapsedRealtime()
            binding.chronometer.stop()
            binding.stopbutton.isEnabled = false
            binding.resetbutton.isEnabled = false
            binding.startbutton.isEnabled = true
        }
    }
    // 뒤로가기 버튼 이벤트 핸들러
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        // 뒤로가기 버튼 눌렀을 때 처리
        if (keyCode === KeyEvent.KEYCODE_BACK) {
            // 뒤로가기 버튼을 처음 눌렀거나 누른 지 3초 지났을 때 처리
            if (System.currentTimeMillis() - initTime > 3000) {
                Toast.makeText(this, "종료하려면 한 번 더 누르세요!!",Toast.LENGTH_SHORT).show()
                initTime = System.currentTimeMillis()
                return true
            }
        }
        return super.onKeyDown(keyCode, event)
    }
}
