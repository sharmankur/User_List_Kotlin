package com.info.userlistdemo.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.info.userlistdemo.R
import com.info.userlistdemo.model.UserModel
import kotlinx.android.synthetic.main.user_detail_item.view.*

class UserListAdapter(var userList: ArrayList<UserModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_HEADER = 0
    private val TYPE_ITEMS = 1
    fun updateUserList(newUsers: List<UserModel>) {
        userList.clear()
        userList.addAll(newUsers)
        notifyDataSetChanged()
    }
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var userView: View
        if (viewType == 0) {
            userView =LayoutInflater.from(parent.context).inflate(R.layout.user_header, parent, false)
            return  VHHeaderTitle(userView);
        } else {
            userView=  (LayoutInflater.from(parent.context)
                .inflate(R.layout.user_detail_item, parent, false))
            return UserDetailHolder(userView)
        }
        throw RuntimeException("there is no type that matches the type " + viewType + " + make sure your using types correctly");
    }

    override fun getItemCount() = userList.size

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder is UserDetailHolder) {
            holder.bind(userList[position])
        }

    }

    override fun getItemViewType(position: Int): Int {
        if (isPositionHeader(position)) {

            return TYPE_HEADER;
        }

        return TYPE_ITEMS;
    }


    private fun isPositionHeader(position: Int): Boolean {
        return position == 0
    }
    class UserDetailHolder(v: View) : ViewHolder(v), View.OnClickListener {
        private var view: View = v

        private val txtFirstNameVal = view.txtFirstNameVal
        private val txtLastNameVal = view.txtLastNameVal
        private val txtPhoneNoVal = view.txtPhoneNoVal
        private val txtCityVal = view.txtCityVal
        private val txtStateVal = view.txtStateVal
        private val txtPinCodeVal = view.txtPinCodeVal
        private val btnEdit = view.btnEdit
        fun bind(userModel: UserModel) {
            txtFirstNameVal.text = userModel.fName
            txtLastNameVal.text = userModel.lName
            txtPhoneNoVal.text = userModel.phNo
            txtCityVal.text = userModel.city
            txtStateVal.text = userModel.state
        }

        override fun onClick(v: View?) {

        }


    }

    private class VHHeaderTitle(view: View?) : ViewHolder(view!!)
}