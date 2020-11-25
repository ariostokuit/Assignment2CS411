package org.csuf.cpsc411.assignment2_cs411

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

class LableColumnGenerator (val ctx : Context) {
    fun generate() : LinearLayout{
        val layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL
        layoutObj.setBackgroundColor(Color.GREEN)
        val lbParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        lbParams.weight = 1.0F
        lbParams.topMargin = 5

        var lbl = TextView(ctx)
        lbl.text = "Claim:"

        //Create the label for Claim
        lbl.setTypeface(Typeface.DEFAULT_BOLD)
        lbl.gravity = Gravity.CENTER
        lbl.setBackgroundColor(Color.YELLOW)
        layoutObj.addView(lbl, lbParams)
        lbl = TextView(ctx)
        lbl.text = "Date:"

        //Create the label for Date
        lbl.setTypeface(Typeface.DEFAULT_BOLD)
        lbl.gravity = Gravity.CENTER
        lbl.setBackgroundColor(Color.YELLOW)
        layoutObj.addView(lbl, lbParams)
        return layoutObj


    }
}