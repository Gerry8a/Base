package com.cosmocolor.sadas.ui.detail.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cosmocolor.sadas.databinding.FragmentSignatureBinding
import com.github.gcacace.signaturepad.views.SignaturePad


class SignatureFragment : Fragment() {

    private lateinit var binding: FragmentSignatureBinding
    private var bandera: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignatureBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnRepit.setOnClickListener {
            binding.signaturePad.clear()
        }

        binding.btnSave.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Guardado",
                Toast.LENGTH_SHORT
            ).show()
            binding.btnSave.isClickable = false
        }

        if (binding.signaturePad.isEmpty) {
            binding.btnSave.isClickable = false
        }

        binding.signaturePad.setOnSignedListener(object : SignaturePad.OnSignedListener {
            override fun onStartSigning() {
                //Event triggered when the pad is touched
                bandera = true
//                Toast.makeText(requireContext(), "Empezando", Toast.LENGTH_SHORT).show()
            }

            override fun onSigned() {
                binding.btnSave.isClickable = true
                bandera = false
//                Toast.makeText(requireContext(), "Firmado", Toast.LENGTH_SHORT).show()
            }

            override fun onClear() {
                binding.btnSave.isClickable = false
            }
        })


    }


}