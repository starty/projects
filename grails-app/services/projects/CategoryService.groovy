package projects

import grails.converters.JSON

class CategoryService {

    def grailsApplication

    def getCategoryById (Integer categoryId){

       def categoryPath = grailsApplication.config.grails.categoryPathUrl
        // url que apunta a la api
        def url = "/$categoryPath/$categoryId"
        def restClient = grailsApplication.mainContext.getBean("restClient")
        def returnValue = [responseStatus: null, responseData: null]
        restClient.get ( uri : url.toString(),
                success: {
                    returnValue.responseData = it.data
                    returnValue.responseStatus = it.status?.statusCode as Long
                    //println "${returnValue.responseStatus}"
                },
                failure: {
                    returnValue.responseStatus = it.status?.statusCode
                    println "get failed, status ${it.status?.statusCode}, response ${it.data}"
                }
        )
        return returnValue
    }
}