package org.cardna.presentation.ui.detailcard.view

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import com.example.cardna.databinding.ActivityCardShareBinding
import com.example.cardna.databinding.ActivityDetailCardBinding
import dagger.hilt.android.AndroidEntryPoint
import org.cardna.presentation.base.BaseViewUtil
import com.example.cardna.R
import java.io.ByteArrayOutputStream

@AndroidEntryPoint
class CardShareActivity : BaseViewUtil.BaseAppCompatActivity<ActivityCardShareBinding>(R.layout.activity_card_share) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun initView() {
        //공유하기 버튼을 누르면
        binding.tvShare.setOnClickListener {

            //view->bitmap: 공유하고싶은 이미지 ctl view를 bitmap으로 변환 후
            val bitmap = viewToBitmap(binding.ctlShare)

            //bitmap->url
            val uri: Uri? = getImageUri(this, bitmap)


            //인텐트에 url넣어서 시작하기
            val shareIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_STREAM, uri)
                type = "image/jpeg"
            }
            startActivity(Intent.createChooser(shareIntent, "친구에게 공유하기"))
        }

    }

    fun viewToBitmap(view: View): Bitmap {
        val bitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        view.draw(canvas)

        return bitmap
    }


    private fun getImageUri(context: Context, inImage: Bitmap): Uri? {
        val bytes = ByteArrayOutputStream()
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
        val path: String = MediaStore.Images.Media.insertImage(
            context.getContentResolver(),
            inImage,
            "Title",
            null
        )
        return Uri.parse(path)
    }

}


