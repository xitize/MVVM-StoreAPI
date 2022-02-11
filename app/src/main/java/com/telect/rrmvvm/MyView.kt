package com.telect.rrmvvm

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View


class MyView(context: Context) : View(context) {
    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val x = 180.0
        val y = 80.0
        val radius = 60.0
        val paint = Paint()
        paint.color = Color.parseColor("#CD5C5C")
        canvas?.drawCircle(x.toFloat(), y.toFloat(), radius.toFloat(), paint)
        canvas?.density = 56

    }
}