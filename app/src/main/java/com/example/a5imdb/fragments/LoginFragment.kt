package com.example.a5imdb.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.a5imdb.databinding.FragmentLoginBinding
import com.example.a5imdb.functions.checkInputsFullFilledAndUpdateButton

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ahora puedes acceder a las vistas a través de ViewBinding
        binding.userTextInput.addTextChangedListener {
            checkInputsFullFilledAndUpdateButton(
                listOf(binding.userTextInput, binding.passwordTextInput),
                binding.loginButton,
                requireContext()
            )
        }

        binding.passwordTextInput.addTextChangedListener {
            checkInputsFullFilledAndUpdateButton(
                listOf(binding.userTextInput, binding.passwordTextInput),
                binding.loginButton,
                requireContext()
            )
        }

        binding.register.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginToRegister2())
        }

        binding.joinAsGuest.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginToSearch())
        }
    }


}
