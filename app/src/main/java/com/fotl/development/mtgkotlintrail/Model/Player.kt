package com.fotl.development.mtgkotlintrail.Model

class Player(
    // String? allows for null value, the normal String does not
    // var declaration with type --- var/val name: type
    // Var if its a normal var that can be reassigned, val if its an final
    // name is ovies, type is the type of var, like Int, Double, String and so on
        var _name: String?, var _lifeTotal: Int, var _infectCounter: Int, var _cmdDmgCounter: Int) {

}