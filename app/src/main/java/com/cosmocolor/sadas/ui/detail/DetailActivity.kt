package com.cosmocolor.sadas.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.navArgs
import com.cosmocolor.sadas.adapter.PageAdapter
import com.cosmocolor.sadas.databinding.ActivityDetailBinding
import com.cosmocolor.sadas.ui.detail.fragments.*
import com.cosmocolor.sadas.util.Constanst.TICKET_BUNDLE
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val args by navArgs<DetailActivityArgs>()
    private lateinit var pageAdapter: PageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
    }

    private fun setupUI() {
        setUpToolBar()
        setUpPageAdapter()
    }

    private fun setUpPageAdapter() {
        val fragments = ArrayList<Fragment>()
        fragments.add(DetailsFragment())
        fragments.add(ClientFragment())
        fragments.add(EvidenceFragment())
        fragments.add(SignatureFragment())

        val titles = ArrayList<String>()
        titles.add("Detalles")
        titles.add("Cliente")
        titles.add("Evidencia")
        titles.add("Firma")

        val resultBundle = Bundle()
        resultBundle.putParcelable("ggg", args.ticket)

        //Línea para habilitar el swipe
        binding.viewPager2.isUserInputEnabled = true
        pageAdapter = PageAdapter(
//            resultBundle,
            fragments,
            this
        )
        binding.viewPager2.apply {
            adapter = pageAdapter
        }
        TabLayoutMediator(binding.tableLayout, binding.viewPager2) { tab, position ->
            tab.text = titles[position]
        }.attach()
    }

    private fun setUpToolBar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = args.ticket.nombreProyecto
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }
}