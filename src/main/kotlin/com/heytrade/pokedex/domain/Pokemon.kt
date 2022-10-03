package com.heytrade.pokedex.domain

data class Pokemon( var id: String?,
                    var number:String?,
                    var name : String?,
                    var type: List<String>?,
                    var favorite:Boolean?,
                    var imgUrl:String?,
                    var soundUrl:String?,
                    var evolutions:List<Pokemon>?,
                    var cp:Int?,
                    var hp:Int?,
                    var minWeight:Double?,
                    var maxWeight:Double?,
                    var minHeight:Double?,
                    var maxHeight:Double?) {
}
