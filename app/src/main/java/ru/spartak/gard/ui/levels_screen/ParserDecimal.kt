package ru.spartak.gard.ui.levels_screen

object ParserDecimal {
    fun pars(decimal:Int):String{
        val stringDecimal = decimal.toString().reversed()
        var new=""
        for (i in stringDecimal.indices){
            if (i==3) new+=" "
            new+= stringDecimal[i]
        }
        return new.reversed()
    }
}