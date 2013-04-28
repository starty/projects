package projects

import grails.converters.JSON
import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.Method.GET

class CategoryService {

    def grailsApplication

    def getCategoryById (Integer categoryId){

       def categoryPath = grailsApplication.config.grails.categoryPathUrl
        // url que apunta a la api
        //def baseUrl = grailsApplication.config.grails.serverUrl
        //def url =   "/$categoryPath/$categoryId"


        //def restBuilder = new RestBuilder()
        def http = new HTTPBuilder("http://localhost:8090/mockserver")

        http.request( GET, groovyx.net.http.ContentType.JSON ) { req ->
            uri.path ="http://localhost:8090/mockserver"+  "/"+categoryPath+"/"+categoryId
            headers.'User-Agent' = 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'
           response.success = { resp, json ->
                println resp.statusLine
                return json.responseData
            }
            response.failure = { resp ->
                println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
            }
        }
    }
}
