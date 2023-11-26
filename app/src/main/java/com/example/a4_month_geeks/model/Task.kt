package com.example.a4_month_geeks.model

import java.io.Serializable

data class Task(
    val title:String?=null,
    val desk:String?=null,
):Serializable
//нужен для серилизиации хз для чего но что бы передать данные она нужна
