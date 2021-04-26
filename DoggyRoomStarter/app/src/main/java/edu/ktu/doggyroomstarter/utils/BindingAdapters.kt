package edu.ktu.doggyroomstarter.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.ktu.doggyroomstarter.adapters.DogAdapter
import edu.ktu.doggyroomstarter.models.Dog

@BindingAdapter("dogImage")
fun ImageView.setDogImage(dog: Dog) {
    Glide.with(this).load(dog.image).into(this)
}

@BindingAdapter("dogs")
fun RecyclerView.setDogs(dogs: List<Dog>?) {
    dogs?.let { (adapter as DogAdapter).submitList(dogs) }
}