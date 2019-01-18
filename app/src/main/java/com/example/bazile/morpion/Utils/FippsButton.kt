package com.example.bazile.morpion.Utils

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.Button

class FippsButton : Button {

    constructor(context: Context?) : super(context){
        val face = Typeface.createFromAsset(context!!.assets, "fonts/fipps_regular.otf")
        this.typeface = face
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        val face = Typeface.createFromAsset(context!!.assets, "fonts/fipps_regular.otf")
        this.typeface = face
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        val face = Typeface.createFromAsset(context!!.assets, "fonts/fipps_regular.otf")
        this.typeface = face
    }

}