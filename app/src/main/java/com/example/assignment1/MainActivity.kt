package com.example.assignment1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var result: TextView = findViewById(R.id.Result)
        var button :Button = findViewById(R.id.buttonOrder)
        //Spinner
        var flag :String = "Choose A Flavor"
        val flavorSpinner: Spinner = findViewById(R.id.flavors_spinner)
        var options = arrayOf("Choose A Flavor","Chocolate", "Vanilla", "Strawberry", "Blueberry", "Lemon")
        flavorSpinner.adapter =
            ArrayAdapter(this,android.R.layout.simple_list_item_1,options)
        flavorSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>, p1: View?, p2:Int, p3: Long){
                flag = options.get(p2)
            }
            override fun onNothingSelected(p0: AdapterView<*>?){
            }
        };
        button.setOnClickListener { view ->
            when(flag){
            "Chocolate" -> {
                result.setVisibility(View.VISIBLE)
                result.text = chocolate();
            }
            "Vanilla"->
                {
                    result.setVisibility(View.VISIBLE)
                    result.text = vanilla();
                }
            "Blueberry"->
                {
                    result.setVisibility(View.VISIBLE)
                    result.text = blueberry().toString();
                }
            "Strawberry"->
                {
                    result.setVisibility(View.VISIBLE)
                    result.text = strawberry();
                }
           "Lemon"->
           {
                result.setVisibility(View.VISIBLE)
                result.text = lemon();
            }
            else ->
                result.text = "Must choose a flavor!"
            }
        };

    }
}
public fun chocolate(): String { return "Total is $2!"; }
public fun vanilla(): String { return "Total is $1!"; }
public fun blueberry():String{ return "Total is $1.50!"; }
public fun strawberry():String{ return "Total is $1.85!"; }
public fun lemon():String{ return "Total is $1.23!"; }

