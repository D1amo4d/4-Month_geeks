package com.example.a4_month_geeks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.a4_month_geeks.data.local.Pref
import com.example.a4_month_geeks.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val pref: Pref by lazy {//Это называется ленивая инициализация что это такое ? это очень оптимизирует нащ код например
        Pref(this)//этот преф не используется если преф не где не трогается из за этого инициализация не происходит но если
    }//его где то вызвать будь это сетОнКликЛистнер то он тогда начнет инициализироваться

    //private val pref2=Pref(this) // вчем минус этой инициализации и отличие от ленивой инициализации если его даже не трогать
    //из за того что компилируется сверху вниз он инициализируеця и он просто будет весть в памяти если мы его даже не используем
    //и из за этого он занимает энную чясть памяти и просто таких будет сотни тисача то будет нагрузка памяти и чтоб такого не было
    // мы используем ленивую инициализацию

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        if (!pref.onShowed()) {//у onShowed есть только 2-состояния показано и не показано по дефолту стоит не показано и мы тут
            navController.navigate(R.id.onBoardingFragment)//проеверяем то что если тут показано viewPager2 то мы переъодив в другой фрагмент а если же не показано то мы показано ты мф показываем
        }

        navController.navigate(R.id.onBoardingFragment)//мы тут говорим что наш фрагмент запустится первым

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_dashboard,
                R.id.navigation_notifications,
                R.id.taskFragment,
                R.id.profilerFragment
            )
        )
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            if (destination.id == R.id.onBoardingFragment) {
                navView.isVisible = false
                supportActionBar?.hide()
            } else {
                navView.isVisible = true
                supportActionBar?.show()

            }
        }

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}
