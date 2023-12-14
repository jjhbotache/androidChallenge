package com.example.a5imdb.view.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.a5imdb.R
import com.example.a5imdb.databinding.FragmentRegisterBinding
import com.example.a5imdb.functions.checkInputsFullFilledAndUpdateButton

class Register : Fragment() {
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            returnButton.setOnClickListener {
                findNavController().navigate(RegisterDirections.actionRegister2ToLogin())
            }

            //check and update the login button whether the inputs are full filled
            nameInput.addTextChangedListener {
                checkInputsFullFilledAndUpdateButton(
                    listOf(nameInput, emailInput, passwordInput),
                    createButton,
                    requireContext()
                )
            }

            emailInput.addTextChangedListener {
                checkInputsFullFilledAndUpdateButton(
                    listOf(nameInput, emailInput, passwordInput),
                    createButton,
                    requireContext()
                )
            }

            passwordInput.addTextChangedListener {
                checkInputsFullFilledAndUpdateButton(
                    listOf(nameInput, emailInput, passwordInput),
                    createButton,
                    requireContext()
                )
                updatePasswordText()
            }
        }
    }

    private fun updatePasswordText() {
        if (binding.passwordInput.text.toString().length < 9) {
            binding.passwordWarnText.setTextColor(Color.rgb(255, 0, 0))
        } else {
            binding.passwordWarnText.setTextColor(resources.getColor(R.color.gray))
        }
    }

}
