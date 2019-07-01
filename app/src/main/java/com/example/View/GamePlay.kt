package com.example.knockdeokbae

import android.content.Context
import android.media.Image
import android.os.AsyncTask
import android.os.Bundle
import android.os.SystemClock.sleep
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.game_play.*
import kotlinx.android.synthetic.main.game_play.view.*


class GamePlay(_goal : Int) : Fragment() {
    private lateinit var mainActivity : MainActivity
    var goal = _goal

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.game_play, null)
        var count = 0

        view.btn_hand.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(view: View?, event: MotionEvent?): Boolean {
                when(event?.action) {
                    MotionEvent.ACTION_DOWN -> {
                        btn_hand.x -= 230
                        btn_hand.y -= 50
                        DoekBae.setBackgroundResource(R.drawable.deok_bae_hit)
                        count++
                        if(count >= goal) mainActivity.onFragmentChange("win")
                    }
                    MotionEvent.ACTION_UP -> {
                        btn_hand.x += 230
                        btn_hand.y += 50
                        DoekBae.setBackgroundResource(R.drawable.deok_bae)
                    }
                }
                return view?.onTouchEvent(event) ?: true
            }
        })

        TimerBar().execute(view.iv_timer, view.right_wall)

        return view
    }

    class TimerBar : AsyncTask<ImageView, Void, Void>() {
        lateinit var iv_timer : ImageView
        lateinit var rightWall : ImageView

        /** 동작 수행 전에 실행 */
        override fun onPreExecute() {
            super.onPreExecute()
        }

        /** 동작 중에 실행 */
        override fun onProgressUpdate(vararg values: Void) {
            super.onProgressUpdate(*values)
            iv_timer.layoutParams.width += 30
            iv_timer.requestLayout()
            if(iv_timer.width >= rightWall.x * 3) {
                Log.e("타이머 : ", "부딪힘")
                onCancelled()
            }
        }

        /** 동작 끝난 후 실행 */
        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
        }

        /** 백그라운드에서 실행 */
        override fun doInBackground(vararg values: ImageView): Void {
            iv_timer = values[0]
            rightWall = values[1]
            while(true) {
                sleep(100)
                publishProgress()
            }
        }
    }
}