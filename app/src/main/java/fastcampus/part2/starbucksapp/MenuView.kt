package fastcampus.part2.starbucksapp

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import fastcampus.part2.starbucksapp.databinding.ItemMenuBinding

class MenuView @JvmOverloads constructor(
    context: Context,
    attritbuteSet: AttributeSet? = null,
    defStyleAttr: Int = 0
): LinearLayout(context, attritbuteSet, defStyleAttr) {

    private lateinit var binding: ItemMenuBinding
    private var title: String? = null
    private var imageUrl : String? = null

    // 제일 초기에 실행되는 메서드
    init{
        attritbuteSet?.let {
            initAttr(it)
        }
        initView()
    }

    private fun initAttr(attrs:AttributeSet){
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.MenuView,
            0, 0
        ).apply{
            title = getString(R.styleable.MenuView_title)
            imageUrl = getString(R.styleable.MenuView_imageUrl)
        }
    }

    private fun initView() {
        val view = inflate(context, R.layout.item_menu, this)
        binding = ItemMenuBinding.bind(view)

        title?.let{
            setTitle(it)
        }
        imageUrl?.let{
            setImageUrl(it)
        }

    }
    fun setTitle(title: String){
        this.title = title
        binding.tvName.text = title
    }

    fun setImageUrl(imageUrl: String) {
        this.imageUrl = imageUrl
        Glide.with(binding.imageView)
            .load(imageUrl)
            .circleCrop()
            .into(binding.imageView)
    }

}