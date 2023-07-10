package com.example.calendar1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import android.widget.Toast
import com.example.calendar1.databinding.ActivityMainBinding
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Date


class MainActivity : AppCompatActivity() {
	private lateinit var calendarView: CalendarView

	@SuppressLint("SimpleDateFormat")
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		val binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		calendarView = binding.calendarView // calendarView 초기화 해야함(아니면 오류뜸)

		// 기본 세팅
		val formatter: DateFormat = SimpleDateFormat("MM월  dd일")
		val date = Date(calendarView.date)
		binding.title.text= formatter.format(date)

		//날짜 클릭 리스너
		binding.calendarView.setOnDateChangeListener{_, year, month, dayOfMonth->
			val day = "${month + 1}월  ${dayOfMonth}일"//년도 추가하고 싶으면 ${year}년
			binding.title.text= day
			binding.textView4.text=day+"마리수"
			binding.textView5.text=day+"km"
		}
		binding.bookBtn.setOnClickListener {
			Toast.makeText(this, "도감버튼 클릭됨", Toast.LENGTH_SHORT).show()//일단 터치메서드만 만들어둠
		}
	}
}