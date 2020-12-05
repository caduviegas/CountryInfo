package br.com.innaval.countryinfo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Pais (
        @SerializedName("name")val nome:String,
        @SerializedName("region") val continente:String,
        @SerializedName("population") val populacao:Double,
        @SerializedName("capital") val capital:String,
        @SerializedName("area") val area:Double,
        @SerializedName("latlng") val coordenadas: List<Double>,
        @SerializedName("languages")val idiomas:List<Idioma>,
        @SerializedName("flag") val bandeira:String

): Parcelable