# 프로젝트 내용
* Chronometer 클래스 사용하여 스톱워치 시작, 정지, 리셋 버튼 구현
* 뒤로 가기 버튼 이벤트 처리

# 완성 모습
![](https://velog.velcdn.com/images/kuronuma_daisy/post/bc8698a5-67f5-4176-a702-6c5e199619e4/image.gif)

# 설명
## 스톱워치 기능
### Start 버튼
> 시작 버튼 이벤트 처리
binding.chronometer.base = pauseTime `멈췄던 시간` + SystemClock.elapsedRealtime() `부팅 후 지속 경과 시간`
binding.chronometer.base = 0으로 두면 Chronometer의 시계에 자동으로 부팅을 한 시점으로부터의 경과 시간이 나온다. SystemClock.elapsedRealtime()은 부팅 이후의 시간 경과를 뜻한다. 그러므로 base를 경과 시간으로 둬야 시계가 `00:00`부터 시작하는 것 같다!
pauseTime 더하는 부분은 아래 정지 버튼 이벤트 처리에 설명했다.

```kotlin
binding.startbutton.setOnClickListener {
            binding.chronometer.base = SystemClock.elapsedRealtime() + pauseTime
            binding.chronometer.start()
            // 버튼 표시 여부 조정
            binding.stopbutton.isEnabled = true
            binding.resetbutton.isEnabled = true
            binding.startbutton.isEnabled = false
        }
```
### Stop 버튼
> 정지 버튼 이벤트 처리
pauseTime `정지 시간` = binding.chronometer.base`Start 누를 때 저장해둔 경과 시간` - SystemClock.elapsedRealtime() `현재 경과 시간`
이렇게 계산하면 pauseTime에는 측정된 시간의 음수값이 담긴다. 따라서 Start 버튼을 누를 때 부팅 후 경과시간에서 여태 측정된 시간의 음수값을 더하여 base를 다시 세팅하면, 멈췄던 시간부터 다시 측정할 수 있게 되는 것이다.

```kotlin
binding.stopbutton.setOnClickListener {
            pauseTime = binding.chronometer.base - SystemClock.elapsedRealtime()
            binding.chronometer.stop()
            binding.stopbutton.isEnabled = false
            binding.resetbutton.isEnabled = true
            binding.startbutton.isEnabled = true
        }
```
### Reset 버튼
> 리셋 버튼 이벤트 처리
base를 다시 SystemClock.elapsedRealtime()로 바꾼다. 그럼 시계가 `00:00`이 되겠죵!!!! 드디어 이해했다~!

```kotlin
binding.resetbutton.setOnClickListener {
            pauseTime = 0L
            binding.chronometer.base = SystemClock.elapsedRealtime()
            binding.chronometer.stop()
            binding.stopbutton.isEnabled = false
            binding.resetbutton.isEnabled = false
            binding.startbutton.isEnabled = true
        }
```
## 뒤로 가기 버튼 이벤트 처리
> OS의 뒤로 가기 버튼 첫 클릭시 System.currentTimeMillis() `현재시각`에서 initTime `0`을 빼면 Toast 메시지를 띄우고 super.onKeyDown(keyCode, event)가 아닌 true를 리턴하여 종료되지 않게 한다.

> 이때 initTime에 System.currentTimeMillis() `현재시각`이 저장되었기 때문에 다시 클릭시 클릭시점 시간과 initTime의 차가 3000밀리세컨 이하라면(종료버튼을 빠르게 두 번 눌렀다면) super.onKeyDown(keyCode, event)가 리턴되어 원래대로 종료 버튼의 기능을 수행한다.

```kotlin
override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        // 뒤로 가기 버튼 눌렀을 때 처리
        if (keyCode === KeyEvent.KEYCODE_BACK) {
            // 뒤로 가기 버튼을 처음 눌렀거나 누른 지 3초 지났을 때 처리
            if (System.currentTimeMillis() - initTime > 3000) {
                Toast.makeText(this, "종료하려면 한 번 더 누르세요!!",Toast.LENGTH_SHORT).show()
                initTime = System.currentTimeMillis()
                return true
            }
        }
        return super.onKeyDown(keyCode, event)
    }
```


# 배운 점
* chronometer.base는 `부팅 경과 시간 기준`이다. 이걸 몰라서 이해하는 데 한참 걸렸다! base를 0으로 둬보고, Log를 찍어보며 깨달았다. 따라서 말 그대로 base를 부팅 경과 시간으로 둬야 start 시점부터의 경과 시간을 잴 수 있어 스톱워치로서의 역할을 할 수 있게 된다. 
* 예전에도 구현해본 기능인데, 하나하나 이해해보려고 하니 새로운 공부가 되어 부끄럽기도 하다.. ㅎ
* System.currentTimeMillis() 값을 이용해서 `클릭 시간 차`를 알 수 있음을 상기시켰다.

# 벨로그

