package com.gibisoft.knockdeokbae_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.container, Main()).commit()
    }

    fun onFragmentChange(str : String) {
        when(str) {
            "메인화면" -> supportFragmentManager.beginTransaction().replace(R.id.container, Main()).commit()
            "how" -> supportFragmentManager.beginTransaction().replace(R.id.container, How()).commit()
            "난이도 선택" -> supportFragmentManager.beginTransaction().replace(R.id.container, DifficultySelection()).commit()
            "게임 플레이_easy" -> supportFragmentManager.beginTransaction().replace(R.id.container, GamePlay(40)).commit()
            "게임 플레이_normal" -> supportFragmentManager.beginTransaction().replace(R.id.container, GamePlay(70)).commit()
            "게임 플레이_hard" -> supportFragmentManager.beginTransaction().replace(R.id.container, GamePlay(100)).commit()
            "lose" -> supportFragmentManager.beginTransaction().replace(R.id.container, Lose()).commit()
        }
    }
    fun onFragmentChangeWin(difficulty : String) {
        supportFragmentManager.beginTransaction().replace(R.id.container, Win(difficulty)).commit()
    }
}