# 주제
전화번호 키패드 화면을 구현했다. `레이아웃`을 다양하게 사용하였다.
책에서는 화면만 구현하지만 한 번 텍스트 뷰 이벤트 처리로 `입력 기능`도 구현해봤다.
![](https://velog.velcdn.com/images/kuronuma_daisy/post/2b424295-1e0b-49f8-96a3-b84c81cd7a26/image.png)

# 완성 모습
모든 번호 키패드 클릭시 번호 출력 잘 되고 지우기 버튼도 잘 된다.
마지막에 잘 안 보이지만 지우기 버튼 연타하고 있다.
![](https://velog.velcdn.com/images/kuronuma_daisy/post/12020e18-935e-4c87-9881-690d5e2e451f/image.gif)

# 느낀 점
* 처음에 "전화번호 입력" 이라는 힌트 문구 뒤에 번호가 덧붙여져서 당황했다. 가끔 그런 키패드도 만나본 것 같은데 개인적으로 불편했던 경험이기 때문에 `첫 번호 입력시 힌트 문구는 지워지도록` 구현하였다.
* 이왕 해보는거 지우기 버튼도 구현해보려고 추가했다. 잘 구현했다고 생각하며 버튼을 연타했다가 애플리케이션이 튕겨졌다. 입력창이 비어있을 때 지우려고 하면 에러가 난 것이기 때문에 isEmpty() 함수로 조건을 붙여 해결하였다.
* 뷰 바인딩을 사용해봤다. binding.id로 계속 작성하니 코드가 길어보여서 tv_num 변수로 대입해 길이를 줄여 사용해봤는데, 사실 별 차이는 없을 것 같다.
# 코드
반복되는 코드가 많다. 전화번호 키패드를 직접 구현하는 더 좋은 방법이 있을지 궁금하다.
### 액티비티
```kotlin
package toss.next.ch7_layout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import toss.next.ch7_layout.databinding.ActivityMainBinding
import toss.next.ch7_layout.ui.theme.AndroidLabTheme

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
```
### xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center_horizontal">
    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="20dp">
        <ImageView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:src="@drawable/add"
            android:tint="#00DD00"/>
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="연락처에 추가"
            android:textColor="#00DD00"
            android:textStyle="bold"
            android:layout_gravity="center"/>
    </LinearLayout>
    <TextView
        android:id="@+id/tv_numbers"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="100dp"
        android:text="전화번호 입력"
        android:textSize="40dp"/>
    <GridLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:columnCount="3"
        android:layout_marginTop="10dp">
        <TextView
            android:id="@+id/one"
            android:text="1"
            android:textSize="30dp"
            android:textStyle="bold"
            android:paddingLeft="40dp"
            android:paddingRight="40dp"
            android:paddingBottom="10dp"
            android:paddingTop="10dp"/>
        <TextView
            android:id="@+id/two"
            android:text="2"
            android:textSize="30dp"
            android:textStyle="bold"
            android:paddingLeft="40dp"
            android:paddingRight="40dp"
            android:paddingBottom="10dp"
            android:paddingTop="10dp"/>
        <TextView
            android:id="@+id/three"
            android:text="3"
            android:textSize="30dp"
            android:textStyle="bold"
            android:paddingLeft="40dp"
            android:paddingRight="40dp"
            android:paddingBottom="10dp"
            android:paddingTop="10dp"/>
        <TextView
            android:id="@+id/four"
            android:text="4"
            android:textSize="30dp"
            android:textStyle="bold"
            android:paddingLeft="40dp"
            android:paddingRight="40dp"
            android:paddingBottom="10dp"
            android:paddingTop="10dp"/>
        <TextView
            android:id="@+id/five"
            android:text="5"
            android:textSize="30dp"
            android:textStyle="bold"
            android:paddingLeft="40dp"
            android:paddingRight="40dp"
            android:paddingBottom="10dp"
            android:paddingTop="10dp"/>
        <TextView
            android:id="@+id/six"
            android:text="6"
            android:textSize="30dp"
            android:textStyle="bold"
            android:paddingLeft="40dp"
            android:paddingRight="40dp"
            android:paddingBottom="10dp"
            android:paddingTop="10dp"/>
        <TextView
            android:id="@+id/seven"
            android:text="7"
            android:textSize="30dp"
            android:textStyle="bold"
            android:paddingLeft="40dp"
            android:paddingRight="40dp"
            android:paddingBottom="10dp"
            android:paddingTop="10dp"/>
        <TextView
            android:id="@+id/eight"
            android:text="8"
            android:textSize="30dp"
            android:textStyle="bold"
            android:paddingLeft="40dp"
            android:paddingRight="40dp"
            android:paddingBottom="10dp"
            android:paddingTop="10dp"/>
        <TextView
            android:id="@+id/nine"
            android:text="9"
            android:textSize="30dp"
            android:textStyle="bold"
            android:paddingLeft="40dp"
            android:paddingRight="40dp"
            android:paddingBottom="10dp"
            android:paddingTop="10dp"/>
        <TextView
            android:id="@+id/star"
            android:text="*"
            android:textSize="30dp"
            android:textStyle="bold"
            android:paddingLeft="40dp"
            android:paddingRight="40dp"
            android:paddingBottom="10dp"
            android:paddingTop="10dp"/>
        <TextView
            android:id="@+id/zero"
            android:text="0"
            android:textSize="30dp"
            android:textStyle="bold"
            android:paddingLeft="40dp"
            android:paddingRight="40dp"
            android:paddingBottom="10dp"
            android:paddingTop="10dp"/>
        <TextView
            android:id="@+id/sharp"
            android:text="#"
            android:textSize="30dp"
            android:textStyle="bold"
            android:paddingLeft="40dp"
            android:paddingRight="40dp"
            android:paddingBottom="10dp"
            android:paddingTop="10dp"/>
    </GridLayout>
    <RelativeLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="20dp">
        <ImageView
            android:id="@+id/icon_video"
            android:src="@drawable/video"
            android:layout_width="50dp"
            android:layout_height="50dp"
            android:layout_marginRight="30dp"/>
        <ImageView
            android:id="@+id/icon_call"
            android:layout_height="50dp"
            android:layout_width="50dp"
            android:src="@drawable/call"
            android:layout_toRightOf="@+id/icon_video"/>
        <ImageView
            android:id="@+id/icon_back"
            android:layout_height="50dp"
            android:layout_width="50dp"
            android:src="@drawable/back"
            android:layout_toRightOf="@+id/icon_call"
            android:layout_marginLeft="30dp"/>
    </RelativeLayout>
</LinearLayout>
```
# [해당 프로젝트 벨로그 링크](https://velog.io/@kuronuma_daisy/Android-%EC%A0%84%ED%99%94%EB%B2%88%ED%98%B8-%ED%82%A4%ED%8C%A8%EB%93%9C-%ED%99%94%EB%A9%B4-%EA%B5%AC%ED%98%84)
