package projects

import grails.converters.JSON

class ProjectController {

    def projectService
    def helperService

    def postProject ()   {

        def missingParameters = helperService.validateMandatoryFields(data)

        if (missingParameters) {
            def paramsString = ""
            for (missingParameter in missingParameters) {
                paramsString += missingParameter+", "
            }
            paramsString = paramsString[0..-3]
            response.status = 403 // Forbidden
            if (missingParameters.size() == 1)
                render helperService.renderError("Parameter "+paramsString+" is mandatory.", "403")
            else
                render helperService.renderError("Parameters "+paramsString+" are mandatory.", "403")
            return
        }

        def projectJson = request.JSON
        def project = projectService.createProject(projectJson)
        response.status = 200
        render project as JSON

    }

    def getProjectByProjectId() {

        if(!params.projectId) {
            response.status = 403 // Forbidden
            render helperService.renderError("Parameter 'projectId' is mandatory.", "403")
            return
        }

        def project = projectService.getProjectByProjectId(params.projectId as Integer)

        if (project) {
            response.status = 200     //Ok
            render project as JSON
            return
        }
        else{
            response.status = 404 // NotFound
            render helperService.renderError("Project with id "+params.projectId+" not found.", "404")
            return
        }

    }

    def getProjectsByCategory  () {

        if(!params.categoryId) {
            response.status = 403 // Forbidden
            render helperService.renderError("Parameter 'categoryId' is mandatory.", "403")
            return
        }

        def project = projectService.getProjectsByCategoryId(params.categoryId as Integer)

        if (project) {
            response.status = 200     //Ok
            render project as JSON
            return
        }
        else{
            response.status = 404 // NotFound
            render helperService.renderError("Project with id "+params.categoryId+" not found.", "404")
            return
        }

    }

    def getProjectByUser () {

        if(!params.userId) {
            response.status = 403 // Forbidden
            render helperService.renderError("Parameter 'userId' is mandatory.", "403")
            return
        }

        def project = projectService.getProjectsByUserId(params.userId as Integer)

        if (project) {
            response.status = 200  // Ok
            render project as JSON
            return
        }
        else{
            response.status = 404 // NotFound
            render helperService.renderError("Project with id "+params.userId+" not found.", "404")
            return
        }

    }


}

