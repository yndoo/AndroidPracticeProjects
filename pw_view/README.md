## 주제 
카카오톡 비밀번호 확인 화면을 따라했다. 화면만 구현했다.  
  
![](https://velog.velcdn.com/images/kuronuma_daisy/post/3140ed4b-172a-4731-b5ab-c2f01d74a8ab/image.png)  
[사진 출처 블로그](https://daily-life24.tistory.com/341)

## 완성 모습  
가지고 있던 태블릿에 실행하였다.  
![](https://velog.velcdn.com/images/kuronuma_daisy/post/d419be83-8e72-4252-be9a-1cc41f5c7238/image.gif)

## 느낀 점  
* EditText의 inputType 옵션이 정말 다양하다. 
  * 아이디 입력 부분에는 textEmailAddress로 옵션으로 넣었고, 비밀번호에는 textPassword를 옵션으로 했다.
  * 다양한 속성값 : none, text, textCapSentences, textEmailAddress, textPassword, phone, number, numberPassword ... 더 많음.  
* 태블릿에 실행해보니 layout 구성과 padding, margin에 더 신경써야할 것 같다. 작은 화면보다 여백이 많이 느껴지기 때문이다. 여기서는 상위 LinearLayout에 `padding`을 `16dp > 50dp`로 늘리고, 제일 위에있는 TextView에 `marginTop`을 `16dp` 넣었다.
* string을 하드코딩하기보다 string 리소스에 등록하여 사용하는 것이 유지보수에 좋다.
* 요즘 자꾸 새 프로젝트 생성할 때마다 뜨는 에러가 있는데 Clean project로 거의 해결된다. [(관련 게시글)](https://velog.io/@kuronuma_daisy/Android-Studio-에러-is-translated-here-but-not-found-in-default-locale-Unresolved-reference-activitymain)

## 코드
### activity_main.xml 코드 
사실상 xml파일이 전부이다.
하지만 아래에 깃허브도 첨부했다.
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="50dp">

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/main_desc"
        android:textSize="17dp"
        android:layout_marginTop="16dp"/>
    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="아이디"
        android:inputType="textEmailAddress"/>
    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="비밀번호"
        android:inputType="textPassword"/>
    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/password_txt"
        android:textSize="10dp"/>
    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="확인"
        android:layout_marginTop="16dp"/>

</LinearLayout>
```

[벨로그 링크](https://velog.io/@kuronuma_daisy/카카오톡-비밀번호-확인-화면-따라하기)
