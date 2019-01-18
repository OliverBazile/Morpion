package com.example.bazile.morpion.Utils

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import android.graphics.Typeface

class FippsTextView : TextView{

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