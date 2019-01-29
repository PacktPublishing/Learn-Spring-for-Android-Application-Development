package springforandroid.pactpub.sunnat629.resttemptest

class Users(var id: Int,
            var name: String,
            var login: String,
            var company: String,
            var location: String)

class Repository(var id: String,
                 var name: String,
                 var private: Boolean,
                 var html_url: String,
                 var description: String)

class Gist(var description: String,
           var public: Boolean)

class DeleteRepos(var id: String,
                  var name: String,
                  var private: Boolean)