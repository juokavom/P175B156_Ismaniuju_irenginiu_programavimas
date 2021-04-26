package edu.ktu.guessthenumber.utils

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout
import edu.ktu.guessthenumber.R

@BindingAdapter("guessedNumber", "guessResult")
fun TextView.setGuessedNumberAndResult(number: Int, result: Int) {
    when (result) {
        -1 -> {
            visibility = View.VISIBLE
            text = resources.getString(R.string.too_low, number)
        }
        1 -> {
            visibility = View.VISIBLE
            text = resources.getString(R.string.too_high, number)
        }
        else -> visibility = View.INVISIBLE
    }
}

@BindingAdapter("errorText")
fun TextInputLayout.setErrorText(errorText: String?) {
    error = errorText
}