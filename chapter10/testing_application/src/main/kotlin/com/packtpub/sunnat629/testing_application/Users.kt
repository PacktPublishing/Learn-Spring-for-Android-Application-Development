package com.packtpub.sunnat629.testing_application

class Users {
    constructor(id: String?,
                name: String?) {
        this.id = id
        this.name = name
    }

    constructor(name: String?) {
        this.name = name
    }

    private var name: String? = null
    private var id: String? = null
}