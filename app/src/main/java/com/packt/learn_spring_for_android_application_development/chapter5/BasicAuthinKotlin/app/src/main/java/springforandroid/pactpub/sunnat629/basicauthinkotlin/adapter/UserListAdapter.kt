package springforandroid.pactpub.sunnat629.basicauthinkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import springforandroid.pactpub.sunnat629.basicauthinkotlin.R
import springforandroid.pactpub.sunnat629.basicauthinkotlin.model.UserModel

class UserListAdapter(context: Context,
                      private val userList: List<UserModel>?) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
            as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.user_list_item, parent, false)


        val name = rowView.findViewById(R.id.name) as TextView
        val email = rowView.findViewById(R.id.email) as TextView
        val contactNumber = rowView.findViewById(R.id.contactNumber) as TextView

        val userDetails = getItem(position) as UserModel

        name.text = userDetails.name
        email.text = userDetails.email
        contactNumber.text = userDetails.contact_number

        return rowView
    }

    override fun getItem(position: Int): Any {
        return userList!![position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return userList!!.size
    }
}
