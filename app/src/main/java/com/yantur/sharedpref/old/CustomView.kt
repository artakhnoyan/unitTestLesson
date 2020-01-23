package com.yantur.sharedpref.old

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.yantur.sharedpref.R
import kotlinx.android.synthetic.main.custom_view.view.*

class CustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.custom_view, this)
        setOnClickListener {toogleView()}
        isClickable = true
    }


    fun toogleView() {
        if (pink.visibility == View.VISIBLE) {
            pink.visibility = GONE
        } else {
            pink.visibility = View.VISIBLE

        }
        if (green.visibility == View.VISIBLE) {
            green.visibility = GONE
        } else {
            green.visibility = View.VISIBLE

        }
    }
}
