package com.example.nikita.calc

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_calc.*


class CalcActivity : AppCompatActivity() {
    private var numcount = 0
    private var leftnumber : String = ""
    private var rigthnumber : String = ""
    private var finalresult : String = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc)




        result.text = "0"

        button0.setOnClickListener { appendToExpression("0", true) }
       // button0.isClickable = false

        button1.setOnClickListener { appendToExpression("1", true) }
        button2.setOnClickListener { appendToExpression("2", true) }
        button3.setOnClickListener { appendToExpression("3", true) }
        button4.setOnClickListener { appendToExpression("4", true) }
        button5.setOnClickListener { appendToExpression("5", true) }
        button6.setOnClickListener { appendToExpression("6", true) }
        button7.setOnClickListener { appendToExpression("7", true) }
        button8.setOnClickListener { appendToExpression("8", true) }
        button9.setOnClickListener { appendToExpression("9", true) }














    button_minus.setOnClickListener { appendToExpression("-" , false) }
    button_minus.isClickable = false



    button_plus.setOnClickListener {  appendToExpression("+", false)}
    button_plus.isClickable = false



    button_division.setOnClickListener { appendToExpression("/", false) }
    button_division.isClickable = false




    button_multiply.setOnClickListener {  appendToExpression("x", false)}
    button_multiply.isClickable = false












        button_del.setOnClickListener {
            result.text = ""
            expression.text = ""


            numcount = 0

            leftnumber = ""
            rigthnumber = ""

        }



        button_equals.setOnClickListener {




           // result.text = (result.text.toString() + finalresult.toInt()    )

        }



        numcount = 0
    }








        private fun appendToExpression(string : String, clear : Boolean){
            numcount ++


            if (string == "-" ||  string == "+"  ||  string == "x" ||  string == "/" ) {

                button_minus.isClickable = false
                button_plus.isClickable = false
                button_division.isClickable = false
                button_multiply.isClickable = false



                leftnumber = expression.text.toString().substring(0, (expression.text.length))



            }




            else {
                button_minus.isClickable = true
                button_plus.isClickable = true
                button_division.isClickable = true
                button_multiply.isClickable = true
            }

            if (!clear){

                result.text = ""

                expression.append(string)




            } else {

//                expression.append(result.text)
                expression.append(string)

                result.text = ""

            }





            rigthnumber = expression.text.toString().substring(leftnumber.length + 1, numcount)

            try {

                when((expression.text.contains("+") || expression.text.contains("x") || expression.text.contains("/") || expression.text.contains("-")) && expression.text.length > 2 ){

                    expression.text.contains("-") ->   finalresult   = (leftnumber.toInt() - rigthnumber.toInt() ).toString()


                    expression.text.contains("+") ->   finalresult   = (leftnumber.toInt() + rigthnumber.toInt() ).toString()


                    expression.text.contains("/") -> if (leftnumber.toInt() < rigthnumber.toInt() ){


                        finalresult = (leftnumber.toLong() / (rigthnumber.toLong()) ).toString()

                    } else {
                        finalresult = (leftnumber.toLong() / (rigthnumber.toLong()) ).toString()
                        // finalresult = (leftnumber.toInt() / (rigthnumber.toInt()) ).toString()
                    }





                    expression.text.contains("x") ->   finalresult  = ( (leftnumber.toInt()) * (rigthnumber.toInt()) ).toString()






                }










                result.text = (result.text.toString() + finalresult.toInt()    )

                Toast.makeText(this, "$leftnumber   $rigthnumber numcount = $numcount",Toast.LENGTH_LONG).show()

            } catch (e: Exception ) { }












        }








}
