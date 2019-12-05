package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.exercise1.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.buttonCalculate.setOnClickListener{
            calculateLoan()
        }
        binding.buttonReset.setOnClickListener{
            clear()
        }

    }

    private fun clear() {
        binding.editTextCarPrice.text.clear()
        binding.editTextDownPayment.text.clear()
        binding.editTextLoanPeriod.text.clear()
        binding.editTextInterestRate.text.clear()

        binding.textViewLoan.text = String.format("Car loan: ")
        binding.textViewInterest.text = String.format("Interest: ")
        binding.textViewMonthlyRepayment.text = String.format("Monthly Payment: ")
    }

    private fun calculateLoan(){
        try {
            val loan: Double =
                binding.editTextCarPrice.text.toString().toDouble() + binding.editTextDownPayment.text.toString().toDouble()
            val interest: Double =
                loan * (binding.editTextInterestRate.text.toString().toDouble() / 100) * binding.editTextLoanPeriod.text.toString().toDouble()
            val monthPayment: Double =
                (loan + interest) / binding.editTextLoanPeriod.text.toString().toDouble() / 12

            binding.textViewLoan.text = String.format("Car loan: %.2f", loan)
            binding.textViewInterest.text = String.format("Interest: %.2f", interest)
            binding.textViewMonthlyRepayment.text =
                String.format("Monthly Payment: %.2f", monthPayment)
        }catch(e : Exception){println("error")}


    }

}
