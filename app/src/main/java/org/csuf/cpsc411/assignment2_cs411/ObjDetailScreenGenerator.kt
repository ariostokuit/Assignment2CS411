package org.csuf.cpsc411.assignment2_cs411

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class ObjDetailScreenGenerator(val ctx : Context) {
    lateinit var layoutObj : LinearLayout
    fun generate() : LinearLayout{

        //Create a linearLayout object
        layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL
        layoutObj.setBackgroundColor(Color.WHITE)

        //add "Please ENter Claim Information" at top
        val tLayout = LinearLayout(ctx)
        val tParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        tParams.gravity = Gravity.TOP
        tLayout.layoutParams = tParams
        tLayout.orientation = LinearLayout.VERTICAL

        var titleLabel = TextView(ctx)
        titleLabel.text = "Please Enter Claim Information"
        titleLabel.setTextSize(30.0F)
        titleLabel.gravity = Gravity.CENTER
        tLayout.addView(titleLabel)
        layoutObj.addView(tLayout, tParams)

        //add ObjDetailSection
        val fldRowGenerator = ObjDetailSectionGenerator(ctx)
        val colView = fldRowGenerator.generate()
        layoutObj.addView(colView)

        //Create Add Button LinearLayout
        val nLayout = LinearLayout(ctx)
        val nParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        //only applied to height now
        nParams.gravity = Gravity.RIGHT
        nLayout.layoutParams = nParams
        nLayout.orientation = LinearLayout.HORIZONTAL
        nLayout.setBackgroundColor(Color.GRAY)

        //Create the button
        val nButton = Button(ctx)
        nButton.text = "Add"
        nButton.setTextSize(25.0F)
        nButton.setId(R.id.add_btn)
        nButton.setBackgroundColor(Color.CYAN)
        val nbParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        nbParams.gravity = Gravity.BOTTOM
        nLayout.addView(nButton, nbParams)

        //add the add button to the layoutObj
        layoutObj.addView(nLayout, nParams)

        //Create a status message LinearLayout
        val sLayout = LinearLayout(ctx)
        val sParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        sParams.gravity = Gravity.BOTTOM
        sLayout.layoutParams = sParams
        sLayout.orientation = LinearLayout.VERTICAL
        var statuslbl = TextView(ctx)
        statuslbl.text = "Status"
        statuslbl.setTypeface(Typeface.DEFAULT_BOLD)
        statuslbl.setTextSize(25.0F)
        statuslbl.gravity = Gravity.CENTER
        statuslbl.setBackgroundColor(Color.YELLOW)
        sLayout.addView(statuslbl)
        layoutObj.addView(sLayout, sParams)

        var statusValue = TextView(ctx)
        statusValue.id = R.id.status_message
        statusValue.setHint("<Status Message>")
        statusValue.setTextSize(30.0F)
        statusValue.gravity = Gravity.CENTER
        statusValue.setBackgroundColor(Color.LTGRAY)
        layoutObj.addView(statusValue, sParams)

        return layoutObj

    }
}