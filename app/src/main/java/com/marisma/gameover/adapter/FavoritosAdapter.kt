import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marisma.gameover.Favoritos
import com.marisma.gameover.databinding.ItemFavoritoBinding

class FavoritosAdapter(private val favoritosLista: List<Favoritos>, private val onClickListener: (Favoritos) -> Unit) : RecyclerView.Adapter<FavoritosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemFavoritoBinding.inflate(layoutInflater, parent, false)
        return FavoritosViewHolder(binding)
    }

    override fun getItemCount(): Int = favoritosLista.size

    override fun onBindViewHolder(holder: FavoritosViewHolder, position: Int) {
        holder.render(favoritosLista[position], onClickListener)
    }
}

class FavoritosViewHolder(private val binding: ItemFavoritoBinding) : RecyclerView.ViewHolder(binding.root) {

    fun render(favorito: Favoritos, onClickListener: (Favoritos) -> Unit) {
        // Aquí puedes configurar la vista del elemento de favoritos según tus necesidades
        // Por ejemplo, puedes establecer el nombre del juego en un TextView y el manejar el clic del botón de borrar
        // Puedes utilizar Glide u otra biblioteca para cargar imágenes
        binding.btnDelete.setOnClickListener {
            onClickListener(favorito)
        }
    }
}
