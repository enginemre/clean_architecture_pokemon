package com.engin.entity.dto


import com.engin.entity.model.Result
import com.google.gson.annotations.SerializedName

class ResultDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String,
    val imageUrl:String?
)

fun ResultDto.toResult():Result{
    val number = if(url.endsWith("/")){
        url.dropLast(1).takeLastWhile { it.isDigit() }
    }else{
        url.takeLastWhile { it.isDigit() }
    }
    val imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${number}.png"
    return Result(name, url,imageUrl)
}