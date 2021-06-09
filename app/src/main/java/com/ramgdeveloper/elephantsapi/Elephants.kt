package com.ramgdeveloper.elephantsapi


import com.google.gson.annotations.SerializedName

class Elephants : ArrayList<Elephants.ElephantsItem>(){
    data class ElephantsItem(
        @SerializedName("affiliation")
        val affiliation: String?,
        @SerializedName("dob")
        val dob: String?,
        @SerializedName("dod")
        val dod: String?,
        @SerializedName("fictional")
        val fictional: String?,
        @SerializedName("_id")
        val id: String?,
        @SerializedName("image")
        val image: String?,
        @SerializedName("index")
        val index: Int?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("note")
        val note: String?,
        @SerializedName("sex")
        val sex: String?,
        @SerializedName("species")
        val species: String?,
        @SerializedName("__v")
        val v: Int?,
        @SerializedName("wikilink")
        val wikilink: String?
    )
}