package ibanez.pppb1.tugasp10pppb1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ibanez.pppb1.tugasp10pppb1.databinding.ItemProfileBinding
import ibanez.pppb1.tugasp10pppb1.model.Data
import ibanez.pppb1.tugasp10pppb1.model.Profile

class ProfileAdapter(
    private val profileList: List<Data>,
    private val onItemClick: (Data) -> Unit
) : RecyclerView.Adapter<ProfileAdapter.ItemProfileViewHolder>() {

    inner class ItemProfileViewHolder(private val binding: ItemProfileBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(profile: Data) {
            binding.txtName.text = "Name  : ${profile.firstName} ${profile.lastName}"
            binding.txtEmail.text = "Email   : ${profile.email}"
            Glide.with(binding.root.context)
                .load(profile.avatar)
                .into(binding.photoProfile)

            binding.photoProfile.setOnClickListener {
                onItemClick(profile)
            }
            binding.txtName.setOnClickListener {
                onItemClick(profile)
            }
            binding.txtEmail.setOnClickListener {
                onItemClick(profile)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemProfileViewHolder {
        val binding = ItemProfileBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemProfileViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemProfileViewHolder, position: Int) {
        holder.bind(profileList[position])
    }

    override fun getItemCount(): Int {
        return profileList.size
    }
}
