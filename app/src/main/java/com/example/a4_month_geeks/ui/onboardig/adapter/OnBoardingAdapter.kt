package com.example.a4_month_geeks.ui.onboardig.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.a4_month_geeks.databinding.ItemOnboardingBinding
import com.example.a4_month_geeks.model.OnBoarding

class OnBoardingAdapter(private val onClic:()->Unit) : Adapter<OnBoardingAdapter.OnBOardingViewHodler>() {
    private val list = arrayListOf<OnBoarding>(
        OnBoarding("https://img.freepik.com/premium-photo/3d-burger-on-white-background_1004243-1028.jpg?size=626&ext=jpg&ga=GA1.1.947609918.1700926434&semt=sph","svjhjjbnj","KKjkNNJKnJKNSKJVNJKNV\nmxvfjfndvsdvsdvfdvsfdvf\n"),
        OnBoarding("https://img.freepik.com/premium-photo/an-owl-standing-on-a-log_786255-17483.jpg?size=626&ext=jpg&ga=GA1.1.947609918.1700926434&semt=sph","sdvcs","fmdzbklfkbglkfdlbkfgb\nsfmvlkdmfvbdklfbkd\nkfkvmkfd"),
        OnBoarding("https://img.freepik.com/premium-photo/an-iceberg-floating-in-the-ocean_717440-15603.jpg?size=626&ext=jpg&ga=GA1.1.947609918.1700926434&semt=sph","sfvsdfvfdvdf","KKjkNNJKnJKNSKJVNJKNV\nmxvfjfndvsdvsdvfdvsfdvf"),
        OnBoarding("https://img.freepik.com/free-photo/cartoon-lofi-young-manga-style-girl-studying-while-listening-to-music-and-raining-in-the-street-ai-generative_123827-24916.jpg?size=626&ext=jpg&ga=GA1.1.947609918.1700926434&semt=ais","sdcvsds","KKjkNNJKnJKNSKJVNJKNV\nmxvfjfndvsdvsdvfdvsfdvf"),
        OnBoarding("https://img.freepik.com/premium-photo/anime-girl-looks-into-the-distance-at-a-pink-sunset-generative-ai_170984-5536.jpg?size=626&ext=jpg&ga=GA1.1.947609918.1700926434&semt=ais","mcsdmfvfdmvkmdfkmvkdfmvkmfdkmvkfd\nksdmksmdfkmskdmfksdm\nsdkfskjf","sdvsvsvsvs"),
        OnBoarding("https://img.freepik.com/free-photo/free-photo-happy-mothers-day-mom-and-child-love-background-wallpaper_1340-30811.jpg?size=626&ext=jpg&ga=GA1.1.947609918.1700926434&semt=ais","mcsdmfvfdmvkmdfkmvkdfmvkmfdkmvkfd\nksdmksmdfkmskdmfksdm\nsdkfskjf","sdvsvsvsvs"),
        OnBoarding("https://img.freepik.com/premium-photo/little-kawaii-girl-eating-sushi-anime-manga-cartoon-style_691560-5336.jpg?size=626&ext=jpg&ga=GA1.1.947609918.1700926434&semt=ais","mcsdmfvfdmvkmdfkmvkdfmvkmfdkmvkfd","sdvsvsvsvs"),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBOardingViewHodler {
        return OnBOardingViewHodler(
            ItemOnboardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: OnBOardingViewHodler, position: Int) {
        return holder.bind(list[position])
    }

    inner class OnBOardingViewHodler(private val binding: ItemOnboardingBinding) :
        ViewHolder(binding.root) {

        fun bind(onBoard: OnBoarding) {
            binding.apply {
                Glide.with(binding.root).load(onBoard.imgeView).into(imgBoard)
                tvTitleName.text = onBoard.tvTitleName
                tvNtroduction.text = onBoard.tvNtroduction
               /* tvSkip.isVisible = adapterPosition == list.lastIndex
                btnGoneStarted.isVisible = adapterPosition != list.lastIndex*/

                 if (adapterPosition==list.lastIndex){
                     tvSkip.isVisible=false
                     btnGoneStarted.isVisible=true
                 }else{
                     tvSkip.isVisible=true
                     btnGoneStarted.isVisible=false
                 }
                btnGoneStarted.setOnClickListener{
                    onClic()
                }
                tvSkip.setOnClickListener{
                onClic()

                }

            }
        }

    }
}
