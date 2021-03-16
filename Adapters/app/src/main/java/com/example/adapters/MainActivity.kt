package com.example.adapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var carAdapter: CarAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val carList = mutableListOf(
            Car("Mercedes-Benz", "C220", 11000.0F),
            Car("Citroen", "C5", 5500.0F),
            Car("Ford", "Transit", 10000.0F),
            Car("Skoda", "Superb", 8700.0F),
            Car("Ford", "Focus ST", 11000.0F),
            Car("Opel", "Ascona", 250.0F),
            Car("Hyundai", "Tucson", 18000.0F),
            Car("Ford", "Mondeo", 10000.0F),
            Car("Peugeot", "508 SW", 8800.0F),
            Car("Fiat", "Bravo", 1000.0F),
            Car("Volkswagen", "Passat", 9000.0F),
            Car("Skoda", "Octavia", 7500.0F),
            Car("Volkswagen", "Multivan", 20000.0F)
        )

        val recycler = findViewById(R.id.carList) as RecyclerView
        carAdapter = CarAdapter(this) { car ->
            val newCarList = carAdapter.currentList.toMutableList()
            newCarList.remove(car)
            carAdapter.submitList(newCarList)
        }
        carAdapter.submitList(carList)
        recycler.adapter = carAdapter
    }
}