package com.Team7.Skyinvasion.ui.game.views.bullets

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.Team7.Skyinvasion.R
import com.Team7.Skyinvasion.utils.scaleView


class BulletCountView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0,
) : AppCompatTextView(context, attributeSet, defStyle) {

    fun setBulletCount(ammoCount: Int, maxCount: Float) {
        text = context.getString(R.string.ammo_reserve_text, ammoCount)
        if (ammoCount / maxCount < 0.25) {
            setTextColor(Color.RED)
        } else {
            setTextColor(Color.WHITE)
        }
    }

    fun onBulletCollected() {
        scaleView(0.1F)
    }

}
