package com.example.knockdeokbae

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.game_play.*
import kotlinx.android.synthetic.main.game_play.view.*

class GamePlay(_goal : Int) : Fragment() {
    lateinit var mainActivity : MainActivity
    lateinit var timerBar : TimerBar
    var goal = _goal

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mainActivity = context as MainActivity
        timerBar = TimerBar()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.game_play, null)
        var count = 0

        view.btn_hand.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(view: View?, event: MotionEvent?): Boolean {
                when(event?.action) {
                    MotionEvent.ACTION_DOWN -> {
                        btn_hand.x -= 300
                        btn_hand.y -= 50
                        DoekBae.setBackgroundResource(R.drawable.deok_bae_hit)
                        count++
                        Log.e("카운트  : ", "$count")
                        if(count >= goal) {
                            timerBar.cancel(true)
                            when(goal) {
                                40 -> mainActivity.onFragmentChangeWin("Easy")
                                70 -> mainActivity.onFragmentChangeWin("Normal")
                                100 -> mainActivity.onFragmentChangeWin("Hard")
                            }
                        }
                    }
                    MotionEvent.ACTION_UP -> {
                        btn_hand.x += 300
                        btn_hand.y += 50
                        DoekBae.setBackgroundResource(R.drawable.deok_bae)
                    }
                }
                return view?.onTouchEvent(event) ?: true
            }
        })
        timerBar.execute()

        return view
    }

    inner class TimerBar : AsyncTask<Void, Void, Void>() {

        /** 동작 중에 실행 */
        override fun onProgressUpdate(vararg values: Void) {
            super.onProgressUpdate(*values)

            iv_timer.layoutParams.width += 50
            iv_timer.requestLayout()

            if(iv_timer.width >= iv_timer_full.width * 2) {
                timerBar.cancel(true)
                mainActivity.onFragmentChange("lose")
            }
        }

        /** 백그라운드에서 실행 */
        override fun doInBackground(vararg values: Void): Void? {
            while(true) {
                SystemClock.sleep(100)
                publishProgress()
                if(isCancelled) break
            }
            return null
        }
    }
}