package com.sunnat629.mvvmroomexample.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable
import android.support.annotation.NonNull

@Entity(tableName = "users")
class Users(): Parcelable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "userId")
    var userId: Int = 0

    @NonNull
    @ColumnInfo(name = "username")
    lateinit var username: String

    @NonNull
    @ColumnInfo(name = "email")
    lateinit var email: String

    @NonNull
    @ColumnInfo(name = "contactNumber")
    lateinit var contactNumber: String

   @NonNull
    @ColumnInfo(name = "address")
    lateinit var address: String

    constructor(username: String, email: String, contactNumber: String, address: String):this(){
        this.username = username
        this.email = email
        this.contactNumber = contactNumber
        this.address = address
    }

    constructor(parcel: Parcel) : this() {
        userId = parcel.readInt()
        username = parcel.readString()!!
        email = parcel.readString()!!
        contactNumber = parcel.readString()!!
        address = parcel.readString()!!
    }

    override fun toString(): String {
        return "Users(username='$username', email='$email', contactNumber='$contactNumber', address='$address')"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(userId)
        parcel.writeString(username)
        parcel.writeString(email)
        parcel.writeString(contactNumber)
        parcel.writeString(address)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Users> {
        override fun createFromParcel(parcel: Parcel): Users {
            return Users(parcel)
        }

        override fun newArray(size: Int): Array<Users?> {
            return arrayOfNulls(size)
        }
    }
}