import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.marisma.gameover.Favoritos
import com.marisma.gameover.FavoritosProvider
import com.marisma.gameover.databinding.ItemFavoritoBinding

class FavoritoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemFavoritoBinding.bind(view)

    fun render(favorito: Favoritos) {
        binding.tvJuegoName.text = favorito.nombre
        Glide.with(binding.ivJuego.context).load(favorito.imagenUrl).into(binding.ivJuego)

        binding.btnDelete.setOnClickListener {
            FavoritosProvider.quitarJuegoFavorito(favorito)
        }
    }
}
