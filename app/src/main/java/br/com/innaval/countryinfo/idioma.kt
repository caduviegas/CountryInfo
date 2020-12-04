package br.com.innaval.countryinfo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Idioma(
        @SerializedName("iso639_2") val codigo:String,
        @SerializedName("nativeName") val nomeNativo:String,
        @SerializedName("name") val nome:String

):Parcelable