package projects

import grails.converters.JSON

class HelperService {

    def httpStatusCodes = [
            "400":"bad_request",
            "404":"not_found",
            "403":"forbidden",
            "500":"internal_server_error"
                          ]

    JSON renderError(String errorMessage, String statusCode) {
        def error = [:]
        error.put("message", errorMessage)
        error.put("status_code", statusCode)
        error.put("error_type", httpStatusCodes[statusCode])
        return error as JSON
    }


    def validateMandatoryFields(def data) {

        def missingParameters = []

        if(!data.userId) {
            missingParameters.add("userId")
        }

        if(!data.title) {
            missingParameters.add("title")
        }

        if(!data.categoryId) {
            missingParameters.add("categoryId")
        }

        //Location location
        //rewards

        if(!data.videoUrl) {
            missingParameters.add("videoUrl")
        }

        if(!data.description) {
            missingParameters.add("description")
        }

        if(!data.riskAndChallenges) {
            missingParameters.add("riskAndChallenges")
        }

        if(!data.last_name) {
            missingParameters.add("startDate")
        }

        if(!data.last_name) {
            missingParameters.add("endDate")
        }

        if(!data.last_name) {
            missingParameters.add("goalAmount")
        }

        return missingParameters
    }


}

