package projects

import grails.converters.JSON
import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.Method.GET

class CategoryService {

    def grailsApplication

    def getCategoryById (Integer categoryId){

       def categoryPath = grailsApplication.config.grails.categoryPathUrl

        def http = new HTTPBuilder(grailsApplication.config.grails.apiUrl)

        http.request( GET, groovyx.net.http.ContentType.JSON ) { req ->

            uri.path =  grailsApplication.config.grails.apiUrl+"/"+categoryPath+"/"+categoryId

           response.success = { resp, json ->
                println resp.statusLine
                return json
            }
            response.failure = { resp ->
                println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
            }
       }
    }
}
