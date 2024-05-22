package com.example.affirmation.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation(
    @StringRes val stringRessourcesId:Int,
    @DrawableRes val imageResource:Int
)
