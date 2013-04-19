package projects

import grails.converters.JSON

class ProjectController {

    def projectService

    def getProjectbyProjectId() {

        response.status=200
        render projectService.getProjectByProjectId(params.projectId as Integer) as JSON

    }

    def postProject ()   {

        def projectJson = request.JSON
        def project = projectService.createProject(projectJson)
        response.status = 200
        render project as JSON

    }

    def getProjectsByCategory  () {

        response.status = 200
        render projectService.getProjectsByCategoryId(params.categoryId as Integer)  as JSON

    }

}

