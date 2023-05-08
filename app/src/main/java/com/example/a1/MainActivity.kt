package com.example.a1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_sci = findViewById<RadioButton>(R.id.btn_sci)
        val btn_stone = findViewById<RadioButton>(R.id.btn_stone)
        val btn_paper = findViewById<RadioButton>(R.id.btn_paper)
        val tv_winner = findViewById<TextView>(R.id.end)
        val tv_com = findViewById<TextView>(R.id.tv_com)
        val btn_start = findViewById<Button>(R.id.btn_start)
        val end=findViewById<TextView>(R.id.end)

        btn_start.setOnClickListener{
            val com=(Math.random()*3).toInt()
            val player = when{
                btn_sci.isChecked->"剪刀"
                btn_stone.isChecked->"石頭"
                btn_paper.isChecked->"布"
                else -> "無"
            }
            val comText = when(com){
                0->"剪刀"
                1->"石頭"
                2 ->"布"
                else -> "無"
            }
            tv_com.text="電腦出拳\n$comText"
            when {
                btn_sci.isChecked &&com ==2 ||
                        btn_stone.isChecked && com==0 ||
                        btn_paper.isChecked && com==1 ->{
                            end.text="WIN"
                        }
                btn_sci.isChecked && com ==1 ||
                        btn_stone.isChecked && com==2 ||
                        btn_paper.isChecked && com==0 ->{
                            tv_winner.text="victory\n computer"
                    end.text="lose"
                        }
                btn_sci.isChecked && com ==0 ||
                        btn_stone.isChecked && com==1 ||
                        btn_paper.isChecked && com==2 ->{
                    tv_winner.text="victory\n tie"
                    end.text="tie"
                        }
                else ->{
                    tv_winner.text=""
                    tv_com.text="請先點選"
                    end.text=""
                }
            }
        }



    }
}