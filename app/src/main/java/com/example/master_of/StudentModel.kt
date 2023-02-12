package com.example.master_of

class StudentModel {

    var id = 0
    var name:String
    var sruname:String
    var adress:String
    var phoneno = 0

    constructor(id: Int, name: String, sruname: String, adress: String, phoneno: Int) {
        this.id = id
        this.name = name
        this.sruname = sruname
        this.adress = adress
        this.phoneno = phoneno
    }
}