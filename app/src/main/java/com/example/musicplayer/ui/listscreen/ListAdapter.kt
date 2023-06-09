package com.example.musicplayer.ui.listscreen

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musicplayer.databinding.ItemSongBinding
import com.example.musicplayer.models.Song

@Suppress("DEPRECATION")

class ListAdapter(
    private val songs: List<Song>,
    private val onSongClickListener: (Int) -> Unit,
    private val onDeleteListener: (Song) -> Unit
) : RecyclerView.Adapter<ListAdapter.SongViewHolder>() {

    inner class SongViewHolder(binding: ItemSongBinding) : RecyclerView.ViewHolder(binding.root) {
        val title: TextView = binding.songTitle
        val image: ImageView = binding.albumImg

        init {
            binding.root.setOnClickListener {
                onSongClickListener(adapterPosition)
            }
            binding.deletebtn.setOnClickListener {
                onDeleteListener(songs[adapterPosition])
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val binding = ItemSongBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SongViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return songs.size
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song = songs[position]
        holder.title.text = song.songTitle
        Glide.with(holder.image.context).load(song.album).into(holder.image)
    }


}