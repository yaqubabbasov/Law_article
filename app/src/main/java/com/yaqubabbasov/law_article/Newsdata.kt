package com.yaqubabbasov.law_article

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Newsdata(val image:Int, val title:String,val text:String):Parcelable
