package com.example.a5imdb.fragments

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.a5imdb.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding
    private val tag = "SplashFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        Log.d(tag, "onCreateView")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(tag, "onViewCreated")

        val sendToSecondScreen = Runnable {
            findNavController().navigate(SplashFragmentDirections.actionSplashToLogin3())
            //findNavController().popBackStack()
            //activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
            // Remove the fragment from the back stack (doesn't work)
            /*val fragmentTag = "YourFragmentTag"
            val fragment = requireActivity().supportFragmentManager.findFragmentByTag(fragmentTag)
            if (fragment != null) {
                requireActivity().supportFragmentManager.beginTransaction().remove(fragment).commit()
                requireActivity().supportFragmentManager.popBackStackImmediate(fragmentTag, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }*/
                    }

        Handler().postDelayed(sendToSecondScreen, 1500)

        // Uncomment the following line if you want to navigate on screen click
        // binding.screen.setOnClickListener { sendToSecondScreen.run() }
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "onDestroy")
    }

}
