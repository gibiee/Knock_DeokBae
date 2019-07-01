package com.example.knockdeokbae

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "덕배죽이기"

        layout_1.visibility = View.GONE
        layout_2.visibility = View.GONE

        supportFragmentManager.beginTransaction().replace(R.id.container, Main()).commit()
    }
    fun onFragmentChange(str : String) {
        when(str) {
            "메인화면" -> supportFragmentManager.beginTransaction().replace(R.id.container, Main()).commit()
            "난이도 선택" -> supportFragmentManager.beginTransaction().replace(R.id.container, DifficultySelection()).commit()
            "how" -> supportFragmentManager.beginTransaction().replace(R.id.container, How()).commit()
            "게임 플레이_easy" -> supportFragmentManager.beginTransaction().replace(R.id.container, GamePlay(3)).commit()
            "게임 플레이_normal" -> supportFragmentManager.beginTransaction().replace(R.id.container, GamePlay(5)).commit()
            "게임 플레이_hard" -> supportFragmentManager.beginTransaction().replace(R.id.container, GamePlay(8)).commit()
            "win" -> supportFragmentManager.beginTransaction().replace(R.id.container, Win()).commit()
            "lose" -> print("")
        }
    }
    // 30 55 80
}
